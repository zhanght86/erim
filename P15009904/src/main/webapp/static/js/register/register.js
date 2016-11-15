
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
            fozyFirstField			: true   
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
    // 直营单位可服务区域
	regiArea.initProvince('110000','cbsProProvince','cbsProCity','cbsProCounty');
});

