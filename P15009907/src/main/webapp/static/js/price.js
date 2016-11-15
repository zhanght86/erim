var price = {
	// 同业资源量价信息
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
				wxcalert("该出租车没有量价信息！");
			}
		}, "json");
	},
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
			}
		}, "json");
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
			alert("以前的信息不可以修改");
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
	 * --------------------- 专线 - 量价 -----------------------------------------------
	 */
	$("#lpe_date_d li").each(function(){
		if($(this).html()!=""){
			$(this).css("cursor","pointer");
		}
	});
	// 当被点击时
	$("#lpe_date_d").on("click","li",function(){
		var a = $(this).children("input[name='isUpdate']").val();
		if (a == '01') {
			alert("以前的信息不可以修改");
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
	$("#lpe_date_d li").on("click","a",function(){
		var id = $(this).parent().parent().children("input[name='date_id']").val();
		var lpeSign = $(this).parent().parent().children("input[name='date_lpeSign']").val();
		var lpeTradeAdult = $(this).parent().parent().children("input[name='date_lpeTradeAdult']").val();
		var lpeTradeChild = $(this).parent().parent().children("input[name='date_lpeTradeChild']").val();
		var lpeRetailAdult = $(this).parent().parent().children("input[name='date_lpeRetailAdult']").val();
		var lpeRetailChild = $(this).parent().parent().children("input[name='date_lpeRetailChild']").val();
		var lpeSinglePrice = $(this).parent().parent().children("input[name='date_lpeSinglePrice']").val();
		var lpeSingleShow = $(this).parent().parent().children("input[name='date_lpeSingleShow']").val();
		var lpeInsurePrice = $(this).parent().parent().children("input[name='date_lpeInsurePrice']").val();
		var lpeInsureShow = $(this).parent().parent().children("input[name='date_lpeInsureShow']").val();
		var lpeIsUpgrade = $(this).parent().parent().children("input[name='date_lpeIsUpgrade']").val();
		var lpeUpgradeCont = $(this).parent().parent().children("input[name='date_lpeUpgradeCont']").val();
		var lpeUpgradeAdult = $(this).parent().parent().children("input[name='date_lpeUpgradeAdult']").val();
		var lpeUpgradeChild = $(this).parent().parent().children("input[name='date_lpeUpgradeChild']").val();
		
		if($(this).html()=="停售"){
			$(this).parent().remove();
			index.load("line/price/updateIsOpen?lpeIsOpen=01&id=" + id);
		}else if($(this).html()=="出售"){
			$(this).parent().remove();
			index.load("line/price/updateIsOpen?lpeIsOpen=02&id=" + id);
		}else{
			$("#update_id").val(id);
			$("#update_lpeSign").val(lpeSign);
			$("#update_lpeTradeAdult").val(lpeTradeAdult);
			$("#update_lpeTradeChild").val(lpeTradeChild);
			$("#update_lpeRetailAdult").val(lpeRetailAdult);
			$("#update_lpeRetailChild").val(lpeRetailChild);
			$("#update_lpeSinglePrice").val(lpeSinglePrice);
			$("#update_lpeSingleShow").val(lpeSingleShow);
			$("#update_lpeInsurePrice").val(lpeInsurePrice);
			$("#update_lpeInsureShow").val(lpeInsureShow);
			if (lpeIsUpgrade == '01') {
				$("#update_lpeIsUpgrade1").attr("checked","checked");
				$("#update_lpeUpgradeCont").attr('disabled','true');
				$("#update_lpeUpgradeAdult").attr('disabled','true');
				$("#update_lpeUpgradeChild").attr('disabled','true');
			} else {
				$("#update_lpeIsUpgrade2").attr("checked","checked");
				$("#update_lpeUpgradeCont").attr('disabled',false);
				$("#update_lpeUpgradeAdult").attr('disabled',false);
				$("#update_lpeUpgradeChild").attr('disabled',false);
				$("#update_lpeUpgradeCont").val(lpeUpgradeCont);
				$("#update_lpeUpgradeAdult").val(lpeUpgradeAdult);
				$("#update_lpeUpgradeChild").val(lpeUpgradeChild);
			}
			$(".win_box_edit").show();
			$(".win_box_bg").show();
			$(this).parent().remove();
		}
	});
	
	// 量价设置取消
	$('#lpeQuxiao').click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	
	// 量价设置-确定
	$('#lpeQueding').click(function() {
		subform.sub('form2','line/price/updatePrice','line/price/list?portal=04');
	});
	
	// 当点击是否升级时
	$("input[name='lpeIsUpgrade']").change(function() {
		var a = $(this).val();
		if (a == '01') {
			$("input[name='lpeUpgradeCont']").attr('disabled','true');
			$("input[name='lpeUpgradeAdult']").attr('disabled','true');
			$("input[name='lpeUpgradeChild']").attr('disabled','true');
			$("input[name='lpeUpgradeCont']").val(null);
			$("input[name='lpeUpgradeAdult']").val(null);
			$("input[name='lpeUpgradeChild']").val(null);
			
		} else {
			$("input[name='lpeUpgradeCont']").attr('disabled', false);
			$("input[name='lpeUpgradeAdult']").attr('disabled', false);
			$("input[name='lpeUpgradeChild']").attr('disabled', false);
		}
	});
	
})