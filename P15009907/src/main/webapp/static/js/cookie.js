
// 自定义  js cookies
var mycookie = {
		
	// 放置
	set : function(name,value){
		var Days = 30; //此 cookie 将被保存 30 天
	    var exp  = new Date();    //new Date("December 31, 9998");
	    exp.setTime(exp.getTime() + Days*24*60*60*1000);
	    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
	},
	
	//获取
	get : function(name){
		 var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
	     if(arr != null) return unescape(arr[2]); return null;
	},
	
	//删除
	del : function(name){
		var exp = new Date();
	    exp.setTime(exp.getTime() - 1);
	    var cval=mycookie.get(name);
	    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
	}
}