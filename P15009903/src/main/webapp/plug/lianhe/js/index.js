/**
 * 主页用到js
 */
var index = {
		
	
	//右侧访问路径
	load : function(url){
		$("#rdiv").load(url);
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
			form.suburl(url,page.url);
		});
	},
	//省-市-县 二级
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
	//省市县
	regionAll : function(regionid,city,county,selectCity,selectCounty){
		
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
								+'<img src=\"'+_staticRoot+'/images/del.png\">'
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
								+'<img src=\"'+_staticRoot+'/images/del.png\">'
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