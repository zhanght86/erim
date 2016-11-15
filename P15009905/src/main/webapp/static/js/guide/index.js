$(function(){
	
	// 点击日历
	$("li.pink").click(function(){
		
		// 得到点击日期
		var text = $(this).find(".month-month").text();
		// 获取当前年月
	    var datetime = $("#cal_date").html();
	    // 设置日期
	    $("#span_date").html(datetime + " " + text + " 日");
	    // 显示档期设置页面
	    $("#date_popup").show();
	    
	    // 获取当前日历数据
	    var id = $(this).find("input[name='id']").val();
	    var gpeIsOpen = $(this).find("input[name='gpeIsOpen']").val();
	    var gdlId = $(this).find("input[name='gdlId']").val();
	    var day = $(this).find("input[name='day']").val();
	    
	    // 设置数据显示
	    $("#form_dq").find("input[name='id']").val(id);
	    $("#form_dq").find("input[name='gdlId']").val(gdlId);
	    $("#form_dq").find("input[name='day']").val(day);
	    $("#form_dq").find("input[name='gpeIsOpen'][value='" + gpeIsOpen + "']").prop("checked", true)
	    
	});
	
	//档期提交
	$("#form_dq .shuxian").click(function(){
		//验证表单
		if(guide.checkForm("form_dq")) {
			//提交
			$.post($("#form_dq").attr("action"), $("#form_dq").serialize(), function(data) {
				if(0 == data) {
					alert("服务器繁忙");
				} else {
					// 刷新页面
					window.location = _appRoot + '/guide/price/list';
				}
			},'json');
		}
	});
	
	// 更改导游服务类型
	$("input[name='isInternal']").change(function () {
		var service = $("input[name='isInternal']:checked").val();
		// 刷新页面
		window.location = _appRoot + '/guide/price/updateService?isInternal='+service;
	});
	
});



//金额
$("#form_je .shuxian").click(function(){
	//验证表单
	if(guide.checkForm("form_je")){
		//提交
		$.post($("#form_je").attr("action"),$("#form_je").serialize(),function(data){
			if(1==data){
				window.location = _appRoot + '/index';
			}
		},'json');
	}
});

//档期管理点击事件
$("#date_btn").click(function () {
	$("#date_popup").show();
});

//金额管理点击事件
$("#amount_btn").click(function () {
	$("#amount_popup").show();
});

//主页方法
var index = {
	//增加点击事件
	addClick : function(){
		index.click();
	},
	click : function(){
		//日历点击
		$("li.pink").click(function () {
			//得到点击日期
			var text = $(this).find(".month-month").text();
		   
		    $("#date_popup").show();
		    
		    //获取当前事件
		    var datetime = $("#cal_date").html();
		    
		    $("#span_date").html(datetime+text+"日");
		    
		    datetime = datetime.replace(' 年 ','-').replace(' 月','-');
		    
		    $("#gseDateStart").attr("value",datetime+text);
		    
		    // 当前数据ID
		    var id = $(this).find("input[name='id']").val();
		    // 档期状态
		    var isOpen = $(this).find("input[name='gpeIsOpen']").val();
		    $("#form_dq").find("input[name='id']").val(id);
		    $("#form_dq").find("input[name='gpeIsOpen']").removeAttr("checked")
		    $("#form_dq").find("input[name='gpeIsOpen'][value='" + isOpen + "']").attr("checked", "checked")
		    
		    
		    //显示日期
		    //$(".date_left_top_day").html(text);
		    //显示星期
		    //$(".date_left_top_week").html(calander.weekArry[calander.getWeekDay(text)]);
		});
	}
};

/**
 * 日历控件 -JS实现，已废弃
 */
