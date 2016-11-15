$(function(){
	$(".tlst_top li").click(function(){
		var liindex=$(".tlst_top li").index(this);
		$(this).addClass("tlst_topli").siblings().removeClass("tlst_topli");
		$(".tlist_biger div.tlist_ct").eq(liindex).fadeIn(0).siblings(".tlist_biger div.tlist_ct").fadeOut(0);
	});
	/*当地旅游*/
	$("#tlselect1 dd").click(function () {
		$(this).addClass("tlselected").siblings().removeClass("tlselected");
		$("#tlselect1 .tlselect-all").removeClass("tlselected");
		if ($(this).hasClass("tlselect-all")) {
			$("#tlselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#tlselectA").length > 0) {
				$("#tlselectA a").html($(this).text());
			} else {
				$(".tlselect-result dl").append(copyThisA.attr("id", "tlselectA"));
			}
		}
	});
	$("#tlselect1 .tlselect-all").click(function () {
		$(this).addClass("tlselected");
		$(".tlselectdiv dd").siblings().removeClass("tlselected");
	});
	
	$("#tlselect3 dd").click(function () {
		$(this).addClass("tlselected").siblings().removeClass("tlselected");
		if ($(this).hasClass("tlselect-all")) {
			$("#tlselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#tlselectC").length > 0) {
				$("#tlselectC a").html($(this).text());
			} else {
				$(".tlselect-result dl").append(copyThisC.attr("id", "tlselectC"));
			}
		}
	});
	$("#tlselectA").click(function () {
		$(this).remove();
		$("#tlselect1 .tlselect-all").addClass("tlselected");
		$(".tlselectdiv dd").siblings().removeClass("tlselected");
	});
	$("#tlselectC").click(function () {
		$(this).remove();
		$("#tlselect3 .tlselect-all").addClass("tlselected").siblings().removeClass("tlselected");
	});

	$(".tlselect dd").click(function () {
		if ($(".tlselect-result dd").length > 1) {
			$(".tlselect-no").hide();
		} else {
			$(".tlselect-no").show();
		}
	});
	/*/当地旅游*/
	/*石家庄组成团*/
	$("#tgselect1 dd").click(function () {
		$(this).addClass("tgselected").siblings().removeClass("tgselected");
		$("#tgselect1 .tgselect-all").removeClass("tgselected");
		if ($(this).hasClass("tgselect-all")) {
			$("#tgselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#tgselectA").length > 0) {
				$("#tgselectA a").html($(this).text());
			} else {
				$(".tgselect-result dl").append(copyThisA.attr("id", "tgselectA"));
			}
		}
	});
	$("#tgselect1 .tgselect-all").click(function () {
		$(this).addClass("tgselected");
		$(".tgselectdiv dd").siblings().removeClass("tgselected");
	});
	
	$("#tgselect3 dd").click(function () {
		$(this).addClass("tgselected").siblings().removeClass("tgselected");
		if ($(this).hasClass("tgselect-all")) {
			$("#tgselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#tgselectC").length > 0) {
				$("#tgselectC a").html($(this).text());
			} else {
				$(".tgselect-result dl").append(copyThisC.attr("id", "tgselectC"));
			}
		}
	});
	$("#tgselectA").on("click", function () {
		$(this).remove();
		$("#tgselect1 .tgselect-all").addClass("tgselected");
		$(".tgselectdiv dd").siblings().removeClass("tgselected");
	});
	$("#tgselectC").on("click", function () {
		$(this).remove();
		$("#tgselect3 .tgselect-all").addClass("tgselected").siblings().removeClass("tgselected");
	});

	$(".tgselect dd").on("click", function () {
		if ($(".tgselect-result dd").length > 1) {
			$(".tgselect-no").hide();
		} else {
			$(".tgselect-no").show();
		}
	});
	/*/石家庄组成团*/
	/*石家庄出发*/
		$("#tsselect1 dd").click(function () {
		$(this).addClass("tsselected").siblings().removeClass("tsselected");
		$("#tsselect1 .tsselect-all").removeClass("tsselected");
		if ($(this).hasClass("tsselect-all")) {
			$("#tsselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#tsselectA").length > 0) {
				$("#tsselectA a").html($(this).text());
			} else {
				$(".tsselect-result dl").append(copyThisA.attr("id", "tsselectA"));
			}
		}
	});
	$("#tsselect1 .tsselect-all").click(function () {
		$(this).addClass("tsselected");
		$(".tsselectdiv dd").siblings().removeClass("tsselected");
	});
	
	$("#tsselect3 dd").click(function () {
		$(this).addClass("tsselected").siblings().removeClass("tsselected");
		if ($(this).hasClass("tsselect-all")) {
			$("#tsselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#tsselectC").length > 0) {
				$("#tsselectC a").html($(this).text());
			} else {
				$(".tsselect-result dl").append(copyThisC.attr("id", "tsselectC"));
			}
		}
	});
	$("#tsselectA").on("click", function () {
		$(this).remove();
		$("#tsselect1 .tsselect-all").addClass("tsselected");
		$(".tsselectdiv dd").siblings().removeClass("tsselected");
	});
	$("#tsselectC").on("click", function () {
		$(this).remove();
		$("#tsselect3 .tsselect-all").addClass("tsselected").siblings().removeClass("tsselected");
	});

	$(".tsselect dd").on("click", function () {
		if ($(".tsselect-result dd").length > 1) {
			$(".tsselect-no").hide();
		} else {
			$(".tsselect-no").show();
		}
	});
	/*/石家庄出发*/

		/*自由行套餐*/
	$("#tfselect1 dd").click(function () {
		$(this).addClass("tfselected").siblings().removeClass("tfselected");
		$("#tfselect1 .tfselect-all").removeClass("tfselected");
		if ($(this).hasClass("tfselect-all")) {
			$("#tfselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#tfselectA").length > 0) {
				$("#tfselectA a").html($(this).text());
			} else {
				$(".tfselect-result dl").append(copyThisA.attr("id", "tfselectA"));
			}
		}
	});
	$("#tfselect1 .tfselect-all").click(function () {
		$(this).addClass("tfselected");
		$(".tfselectdiv dd").siblings().removeClass("tfselected");
	});
	
	$("#tfselect3 dd").click(function () {
		$(this).addClass("tfselected").siblings().removeClass("tfselected");
		if ($(this).hasClass("tfselect-all")) {
			$("#tfselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#tfselectC").length > 0) {
				$("#tfselectC a").html($(this).text());
			} else {
				$(".tfselect-result dl").append(copyThisC.attr("id", "tfselectC"));
			}
		}
	});
	$("#tfselectA").on("click", function () {
		$(this).remove();
		$("#tfselect1 .tfselect-all").addClass("tfselected");
		$(".tfselectdiv dd").siblings().removeClass("tfselected");
	});
	$("#tfselectC").on("click", function () {
		$(this).remove();
		$("#tfselect3 .tfselect-all").addClass("tfselected").siblings().removeClass("tfselected");
	});

	$(".tfselect dd").on("click", function () {
		if ($(".tfselect-result dd").length > 1) {
			$(".tfselect-no").hide();
		} else {
			$(".tfselect-no").show();
		}
	});

	/*/自由行套餐*/
	/*目的地参团*/
	$("#tdselect1 dd").click(function () {
		$(this).addClass("tdselected").siblings().removeClass("tdselected");
		$("#tdselect1 .tdselect-all").removeClass("tdselected");
		if ($(this).hasClass("tdselect-all")) {
			$("#tdselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#tdselectA").length > 0) {
				$("#tdselectA a").html($(this).text());
			} else {
				$(".tdselect-result dl").append(copyThisA.attr("id", "tdselectA"));
			}
		}
	});
	$("#tdselect1 .tdselect-all").click(function () {
		$(this).addClass("tdselected");
		$(".tdselectdiv dd").siblings().removeClass("tdselected");
	});
	
	$("#tdselect3 dd").click(function () {
		$(this).addClass("tdselected").siblings().removeClass("tdselected");
		if ($(this).hasClass("tdselect-all")) {
			$("#tdselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#tdselectC").length > 0) {
				$("#tdselectC a").html($(this).text());
			} else {
				$(".tdselect-result dl").append(copyThisC.attr("id", "tdselectC"));
			}
		}
	});
	$("#tdselectA").on("click", function () {
		$(this).remove();
		$("#tdselect1 .tdselect-all").addClass("tdselected");
		$(".tdselectdiv dd").siblings().removeClass("tdselected");
	});
	$("#tdselectC").on("click", function () {
		$(this).remove();
		$("#tdselect3 .tdselect-all").addClass("tdselected").siblings().removeClass("tdselected");
	});

	$(".tdselect dd").on("click", function () {
		if ($(".tdselect-result dd").length > 1) {
			$(".tdselect-no").hide();
		} else {
			$(".tdselect-no").show();
		}
	});

	/*/目的地参团*/

});
/*当地旅游*/
var lena=$(".tlselectdiv dd").length;
function int(){
	for(i=5;i<lena;i++){
		$("#tlselect1 dd").eq(i).addClass("hid");   
	}
}
$(".tlselect_more").click(function(){
	var t=$(this).text();
	if(t=="更多"){
		$("#tlselect1 .hid").addClass("show");
		$(this).text("收起");
	}else{
		$("#tlselect1 .hid").removeClass("show");
		$(this).text("更多");
	}  
});
/*当地旅游*/
/*石家庄组成团*/
var len=$("#tgselect1 dd").length;
	function inttg(){
		for(i=5;i<len;i++){
			$("#tgselect1 dd").eq(i).addClass("hid");   
		}
	}
	$(".tgselect_more").click(function(){
		var t=$(this).text();
		if(t=="更多"){
			$("#tgselect1 .hid").addClass("show");
			$(this).text("收起");
		}else{
			$("#tgselect1 .hid").removeClass("show");
			$(this).text("更多");
		}  
	});
