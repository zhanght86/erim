// JavaScript Document
$(document).ready(function(){$(".list_main a").click(function(){switch ($(this).attr('class')){case "win_1":{winShow();$(".win_box_edit table").hide();$(".win_box_edit #table_1").show();break;}case "win_2":{winShow();$(".win_box_edit table").hide();$(".win_box_edit #table_2").show();break;}case "win_3":{winShow();$(".win_box_edit table").hide();$(".win_box_edit #table_3").show();break;}case "win_4":{winShow();$(".win_box_edit table").hide();$(".win_box_edit #table_4").show();break;}case "win_5":{winShow();$(".win_box_edit table").hide();$(".win_box_edit #table_5").show();break;}case "win_6":{winShow();$(".win_box_edit table").hide();$(".win_box_edit #table_6").show();break;}case "win_7":{
winShow();$(".win_box_edit table").hide();$(".win_box_edit #table_7").show();break;}case "win_8":{winShow();$(".win_box_edit").addClass('win_box_edit22');$(".win_box_edit table").hide();$(".win_box_edit #table_8").show();break;}default:return false;break;}});function winShow(){$(".win_box_edit").removeClass('win_box_edit22');$(".win_box_edit").show();$(".win_box_bg").show();}$(".win_box_edit .hui_a").click(function(){$(".win_box_edit").hide();$(".win_box_bg").hide();});$("html").on("click",".menu_list li",function(){$(this).addClass('on');$(this).siblings('li').removeClass('on');
$(this).children('div').show();$(this).siblings('li').children('div').hide();});$(".tab_a a").click(function(){$(this).addClass('on').siblings().removeClass('on');$("#tab_a_block").children('div').eq($(this).index()).show().siblings().hide();});$("input[name='gj_gn']").change(function(){if($(this).val()=='gn'){$(".gn_span").show();$(".gj_span").hide();}else{$(".gj_span").show();$(".gn_span").hide();};});


	



})
