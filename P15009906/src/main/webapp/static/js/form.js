/**
 * 表单应用js
 */
var form = {
	//提交
	sub : function(formid,url){
		var data = $("#"+formid).serialize();
		$.post(url, data,
			function(response) {
				if (response == '0') {
					try{
						wxcalert("服务器繁忙，请稍后！");
					}catch (e) {
						// TODO: handle exception
						alert("服务器繁忙，请稍后！");
					}
				} else if (response == '1') {
					try{
						wxcalert("操作成功！");
					}catch (e) {
						// TODO: handle exception
						alert("操作成功！");
					}
					index.load(page.url);
				}
			}, 
		"json");
	}
};