/*石家庄组成团*/
/*石家庄出发*/
var len=$("#tsselect1 dd").length;
	function intts(){
		for(i=5;i<len;i++){
			$("#tsselect1 dd").eq(i).addClass("hid");   
		}
	}
	$(".tsselect_more").click(function(){
		var t=$(this).text();
		if(t=="更多"){
			$("#tsselect1 .hid").addClass("show");
			$(this).text("收起");
		}else{
			$("#tsselect1 .hid").removeClass("show");
			$(this).text("更多");
		}  
	});
/*石家庄出发*/
/*自由行套餐*/
var lenf=$("#tfselect1 dd").length;
	function inttf(){
		for(f=5;f<lenf;f++){
			$("#tfselect1 dd").eq(f).addClass("hid");   
		}
	}
	$(".tfselect_more").click(function(){
		var tf=$(this).text();
		if(tf=="更多"){
			$("#tfselect1 .hid").addClass("show");
			$(this).text("收起");
		}else{
			$("#tfselect1 .hid").removeClass("show");
			$(this).text("更多");
		}  
	});
/*自由行套餐*/
/*目的地参团*/
var lenf=$("#tdselect1 dd").length;
	function inttd(){
		for(f=5;f<lenf;f++){
			$("#tdselect1 dd").eq(f).addClass("hid");   
		}
	}
	$(".tdselect_more").click(function(){
		var td=$(this).text();
		if(td=="更多"){
			$("#tdselect1 .hid").addClass("show");
			$(this).text("收起");
		}else{
			$("#tdselect1 .hid").removeClass("show");
			$(this).text("更多");
		}  
	});
/*目的地参团*/