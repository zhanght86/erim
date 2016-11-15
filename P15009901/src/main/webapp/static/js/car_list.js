$(function(){
	$(".clst_top li").click(function(){
		var curl = $(this).attr("curl");
		window.location.href=curl;
		
		var liindex=$(".clst_top li").index(this);
		$(this).addClass("clst_topli").siblings().removeClass("clst_topli");
		$(".clist_biger div.clist_ct").eq(liindex).fadeIn(0).siblings(".clist_biger div.clist_ct").fadeOut(0);
	});
	
	/*包车*/
	$("#ccselect1 dd").click(function () {
		$(this).addClass("ccselected").siblings().removeClass("ccselected");
		$("#ccselect1 .ccselect-all").removeClass("ccselected");
		if ($(this).hasClass("ccselect-all")) {
			$("#ccselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#ccselectA").length > 0) {
				$("#ccselectA a").html($(this).text());
			} else {
				$(".ccselect-result dl").append(copyThisA.attr("id", "ccselectA"));
			}
		}
	});
	$("#ccselect1 .ccselect-all").click(function () {
		$(this).addClass("ccselected");
		$(".ccselectdiv dd").siblings().removeClass("ccselected");
	});
	
	$("#ccselect3 dd").click(function () {
		$(this).addClass("ccselected").siblings().removeClass("ccselected");
		if ($(this).hasClass("ccselect-all")) {
			$("#ccselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#ccselectC").length > 0) {
				$("#ccselectC a").html($(this).text());
			} else {
				$(".ccselect-result dl").append(copyThisC.attr("id", "ccselectC"));
			}
		}
	});
	$("#ccselectA").live("click", function () {
		$(this).remove();
		$("#ccselect1 .ccselect-all").addClass("ccselected");
		$(".ccselectdiv dd").siblings().removeClass("ccselected");
	});
	$("#ccselectC").live("click", function () {
		$(this).remove();
		$("#ccselect3 .ccselect-all").addClass("ccselected").siblings().removeClass("ccselected");
	});

	$(".ccselect dd").live("click", function () {
		if ($(".ccselect-result dd").length > 1) {
			$(".ccselect-no").hide();
		} else {
			$(".ccselect-no").show();
		}
	});
	/*/包车*/
	/*接机*/
	$("#cmaselect1 dd").click(function () {
		$(this).addClass("cmaselected").siblings().removeClass("cmaselected");
		$("#cmaselect1 .cmaselect-all").removeClass("cmaselected");
		if ($(this).hasClass("cmaselect-all")) {
			$("#cmaselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#cmaselectA").length > 0) {
				$("#cmaselectA a").html($(this).text());
			} else {
				$(".cmaselect-result dl").append(copyThisA.attr("id", "cmaselectA"));
			}
		}
	});
	$("#cmaselect1 .cmaselect-all").click(function () {
		$(this).addClass("cmaselected");
		$(".cmaselectdiv dd").siblings().removeClass("cmaselected");
	});
	
	$("#cmaselect3 dd").click(function () {
		$(this).addClass("cmaselected").siblings().removeClass("cmaselected");
		if ($(this).hasClass("cmaselect-all")) {
			$("#cmaselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#cmaselectC").length > 0) {
				$("#cmaselectC a").html($(this).text());
			} else {
				$(".cmaselect-result dl").append(copyThisC.attr("id", "cmaselectC"));
			}
		}
	});
	$("#cmaselectA").live("click", function () {
		$(this).remove();
		$("#cmaselect1 .cmaselect-all").addClass("cmaselected");
		$(".cmaselectdiv dd").siblings().removeClass("cmaselected");
	});
	$("#cmaselectC").live("click", function () {
		$(this).remove();
		$("#cmaselect3 .cmaselect-all").addClass("cmaselected").siblings().removeClass("cmaselected");
	});

	$(".cmaselect dd").live("click", function () {
		if ($(".cmaselect-result dd").length > 1) {
			$(".cmaselect-no").hide();
		} else {
			$(".cmaselect-no").show();
		}
	});
	/*/接机*/
	/*送机*/
		$("#csaselect1 dd").click(function () {
		$(this).addClass("csaselected").siblings().removeClass("csaselected");
		$("#csaselect1 .csaselect-all").removeClass("csaselected");
		if ($(this).hasClass("csaselect-all")) {
			$("#csaselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#csaselectA").length > 0) {
				$("#csaselectA a").html($(this).text());
			} else {
				$(".csaselect-result dl").append(copyThisA.attr("id", "csaselectA"));
			}
		}
	});
	$("#csaselect1 .csaselect-all").click(function () {
		$(this).addClass("csaselected");
		$(".csaselectdiv dd").siblings().removeClass("csaselected");
	});
	
	$("#csaselect3 dd").click(function () {
		$(this).addClass("csaselected").siblings().removeClass("csaselected");
		if ($(this).hasClass("csaselect-all")) {
			$("#csaselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#csaselectC").length > 0) {
				$("#csaselectC a").html($(this).text());
			} else {
				$(".csaselect-result dl").append(copyThisC.attr("id", "csaselectC"));
			}
		}
	});
	$("#csaselectA").live("click", function () {
		$(this).remove();
		$("#csaselect1 .csaselect-all").addClass("csaselected");
		$(".csaselectdiv dd").siblings().removeClass("csaselected");
	});
	$("#csaselectC").live("click", function () {
		$(this).remove();
		$("#csaselect3 .csaselect-all").addClass("csaselected").siblings().removeClass("csaselected");
	});

	$(".csaselect dd").live("click", function () {
		if ($(".csaselect-result dd").length > 1) {
			$(".csaselect-no").hide();
		} else {
			$(".csaselect-no").show();
		}
	});
	/*/送机*/

		/*接站*/
	$("#cmsselect1 dd").click(function () {
		$(this).addClass("cmsselected").siblings().removeClass("cmsselected");
		$("#cmsselect1 .cmsselect-all").removeClass("cmsselected");
		if ($(this).hasClass("cmsselect-all")) {
			$("#cmsselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#cmsselectA").length > 0) {
				$("#cmsselectA a").html($(this).text());
			} else {
				$(".cmsselect-result dl").append(copyThisA.attr("id", "cmsselectA"));
			}
		}
	});
	$("#cmsselect1 .cmsselect-all").click(function () {
		$(this).addClass("cmsselected");
		$(".cmsselectdiv dd").siblings().removeClass("cmsselected");
	});
	
	$("#cmsselect3 dd").click(function () {
		$(this).addClass("cmsselected").siblings().removeClass("cmsselected");
		if ($(this).hasClass("cmsselect-all")) {
			$("#cmsselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#cmsselectC").length > 0) {
				$("#cmsselectC a").html($(this).text());
			} else {
				$(".cmsselect-result dl").append(copyThisC.attr("id", "cmsselectC"));
			}
		}
	});
	$("#cmsselectA").live("click", function () {
		$(this).remove();
		$("#cmsselect1 .cmsselect-all").addClass("cmsselected");
		$(".cmsselectdiv dd").siblings().removeClass("cmsselected");
	});
	$("#cmsselectC").live("click", function () {
		$(this).remove();
		$("#cmsselect3 .cmsselect-all").addClass("cmsselected").siblings().removeClass("cmsselected");
	});

	$(".cmsselect dd").live("click", function () {
		if ($(".cmsselect-result dd").length > 1) {
			$(".cmsselect-no").hide();
		} else {
			$(".cmsselect-no").show();
		}
	});

	/*/接站*/
	/*送站*/
	$("#cssselect1 dd").click(function () {
		$(this).addClass("cssselected").siblings().removeClass("cssselected");
		$("#cssselect1 .cssselect-all").removeClass("cssselected");
		if ($(this).hasClass("cssselect-all")) {
			$("#cssselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#cssselectA").length > 0) {
				$("#cssselectA a").html($(this).text());
			} else {
				$(".cssselect-result dl").append(copyThisA.attr("id", "cssselectA"));
			}
		}
	});
	$("#cssselect1 .cssselect-all").click(function () {
		$(this).addClass("cssselected");
		$(".cssselectdiv dd").siblings().removeClass("cssselected");
	});
	
	$("#cssselect3 dd").click(function () {
		$(this).addClass("cssselected").siblings().removeClass("cssselected");
		if ($(this).hasClass("cssselect-all")) {
			$("#cssselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#cssselectC").length > 0) {
				$("#cssselectC a").html($(this).text());
			} else {
				$(".cssselect-result dl").append(copyThisC.attr("id", "cssselectC"));
			}
		}
	});
	$("#cssselectA").live("click", function () {
		$(this).remove();
		$("#cssselect1 .cssselect-all").addClass("cssselected");
		$(".cssselectdiv dd").siblings().removeClass("cssselected");
	});
	$("#cssselectC").live("click", function () {
		$(this).remove();
		$("#cssselect3 .cssselect-all").addClass("cssselected").siblings().removeClass("cssselected");
	});

	$(".cssselect dd").live("click", function () {
		if ($(".cssselect-result dd").length > 1) {
			$(".cssselect-no").hide();
		} else {
			$(".cssselect-no").show();
		}
	});

	/*/送站*/
	/*自驾*/
	$("#csdselect1 dd").click(function () {
		$(this).addClass("csdselected").siblings().removeClass("csdselected");
		$("#csdselect1 .csdselect-all").removeClass("csdselected");
		if ($(this).hasClass("csdselect-all")) {
			$("#csdselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#csdselectA").length > 0) {
				$("#csdselectA a").html($(this).text());
			} else {
				$(".csdselect-result dl").append(copyThisA.attr("id", "csdselectA"));
			}
		}
	});
	$("#csdselect2 dd").click(function () {
		$(this).addClass("csdselected").siblings().removeClass("csdselected");
		$("#csdselect2 .csdselect-all").removeClass("csdselected");
		if ($(this).hasClass("csdselect-all")) {
			$("#csdselectB").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#csdselectB").length > 0) {
				$("#csdselectB a").html($(this).text());
			} else {
				$(".csdselect-result dl").append(copyThisA.attr("id", "csdselectB"));
			}
		}
	});
	$("#csdselect4 dd").click(function () {
		$(this).addClass("csdselected").siblings().removeClass("csdselected");
		$("#csdselect4 .csdselect-all").removeClass("csdselected");
		if ($(this).hasClass("csdselect-all")) {
			$("#csdselectD").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#csdselectD").length > 0) {
				$("#csdselectD a").html($(this).text());
			} else {
				$(".csdselect-result dl").append(copyThisA.attr("id", "csdselectD"));
			}
		}
	});
	$("#csdselect1 .csdselect-all").click(function () {
		$(this).addClass("csdselected");
		$(".csdselectdiv dd").siblings().removeClass("csdselected");
	});
	
	$("#csdselect3 dd").click(function () {
		$(this).addClass("csdselected").siblings().removeClass("csdselected");
		if ($(this).hasClass("csdselect-all")) {
			$("#csdselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#csdselectC").length > 0) {
				$("#csdselectC a").html($(this).text());
			} else {
				$(".csdselect-result dl").append(copyThisC.attr("id", "csdselectC"));
			}   
		}
	});
	$("#csdselectA").live("click", function () {
		$(this).remove();
		$("#csdselect1 .csdselect-all").addClass("csdselected");
		$(".csdselectdiv dd").siblings().removeClass("csdselected");
	});
	$("#csdselectB").live("click", function () {
		$(this).remove();
		$("#csdselect2 .csdselect-all").addClass("csdselected");
		$(".csdselectdiv dd").siblings().removeClass("csdselected");
	});
	$("#csdselectD").live("click", function () {
		$(this).remove();
		$("#csdselect4 .csdselect-all").addClass("csdselected");
		$(".csdselectdiv dd").siblings().removeClass("csdselected");
	});
	$("#csdselectC").live("click", function () {
		$(this).remove();
		$("#csdselect3 .csdselect-all").addClass("csdselected").siblings().removeClass("csdselected");
	});

	$(".csdselect dd").live("click", function () {
		if ($(".csdselect-result dd").length > 1) {
			$(".csdselect-no").hide();
		} else {
			$(".csdselect-no").show();
		}
	});

	/*/自驾*/
	//baoche
