/**
 * 表单应用js
 */
var form = {
	//提交表单
	sub : function(data,url,loadUrl){
		$.post(url, data,
			function(response) {
				if (response == '0') {
					alert("服务器繁忙，请稍后！");
				} else if (response == '1') {
					$alert("操作成功！");
					setTimeout(function() {
						index.load(loadUrl);
					}, 1000);
				}
			}, 
		"json");
	},
	//提交路径
	suburl : function(url,loadUrl){
		$.post(url,
			function(response) {
				if (response == '0') {
					alert("服务器繁忙，请稍后！");
				} else if (response == '1') {
					alert("操作成功！");
					setTimeout(function() {
						index.load(loadUrl);
					}, 1000);
				}
			}, 
		"json");
	},
	//查询表单
	search : function(){
		var url = $(".form-search").attr("action");
		var param = $(".form-search").serialize();
		url = url + "?" + param;
		index.load(url);
		return false;
	},
	//注册页
	regedit : function(data,url,loadUrl){
		$.post(url, data,
			function(response) {
				if (response == '0') {
					alert("服务器繁忙，请稍后！");
				} else if (response == '1') {
					setTimeout(function() {
						window.location = loadUrl;
					}, 1000);
				}
			}, 
		"json");
	},
	//更新
	update : function(formid,url){
		$('#'+formid).validationEngine({   
            scroll       			: true,
            showOneMessage			: true,
            focusFirstField			: true   
        });
		//如果验证通过则提交
		if($('#'+formid).validationEngine('validate')){
			form.sub($("#"+formid).serialize(),url,page.url);
		}
	}
};