/**
 * 主页用到js
 */
var index = {
		
	
	//左侧访问路径
	load : function(url){
		url = index.timestamp(url);
		$(".zh_block").load(url);
	},
	//表单查询
	searchform : function(formid,url){
		var param = $("#"+formid).serialize();
		url = url + "?" + param;
		index.load(url);
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
	regionAll : function(regionid,city,county,selectCity,selectCounty){
		
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
	}
};


//左侧点击
var left = {
    //链接
    location : function(linkurl,parentname,functionname){
        //更改标题指向
        $("#titleSpan").html(parentname + "&nbsp;>&nbsp;" + functionname);
        
        //加载路径改变右侧状态
        index.load(linkurl);
        page.url = linkurl;
    } 
};
