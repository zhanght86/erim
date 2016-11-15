
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
	$("#hlselect1 .hlselect-all").click(function () {
		$(this).addClass("hlselected");
		$(".hlselectdiv dd").siblings().removeClass("hlselected");
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
	$("#hlselect4 dd").click(function () {
		$(this).addClass("hlselected").siblings().removeClass("hlselected");
		if ($(this).hasClass("hlselect-all")) {
			$("#hlselectD").remove();
		} else {
			var copyThisD = $(this).clone();
			if ($("#hlselectD").length > 0) {
				$("#hlselectD a").html($(this).text());
			} else {
				$(".hlselect-result dl").append(copyThisD.attr("id", "hlselectD"));
			}
		}
	});

	$("#hlselectA").live("click", function () {
		$(this).remove();
		$("#hlselect1 .hlselect-all").addClass("hlselected");
		$(".hlselectdiv dd").siblings().removeClass("hlselected");
	});
	
	$("#hlselectB").live("click", function () {
		$(this).remove();
		$("#hlselect2 .hlselect-all").addClass("hlselected").siblings().removeClass("hlselected");
	});
	
	$("#hlselectC").live("click", function () {
		$(this).remove();
		$("#hlselect3 .hlselect-all").addClass("hlselected").siblings().removeClass("hlselected");
	});
	$("#hlselectD").live("click", function () {
		$(this).remove();
		$("#hlselect4 .hlselect-all").addClass("hlselected").siblings().removeClass("hlselected");
	});
	$(".hlselect dd").live("click", function () {
		if ($(".hlselect-result dd").length > 1) {
			$(".hlselect-no").hide();
		} else {
			$(".hlselect-no").show();
		}
	});


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
jQuery(function(jq) {
                var rr = jq('.plane_ctr');
                var conr = rr.find('div.plane_date'),
                conr0 = conr[0],
                btnWr = rr.find('> div.plane_btns'),
                btnPr = btnWr.find('a.up'),
                btnNr = btnWr.find('a.down');
                $('.pdate_box').click(function(){
                    var liindex = $('.pdate_box').index(this);
                    $(this).addClass('on').siblings().removeClass('on');
                    $('.planect_biger div.planect_ct').eq(liindex).fadeIn(150).siblings('.planect_biger div.planect_ct').hide();
                });
                var lisr = conr.find('.pdate_box');
                var pnumr = 7;
                var numr = lisr.length;
                if (numr <= pnumr) return;

                var owr = lisr[1].offsetLeft - lisr[0].offsetLeft,
                idxArear = [0, numr - pnumr],
                idxr = 0;

                function updateNum(n) {
                    if (n > idxArear[1] || n < idxArear[0]) {
                        return;
                    }

                    btnPr[((n == 0) ? 'add': 'remove') + 'Class']('uN');
                    btnNr[((n == idxArear[1]) ? 'add': 'remove') + 'Class']('dN');

                    idxr = n;
                    conr.stop().animate({
                        left: -n * owr
                    },
                    300);
                }

                btnPr.click(function() {
                    updateNum(idxr - 1);
                    return false;
                });
                btnNr.click(function() {
                    updateNum(idxr + 1);
                    return false;
                });
                	/*显示掩藏*/
				$('.planect_ctbox li .planect_can').click(function(){
					var liindex = $('.planect_ctbox li .planect_can').index(this);
					$('.planect_biger .planect_ctbhide').eq(liindex).toggle();
					
				});
            });
 function change(){
  var num1 = document.getElementById("num1").value;
  var num2 = document.getElementById("num2").value;
   document.getElementById("num2").value = num1;
   document.getElementById("num1").value = num2;
 }
 /*单程、往返显示*/
 var chce=document.getElementById("plane_choice");
	function choice(){
		if(chce.value=="单程"){
			$(".ptop_topwno").show();
			$(".ptop_topwri").hide();
		}
		if(chce.value=="往返"){
			$(".ptop_topwri").show();
			$(".ptop_topwno").hide();
		}
	}
