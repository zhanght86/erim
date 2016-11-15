
$(document).ready(function(){
							
	$("#hlselect1 dd").click(function () {
		$(this).addClass("hlselected").siblings().removeClass("hlselected");
		$("#hlselect1 .hlselect-all").removeClass("hlselected");
		if ($(this).hasClass("hlselect-all")) {
			$("#hlselectA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#hlselectA").length > 0) {
				$("#hlselectA a").html($(this).text());
			} else {
				$(".hlselect-result dl").append(copyThisA.attr("id", "hlselectA"));
			}
		}
	});
	$("#hlselect2 dd").click(function () {
		$(this).addClass("hlselected").siblings().removeClass("hlselected");
		if ($(this).hasClass("hlselect-all")) {
			$("#hlselectB").remove();
		} else {
			var copyThisB = $(this).clone();
			if ($("#hlselectB").length > 0) {
				$("#hlselectB a").html($(this).text());
			} else {
				$(".hlselect-result dl").append(copyThisB.attr("id", "hlselectB"));
			}
		}
	});
	$("#hlselect3 dd").click(function () {
		$(this).addClass("hlselected").siblings().removeClass("hlselected");
		if ($(this).hasClass("hlselect-all")) {
			$("#hlselectC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#hlselectC").length > 0) {
				$("#hlselectC a").html($(this).text());
			} else {
				$(".hlselect-result dl").append(copyThisC.attr("id", "hlselectC"));
			}
		}
	});

	$("#hlselectA").live("click", function () {
		$(this).remove();
		$("#hlselect1 .hlselect-all").addClass("hlselected").siblings().removeClass("hlselected");
	});
	
	$("#hlselectB").live("click", function () {
		$(this).remove();
		$("#hlselect2 .hlselect-all").addClass("hlselected").siblings().removeClass("hlselected");
	});
	
	$("#hlselectC").live("click", function () {
		$(this).remove();
		$("#hlselect3 .hlselect-all").addClass("hlselected").siblings().removeClass("hlselected");
	});
	
	$(".hlselect dd").live("click", function () {
		if ($(".hlselect-result dd").length > 1) {
			$(".hlselect-no").hide();
		} else {
			$(".hlselect-no").show();
		}
	});
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
    var a = document.getElementById("hlfloat");
    if (a == undefined) return ! 1;
    var b = 0,
    c, d = a;
    while (d) b += d.offsetTop,
    d = d.offsetParent;
    c = window.ActiveXObject && !window.XMLHttpRequest;
    if (!c || !0) window.onscroll = buffer(e, 150, this)
})();

});
var len=$("#hlselect1 dd a").length;
function int(){
for(i=10;i<len;i++){
$("#hlselect1 dd a").eq(i).addClass("hid");   
}
}
$(".select_more").click(function(){
var t=$(this).text();
if(t=="更多"){
$("#hlselect1 .hid").addClass("show");
$(this).text("收起");
}else{
$("#hlselect1 .hid").removeClass("show");
$(this).text("更多");
}  
});