//	国际国家隐藏
//	$(".local-nation").hide();
	//点击包车显示国家国际
//	$(".baoche, .zijia").click(function(){
//		$(".local-nation").show();
//	});
//	点击同行其他的项国家和国家隐藏
//	$(".clst_top ul li:not(.baoche, .zijia)").click(function(){
//		$(".local-nation").hide();
//	});
	//用车方式是半天日期不显示至什么时候，是全天显示至什么时候
	$("#car-day").change(function(){
		var valday = $(this).children('option:selected').val();
		if(valday=="半天"){
			$("#allday").hide();
		}
		else{
			$("#allday").show();
		}
	});
	
	//zijia
	$("#car-way").change(function(){
		var valday = $(this).children('option:selected').val();
		if(valday=="半天"){
			$("#car-allday").hide();
		}
		else{
			$("#car-allday").show();
		}
	});

});
///*包车*/
//var len=$("#ccselect1 dd").length;
//	function int(){
//		for(i=5;i<len;i++){
//			$("#ccselect1 dd").eq(i).addClass("hid");   
//		}
//	}
//	$(".ccselect_more").click(function(){
//		var t=$(this).text();
//		if(t=="更多"){
//			$("#ccselect1 .hid").addClass("show");
//			$(this).text("收起");
//		}else{
//			$("#ccselect1 .hid").removeClass("show");
//			$(this).text("更多");
//		}  
//	});
///*包车*/
///*接机*/
//var len=$("#cmaselect1 dd").length;
//	function inttg(){
//		for(i=5;i<len;i++){
//			$("#cmaselect1 dd").eq(i).addClass("hid");   
//		}
//	}
//	$(".cmaselect_more").click(function(){
//		var t=$(this).text();
//		if(t=="更多"){
//			$("#cmaselect1 .hid").addClass("show");
//			$(this).text("收起");
//		}else{
//			$("#cmaselect1 .hid").removeClass("show");
//			$(this).text("更多");
//		}  
//	});
///*接机*/
///*送机*/
//var len=$("#csaselect1 dd").length;
//	function intts(){
//		for(i=5;i<len;i++){
//			$("#csaselect1 dd").eq(i).addClass("hid");   
//		}
//	}
//	$(".csaselect_more").click(function(){
//		var t=$(this).text();
//		if(t=="更多"){
//			$("#csaselect1 .hid").addClass("show");
//			$(this).text("收起");
//		}else{
//			$("#csaselect1 .hid").removeClass("show");
//			$(this).text("更多");
//		}  
//	});
///*送机*/
///*接站*/
//var lenf=$("#cmsselect1 dd").length;
//	function inttf(){
//		for(f=5;f<lenf;f++){
//			$("#cmsselect1 dd").eq(f).addClass("hid");   
//		}
//	}
//	$(".cmsselect_more").click(function(){
//		var tf=$(this).text();
//		if(tf=="更多"){
//			$("#cmsselect1 .hid").addClass("show");
//			$(this).text("收起");
//		}else{
//			$("#cmsselect1 .hid").removeClass("show");
//			$(this).text("更多");
//		}  
//	});
///*接站*/
///*送站*/
//var lenf=$("#cssselect1 dd").length;
//	function inttd(){
//		for(f=5;f<lenf;f++){
//			$("#cssselect1 dd").eq(f).addClass("hid");   
//		}
//	}
//	$(".cssselect_more").click(function(){
//		var td=$(this).text();
//		if(td=="更多"){
//			$("#cssselect1 .hid").addClass("show");
//			$(this).text("收起");
//		}else{
//			$("#cssselect1 .hid").removeClass("show");
//			$(this).text("更多");
//		}  
//	});
///*送站*/
///*自驾*/
//var lenf=$("#csdselect1 dd").length;
//	function intsd(){
//		for(f=5;f<lenf;f++){
//			$("#csdselect1 dd").eq(f).addClass("hid");   
//		}
//	}
//	$(".csdselect_more").click(function(){
//		var td=$(this).text();
//		if(td=="更多"){
//			$("#csdselect1 .hid").addClass("show");
//			$(this).text("收起");
//		}else{
//			$("#csdselect1 .hid").removeClass("show");
//			$(this).text("更多");
//		}  
//	});
///*自驾*/

/*广告固定*/
function buffer(a, b, c) {
    var d;
    return function() {
        if (d) return;
        d = setTimeout(function() {
            a.call(this),
            d = undefined
        },
        b)
    }
} (function() {
    function e() {
        var d = document.body.scrollTop || document.documentElement.scrollTop;
        d > b ? (a.className = "div1 div2", c && (a.style.top = d - b + "px")) : a.className = "div1"
    }
    var a = document.getElementById("clist_float");
    if (a == undefined) return ! 1;
    var b = 0,
    c, d = a;
    while (d) b += d.offsetTop,
    d = d.offsetParent;
    c = window.ActiveXObject && !window.XMLHttpRequest;
    if (!c || !0) window.onscroll = buffer(e, 150, this)
})();
/*送机*/
