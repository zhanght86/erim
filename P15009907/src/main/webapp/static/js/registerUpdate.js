var regUtil = {
	// 右侧访问路径
	load : function(url){
		window.location=href=url;
	},
	// 表单查询
	searchform : function(formid,url){
		/*$('#'+formid).validationEngine({
            scroll       			: true,
            showOneMessage			: true,
            focusFirstField			: true   
        });
		//如果验证通过则提交
		if($('#'+formid).validationEngine('validate')){*/
			var param = $("#"+formid).serialize();
			url = url + "?" + param;
			regUtil.load(url);
		//}
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
		if (regionid == 0) {
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
		var vProvince = "select[name='"+province+"']";
		//市
		var vCity = "select[name='"+city+"']";
		//县
		var vTown = "select[name='"+town+"']";
		
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

$(function(){
	// 业务范围切换
	$(".content_liner5 label").click(function(){
    	var inde = $(".content_liner5 label").index($(this));
        $(".content_biger .content_box").eq(inde).show(0).siblings(".content_biger .content_box").hide(0);
    });
	
    /**
     * 地接社
     */
	// 服务类型
	var serv = $("input[name='cbsService']:checked").val();
	// 当等于地接社时
	if (serv == '01') {
		$("#content_box_fomr1").show();
		$("#content_box_fomr2").hide();
		
		// 地接范围-国内1
		if ($business.cbsRanProvince1 == '$business.cbsRanProvince1') {
		    regNullUtil.initProvince('','cbsRanProvince1','cbsRanCity1','cbsRanCounty1');
		} else {
		    regNullUtil.initProvince($business.cbsRanProvince1,'cbsRanProvince1','cbsRanCity1','cbsRanCounty1',$business.cbsRanCity1,$business.cbsRanCounty1);
		}
		// 地接范围-国内2
		if ($business.cbsRanProvince2 == '$business.cbsRanProvince2') {
			regNullUtil.initProvince('','cbsRanProvince2','cbsRanCity2','cbsRanCounty2');
			$(".dj_dijie_guonei2").hide();
		    $(".dj_dijie_guonei2").attr("disabled","disabled");
		} else {
			regNullUtil.initProvince($business.cbsRanProvince2,'cbsRanProvince2','cbsRanCity2','cbsRanCounty1',$business.cbsRanCity2,$business.cbsRanCounty2);
		}
		// 地接范围-国内3
		if ($business.cbsRanProvince3 == '$business.cbsRanProvince3') {
			regNullUtil.initProvince('','cbsRanProvince3','cbsRanCity3','cbsRanCounty3');
			$(".dj_dijie_guonei3").hide();
		    $(".dj_dijie_guonei3").attr("disabled","disabled");
		} else {
			regNullUtil.initProvince($business.cbsRanProvince3,'cbsRanProvince3','cbsRanCity3','cbsRanCounty3',$business.cbsRanCity3,$business.cbsRanCounty3);
		}
		// 地接范围-国内4
		if ($business.cbsRanProvince4 == '$business.cbsRanProvince4') {
			regNullUtil.initProvince('','cbsRanProvince4','cbsRanCity4','cbsRanCounty4');
			$(".dj_dijie_guonei4").hide();
		    $(".dj_dijie_guonei4").attr("disabled","disabled");
		} else {
			regNullUtil.initProvince($business.cbsRanProvince4,'cbsRanProvince4','cbsRanCity4','cbsRanCounty4',$business.cbsRanCity4,$business.cbsRanCounty4);
		}
		// 地接范围-国内5
		if ($business.cbsRanProvince5 == '$business.cbsRanProvince5') {
			regNullUtil.initProvince('','cbsRanProvince5','cbsRanCity5','cbsRanCounty5');
			$(".dj_dijie_guonei5").hide();
		    $(".dj_dijie_guonei5").attr("disabled","disabled");
		} else {
			regNullUtil.initProvince($business.cbsRanProvince5,'cbsRanProvince5','cbsRanCity5','cbsRanCounty5',$business.cbsRanCity5,$business.cbsRanCounty5);
		}
		
	} else {
		$("#content_box_fomr1").hide();
		$("#content_box_fomr2").show();
		
	}
	
    // 地接涉及区域-国内增加
    $(".dj_dj_gn_add1").click(function() {
    	$(".dj_dijie_guonei2").show();
    	$(".dj_dijie_guonei2").removeAttr("disabled");
    });
    $(".dj_dj_gn_add2").click(function() {
    	$(".dj_dijie_guonei3").show();
    	$(".dj_dijie_guonei3").removeAttr("disabled");
    });
    $(".dj_dj_gn_add3").click(function() {
    	$(".dj_dijie_guonei4").show();
    	$(".dj_dijie_guonei4").removeAttr("disabled");
    });
    $(".dj_dj_gn_add4").click(function() {
    	$(".dj_dijie_guonei5").show();
    	$(".dj_dijie_guonei5").removeAttr("disabled");
    });
    // 地接涉及区域-国内减少
    $(".dj_dj_gn_del1").click(function() {
    	$(".dj_dijie_guonei2").hide();
    	$(".dj_dijie_guonei2").attr("disabled","disabled");
    });
    $(".dj_dj_gn_del2").click(function() {
    	$(".dj_dijie_guonei3").hide();
    	$(".dj_dijie_guonei3").attr("disabled","disabled");
    });
    $(".dj_dj_gn_del3").click(function() {
    	$(".dj_dijie_guonei4").hide();
    	$(".dj_dijie_guonei4").attr("disabled","disabled");
    });
    $(".dj_dj_gn_del4").click(function() {
    	$(".dj_dijie_guonei5").hide();
    	$(".dj_dijie_guonei5").attr("disabled","disabled");
    });
    // 是否选择国家
    $("input[name='cbsRanInterna'][value='04']").change(function() {
    	var a = $("input[name='cbsRanInterna'][value='04']:checked").val();
    	if (a == '04') {
    		$(".dj_content_address_gj").show();
    		$(".dj_content_address_gj").removeAttr("disabled");
    	} else {
    		$(".dj_content_address_gj").hide();
    		$(".dj_content_address_gj").attr("disabled","disabled");
    	}
    }); 
    // 地接涉及区域-国家
    $(".dj_dijie_guojia2").hide();
    $(".dj_dijie_guojia2").attr("disabled","disabled");
    $(".dj_dijie_guojia3").hide();
    $(".dj_dijie_guojia3").attr("disabled","disabled");
    $(".dj_dijie_guojia4").hide();
    $(".dj_dijie_guojia4").attr("disabled","disabled");
    $(".dj_dijie_guojia5").hide();
    $(".dj_dijie_guojia5").attr("disabled","disabled");
    // 地接涉及区域-国家-增加
    $(".dj_dj_gj_add1").click(function() {
    	$(".dj_dijie_guojia2").show();
    	$(".dj_dijie_guojia2").removeAttr("disabled");
    });
    $(".dj_dj_gj_add2").click(function() {
    	$(".dj_dijie_guojia3").show();
    	$(".dj_dijie_guojia3").removeAttr("disabled");
    });
    $(".dj_dj_gj_add3").click(function() {
    	$(".dj_dijie_guojia4").show();
    	$(".dj_dijie_guojia4").removeAttr("disabled");
    });
    $(".dj_dj_gj_add4").click(function() {
    	$(".dj_dijie_guojia5").show();
    	$(".dj_dijie_guojia5").removeAttr("disabled");
    });
    // 地接涉及区域-国家-减少
    $(".dj_dj_gj_del1").click(function() {
    	$(".dj_dijie_guojia2").hide();
    	$(".dj_dijie_guojia2").attr("disabled","disabled");
    });
    $(".dj_dj_gj_del2").click(function() {
    	$(".dj_dijie_guojia3").hide();
    	$(".dj_dijie_guojia3").attr("disabled","disabled");
    });
    $(".dj_dj_gj_del3").click(function() {
    	$(".dj_dijie_guojia4").hide();
    	$(".dj_dijie_guojia4").attr("disabled","disabled");
    });
    $(".dj_dj_gj_del4").click(function() {
    	$(".dj_dijie_guojia5").hide();
    	$(".dj_dijie_guojia5").attr("disabled","disabled");
    });
    
    
});

