
//锁定权限后 控制范围

var lock = {
	//初始化
	inithtml: "<option value=''></option>", 
	//根据省获取正式
	city : function(data,key,key1,val,val1){
		
		if(""!=data.val()){
			$.post("/ajaxLockGetRegion","regionid="+data.val(),function(data){
				var html = "",region = "";
				
				if(data.length > 1) { html = lock.inithtml };
				
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