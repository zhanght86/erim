/**
 * 表单应用js
 */
var subform = {
	// ajax 不刷新
	ajaxload : function(data,url) {
		$("#btn").attr({"disabled":"disabled"});
		$.post(url, data, function(response) {
			if (response == '0') {
				window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
			} else if (response == '1') {
				wxcalert("操作成功！");
			}
			$("#btn").removeAttr("disabled");
		}, "json");
	},
	//提交表单，提交成功则跳转页面到指定页面 - 成功则无提示
	subload : function(data,url,loadUrl) {
		$('#'+data).validationEngine({   
            scroll       			: true,
            showOneMessage			: true,
            fozyFirstField			: true   
        });
		//如果验证通过则提交
		if($('#'+data).validationEngine('validate')){
			$("#btn").attr({"disabled":"disabled"});
			$.post(url, $("#"+data).serialize(), function(response) {
				if (response == '0') {
					window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
				} else if (response == '1') {
					setTimeout(function() {
						index.load(loadUrl);
					}, 1000);
				}
				$("#btn").removeAttr("disabled");
			}, "json");
		}
	},
	//不检测是否包含必填项直接提交
	nocheckSub : function(url) {
		$.post(url, function(response) {
			if (response == '0') {
				window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
			} else if (response == '1') {
				wxcalert("操作成功！");
			}
		}, "json");
	},
	//提交表单，提交成功则跳转页面到指定页面 - 是否成功都给提示
	sub : function(data,url,loadUrl){
		$('#'+data).validationEngine({   
            scroll       			: true,
            showOneMessage			: true,
            fozyFirstField			: true   
        });
		//如果验证通过则提交
		if($('#'+data).validationEngine('validate')) {
			$("#btn").attr({"disabled":"disabled"});
			$.post(url, $("#"+data).serialize(), function(response) {
				if (response == '0') {
					window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
				} else if (response == '1') {
					wxcalert("操作成功！");
					setTimeout(function() {
						index.load(loadUrl);
					}, 1000);
				}
				$("#btn").removeAttr("disabled");
			}, "json");
		}
	},
	//提交路径
	suburl : function(url,loadUrl) {
		$("#btn").attr({"disabled":"disabled"});
		$.post(url, function(response) {
			if (response == '0') {
				window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
			} else if (response == '1') {
				wxcalert("操作成功！");
				setTimeout(function() {
					index.load(loadUrl);
				}, 1000);
			}
			$("#btn").removeAttr("disabled");
		}, "json");
	},
	//查询表单
	search : function(){
		var url = $(".form-search").attr("action");
		var param = $(".form-search").serialize();
		url = url + "?" + param;
		index.load(url);
		return false;
	},
	//更新
	update : function(formid,url){
		$('#'+formid).validationEngine({   
            scroll       			: true,
            showOneMessage			: true,
            fozyFirstField			: true   
        });
		//如果验证通过则提交
		if($('#'+formid).validationEngine('validate')){
			subform.ajaxSub($("#"+formid).serialize(),url,page.url);
		}
	},
	//提交表单 
	ajaxSub : function(data,url,loadUrl){
		$("#btn").attr({"disabled":"disabled"});
		$.post(url, data, function(response) {
			if (response == '0') {
				window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
			} else if (response == '2') {
				wxcalert("输入原密码错误或着输入新密码为空");
			} else if (response == '1') {
				wxcalert("操作成功！");
				setTimeout(function() {
					index.load(loadUrl);
				}, 1000);
			}
			$("#btn").removeAttr("disabled");
		}, "json");
	},
	// Ajax提交 有验证,提交是否成功  有提示，不刷新页面
	ajaxCheck : function(formid,url){
		$('#'+formid).validationEngine({   
            scroll       			: true,
            showOneMessage			: true,
            fozyFirstField			: true   
        });
		//如果验证通过则提交
		if($('#'+formid).validationEngine('validate')){
			$("#btn").attr({"disabled":"disabled"});
			var param = $("#"+formid).serialize();
			$.post(url, param, function(response) {
				if (response == '0') {
					window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
				} else if (response == '1') {
					wxcalert("操作成功！");
				}
				$("#btn").attr({"disabled":"disabled"});
			}, "json");
		}
	}
};

