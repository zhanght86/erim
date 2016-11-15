
var regUtil = {
	// 右侧访问路径
	load : function(url){
		window.location=href=url;
	},
	// 表单查询
	searchform : function(formid,url){
		$('#'+formid).validationEngine({
            scroll       			: true,
            showOneMessage			: true,
            focusFirstField			: true   
        });
		//如果验证通过则提交
		if($('#'+formid).validationEngine('validate')){
			var param = $("#"+formid).serialize();
			url = url + "?" + param;
			regUtil.load(url);
		}
	},
	// 注册
	regedit : function(formid,url,loadUrl){
		$('#'+formid).validationEngine({
            scroll       			: true,
            showOneMessage			: true,
            focusFirstField			: true   
        });
		//如果验证通过则提交
		if($('#'+formid).validationEngine('validate')){
			var data = $("#"+formid).serialize();
			$.post(url, data, function(response) {
				if (response == '0') {
					window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
				} else if (response == '1') {
					setTimeout(function() {
						window.location = loadUrl;
					}, 1000);
				}
			}, "json");
		}
	},
	// 国家/城市
	country : function(countryid,key,val){
        var html = "";
        if(countryid!=""){
        	$.post("/ajaxGetCountry","countryid="+countryid,function(data){
                $.each(data,function(i,item){
                    if(val != undefined &&  i == Number(val)){
                        html += "<option value='" + i + "' selected>"+item+"</option>";
                    }else{
                        html += "<option value='" + i + "'>"+item+"</option>";
                    }
                });             
                $(key).html(html);
            },"json");
        }
	},
	initProvince : function(initProvinceId,province,city,town,valCity,valTown){
		//省
		var vProvince = "select[name='"+province+"']";
		//市
		var vCity = "select[name='"+city+"']";
		//县
		var vTown = "select[name='"+town+"']";
		
		regUtil.regionAll(initProvinceId,vCity,vTown,valCity,valTown);
		
		//省市县级联
		$(vProvince).change(function(){
			regUtil.regionAll($(this).val(),vCity,vTown);
		});
		//市县级联
		$(vCity).change(function(){
			regUtil.region($(this).val(),vTown);
		});
	},
	// 省-市-县 二级
	region : function(regionid,key,val){
		var html = "";
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
				regUtil.region(selectCity,county,selectCounty);
			} else {
				//默认第一个省
				var cityid = "";
				$.each(data,function(i,item){
					html += "<option value='" + i + "'>"+item+"</option>";
	                if("" == cityid) cityid = i;
				});				
				$(city).html(html);
				if("" != cityid){
					regUtil.region(cityid,county);
				}
			}
		},"json");
	}
};

var regNullUtil = {
		
	initProvince : function(initProvinceId,province,city,town,valCity,valTown){
		//省
		var vProvince = "#"+province;
		//市
		var vCity = "#"+city;
		//县
		var vTown = "#"+town;
		
		regNullUtil.regionAll(initProvinceId,vCity,vTown,valCity,valTown);
		
		//省市县级联
		$(vProvince).change(function(){
			regNullUtil.regionAll($(this).val(),vCity,vTown);
		});
		//市县级联
		$(vCity).change(function(){
			regNullUtil.region($(this).val(),vTown);
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
				regNullUtil.region(selectCity,county,selectCounty);
			} else {
				//默认第一个省
				var cityid = "";
				$.each(data,function(i,item){
					html += "<option value='" + i + "'>"+item+"</option>";
	                if("" == cityid) cityid = i;
				});				
				$(city).html(html);
				if("" != cityid){
					regNullUtil.region(cityid,county);
				}
			}
		},"json");
	}
};
