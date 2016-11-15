
//锁定权限后 控制范围

var lock = {
	//初始化
	inithtml: "<option value=''></option>", 
	//根据省获取城市
	city : function(data,key,key1,val,val1){
		
		if(""!=data.val()){
			$.post("/ajaxLockGetRegion","regionid="+data.val(),function(data){
				var html = "",region = "";
				//if(data.length > 0) { html = lock.inithtml };
				$.each(data,function(i,item){
					if(val != undefined &&  item.regionId == val){
						html += "<option value='" + item.regionId + "' selected>"+item.regionName+"</option>";
					}else{
						html += "<option value='" + item.regionId + "'>"+item.regionName+"</option>";
					}
				});				
				$("#"+key).html(html);
				
				lock.town($("#"+key),key1,val1);
			},"json");
		}else{
			$("#"+key).html(lock.inithtml);
			$("#"+key1).html(lock.inithtml);
		}
	},
	//根据市获取城镇
	town : function(data,key,val){
		if(""!=data.val()){
			$.post("/ajaxLockGetTown","regionid="+data.val(),function(data){
				var html = "";
				if(data.length > 1) { html = lock.inithtml };
				$.each(data,function(i,item){
					if(val != undefined &&  item.regionId == val){
						html += "<option value='" + item.regionId + "' selected>"+item.regionName+"</option>";
					}else{
						html += "<option value='" + item.regionId + "'>"+item.regionName+"</option>";
					}
				});				
				$("#"+key).html(html);
			},"json");
		}else{
			$("#"+key).html(lock.inithtml);
		}
	}
}


//锁定权限后 控制范围 - 自定义 省市默认第一条

var custom = {
	//初始化
	inithtml: "<option value=''></option>", 
	//根据省获取城市
	city : function(data,key,key1,val,val1){
		
		if(""!=data.val()){
			$.post("/ajaxLockGetRegion","regionid="+data.val(),function(data){
				var html = "",region = "";
				
				$.each(data,function(i,item){
					if(val != undefined &&  item.regionId == val){
						html += "<option value='" + item.regionId + "' selected>"+item.regionName+"</option>";
					}else{
						html += "<option value='" + item.regionId + "'>"+item.regionName+"</option>";
					}
				});				
				$("#"+key).html(html);
				
				custom.town($("#"+key),key1,val1);
			},"json");
		}else{
			$("#"+key).html(custom.inithtml);
			$("#"+key1).html(custom.inithtml);
		}
	},
	//根据市获取城镇
	town : function(data,key,val){
		if(""!=data.val()){
			$.post("/ajaxLockGetTown","regionid="+data.val(),function(data){
				var html = "";
				if(data.length > 1) { html = custom.inithtml };
				$.each(data,function(i,item){
					if(val != undefined &&  item.regionId == val){
						html += "<option value='" + item.regionId + "' selected>"+item.regionName+"</option>";
					}else{
						html += "<option value='" + item.regionId + "'>"+item.regionName+"</option>";
					}
				});				
				$("#"+key).html(html);
			},"json");
		}else{
			$("#"+key).html(custom.inithtml);
		}
	}
}