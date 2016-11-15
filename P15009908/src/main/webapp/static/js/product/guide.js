/*
 * 产品管理 - 导游管理 - JS
 */
$(function () {
	// 省市县增加时的临时变量
	var tranc = 11;
	// 增加省市县、语言、国家时的数量限制
	var lockNum = 5;
	// 国内地陪增加省市县
	$(".doadmin_toplboxb .city_box .a_button").die('click').live('click', function() {
		
	    if ($(this).text() == "+") {
	    	var num = $(this).parent().parent().children().length;
	    	if(num == lockNum) return;
	        var tranchtml = $("#div_city_demo").html();
	        tranchtml = tranchtml.replace(/gdlLocalProvince1/gm,'gdlLocalProvince'+tranc);
	    	tranchtml = tranchtml.replace(/gdlLocalCity1/gm,'gdlLocalCity'+tranc);
	    	tranchtml = tranchtml.replace(/gdlLocalCounty1/gm,'gdlLocalCounty'+tranc);
	    	tranchtml = tranchtml.replace('>+',' style="background:#ccc">-');
	    	var html = '<div class="city_box mt15">'+tranchtml+'</div>';
	        $(this).parent().parent().append(html);
	        
	        tranc++;
	    } else {
	        $(this).parent().remove();
	    }
	});
	
	// 国内全陪增加省市县
	$(".doadmin_toplboxb2 .city_boxx .a_button").die('click').live('click', function() {
	    if ($(this).text() == "+") {
	    	
	    	var num = $(this).parent().parent().children().length;
	    	if(num == lockNum) return;
	    	
	        var tranchtmll = $("#div_city_national").html();
	        tranchtmll = tranchtmll.replace(/gdlNationalProvince1/gm,'gdlNationalProvince'+tranc);
	    	tranchtmll = tranchtmll.replace(/gdlNationalCity1/gm,'gdlNationalCity'+tranc);
	    	tranchtmll = tranchtmll.replace(/gdlNationalCounty1/gm,'gdlNationalCounty'+tranc);
	    	tranchtmll = tranchtmll.replace('>+',' style="background:#ccc">-');
	    	 
	    	var html = '<div class="city_boxx mt15">'+tranchtmll+'</div>';
	        $(this).parent().parent().append(html);
	        
	        tranc++;
	    } else {
	        $(this).parent().remove();
	    }
	});
	
	// 国际港澳台领队增加省市县
	$(".doadmin_toplboxb3 .city_boxa .a_button").die('click').live('click', function() {
	    if ($(this).text() == "+") {
	    	
	    	var num = $(this).parent().parent().children().length;
	    	if(num == lockNum) return;
	    	
	        var tranchtmlw = $("#div_city_leader").html();
	        tranchtmlw = tranchtmlw.replace(/gdlLeaderProvince1/gm,'gdlLeaderProvince'+tranc);
	    	tranchtmlw = tranchtmlw.replace(/gdlLeaderCity1/gm,'gdlLeaderCity'+tranc);
	    	tranchtmlw = tranchtmlw.replace(/gdlLeaderCounty1/gm,'gdlLeaderCounty'+tranc);
	    	tranchtmlw = tranchtmlw.replace('>+',' style="background:#ccc">-');
	    	var html = '<div class="city_boxa mt15">'+tranchtmlw+'</div>';
	        $(this).parent().parent().append(html);
	        //初始化省市县
	        tranc++;
	    } else {
	        $(this).parent().remove();
	    }
	});
	
	//其他语言添加
	$("#language .input_right .a_button").die('click').live("click",function(){
		var stu_num = $(this).parent().parent().find(".input_right").length;
		// 减
		if($(this).text()=="-") {
			$(this).parent().remove();
		}
		// 添加
		if($(this).text()=="+") {
			if(stu_num == lockNum) {
				return;
			}
			$(this).parent().parent().append('<div class="input_right newline_ctllr4 gdlLangua" style="width:140px;margin-top:10px;margin-left:10px;float:left;"><input type="text" class="w200 lab_input validate[maxSize[10]]" name="gdlRest" style="width:100px;"/><a href="javascript:void(0)" class="a_button xl_bg_ccc">-</a></div>');
		}
	});
	
	//国际/港澳台地陪国家
	$("#div_trainl_ctctbl .carinfo_ctblr_a .a_button").die("click").die('click').live("click",function(){
	 	var stu_num = $(this).parent().parent().children().length;
	 	if($(this).text() == "-") {
	     	$(this).parent().remove();
	 	}
	 	if($(this).text() == "+") {
	 		if(stu_num == lockNum) {
	 			return;
	 		}
			$(this).parent().parent().append('<div class="carinfo_ctblr_a" style="margin-top:15px;float:right;width:227px;"><div class="doadmin_toplbra" style="width:130px;"><input type="text" style="width:150px;"  name="gdlGaidCountry" class="validate[maxSize[20]] autoquerycountry"  onfocus="autoquery();"></div><a class="a_button" style="float:right;"  href="javascript:void(0)">-</a></div>');
	 	}
	});
	
	//领队国家
	$("#newline1  .carinfo_ctblr_a .a_button").die("click").live("click",function(){
	   	var stu_num = $(this).parent().parent().children().length;
		if($(this).text() == "-") {
			$(this).parent().remove();
		}
	   	if($(this).text() == "+") {
	   		if(stu_num == lockNum){
	   			return;
	   		}
	   		$(this).parent().parent().append('<div class="carinfo_ctblr_a" style="margin-top:15px;float:right;width:227px;"><div class="doadmin_toplbra" style="width:130px;"><input type="text" style="width:150px;"  name="gdlDestinationCountry" class="validate[maxSize[20]] autoquerycountry" onfocus="autoquery();"></div><a class="a_button" style="float:right;"  href="javascript:void(0)">-</a></div>');
	   	}
	});
	
	// 其他语种隐藏展示
	$("input[name='gdlLanguage'][value='21']").change(function() {
		var check = $(this).prop("checked");
		if(check){
			$('.gdlLangua').show();
		}else{
			$("input[name='gdlRest']").attr("value","");
			$('.gdlLangua').hide();
		}
	});
	
	// 点击事件
	// 国内地陪
	$("input[name='gdlServer'][value='01']").change(function() {
		$('#newline_ctllrbb').toggle();
	});
	// 国内全陪
	$("input[name='gdlServer'][value='02']").change(function() {
		$('#newline_ctllrbb1').toggle();
	});
	// 国际港澳台领队
	$("input[name='gdlServer'][value='03']").change(function() {
		$('#newline_ctllrbid').toggle();
		$('#newline_ctllrbidd').toggle();
        $('#newline').toggle();
	});
	// 国际港澳台地陪
	$("input[name='gdlServer'][value='04']").change(function() {
   		$('#newline_ctllra1').toggle();
	});	
	
	// 国际领队 是否显示外国 切换
	$("input[name='gdlDestination'][value='04']").change(function() {
		$("#newline1").toggle();
	});
	// 国际地陪
	$("input[name='gdlGaidLokal'][value='04']").change(function() {
		$("#div_trainl_ctctbl").toggle();
	});
})

