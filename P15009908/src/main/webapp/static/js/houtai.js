
$(".leftdiv dt").css({"background": "url('static/images/bg0.gif') repeat-x"});
$(".leftdiv>dl>div>dd>span").css({"background": "url('static/images/houtai5.png') no-repeat","background-position":"left","color":"#fff"});
$(function(){
	$(".leftdiv dd").hide();
	$(".leftdiv dt").click(function(){
		
		$(".leftdiv dt").css({"background": "url('static/images/bg0.gif') repeat-x","color":"#323232"});
		$(this).css({"background": "url('static/images/bg1.gif') repeat-x","color":"#fff"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('div').removeClass("menu_chioe");
		$(".menu_chioe").slideUp(); 
		$(this).parent().find('dd').slideToggle(0);
		$(this).parent().find('div').slideToggle(0);
		$(this).parent().find('dd').addClass("menu_chioce");
		$(this).parent().find('div').addClass("menu_chioe");
		var liHeight = $('.leftdiv dt').height();
		var liindex = $('.leftdiv dt').index(this);
		$('.leftdivp img').stop(false,true).animate({'top' : liindex * liHeight + 'px'},300);
		
		
		//放置cookie 点击左侧事件
		var id = $(this).attr("id");
		if(id != undefined && id != ''){
			mycookie.del("leftclick");
			mycookie.set("leftclick",id);
		}
	});
	//点击
	var left_dt_id = mycookie.get("leftclick");
	if(left_dt_id != undefined){
		$("#"+left_dt_id).trigger("click");
	};
	
	$('.leftdiv>dl>div>dd>span').click(function() {
		
		
    	$(".leftdiv>dl>div>dd>span").css({"background": "url('static/images/houtai5.png') no-repeat","background-position":"left","color":"#fff"});
		$(this).css({"background": "url('static/images/houtai6.png') no-repeat","background-position":"left","color":"#ff9640"});
		
		//更改标题指向
		var html = $(this).attr("parent") + "&nbsp;>&nbsp;" + $(this).text();
		$("#titleSpan").html(html);
		
		//加载路径改变右侧状态
		var url = $(this).attr("text");
		index.load(url);
		page.url = url;
		page.backurl = url;
		
		//保存cookie页面刷新时从cookie中获取
		mycookie.del("pageurl");
		mycookie.set("pageurl",page.url);
		var id = $(this).attr("id");
		if(id != undefined && id != ''){
			mycookie.del("leftspanclick");
			mycookie.set("leftspanclick",id);
		}
	});
	//重载缓存中路径 默认选中wei zh
	var left_span_id = mycookie.get("leftspanclick");
	if(left_span_id != undefined){
		$("#"+left_span_id).css({"background": "url('/static/images/houtai6.png') no-repeat","background-position":"left","color":"#ff9640"});
		//更改标题指向
		var html = $("#"+left_span_id).attr("parent") + "&nbsp;>&nbsp;" + $("#"+left_span_id).text();
		$("#titleSpan").html(html);
	};
	
	
	/*王赛行程管理添加线路2015年10月08号*/
	$(".newline_ctrlblrs a").live("click",function(){
		var xl_num=$(this).parent().parent().children().length;
		if($(this).text()=="-"){
			$(this).parent().remove();
		}
		if(xl_num>7){
			return ;
		}
		if($(this).text()=="+"){
			var htm = $(this).parents(".newline_ctrlblrs").html();
				htm = htm.replace('+','-');
				htm = '<div class="newline_ctrlblrs">'+htm+'</div>';
			$(this).parent().parent().append(htm);
			
			//置空复制的value值
			$(this).parent().parent().find(".newline_ctrlblrs:last").find("select").attr("value","");
			$(this).parent().parent().find(".newline_ctrlblrs:last").find("input").attr("value","");
		}
	});

    $(".mtabtop li").click(function(){
    	var liindex = $('.mtabtop li').index(this);
		$(this).addClass('mtabtopli').siblings().removeClass('mtabtopli');
    	  var index = $(".mtabtop li").index($(this));
        $('.mtabbiger .mtabbox').eq(index).show(0).siblings(".mtabbiger .mtabbox").hide(0);
    });
    /*自驾*/
	$(".self_cttop label").click(function(){
    	var liindex = $('.self_cttop label').index(this);
        $('.self_ctbiger .self_ctbox').eq(liindex).show(0).siblings(".self_ctbiger .self_ctbox").hide(0);
    });
	/*新增餐厅*/
	$(".newfood_top label").click(function(){
    	var liindex = $('.newfood_top label').index(this);
        $('.newfood_ct .newfood_box').eq(liindex).show(0).siblings(".newfood_ct .newfood_box").hide(0);
    });

    /*国际*/
    $("#newfood_in").click(function(){
    	$(".newfood_inter").toggle();
    });
    
//    var management = "<div class='visaa_lrboxsa'>"
//                         + "<div class='visaa_lrboxl'>"
//                             + "<span>材料名称:</span>"
//                             + "<div class='visaa_lrboxlr'>"
//                                + "<input type='text' class='w212'>"
//                                + "<a style='background-color:#ccc;' href='javascript:void(0)'>-</a>"
//                             + "</div>"
//                         + "</div>"
//                         + "<div class='visaa_lrboxl'>"
//                             + "<span>材料说明:</span>"
//                             + "<div class='visaa_lrboxlr'>"
//                                +"<textarea></textarea>"
//                              + "</div>"
//                         + "</div>"
//                         + "<div class='visaa_lrboxl'>"
//                            + "<span>上传图片:</span>"
//                            + "<div class='visaa_lrboxlr'>"
//                                + '<input name="cslImag" value="" type="hidden" id="gdlImgCard3"/>'
//                                + '<input name="file" id="uploadify3" contenteditable="false" size="30" type="file" />'
//                                + '<span id="filespan3" class="pic_upload"></span>'
//                                + '<div id="fileQueue3"></div>'
//                                //+ '<input name="file" id="uploadify9" contenteditable="false" size="30" type="file" />'
//                            + "</div>"
//                         + "</div>"
//                         + "<div class='visaa_lrboxl'>"
//                            + "<span>上传文本:</span>"
//                            + "<div class='visaa_lrboxlr'>"
//                                + '<input name="cslImag" value="" type="hidden" id="gdlImgCard3"/>'
//                                + '<input name="file" id="uploadify3" contenteditable="false" size="30" type="file" />'
//                                + '<span id="filespan3" class="pic_upload"></span>'
//                                + '<div id="fileQueue3"></div>'
//                            + "</div>"
//                         + "</div>";
    
//    /*签证材料添加*/
//	$(".visaa_lrboxl .visaa_lrboxlr a").live("click",function(){
//		if($(this).text()=="+"){
//			//$(this).text('-').css("background-color","#ccc");
//			var objn=$(this).parent().parent().parent().children().length;
//			$(this).parent().parent().parent().after(management);
//		}else{
//			$(this).parent().parent().parent().remove();
//		}
//	});
//	/*签证材料*/
//	$(".visaa_lrtop li").click(function(){
//		var liindex = $('.visaa_lrtop li').index(this);
//		
//		$(this).css({"background":"#fff"}).siblings().css({"background":"#ccc"});
//		$('.visaa_lrbbiger .visaa_lrbox').eq(liindex).show(0).siblings(".visaa_lrbbiger .visaa_lrbox").hide(0);
//	});
	/*签证弹出框*/
	$(".priceadmin").click(function(){
		$(".win_box_edit").show();
		$(".win_box_bg").show();
	});
	$(".win_box_edit .esc_a").click(function() {
		$(".win_box_edit").hide();
		$(".win_box_bg").hide();
	});
	
});
	/*票类管理中的主要景点*/
//主要景点
/*
$("#xl_divadd1 .newline_ctllr2 .xl_add").live("click",function(){
	var xl_num=$(this).parent().parent().children().length;
	if($(this).text()=="-"){
		$(this).parent().remove();
	}
	if(xl_num>6){
	return ;
	}
	if($(this).text()=="+"){
		$(this).parent().after('<div class="newline_ctllr2"><input type="text" name="tdlTicket" class="validate[required,maxSize[50]]" style="width:108px;"><a href="javascript:void(0)" class="xl_add xl_bg_ccc">-</a></div>');
	}
});*/
	
	/*火车票全选*/
	$("#checkAllt").click(function() {
	    $('input[name="subBoxt"]').attr("checked",this.checked); 
	});
	var $subBoxt = $("input[name='subBoxt']");
	$subBoxt.click(function(){
	    $("#checkAllt").attr("checked",$subBoxt.length == $("input[name='subBoxt']:checked").length ? true : false);
	});
	$("#checkAllt2").click(function() {
	    $('input[name="subBoxt2"]').attr("checked",this.checked); 
	});
	var $subBoxt2 = $("input[name='subBoxt2']");
	$subBoxt2.click(function(){
	    $("#checkAllt2").attr("checked",$subBoxt2.length == $("input[name='subBoxt2']:checked").length ? true : false);
	});
	$("#checkAllt3").click(function() {
	    $('input[name="subBoxt3"]').attr("checked",this.checked); 
	});
	var $subBoxt3 = $("input[name='subBoxt3']");
	$subBoxt3.click(function(){
	    $("#checkAllt3").attr("checked",$subBoxt3.length == $("input[name='subBoxt3']:checked").length ? true : false);
	});
	$(".trainl_cttop li").click(function(){
		var liindex = $('.trainl_cttop li').index(this);
		$(this).css({"background":"#d09e64"}).siblings().css({"background":"#969696"});
	    $('.trainl_biger .train_box').eq(liindex).show(0).siblings(".trainl_biger .train_box").hide(0);
	});
	

/*新增票类名称
$(".ticket_ctllb .ticket_ctlla a").live("click",function(){
	if($(this).text()=="+"){
		$(this).text('-').css("background-color","#ccc");
		var objn=$(this).parent().children().length;
		$(this).parent().after("<div class='ticket_ctlla'><input type='text' name='tdlTicket' class='validate[required,maxSize[20]]'><span style='color:red;'>*</span><a href='javascript:void(0)'>+</a></div>");
	}else{
		$(this).parent().remove();
	}
});*/
/*门票须知*/
$(".ticket_ctllb li").click(function(){wxcalert(1);
	var liindex = $('.ticket_ctllb li').index(this);
	$(this).css({"background":"#fff"}).siblings().css({"background":"#ccc"});
    $('.ticket_ctllbiger .ticket_ctllbox').eq(liindex).show(0).siblings(".ticket_ctllbiger .ticket_ctllbox").hide(0);
});
/*景点图片*/
$(".newline_ctlla2 .newline_ctllr3 .newline_ctllr2 a").live("click",function(){
	if($(this).text()=="+"){
		$(this).text('-').css("background-color","#ccc");
		var objn=$(this).parent().children().length;
		$(this).parent().after("<div class='newline_ctllr2'><input type='text' style='width:230px;'><input type='text' style='width:80px;text-align:center;'value='选择图片'><a href='javascript:void(0)'>+</a></div>");
	}else{
		$(this).parent().remove();
	}
});

/*当地游主要景点添加*/
/*$(".newline_ctlla2 .newline_ctllr4 .newline_ctllr2 a").live("click",function(){
	if($(this).text()=="+"){
		$(this).text('-').css("background-color","#ccc");
		var objn=$(this).parent().children().length;
		$(this).parent().after("<div class='newline_ctllr2'><input type='text' name='gddCharacteristic' class='validate[required,maxsize[50]]'><a href='javascript:void(0)'>+</a></div>");
	}else{
		$(this).parent().remove();
	}
});*/

//代金卷点击
$(".djj_ctl .djj_ctlr .djj_ctlm a").live("click",function(){
	if($(this).text()=="添加代金券"){
    	$(this).text('删除代金券').css("background-color","#ccc");
        var objn = $(this).parent().parent().parent().children().length;
        $(this).parent().parent().parent().after("<div class='djj_ctl'>" + 
			"<span style='width:91px;'>代金券面额:</span>" +
			"<input type='hidden' value='' name='cvpId'/>"+ 
			"<div class='djj_ctlr'>" + 
				"<div class='djj_ctlm'>" + 
					"<input type='text' class='validate[required,custom[integer],min[1],max[100000],funcCall[comparison2]]' name='cvpPriceTotal'><span>元</span><span style='color:red;margin-left:69px;margin-top:-27px;'>*</span>" + 
				"</div>" + 
				"<span>同业价:</span>" + 
				"<div class='djj_ctlm'>" + 
					"<input type='text' class='validate[required,custom[integer],min[1],max[100000]]' name='cvpPriceTown'><span>元</span><span style='color:red;margin-left:69px;margin-top:-27px;'>*</span>" + 
				"</div>" + 
				"<span>批发价:</span>" + 
				"<div class='djj_ctlm'>" + 
					"<input type='text' class='validate[required,custom[integer],min[1],max[100000],funcCall[comparison1]]' name='cvpPriceSale'><span>元</span><span style='color:red;margin-left:69px;margin-top:-27px;'>*</span>" + 
				"</div>" + 
				"<span>零售价:</span>" + 
				"<div class='djj_ctlm'>" + 
					"<input type='text' class='validate[required,custom[integer],min[1],max[100000],funcCall[comparison]]' name='cvpPriceRetail'><span>元</span><span style='color:red;margin-left:69px;margin-top:-27px;'>*</span>" + 
					"<a herf='javaScript:void(0)' class='djj_add'>添加代金券</a>" + 
				"</div>" + 
			"</div>" + 
		"</div>");
		return;
    }else{
        $(this).parent().parent().parent().remove();
        var id = $(this).parents(".djj_ctl").find("input[name='cvpId']").val();
        if(""!=id){
            $.post("/cafeteria/voucher/deltetPrice?id="+id,function(data){},'json');
        }
		return;
    }
});
/*门票-票类管理*/
//票类增加
$("#mp_divadd .newline_ctllr2 .add_key_word").live("click",function(){
	var xl_num=$("#mp_divadd .newline_ctllr2").length;
	if($(this).text()=="-"){
		$(this).parent().remove();
	}
	if(xl_num>5){
	return ;
	}
	if($(this).text()=="+"){
		$('<div class="newline_ctllr2"><input type="text" name="tdlTicket" class="validate[required,maxSize[50]]" style="width:108px;"><a href="javascript:void(0)" class="add_key_word">-</a></div>').appendTo("#mp_divadd");
	}
});
/*门票须知*/
$(".ticket_ctllb li").click(function(){
	var liindex = $('.ticket_ctllb li').index(this);
	$(this).css({"background":"#fff"}).siblings().css({"background":"#ccc"});
    $('.ticket_ctllbiger .ticket_ctllbox').eq(liindex).show(0).siblings(".ticket_ctllbiger .ticket_ctllbox").hide(0);
});
// 酒店附近景点新增
/*$(".add_feature").live("click",function(){
    var objn = $(this).parent().parent().children().length;
    if($(this).text()=="-"){
        $(this).parent().remove();
    }
    if (objn > 4) {return;}
    if($(this).text()=="+") {
        $(this).parent().after("<div class='input_right newline_ctllr4 mt15'><input class='w200 lab_input validate[maxSize[30]]' name='hdlFeature' /><a href='javascript:void(0)' class='add_feature'>-</a></div>");
    }
});*/
//wxy12-1酒店附近景点
$("#hotel-around .input_right .add_key_word").live("click",function(){
	var keyhla=$("#hotel-around .input_right").length;
	if($(this).text()=="-"){
		$(this).parent().remove()
	}
	if(keyhla>4){
		return false;
	}
	if($(this).text()=="+"){
		$('<div class="input_right mt15"><input class="w200 lab_input validate[maxSize[40]]" name="hdlFeature" placeholder="没有可不填"/><a href="javascript:void(0)" class="add_key_word">-</a></div>').appendTo("#hotel-around");
	}
});
//wxy12-1酒店关键词
$("#hotel-keywords .input_right .add_key_word").live("click",function(){
    var keylen = $("#hotel-keywords .input_right").length;
    if($(this).text()=="-"){
        $(this).parent().remove();
    }
    if (keylen > 4) {return;}
    if($(this).text()=="+"){
       $('<div class="input_right newline_ctllr4 mt15" ><input type="text" class="w200 lab_input validate[required,maxSize[20]]" name="hdlKeyword" placeholder="如希尔顿"/><span class="mess_star_red">*</span><a href="javascript:void(0)" class="add_key_word">-</a></div>').appendTo("#hotel-keywords");
    }
});

// 酒店关键字
/*$(".add_key_word").live("click",function(){
    var objn = $(".div_big .input_right").length;
    if($(this).text()=="-"){
        $(this).parent().remove();
    }
    if (objn > 10) {return;}
    if($(this).text()=="+") {
        $("<div class='input_right newline_ctllr4 mt15'><input type='text' class='w200 lab_input validate[required,maxSize[10]]' name='hdlKeyword' /><span class='mess_star_red'>*</span><a href='javascript:void(0)' class='add_key_word'>-</a></div>").appendTo(".div_big");
    }
});*/
// 产品特色
$(".add_gdd_feature").live("click",function(){
	var objn = $(this).parent().parent().children().length;
	if($(this).text()=="-"){
		$(this).parent().remove();
	}
	if (objn > 4) {return;}
	if($(this).text()=="+") {
		$(this).parent().after("<div class='input_right newline_ctllr4 mt15'><input type='text' class='w200 lab_input validate[required,maxSize[20]]' name='gddFeature' /><span class='mess_star_red'>*</span><a href='javascript:void(0)' class='add_gdd_feature'>-</a></div>");
	}
});

/*当地游*/
//当地游主要景点增加
$("#zyjd_add .newline_ctllr2 .add_key_word").live("click",function(){
	var zyjd_num=$("#zyjd_add .newline_ctllr2").length;
	if($(this).text()=="-"){
		$(this).parent().remove();
	}
	if(zyjd_num>21){
	return ;
	}
	if($(this).text()=="+"){
		$('<div class="newline_ctllr2"><input type="text" name="gddCharacteristic" class="validate[required,maxSize[50]]" style="width:108px;"><a href="javascript:void(0)" class="add_key_word">-</a></div>').appendTo("#zyjd_add");
	}
});
//学生活动增加
/*$("#stu_add .input_right .add_key_word").live("click",function(){
    var stu_num = $(this).parent().parent().find(".input_right").length;
    if($(this).text()=="-"){
        $(this).parent().remove();
    }
    if (stu_num > 1) {return;}
    if($(this).text()=="+") {
        $(this).parent().after('<div class="input_right newline_ctllr4" style="width:140px;margin-top:15px;margin-right:15px;float:left;"><input type="text" class="w200 lab_input validate[maxSize[10]]" name="gddAddgame" style="width:100px;"/><a href="javascript:void(0)" class="add_key_word xl_bg_ccc">-</a></div>');
    }
});*/

//产品主题增加
$("#standards_add .input_right .add_key_word").live("click",function(){
    var stu_num = $("#standards_add .input_right").length;
    if($(this).text()=="-"){
        $(this).parent().remove();
    }
    if (stu_num > 1) {return;}
    if($(this).text()=="+") {
        $('<div class="input_right newline_ctllr4" id="standarda"  style="width:150px;margin-right:15px;float:left;"><input type="text" class="w200 lab_input validate[maxSize[10]]" name="gddAddstandards" style="width:100px;"/><a href="javascript:void(0)" class="add_key_word">-</a></div>').appendTo("#standards_add");
    }
});
//线路玩法增加
$("#xl_divadd .newline_ctllr2 .xl_add").live("click",function(){
	var xl_num=$(this).parent().parent().children().length;
	if($(this).text()=="-"){
		$(this).parent().remove();
	}
	if(xl_num>6){
	return ;
	}
	if($(this).text()=="+"){
		$(this).parent().after('<div class="newline_ctllr2"><input type="text" name="gddProductine" class="validate[maxSize[50]]" style="width:108px;"><a href="javascript:void(0)" class="xl_add xl_bg_ccc">-</a></div>');
	}
});

$("#hc_zhandian .div_right .add_key_word").live("click",function(){
	var xl_num=$("#hc_zhandian .div_right").length;
	if($(this).text()=="-"){
		$(this).parent().remove();
	}
	if(xl_num>3){
	return ;
	}
	if($(this).text()=="+"){   
		$("<div class='div_right'><input type='text' name='ttdStartStation' class='room_num validate[maxSize[30]]'/><a href='javascript:void(0)' class='add_key_word'>-</a></div>").appendTo("#hc_zhandian");
	}
});



 

