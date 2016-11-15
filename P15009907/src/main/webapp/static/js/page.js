/**
 * 分页
 */
var page = {
	//跳转路径
	url     : "",
	backurl : "",
	//初始化body right  a标签连接
	init : function(){
		$(".tpager a").click(function(){
			//分页时触发
			if($(this).attr("text") != undefined){
				var texturl = "";
				if(page.url.indexOf('?')>-1){
					texturl = $(this).attr("text").replace('?','&');
					var u = page.url + texturl;
					index.load(u);
				}else{
					var u = page.url + $(this).attr("text");
					index.load(u);
				}
			}
			//a标签触发
			if($(this).attr("link") != undefined){
				var url = $(this).attr("link");
				index.load(url);
			}
		});
	}
};