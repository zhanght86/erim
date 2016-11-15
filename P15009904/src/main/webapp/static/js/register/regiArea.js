/*
 * 注册页面 省市县加载JS方法
 */
var regiArea = {
	initProvince : function(initProvinceId,province,city,town,valCity,valTown){
		//省
		var vProvince = "select[name='"+province+"']";
		//市
		var vCity = "select[name='"+city+"']";
		//县
		var vTown = "select[name='"+town+"']";
		
		regiArea.regionAll(initProvinceId,vCity,vTown,valCity,valTown);
		
		//省市县级联
		$(vProvince).change(function(){
			regiArea.regionAll($(this).val(),vCity,vTown);
		});
		//市县级联
		$(vCity).change(function(){
			regiArea.region($(this).val(),vTown);
		});
	},
	// 省-市-县 二级
	region : function(regionid,key,val){
		var html = "<option value=''></option>";
		$.post("/ajaxGetRegion","regionid="+regionid,function(data){
			$.each(data,function(i,item){
				if(val != undefined &&  i == Number(val)){
					html += "<option value='" + i + "' selected>"+item+"</option>";
				}else{
					html += "<option value='" + i + "'>"+item+"</option>";
				}
			});				
			$(key).html(html);
		},"json");
	},
	// 省市县
	// regionid：默认省的健，城市标签ID，县标签ID，
	regionAll : function(regionid,city,county,selectCity,selectCounty){
		if (regionid == "") {
			$(city).html(null);
			return;
		}
		var html = "";
		//市一级
		$.post("/ajaxGetRegion","regionid="+regionid,function(data){
			//如果选择城市选择不为空
			if(undefined != selectCity && "" != selectCity){
				$.each(data,function(i,item){
					if(i == selectCity){
						html += "<option value='" + i + "' selected>"+item+"</option>";
					}else{
						html += "<option value='" + i + "'>"+item+"</option>";
					}
	                if("" == cityid) cityid = i;
				});				
				$(city).html(html);
				regiArea.region(selectCity,county,selectCounty);
			} else {
				//默认第一个省
				var cityid = "";
				$.each(data,function(i,item){
					html += "<option value='" + i + "'>"+item+"</option>";
	                if("" == cityid) cityid = i;
				});				
				$(city).html(html);
				if("" != cityid){
					regiArea.region(cityid,county);
				}
			}
		},"json");
	}
};

/*
 * 默认为null 注册页 省市县加载
 */
var nullArea = {
		
	initProvince : function(initProvinceId,province,city,town,valCity,valTown){
		//省
		var vProvince = "select[name='"+province+"']";
		//市
		var vCity = "select[name='"+city+"']";
		//县
		var vTown = "select[name='"+town+"']";
		
		nullArea.regionAll(initProvinceId,vCity,vTown,valCity,valTown);
		
		//省市县级联
		$(vProvince).change(function(){
			nullArea.regionAll($(this).val(),vCity,vTown);
		});
		//市县级联
		$(vCity).change(function(){
			nullArea.region($(this).val(),vTown);
		});
	},
	// 省-市-县 二级
	region : function(regionid,key,val){
		if (regionid == '') {
			$(key).html(null);
			return;
		}
		var html = "<option value=''></option>";
		$.post("/ajaxGetRegion","regionid="+regionid,function(data){
			$.each(data,function(i,item){
				if(val != undefined &&  i == Number(val)){
					html += "<option value='" + i + "' selected>"+item+"</option>";
				}else{
					html += "<option value='" + i + "'>"+item+"</option>";
				}
			});				
			$(key).html(html);
		},"json");
	},
	// 省市县
	// regionid：默认省的健，城市标签ID，县标签ID，
	regionAll : function(regionid,city,county,selectCity,selectCounty){
		if (regionid == '') {
			$(city).html(null);
			$(county).html(null);
			return;
		}
		var html = "<option value=''></option>";
		//市一级
		$.post("/ajaxGetRegion","regionid="+regionid,function(data){
			//如果选择城市选择不为空
			if(undefined != selectCity && "" != selectCity){
				$.each(data,function(i,item){
					if(i == selectCity){
						html += "<option value='" + i + "' selected>"+item+"</option>";
					}else{
						html += "<option value='" + i + "'>"+item+"</option>";
					}
	                if("" == cityid) cityid = i;
				});				
				$(city).html(html);
				nullArea.region(selectCity,county,selectCounty);
			} else {
				//默认第一个省
				var cityid = "";
				$.each(data,function(i,item){
					html += "<option value='" + i + "'>"+item+"</option>";
	                if("" == cityid) cityid = i;
				});				
				$(city).html(html);
				if("" != cityid){
					nullArea.region(cityid,county);
				}
			}
		},"json");
	}
};
