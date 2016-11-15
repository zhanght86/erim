/**
 * 主页用到js
 */
var index = {
	
	//分页公用js
	pubload : function(url){
		//路径加上时间戳
		url = index.timestamp(url);
//		$.post(url,function(data){
//		    //放到cookie 防止页面刷新
//			mycookie.set("loaddata",url);
//		    
//		    data += '<script type="text/javascript" src="/static/js/h5.js"></script>';
//		    $(".rightcontent .rdiv").html(data);
//		},'html');
		$.ajax({
			 type  : "GET",
             url   : url,
             async : false,
             success : function(data){
            	//放到cookie 防止页面刷新
            	 if(url.substring(0,1).indexOf('?')>-1){
            		 mycookie.del("loaddata");
                	 mycookie.set("loaddata",url);
            	 }
            	 data += '<script type="text/javascript" src="/static/js/h5.js"></script>';
            	 $(".rightcontent .rdiv").html(data);
             }
		});
		//$(".rightcontent .rdiv").load(url);
		//$(".rightcontent .rdiv").append('<script type="text/javascript" src="/static/js/h5.js"></script>');
	},
	//下一页
	nextPage : function(url){
		page.url = url;
		index.pubload(url);
	},
	//右侧访问路径
	load : function(url){
		index.pubload(url);
	},
	//解决浏览器缓存
	timestamp : function(url){
		var getTimestamp=new Date().getTime();
		if(url.indexOf("?")>-1){
		  url=url+"&t="+getTimestamp;
		}else{
		  url=url+"?t="+getTimestamp;
		}
		return url;
	},
	//删除
	del : function(url){
		$("body").append(index.htmldel);
		$('.del_mask').fadeIn(100);
		$('.del').slideDown(200);
		//删除
		index.delclick(url);
	},
	//删除事件
	delclick : function(url){
		//取消删除
		$('.del .delquxiao').click(function() {
			$('.del_mask').fadeOut(100);
			$('.del').slideUp(200);
		});
		//确认删除
		$('.del .delqueren').click(function() {
			$('.del_mask').fadeOut(100);
			$('.del').slideUp(200);
			index.suburl(url,page.url);
		});
	},
	//提交路径
	suburl : function(url,loadUrl){
		$.post(url,
			function(response) {
				if (response == '0') {
					window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
				} else if (response == '1') {
					alert("操作成功！");
					setTimeout(function() {
						index.load(loadUrl);
					}, 1000);
				}
			}, 
		"json");
	},
	//表单查询
	searchform : function(formid,url){
		var param = $("#"+formid).serialize();
		url = url + "?" + param;
		index.load(url);
	},
	// //提醒 兼容ie8
	// placeholder : function(){
	     // //判断浏览器是否支持placeholder属性
          // supportPlaceholder='placeholder'in document.createElement('input'),
          // placeholder=function(input){
            // var text = input.attr('placeholder');
//             
            // defaultValue = input.defaultValue;
            // if(!defaultValue){
              // input.val(text).addClass("phcolor");
            // }
            // input.focus(function(){
              // if(input.val() == text){
                // $(this).val("");
              // }
            // });
//          
            // input.blur(function(){
              // if(input.val() == ""){
                // $(this).val(text).addClass("phcolor");
              // }
            // });
//          
            // //输入的字符不为灰色
            // input.keydown(function(){
              // $(this).removeClass("phcolor");
            // });
          // };
//          
          // //当浏览器不支持placeholder属性时，调用placeholder函数
          // if(!supportPlaceholder){
            // $('input').each(function(){
              // text = $(this).attr("placeholder");
              // if($(this).attr("type") == "text"){
                // placeholder($(this));
              // }
            // });
          // }
	// },
//	//提交表单，提交成功则跳转页面到指定页面 - 成功则无提示
//	subload : function(data,url,loadUrl) {
//		$('#'+data).validationEngine({   
//            scroll       			: true,
//            showOneMessage			: true,
//            focusFirstField			: true   
//        });
//		//如果验证通过则提交
//		if($('#'+data).validationEngine('validate')){
//			$.post(url, $("#"+data).serialize(), function(response) {
//				if (response == '0') {
//					window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
//				} else if (response == '1') {
//					setTimeout(function() {
//						index.load(loadUrl);
//					}, 1000);
//				}
//			}, "json");
//		}
//	},
//	//提交表单，提交成功则跳转页面到指定页面 - 是否成功都给提示
//	sub : function(data,url,loadUrl){
//		$('#'+data).validationengine({   
//            scroll       			: true,
//            showOneMessage			: true,
//            focusFirstField			: true   
//        });
//		//如果验证通过则提交
//		if($('#'+data).validationEngine('validate')){
//			$.post(url, $("#"+data).serialize(),
//				function(response) {
//					if (response == '0') {
//						window.wxc.xcConfirm("服务器繁忙，请稍后！", window.wxc.xcConfirm.typeEnum.error);
//					} else if (response == '1') {
//						wxcalert("操作成功！");
//						setTimeout(function() {
//							index.load(loadUrl);
//						}, 1000);
//					}
//				}, 
//			"json");
//		}
//	},
	/**
	 * 省市县初始化
	 * @param initProvinceId  初始化省ID
	 * @param province		  省对应name名称
	 * @param city			  市对应name名称
	 * @param town			  县对应name名称
	 * @param valCity		  修改时添加市默认选中值
	 * @param valTown		  修改时添加县默认选种植
	 */
	initProvince : function(initProvinceId,province,city,town,valCity,valTown){
		//省
		var vProvince = "select[name='"+province+"']";
		//市
		var vCity = "select[name='"+city+"']";
		//县
		var vTown = "select[name='"+town+"']";
		index.regionAll(initProvinceId,vCity,vTown,valCity,valTown);
		
		//省市县级联
		$(vProvince).change(function(){
			index.regionAll($(this).val(),vCity,vTown);
		});
		//市县级联
		$(vCity).change(function(){
			index.region($(this).val(),vTown);
		});
	},
	
	/**
	 * 
	 * @param initProvinceId  初始化省id
	 * @param province		  省对应id名称
	 * @param city			  市对应id名称
	 * @param town			  县对应id名称
	 * @param valCity		  修改时添加市默认选中值
	 * @param valTown		  修改时添加县默认选种植
	 */
	initProvinceByCity : function(initProvinceId,province,city,town,valCity,valTown){
		//省
		var vProvince = "select[city='"+province+"']";
		//市
		var vCity = "select[city='"+city+"']";
		//县
		var vTown = "select[city='"+town+"']";
		index.regionAll(initProvinceId,vCity,vTown,valCity,valTown);
		
		//省市县级联
		$(vProvince).change(function(){
			index.regionAll($(this).val(),vCity,vTown);
		});
		//市县级联
		$(vCity).change(function(){
			index.region($(this).val(),vTown);
		});
	},
	
	//删除,并跳转到指定页面
	delload : function(url, loadUrl){
		$("body").append(index.htmldel);
		$('.del_mask').fadeIn(100);
		$('.del').slideDown(200);
		//取消删除
		$('.del .delquxiao').click(function() {
			$('.del_mask').fadeOut(100);
			$('.del').slideUp(200);
		});
		//确认删除
		$('.del .delqueren').click(function() {
			$('.del_mask').fadeOut(100);
			$('.del').slideUp(200);
			index.suburl(url,loadUrl);
		});
	},
	//国家
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
	//省-市-县 二级
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
	
	//省市县
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
				index.region(selectCity,county,selectCounty);
			}else{
				//默认第一个省
				var cityid = "";
				$.each(data,function(i,item){
					html += "<option value='" + i + "'>"+item+"</option>";
	                if("" == cityid) cityid = i;
				});				
				$(city).html(html);
				if("" != cityid){
					index.region(cityid,county);
				}
			}
		},"json");
	},
	//删除html
	htmldel : '<div class="del">'
					+'<div class="deltop">提示</div>'
						+'<div class="delcter">'
							+'<div class="delctera">'
								+'<img src=\"static/images/del.png\">'
								+'<div class="delfont">'
									+'<span>您确认要删除吗？</span> <span>如果是请点击确认，不是点击取消</span>'
								+'</div>'
							+'</div>'
							+'<div class="delcterb">'
								+'<button type="submit" class="delqueren"></button>'
								+'<button type="button" class="delquxiao"></button>'
							+'</div>'
						+'</div>'
					+'</div>'
					+'<div class="del_mask"></div>',
	//删除成功
	htmlmessage : '<div class="del">'
					+'<div class="deltop">提示</div>'
						+'<div class="delcter">'
							+'<div class="delctera">'
								+'<img src=\"static/images/del.png\">'
								+'<div class="delfont">'
									+'<span>删除成功</span>'
								+'</div>'
							+'</div>'
							+'<div class="delcterb">'
								+'<button type="button" class="delquxiao"></button>'
							+'</div>'
						+'</div>'
					+'</div>'
					+'<div class="del_mask"></div>'
};

// 默认为null的省市县加载
var regUtil = {
		
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
		//var html = "<option value=''></option>";
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
