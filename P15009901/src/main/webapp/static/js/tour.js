$(document).ready(function(){
							
	$("#trselect1 dd").click(function () {
		$(this).addClass("trselected").siblings().removeClass("trselected");
		$("#trselect1 .trselect-all").removeClass("trselected");
		if ($(this).hasClass("trselect-all")) {
			$("#trselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#trselectA").length > 0) {
				$("#trselectA a").html($(this).text());
			} else {
				$(".trselect-result dl").append(copyThisA.attr("id", "trselectA"));
			}
		}
	});
	$("#trselect1 .trselect-all").click(function () {
		$(this).addClass("trselected");
		$(".trselectdiv dd").siblings().removeClass("trselected");
	});
	$("#trselect2 dd").click(function () {
		$(this).addClass("trselected").siblings().removeClass("trselected");
		$("#trselect2 .trselect-all").removeClass("trselected");
		if ($(this).hasClass("trselect-all")) {
			$("#trselectB").remove();
		} else {
			var copyThisB = $(this).clone();
			if ($("#trselectB").length > 0) {
				$("#trselectB a").html($(this).text());
			} else {
				$(".trselect-result dl").append(copyThisB.attr("id", "trselectB"));
			}
		}
	});
	$("#trselect2 .trselect-all").click(function () {
		$(this).addClass("trselected");
		$(".trselect2_div dd").siblings().removeClass("trselected");
	});
	$("#trselect3 dd").click(function () {
		$(this).addClass("trselected").siblings().removeClass("trselected");
		if ($(this).hasClass("trselect-all")) {
			$("#trselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#trselectC").length > 0) {
				$("#trselectC a").html($(this).text());
			} else {
				$(".trselect-result dl").append(copyThisC.attr("id", "trselectC"));
			}
		}
	});
	$("#trselect4 dd").click(function () {
		$(this).addClass("trselected").siblings().removeClass("trselected");
		if ($(this).hasClass("trselect-all")) {
			$("#trselectD").remove();
		} else {
			var copyThisD = $(this).clone();
			if ($("#trselectD").length > 0) {
				$("#trselectD a").html($(this).text());
			} else {
				$(".trselect-result dl").append(copyThisD.attr("id", "trselectD"));
			}
		}
	});

	$("#trselectA").live("click", function () {
		$(this).remove();
		$("#trselect1 .trselect-all").addClass("trselected");
		$(".trselectdiv dd").siblings().removeClass("trselected");
	});
	
	$("#trselectB").live("click", function () {
		$(this).remove();
		$("#trselect2 .trselect-all").addClass("trselected")
		$(".trselect2_div dd").siblings().removeClass("trselected");
	});
	
	$("#trselectC").live("click", function () {
		$(this).remove();
		$("#trselect3 .trselect-all").addClass("trselected").siblings().removeClass("trselected");
	});
	$("#trselectD").live("click", function () {
		$(this).remove();
		$("#trselect4 .trselect-all").addClass("trselected").siblings().removeClass("trselected");
	});
	$(".trselect dd").live("click", function () {
		if ($(".trselect-result dd").length > 1) {
			$(".trselect-no").hide();
		} else {
			$(".trselect-no").show();
		}
	});

	/*默认、全程陪同、当地地接*/
	$(".tour_default").click(function(){
		$(this).addClass("toura").siblings().removeClass("toura");
		$(".full").show();
		$(".local").show();
	});
	$(".tour_full").click(function(){
		$(this).addClass("toura").siblings().removeClass("toura");
		$(".full").show();
		$(".local").hide();
	});
	$(".tour_local").click(function(){
		$(this).addClass("toura").siblings().removeClass("toura");
		$(".local").show();
		$(".full").hide();
	});

});

var len=$("#trselect1 dd").length;
	function int(){
		for(i=10;i<len;i++){
			$("#trselect1 dd").eq(i).addClass("hid");   
		}
	}
	$(".trselect_more").click(function(){
		var t=$(this).text();
		if(t=="更多"){
			$("#trselect1 .hid").addClass("show");
			$(this).text("收起");
		}else{
			$("#trselect1 .hid").removeClass("show");
			$(this).text("更多");
		}  
	});
	var leng=$("#trselect2 dd").length;
	function inttr(){
		for(i=10;i<leng;i++){
			$("#trselect2 dd").eq(i).addClass("hid");   
		}
	}
	$(".trselect_trmore").click(function(){
		var d=$(this).text();
		if(d=="更多"){
			$("#trselect2 .hid").addClass("show");
			$(this).text("收起");
		}else{
			$("#trselect2 .hid").removeClass("show");
			$(this).text("更多");
		}  
	});