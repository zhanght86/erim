var price = {
	// 同业资源 跳转查看量价
	sametown : function(url,loadUrl){
		$.post(url, function(response) {
			if (response == '0') {
				window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
			} else if (response == '1') {
				setTimeout(function() {
					index.load(loadUrl);
				}, 1000);
			} else if (response == '30') {
				wxcalert("该酒店没有量价信息！");
			} else if (response == '32') {
				wxcalert("该景区没有量价信息！");
			} else if (response == '33') {
				wxcalert("该特色餐没有量价信息！");
			} else if (response == '34') {
				wxcalert("该租车没有量价信息！");
			} else if (response == '35') {
				wxcalert("该导游没有量价信息！");
			}
		}, "json");
	},
	// 产品管理 跳转量价管理
	suburl : function(url,loadUrl){
		$.post(url, function(response) {
			if (response == '0') {
				window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
			} else if (response == '1') {
				setTimeout(function() {
					index.load(loadUrl);
				}, 1000);
			} else if (response == '30') {
				wxcalert("请先添加房型信息！");
			} else if (response == '35') {
				wxcalert("请先添加服务类型信息！");
			}
		}, "json");
	},
	//提交表单，提交成功则跳转页面到指定页面 - 是否成功都给提示
	sub : function(subId,data,url,loadUrl){
		$('#'+data).validationEngine({   
            scroll       			: true,
            showOneMessage			: true,
            focusFirstField			: true   
        });
		//如果验证通过则提交
		if($('#'+data).validationEngine('validate')) {
			$("#"+subId).attr({"disabled":"disabled"});
			$.post(url, $("#"+data).serialize(), function(response) {
				if (response == '0') {
					window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
				} else if (response == '1') {
					wxcalert("操作成功！");
					setTimeout(function() {
						index.load(loadUrl);
					}, 1000);
				} else if (response == '20') { // 量价
					wxcalert("没有可添加的日期！");
				}
				$("#"+subId).removeAttr("disabled");
			}, "json");
		}
	},
	// 批量停售
	batchStop : function(formid,url){
		$('#'+formid).validationEngine({
            scroll       			: true,
            showOneMessage			: true,
            focusFirstField			: true
        });
		//如果验证通过则提交
		if($('#'+formid).validationEngine('validate')){
			$("#btn").attr({"disabled":"disabled"});
			var param = $("#"+formid).serialize();
			url = url + "?" + param;
			index.load(url);
			$("#btn").removeAttr("disabled");
		}
	}
};

