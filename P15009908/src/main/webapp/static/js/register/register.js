
var register = {
	// 上一步
	load : function(url){
		window.location=href=url;
	},
	// 下一步
	regedit : function(formid,url,loadUrl){
		$('#'+formid).validationEngine({
            scroll       			: true,
            showOneMessage			: true,
            focusFirstField			: true   
        });
		//如果验证通过则提交
		if($('#'+formid).validationEngine('validate')){
			$("#btn").attr({"disabled":"disabled"});
			var data = $("#"+formid).serialize();
			$.post(url, data, function(response) {
				if (response == '0') {
					window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
				} else if (response == '1') {
					setTimeout(function() {
						window.location = loadUrl;
					}, 1000);
				}
				$("#btn").attr({"disabled":"disabled"});
			}, "json");
		}
	}
};

$(function(){
	
	// 地接涉及区域-国内
    $(".dj_dijie_guonei2").hide();
    $(".dj_dijie_guonei2").attr("disabled","disabled");
    $(".dj_dijie_guonei3").hide();
    $(".dj_dijie_guonei3").attr("disabled","disabled");
    $(".dj_dijie_guonei4").hide();
    $(".dj_dijie_guonei4").attr("disabled","disabled");
    $(".dj_dijie_guonei5").hide();
    $(".dj_dijie_guonei5").attr("disabled","disabled");
    // 地接涉及区域-国内增加
    $(".dj_dj_gn_add1").click(function() {
    	$(".dj_dijie_guonei2").show();
    	$(".dj_dijie_guonei2").removeAttr("disabled");
    });
    $(".dj_dj_gn_add2").click(function() {
    	$(".dj_dijie_guonei3").show();
    	$(".dj_dijie_guonei3").removeAttr("disabled");
    });
    $(".dj_dj_gn_add3").click(function() {
    	$(".dj_dijie_guonei4").show();
    	$(".dj_dijie_guonei4").removeAttr("disabled");
    });
    $(".dj_dj_gn_add4").click(function() {
    	$(".dj_dijie_guonei5").show();
    	$(".dj_dijie_guonei5").removeAttr("disabled");
    });
    // 地接涉及区域-国内减少
    $(".dj_dj_gn_del1").click(function() {
    	$(".dj_dijie_guonei2").hide();
    	$(".dj_dijie_guonei2").attr("disabled","disabled");
    });
    $(".dj_dj_gn_del2").click(function() {
    	$(".dj_dijie_guonei3").hide();
    	$(".dj_dijie_guonei3").attr("disabled","disabled");
    });
    $(".dj_dj_gn_del3").click(function() {
    	$(".dj_dijie_guonei4").hide();
    	$(".dj_dijie_guonei4").attr("disabled","disabled");
    });
    $(".dj_dj_gn_del4").click(function() {
    	$(".dj_dijie_guonei5").hide();
    	$(".dj_dijie_guonei5").attr("disabled","disabled");
    });
    // 是否选择国家
    $("input[name='cbsRanInterna'][value='04']").change(function() {
    	var a = $("input[name='cbsRanInterna'][value='04']:checked").val();
    	if (a == '04') {
    		$(".dj_content_address_gj").show();
    		$(".dj_content_address_gj").removeAttr("disabled");
    	} else {
    		$(".dj_content_address_gj").hide();
    		$(".dj_content_address_gj").attr("disabled","disabled");
    	}
    }); 
    // 地接涉及区域-国家
    $(".dj_content_address_gj").hide();
	$(".dj_content_address_gj").attr("disabled","disabled");
    $(".dj_dijie_guojia2").hide();
    $(".dj_dijie_guojia2").attr("disabled","disabled");
    $(".dj_dijie_guojia3").hide();
    $(".dj_dijie_guojia3").attr("disabled","disabled");
    $(".dj_dijie_guojia4").hide();
    $(".dj_dijie_guojia4").attr("disabled","disabled");
    $(".dj_dijie_guojia5").hide();
    $(".dj_dijie_guojia5").attr("disabled","disabled");
    // 地接涉及区域-国家-增加
    $(".dj_dj_gj_add1").click(function() {
    	$(".dj_dijie_guojia2").show();
    	$(".dj_dijie_guojia2").removeAttr("disabled");
    });
    $(".dj_dj_gj_add2").click(function() {
    	$(".dj_dijie_guojia3").show();
    	$(".dj_dijie_guojia3").removeAttr("disabled");
    });
    $(".dj_dj_gj_add3").click(function() {
    	$(".dj_dijie_guojia4").show();
    	$(".dj_dijie_guojia4").removeAttr("disabled");
    });
    $(".dj_dj_gj_add4").click(function() {
    	$(".dj_dijie_guojia5").show();
    	$(".dj_dijie_guojia5").removeAttr("disabled");
    });
    // 地接涉及区域-国家-减少
    $(".dj_dj_gj_del1").click(function() {
    	$(".dj_dijie_guojia2").hide();
    	$(".dj_dijie_guojia2").attr("disabled","disabled");
    });
    $(".dj_dj_gj_del2").click(function() {
    	$(".dj_dijie_guojia3").hide();
    	$(".dj_dijie_guojia3").attr("disabled","disabled");
    });
    $(".dj_dj_gj_del3").click(function() {
    	$(".dj_dijie_guojia4").hide();
    	$(".dj_dijie_guojia4").attr("disabled","disabled");
    });
    $(".dj_dj_gj_del4").click(function() {
    	$(".dj_dijie_guojia5").hide();
    	$(".dj_dijie_guojia5").attr("disabled","disabled");
    });
    // 地接范围-非必填
    nullArea.initProvince('','cbsRanProvince1','cbsRanCity1','cbsRanCounty1');
    nullArea.initProvince('','cbsRanProvince2','cbsRanCity2','cbsRanCounty2');
    nullArea.initProvince('','cbsRanProvince3','cbsRanCity3','cbsRanCounty3');
    nullArea.initProvince('','cbsRanProvince4','cbsRanCity4','cbsRanCounty4');
    nullArea.initProvince('','cbsRanProvince5','cbsRanCity5','cbsRanCounty5');
    
    // 直营单位可服务区域
    nullArea.initProvince('','cbsProProvince','cbsProCity','cbsProCounty');
    
});