var calander = {
	
	year  	 : 0, //年份
	m     	 : 0, //月份
	month 	 : 0, //月号
	date 	 : 0, //日期
	day   	 : 0, //星期
	firstDay : 0, //第一天
	weekArry : new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六"),
	
	//上下月
	next : {
		//上月
		before : function(){
			calander.next.show('before');
		},
		//下月
		after : function(){
			calander.next.show('after');
		},
		//通用
		show : function(ntype){
			//初始化
			calander.getDay();
			
			if('before' == ntype){
				if(calander.month>1){
					calander.month = calander.month - 1;
				}else{
					calander.year = calander.year - 1;
					calander.month = 12;
				}
			} 
			if('after'  == ntype){
				if(calander.month < 12){
					calander.month = calander.month + 1;
				}else{
					calander.year = calander.year + 1;
					calander.month = 1;
				}
			} 
			
			//当前日历
			var monthsNum = calander.formatMonthDay();
			calander.formatDay();
			//清空日历
			$(".month-body").html("");
			// $(".date_left_top_day").html("");
			// $(".date_left_top_week").html("");
			calander.show(monthsNum);
		}
	},
	//展示
	show : function(monthsNum){
		//展示
		$("#cal_date").text(calander.year+" 年 "+calander.month+" 月");		
		var month_box         = "<div class='month-box'><img src='"+_staticRoot+"/img/calander/checkbox.png'/></div>";
		
		for(var i=0;i<42;i++){
            $("<li>"+month_box+"<div class='month-month'></div><div class='month-price'></div></li>").appendTo(".month-body").addClass("month-cell");		        
		}
//		var firstDay = calander.day-(calander.date%7-1);       //!important 计算月初星期数
//		alert(firstDay);
		var day = new Date(calander.year,calander.month-1,1);
		var firstDay = day.getDay();

		  if(firstDay==7){                     //如果月初为七，归零
			  firstDay =0;
		  }
		  if(firstDay<0){                       //如果月初为负，加七循环
			  firstDay +=7;
		  }
		  var f = firstDay;
		  var idx = 0;
		  
		  var arrayFull   = fullDate.split(",");
		  var arrayFree   = fullFree.split(",");
		  var arrayPrice  = fullPrice.split(",");
		  
		  for(var j=1;j<=monthsNum[calander.m];j++){
		      var d = calander.year+"-"+calander.month+"-"+j;
		      var idex = arrayFull.indexOf(d);
		      if(idex>-1){
		          if(arrayFree[idex]=='2'){
                    $("li.month-cell .month-box").eq(f).html("<img src='"+_staticRoot+"/img/calander/checked.png'/>");		              
		          }
                  $("li.month-cell .month-price").eq(f).html("¥"+arrayPrice[idex]);		
		      }
			  $("li.month-cell .month-month").eq(f).text(""+j).parent().addClass("pink");
			  f++; 
		  }
		//当天标红
     	 var today = new Date();
		 if(today.getFullYear() == calander.year && today.getMonth()+1 == calander.month){
			 $("li.month-cell .month-month").eq(firstDay-1+calander.date).parent().addClass("red");
			 $(".date_left_top_day").html(firstDay+calander.date-2);
			 $(".date_left_top_week").html(calander.weekArry[calander.getWeekDay(firstDay+calander.date-2)]);
		 }
     	 
     	//增加点击事件
     	index.addClick();
	},
	//根据年月日获取星期几
	getWeekDay : function(day){
		var day = new Date(calander.year,calander.month-1,day);
		return day.getDay();
	},
	
	//初始化
	init : function(){
		//初始化
		calander.getDay();
		var monthsNum = calander.formatMonthDay();
//		calander.formatMonth();
		calander.formatDay();
		calander.show(monthsNum);
	},
	//得到当前年月
	getDay : function(){
		if(0 == calander.month){
			var today      = new Date();              //当前日期
			calander.year  = today.getFullYear();     //获取年份
			calander.m     = today.getMonth();        //获取月号
			calander.month = today.getMonth()+1;      //获取月份
			calander.date  = today.getDate();	      //获取日期
			calander.day   = today.getDay();          //获取星期
		}
	},
	//得到每月天数
	formatMonthDay : function(){
		//每月天数
	    var monthsNum=[31,28,31,30,31,30,31,31,30,31,30,31];
	    var isleapyear = calander.year%4;        //判断闰年
	    if(isleapyear==0){
		    monthsNum[1]=29;
	    }
	    return monthsNum;
	},
	//月份格式化 月份小于10的 补0 如 9 ： 09
	formatMonth : function(){
		//月份小于10的 补0 如 9 ： 09
	    if(calander.month<10) calander.month= "0" + calander.month; 
	},
	//日期格式化
	formatDay : function(){
		//如果为0 则为星期七
	    if(calander.day==0)   calander.day = 7;
	}
};