// JavaScript Document
$(document).ready(function(){
	
	/**
	 * --------------------- 量价管理通用JS -----------------------------------------------
	 */
	// 房量设置-右上角X关闭
	$(".win_box_edit .esc_a").click(function(){
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	})
	
	$('body').click(function(event) {
		var evt = event.srcElement ? event.srcElement : event.target;
		if($(evt.target)!=$("#date_d li")){
			$(".click_box").remove();
		}
	});
	
	$(".tab_a a").click(function() {
		if($(this).hasClass("on")) {
			return false;
		} else {
			$(this).addClass("on").siblings().removeClass("on");
			var indextab=$(this).index();
			$(this).parent().siblings("table").eq(indextab).show().siblings("table").hide();
			return false;
		}
	});
	
	// 按周选择
	$("input[name='week']").click(function(){
		if($(this).val()==0){
			if ($(this).is(":checked")) {
				$("input[name=week]:checkbox").attr("checked", true);
			} else {
				$("input[name=week]:checkbox").attr("checked", false);
			}
		}else{
			if($("input[name=week]:checked").length>6){
				$("input[name=week]:checkbox:first").attr("checked",true);
			}
			if($("input[name=week]:checked").length<8){
				$("input[name=week]:checkbox:first").attr("checked",false);
			}
		}
	})
	
	/**
	 * --------------------- 酒店量价管理 -----------------------------------------------
	 */
	$("#hnp_date_d li").each(function(){
		if($(this).html()!=""){
			$(this).css("cursor","pointer");
		}
	});
	// 当被点击时
	$("#hnp_date_d").on("click","li",function(){
		var a = $(this).children("input[name='isUpdate']").val();
		if (a == '01') {
			wxcalert("以前的信息不可以修改");
			return;
		}
		if($(this).hasClass("close_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>开房</a><br>" +
					"<a href='javascript:void(0);'>房量设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("open_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>关房</a><br>" +
					"<a href='javascript:void(0);'>房量设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("finish_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'></a><br>" +
					"<a href='javascript:void(0);'>房量设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}
	});
	// 开关房
	$("#hnp_date_d li").on("click","a",function(){
		// id
		var id = $(this).parent().parent().children("input[name='date_id']").val();
		// 数量
		var hnpSign = $(this).parent().parent().children("input[name='date_hnpSign']").val();
		// 价格
		var hnpTradePrice = $(this).parent().parent().children("input[name='date_hnpTradePrice']").val();
		var hnpCombinationPrice = $(this).parent().parent().children("input[name='date_hnpCombinationPrice']").val();
		var hnpRetailPrice = $(this).parent().parent().children("input[name='date_hnpRetailPrice']").val();
		if($(this).html()=="关房"){
			$(this).parent().remove();
			index.load("hotel/price/updateOpen?hnpIsOpen=01&id=" + id);
		}else if($(this).html()=="开房"){
			$(this).parent().remove();
			index.load("hotel/price/updateOpen?hnpIsOpen=02&id=" + id);
		}else{
			$("#update_id").val(id);
			$("#update_hnpSign").val(hnpSign);
			$("#update_hnpTradePrice").val(hnpTradePrice);
			$("#update_hnpCombinationPrice").val(hnpCombinationPrice);
			$("#update_hnpRetailPrice").val(hnpRetailPrice);
			$(".win_box_edit").show();
			$(".win_box_bg").show();
			$(this).parent().remove();
		}
	});
	// 房量设置-取消
	$('#hnp_quxiao').click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	// 房量设置-确定
	$('#hnp_queding').click(function() {
		price.sub('hnp_queding','form2','hotel/price/updatePrice','hotel/price/listPagePortal?portal=05');
	});
	
	// 当选择房型时刷新页面
	$("input[name='hheId']").change(function() {
		var hheId = $("input[name=hheId]:checked").val();
		index.load('hotel/price/listPagePortal?portal=02&hheId='+hheId);
	});
	// 当日房售卖时间
	$("input[name=hnpSellTime]").change(function() {
		var hnpSellTime = $("input[name=hnpSellTime]:checked").val();
		if (hnpSellTime == '02') {
			$("input[name=hnpSellH]").val(null);
			$("input[name=hnpSellH]").attr('disabled','true');
		} else {
			$("input[name=hnpSellH]").attr('disabled',false);
		}
	});
	$("input[name=hnpSellH]").click(function() {
		$("input[name=hnpSellTime]:first").attr("checked",true);
	});
	$("input[name=hnpSellM]").click(function() {
		$("input[name=hnpSellTime]:first").attr("checked",true);
	});
	
	/**
	 * --------------------- 租车-固定接送 -----------------------------------------------
	 */
	$("#tsp_date_d li").each(function(){
		if($(this).html()!=""){
			$(this).css("cursor","pointer");
		}
	});
	// 当被点击时
	$("#tsp_date_d").on("click","li",function(){
		var a = $(this).children("input[name='isUpdate']").val();
		if (a == '01') {
			wxcalert("以前的信息不可以修改");
			return;
		}
		if($(this).hasClass("close_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>出租</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("open_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>停租</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("finish_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'></a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}
	});
	// 开关房
	$("#tsp_date_d li").on("click","a",function(){
		var id = $(this).parent().parent().children("input[name='date_id']").val();
		var tspSign = $(this).parent().parent().children("input[name='date_tspSign']").val();
		var tspTradePrice = $(this).parent().parent().children("input[name='date_tspTradePrice']").val();
		var tspCombinationPrice = $(this).parent().parent().children("input[name='date_tspCombinationPrice']").val();
		var tspRetailPrice = $(this).parent().parent().children("input[name='date_tspRetailPrice']").val();
		
		if($(this).html()=="停租"){
			$(this).parent().remove();
			index.load("texi/send/updateIsOpen?tspIsOpen=01&id=" + id);
		}else if($(this).html()=="出租"){
			$(this).parent().remove();
			index.load("texi/send/updateIsOpen?tspIsOpen=02&id=" + id);
		}else{
			$("#update_id").val(id);
			$("#update_tspSign").val(tspSign);
			$("#update_tspTradePrice").val(tspTradePrice);
			$("#update_tspCombinationPrice").val(tspCombinationPrice);
			$("#update_tspRetailPrice").val(tspRetailPrice);
			$(".win_box_edit").show();
			$(".win_box_bg").show();
			$(this).parent().remove();
		}
	});
	// 量价设置取消
	$('#tspQuxiao').click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	// 量价设置-确定
	$('#tspQueding').click(function() {
		price.sub('tspQueding','form2','texi/send/updatePrice','texi/send/sendPricePage?dicPortal=04');
	});
	
	/**
	 * --------------------- 租车-包车 -----------------------------------------------
	 */
	$("#tcp_date_d li").each(function(){
		if($(this).html()!=""){
			$(this).css("cursor","pointer");
		}
	});
	// 当被点击时
	$("#tcp_date_d").on("click","li",function(){
		var a = $(this).children("input[name='isUpdate']").val();
		if (a == '01') {
			wxcalert("以前的信息不可以修改");
			return;
		}
		if($(this).hasClass("close_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>出租</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("open_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>停租</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("finish_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'></a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}
	});
	// 租车包车
	$("#tcp_date_d li").on("click","a",function(){
		var id = $(this).parent().parent().children("input[name='date_id']").val();
		var tcpSign = $(this).parent().parent().children("input[name='date_tcpSign']").val();
		var tcpTradePrice = $(this).parent().parent().children("input[name='date_tcpTradePrice']").val();
		var tcpCombinationPrice = $(this).parent().parent().children("input[name='date_tcpCombinationPrice']").val();
		var tcpRetailPrice = $(this).parent().parent().children("input[name='date_tcpRetailPrice']").val();
		if($(this).html()=="停租"){
			$(this).parent().remove();
			index.load("texi/car/updateIsOpen?tcpIsOpen=01&id=" + id);
		}else if($(this).html()=="出租"){
			$(this).parent().remove();
			index.load("texi/car/updateIsOpen?tcpIsOpen=02&id=" + id);
		}else{
			$("#update_id").val(id);
			$("#update_tcpSign").val(tcpSign);
			$("#update_tcpTradePrice").val(tcpTradePrice);
			$("#update_tcpCombinationPrice").val(tcpCombinationPrice);
			$("#update_tcpRetailPrice").val(tcpRetailPrice);
			$(".win_box_edit").show();
			$(".win_box_bg").show();
			$(this).parent().remove();
		}
	});
	// 量价设置取消
	$('#tcpQuxiao').click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	// 量价设置-确定
	$('#tcpQueding').click(function() {
		price.sub('tcpQueding','form2','texi/car/updatePrice','texi/car/carPricePage?dicPortal=05');
	});
	
	/**
	 * --------------------- 租车-自驾 -----------------------------------------------
	 */
	$("#tdp_date_d li").each(function(){
		if($(this).html()!=""){
			$(this).css("cursor","pointer");
		}
	});
	// 当被点击时
	$("#tdp_date_d").on("click","li",function(){
		var a = $(this).children("input[name='isUpdate']").val();
		if (a == '01') {
			wxcalert("以前的信息不可以修改");
			return;
		}
		if($(this).hasClass("close_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>出租</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("open_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>停租</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("finish_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'></a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}
	});
	// 开关房
	$("#tdp_date_d li").on("click","a",function(){
		var id = $(this).parent().parent().children("input[name='date_id']").val();
		var tdpSign = $(this).parent().parent().children("input[name='date_tdpSign']").val();
		var tdpTradePrice = $(this).parent().parent().children("input[name='date_tdpTradePrice']").val();
		var tdpCombinationPrice = $(this).parent().parent().children("input[name='date_tdpCombinationPrice']").val();
		var tdpRetailPrice = $(this).parent().parent().children("input[name='date_tdpRetailPrice']").val();
		if($(this).html()=="停租"){
			$(this).parent().remove();
			index.load("texi/drive/updateIsOpen?tdpIsOpen=01&id=" + id);
		}else if($(this).html()=="出租"){
			$(this).parent().remove();
			index.load("texi/drive/updateIsOpen?tdpIsOpen=02&id=" + id);
		}else{
			$("#update_id").val(id);
			$("#update_tdpSign").val(tdpSign);
			$("#update_tdpTradePrice").val(tdpTradePrice);
			$("#update_tdpCombinationPrice").val(tdpCombinationPrice);
			$("#update_tdpRetailPrice").val(tdpRetailPrice);
			$(".win_box_edit").show();
			$(".win_box_bg").show();
			$(this).parent().remove();
		}
	});
	// 量价设置取消
	$('#tdpQuxiao').click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	// 量价设置-确定
	$('#tdpQueding').click(function() {
		price.sub('tdpQueding','form2','texi/drive/updatePrice','texi/drive/drivePricePage?dicPortal=05');
	});
	
	/**
	 * --------------------- 票类-量价 -----------------------------------------------
	 */
	$("#tpl_date_d li").each(function(){
		if($(this).html()!=""){
			$(this).css("cursor","pointer");
		}
	});
	// 当被点击时
	$("#tpl_date_d").on("click","li",function(){
		var a = $(this).children("input[name='isUpdate']").val();
		if (a == '01') {
			wxcalert("以前的信息不可以修改");
			return;
		}
		if($(this).hasClass("close_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>出售</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("open_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>停售</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("finish_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'></a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}
	});
	// 开关房
	$("#tpl_date_d li").on("click","a",function(){
		var id = $(this).parent().parent().children("input[name='date_id']").val();
		var tplSign = $(this).parent().parent().children("input[name='date_tplSign']").val();
		var tplIsSign = $(this).parent().parent().children("input[name='date_tplIsSign']").val();
		var tplTradePrice = $(this).parent().parent().children("input[name='date_tplTradePrice']").val();
		var tplCombinationPrice = $(this).parent().parent().children("input[name='date_tplCombinationPrice']").val();
		var tplRetailPrice = $(this).parent().parent().children("input[name='date_tplRetailPrice']").val();
		if($(this).html()=="停售"){
			$(this).parent().remove();
			index.load("ticket/price/updateIsOpen?tplIsOpen=01&id=" + id);
		}else if($(this).html()=="出售"){
			$(this).parent().remove();
			index.load("ticket/price/updateIsOpen?tplIsOpen=02&id=" + id);
		}else{
			$("#update_id").val(id);
			if (tplIsSign == "01") {
				$("#update_tplSign").val("∞");
			} else {
				$("#update_tplSign").val(tplSign);
			}
			$("#update_tplTradePrice").val(tplTradePrice);
			$("#update_tplCombinationPrice").val(tplCombinationPrice);
			$("#update_tplRetailPrice").val(tplRetailPrice);
			$(".win_box_edit").show();
			$(".win_box_bg").show();
			$(this).parent().remove();
		}
	});
	// 量价设置取消
	$('#tplQuxiao').click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	// 量价设置-确定
	$('#tplQueding').click(function() {
		price.sub('tplQueding','form2','ticket/price/updatePrice','ticket/price/ticketPricePage?portal=04');
	});
	
	// 当选择不限量时
	$("input[name='tplIsSign']").change(function() {
		var a = $("input[name='tplIsSign']:checked").val();
		if (a == '01') {
			$("input[name='tplSign']").attr('disabled','true');
			$("input[name='tplSign']").val(null);
		} else {
			$("input[name='tplSign']").attr('disabled',false);
		}
	});
	
	// 默认选择当日
	$("input[name='tplSameH']").attr('disabled',false);
	$("input[name='tplForwardH']").attr('disabled','true');
	$("input[name='tplForwardH']").val(null);
	
	// 当选择预订时间
	$("input[name='tplDateType']").change(function() {
		var a =	$("input[name='tplDateType']:checked").val();
		
		if (a == '02') {
			$("input[name='tplSameH']").attr('disabled',false);
			$("input[name='tplForwardH']").attr('disabled','true');
			$("input[name='tplForwardH']").val(null);
		} else if (a == '01') {
			$("input[name='tplForwardH']").attr('disabled',false);
			$("input[name='tplSameH']").attr('disabled','true');
			$("input[name='tplSameH']").val(null);
		}
	});
	
	/**
	 * --------------------- 特色餐 - 套餐 - 量价 -----------------------------------------------
	 */
	
	$(".win_box_edit_cpc .esc_a").click(function(){
		$(".win_box_edit_cpc").hide();
		$(".win_box_bg").hide();
	})
	
	
	$("#cpc_date_d li").each(function(){
		if($(this).html()!=""){
			$(this).css("cursor","pointer");
		}
	});
	// 当被点击时
	$("#cpc_date_d").on("click","li",function(){
		var a = $(this).children("input[name='isUpdate']").val();
		if (a == '01') {
			wxcalert("以前的信息不可以修改");
			return;
		}
		if($(this).hasClass("close_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>出售</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("open_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>停售</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("finish_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'></a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}
	});
	// 开关房
	$("#cpc_date_d li").on("click","a",function(){
		var id = $(this).parent().parent().children("input[name='date_id']").val();
		var cpcSign = $(this).parent().parent().children("input[name='date_cpcSign']").val();
		var cpcIsSign = $(this).parent().parent().children("input[name='date_cpcIsSign']").val();
		var cpcTradePrice = $(this).parent().parent().children("input[name='date_cpcTradePrice']").val();
		var cpcCombinationPrice = $(this).parent().parent().children("input[name='date_cpcCombinationPrice']").val();
		var cpcRetailPrice = $(this).parent().parent().children("input[name='date_cpcRetailPrice']").val();
		if($(this).html()=="停售"){
			$(this).parent().remove();
			index.load("cafeteria/price/updateIsOpen?cpcIsOpen=01&id=" + id);
		}else if($(this).html()=="出售"){
			$(this).parent().remove();
			index.load("cafeteria/price/updateIsOpen?cpcIsOpen=02&id=" + id);
		}else{
			$("#update_id").val(id);
			if (cpcIsSign == '01') {
				$("#update_cpcSign").attr('disabled','true');
				$("#update_cpcIsSign").attr("checked", true);
			}
			$("#update_cpcSign").val(cpcSign);
			$("#update_cpcTradePrice").val(cpcTradePrice);
			$("#update_cpcCombinationPrice").val(cpcCombinationPrice);
			$("#update_cpcRetailPrice").val(cpcRetailPrice);
			$(".win_box_edit_cpc").show();
			$(".win_box_bg").show();
			$(this).parent().remove();
		}
	});
	// 量价设置取消
	$('#cpcQuxiao').click(function() {
		$(".win_box_edit_cpc").hide();
		$(".win_box_bg").hide();
	});
	// 量价设置-确定
	$('#cpcQueding').click(function() {
		price.sub('cpcQueding','form2','cafeteria/price/updatePrice','cafeteria/price/list?portal=04');
	});
	// 选择不限量时
	$("input[name='cpcIsSign']").change(function() {
		var a = $("input[name='cpcIsSign']:checked").val();
		if (a == '01') {
			$("input[name='cpcSign']").attr('disabled','true');
			$("input[name='cpcSign']").val(null);
		} else {
			$("input[name='cpcSign']").attr('disabled',false);
		}
	});
	
	/**
	 * --------------------- 导游 - 量价 -----------------------------------------------
	 */
	$("#gpe_date_d li").each(function(){
		if($(this).html()!=""){
			$(this).css("cursor","pointer");
		}
	});
	// 当被点击时
	$("#gpe_date_d").on("click","li",function(){
		var a = $(this).children("input[name='isUpdate']").val();
		if (a == '01') {
			wxcalert("以前的信息不可以修改");
			return;
		}
		if($(this).hasClass("close_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>有</a><br>" +
					"<a href='javascript:void(0);'>价格设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("open_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>无</a><br>" +
					"<a href='javascript:void(0);'>价格设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("finish_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'></a><br>" +
					"<a href='javascript:void(0);'>价格设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}
	});
	// 开关房
	$("#gpe_date_d li").on("click","a",function(){
		var id = $(this).parent().parent().children("input[name='date_id']").val();
		var gpeFloorPrice = $(this).parent().parent().children("input[name='date_gpeFloorPrice']").val();
		var gpeClusterPrice = $(this).parent().parent().children("input[name='date_gpeClusterPrice']").val();
		var gpeGuestPrice = $(this).parent().parent().children("input[name='date_gpeGuestPrice']").val();
		var gpeDate = $(this).parent().parent().children("input[name='date_gpeDate']").val();
		var gdlId = $(this).parent().parent().children("input[name='date_gdlId']").val();
		if($(this).html()=="无"){
			$(this).parent().remove();
			// 关房，按照当前时间和导游ID关闭所有
			index.load("guide/price/updateIsOpen?gpeIsOpen=01&gdlId=" + gdlId + "&gpeDate=" + gpeDate);
		}else if($(this).html()=="有"){
			$(this).parent().remove();
			// 开房，按照ID单独开
			index.load("guide/price/updateIsOpen?gpeIsOpen=02&id=" + id);
		}else{
			$("#update_id").val(id);
			$("#update_gpeFloorPrice").val(gpeFloorPrice);
			$("#update_gpeClusterPrice").val(gpeClusterPrice);
			$("#update_gpeGuestPrice").val(gpeGuestPrice);
			$(".win_box_edit").show();
			$(".win_box_bg").show();
			$(this).parent().remove();
		}
	});
	// 量价设置取消
	$('#gpeQuxiao').click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	// 量价设置-确定
	$('#gpeQueding').click(function() {
		price.sub('gpeQueding', 'form2','guide/price/updatePrice','guide/price/list?portal=04');
	});
	// 预约时间
	$("input[name='gpeAppointType']").change(function() {
		var a = $("input[name='gpeAppointType']:checked").val();
		if (a == '01') {
			$("input[name='gpeAppointNum']").attr('disabled','true');
		} else {
			$("input[name='gpeAppointNum']").attr('disabled',false);
		}
	});
	
	/**
	 * --------------------- 当地游 - 量价 -----------------------------------------------
	 */
	$("#gpc_date_d li").each(function(){
		if($(this).html()!=""){
			$(this).css("cursor","pointer");
		}
	});
	// 当被点击时
	$("#gpc_date_d").on("click","li",function(){
		var a = $(this).children("input[name='isUpdate']").val();
		if (a == '01') {
			wxcalert("以前的信息不可以修改");
			return;
		}
		if($(this).hasClass("close_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>出售</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("open_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>停售</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("finish_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'></a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}
	});
	// 开关房
	$("#gpc_date_d li").on("click","a",function(){
		var id = $(this).parent().parent().children("input[name='date_id']").val();
		var gpeSign = $(this).parent().parent().children("input[name='date_gpeSign']").val();
		var gpeTradeAdult = $(this).parent().parent().children("input[name='date_gpeTradeAdult']").val();
		var gpeTradeChild = $(this).parent().parent().children("input[name='date_gpeTradeChild']").val();
		var gpeRetailAdult = $(this).parent().parent().children("input[name='date_gpeRetailAdult']").val();
		var gpeRetailChild = $(this).parent().parent().children("input[name='date_gpeRetailChild']").val();
		var gpeSinglePrice = $(this).parent().parent().children("input[name='date_gpeSinglePrice']").val();
		var gpeSingleShow = $(this).parent().parent().children("input[name='date_gpeSingleShow']").val();
		var gpeInsurePrice = $(this).parent().parent().children("input[name='date_gpeInsurePrice']").val();
		var gpeInsureShow = $(this).parent().parent().children("input[name='date_gpeInsureShow']").val();
		var gpeIsUpgrade = $(this).parent().parent().children("input[name='date_gpeIsUpgrade']").val();
		var gpeUpgradeCont = $(this).parent().parent().children("input[name='date_gpeUpgradeCont']").val();
		var gpeUpgradeAdult = $(this).parent().parent().children("input[name='date_gpeUpgradeAdult']").val();
		var gpeWholesaleChild = $(this).parent().parent().children("input[name='date_gpeWholesaleChild']").val();
		var gpeWholesaleAdult = $(this).parent().parent().children("input[name='date_gpeWholesaleAdult']").val();
		
		if($(this).html()=="停售"){
			$(this).parent().remove();
			index.load("ground/price/updateIsOpen?gpeIsOpen=01&id=" + id);
		}else if($(this).html()=="出售"){
			$(this).parent().remove();
			index.load("ground/price/updateIsOpen?gpeIsOpen=02&id=" + id);
		}else{
			$("#update_id").val(id);
			$("#update_gpeSign").val(gpeSign);
			$("#update_gpeTradeAdult").val(gpeTradeAdult);
			$("#update_gpeTradeChild").val(gpeTradeChild);
			$("#update_gpeRetailAdult").val(gpeRetailAdult);
			$("#update_gpeRetailChild").val(gpeRetailChild);
			$("#update_gpeSinglePrice").val(gpeSinglePrice);
			$("#update_gpeSingleShow").val(gpeSingleShow);
			$("#update_gpeInsurePrice").val(gpeInsurePrice);
			$("#update_gpeInsureShow").val(gpeInsureShow);
			$("#update_gpeWholesaleAdult").val(gpeWholesaleAdult);
			$("#update_gpeWholesaleChild").val(gpeWholesaleChild);
			if (gpeIsUpgrade == '01') {
				$("#update_gpeIsUpgrade1").attr("checked","checked");
				$("#update_gpeUpgradeCont").attr('disabled','true');
				$("#update_gpeUpgradeAdult").attr('disabled','true');
			} else {
				$("#update_gpeIsUpgrade2").attr("checked","checked");
				$("#update_gpeUpgradeCont").attr('disabled',false);
				$("#update_gpeUpgradeAdult").attr('disabled',false);
				$("#update_gpeUpgradeCont").val(gpeUpgradeCont);
				$("#update_gpeUpgradeAdult").val(gpeUpgradeAdult);
			}
			$(".win_box_edit").show();
			$(".win_box_bg").show();
			$(this).parent().remove();
		}
	});
	// 量价设置取消
	$('#gpcQuxiao').click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	// 量价设置-确定
	$('#gpcQueding').click(function() {
		price.sub('gpcQueding','form2','ground/price/updatePrice','ground/price/list?portal=04');
	});
	// 当点击是否升级时
	$("input[name='gpeIsUpgrade']").change(function() {
		var a = $(this).val();
		if (a == '01') {
			$("input[name='gpeUpgradeCont']").attr('disabled','true');
			$("input[name='gpeUpgradeAdult']").attr('disabled','true');
			
		} else {
			$("input[name='gpeUpgradeCont']").attr('disabled', false);
			$("input[name='gpeUpgradeAdult']").attr('disabled', false);
		}
	});
	
	/**
	 * --------------------- 签证 - 量价 -----------------------------------------------
	 */
	$("#mdl_date_d li").each(function(){
		if($(this).html()!=""){
			$(this).css("cursor","pointer");
		}
	});
	// 当被点击时
	$("#mdl_date_d").on("click","li",function(){
		var a = $(this).children("input[name='isUpdate']").val();
		if (a == '01') {
			wxcalert("以前的信息不可以修改");
			return;
		}
		if ($(this).hasClass("open_li")) {
			$(this).append("<div class='click_box'>" +
					// "<a href='javascript:void(0);'></a><br>" +
					"<a href='javascript:void(0);'>修改价格</a>" +
			"</div>");
			$(this).siblings().children(".click_box").remove();
		}
		return false;
	});
	// 开关房
	$("#mdl_date_d li").on("click","a",function(){
		var id = $(this).parent().parent().children("input[name='date_id']").val();
		var mdlPriceSame = $(this).parent().parent().children("input[name='date_mdlPriceSame']").val();
		var mdlPriceTeam = $(this).parent().parent().children("input[name='date_mdlPriceTeam']").val();
		var mdlPriceSeal = $(this).parent().parent().children("input[name='date_mdlPriceSeal']").val();
		$("#update_id").val(id);
		$("#update_mdlPriceSame").val(mdlPriceSame);
		$("#update_mdlPriceTeam").val(mdlPriceTeam);
		$("#update_mdlPriceSeal").val(mdlPriceSeal);
		$(".win_box_edit").show();
		$(".win_box_bg").show();
		$(this).parent().remove();
	});
	// 量价设置取消
	$('#mdlQuxiao').click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	// 量价设置-确定
	$('#mdlQueding').click(function() {
		price.sub('mdlQueding','form2','management/price/updatePrice','management/price/list?portal=04');
	});
	
	/**
	 * --------------------- 机票 - 量价 -----------------------------------------------
	 */
	$("#pre_date_d li").each(function(){
		if($(this).html()!=""){
			$(this).css("cursor","pointer");
		}
	});
	// 当被点击时
	$("#pre_date_d").on("click","li",function(){
		var a = $(this).children("input[name='isUpdate']").val();
		if (a == '01') {
			wxcalert("以前的信息不可以修改");
			return;
		}
		if($(this).hasClass("close_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>出售</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("open_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'>停售</a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}else if($(this).hasClass("finish_li")){
			$(this).append("<div class='click_box'>" +
					"<a href='javascript:void(0);'></a><br>" +
					"<a href='javascript:void(0);'>量价设置</a>" +
					"</div>");
			$(this).siblings().children(".click_box").remove();
			return false;
		}
	});
	// 开关房
	$("#pre_date_d li").on("click","a",function(){
		var id = $(this).parent().parent().children("input[name='date_id']").val();
		var preSign = $(this).parent().parent().children("input[name='date_preSign']").val();
		var preTradePrice = $(this).parent().parent().children("input[name='date_preTradePrice']").val();
		var preRetailPrice = $(this).parent().parent().children("input[name='date_preRetailPrice']").val();
		
		if($(this).html()=="停售"){
			$(this).parent().remove();
			index.load("planeticket/price/updateIsOpen?preIsOpen=01&id=" + id);
		}else if($(this).html()=="出售"){
			$(this).parent().remove();
			index.load("planeticket/price/updateIsOpen?preIsOpen=02&id=" + id);
		}else{
			$("#update_id").val(id);
			$("#update_preSign").val(preSign);
			$("#update_preTradePrice").val(preTradePrice);
			$("#update_preRetailPrice").val(preRetailPrice);
			$(".win_box_edit").show();
			$(".win_box_bg").show();
			$(this).parent().remove();
		}
	});
	// 量价设置取消
	$('#preQuxiao').click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	// 量价设置-确定
	$('#preQueding').click(function() {
		price.sub('preQueding','form2','planeticket/price/updatePrice','planeticket/price/list?portal=04');
	});
})