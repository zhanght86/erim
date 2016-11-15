
//国内接送的js特效
$("#tab-wrap label").click(function(){
  $(this).siblings().removeClass("active");
  $(this).addClass("active");
  $("#tab-con .tab-con1").hide().eq($(this).prevAll().length).show();
  });
//国外接送的js特效 
$("#tab-wrapp label").click(function(){
  $(this).siblings().removeClass("activee");
  $(this).addClass("activee");
  $("#tab-conn .tab-conn1").hide().eq($(this).prevAll().length).show();
  });
//总的tab切换
$("#tab_p li").click(function(){
  $(this).siblings().removeClass("arc");
  $(this).addClass("arc");
  $("#tab-n .tab-n1").hide().eq($(this).prevAll().length).show();
  });