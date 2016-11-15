
/**
 * 产品检索 
 */
var search = {
	
	//初始化从今天开始五天
	fiveDate : function(id,fxid,cid,afterd,ntype){
		var spanDate = $("#"+id).attr("date");
		var nowdate  = new Date(spanDate);
		var date=new Date(nowdate.setDate(nowdate.getDate()+afterd*6));
		
		var year  = date.getFullYear(); 
		var month = date.getMonth()+1;
		var now   = date.getDate();
		
		//设置时间
		$("#"+id).attr("date",year+"-"+(month<10 ? "0"+month:month)+'-'+(now<10 ? "0"+now:now));
		
		//var html = '<a class="on" href="javascript:;">'+month+'/'+now+'</a>';
		var html = '<a href="javascript:;">'+month+'/'+now+'</a>';
		
		var d = date;
		for(var i = 1; i < 6; i++){
			d1 = new Date(d.setDate(d.getDate()+1));
			html   += '<a href="javascript:;">'+(d1.getMonth()+1)+'/'+(d1.getDate())+'</a>';
		}
		$("#"+id).html(html);
		
		if(null != fxid && null != cid){
			if(null != fxid && "" != fxid){
				var afxid = fxid.split(',');
				//初始化
				for(var f in afxid){
					//酒店
					if("HOTEL" == ntype){
						search.hotel(cid,afxid[f],year,month,now);
					//门票
					}else if("TICKET" == ntype){
						search.ticket(cid,afxid[f],year,month,now);
					//特色餐
					}else if("CAFETERIA" == ntype){
						search.cafeteria(cid,afxid[f],year,month,now);
					//租车
					}else if("TEXI" == ntype){
						search.texi(cid,afxid[f],year,month,now);
					//导游
					}else if("GUIDE" == ntype){
						search.guide(cid,afxid[f],year,month,now);
					//签证
					}else if("MANAGEMENT" == ntype){
						search.management(cid,afxid[f],year,month,now);
					//当地游
					}else if("GROUND" == ntype){
						search.ground(cid,afxid[f],year,month,now);
					//专线
					}else if("LINE" == ntype){
						search.line(cid,afxid[f],year,month,now);
					}
				}
			}
		}
	},
	//专线
	line : function(tdlId,cpeId,year,month,now){

		month =(month<10 ? "0"+month:month);
		now =(now<10 ? "0"+now:now);
		
		var url = "/search/line/price?startDate="+year+"-"+month+"-"+now+"&tdlId="+tdlId;
		
		$.post(url,function(data){
			if(data.length==0){
				for(var i =0;i<6;i++){
					$("#w90_"+tdlId+"_"+cpeId+"_"+i).html('');
				}
			}else{
				$.each(data,function(i,value){
					//alert(value.id);
					if(null != value.lpeSign){
						var h = "总人数"+value.lpeSign+"<br/>";
						
						if(cpeId == '0'){
							h+= "批发"+value.lpeTradeAdult+"元<br/>"
							  + "零售"+value.lpeRetailAdult+"元<br/>";
						}else if(cpeId == '1'){
							h+= "批发"+value.lpeTradeChild+"元<br/>"
							  + "零售"+value.lpeRetailChild+"元<br/>";
						}
						$("#w90_"+tdlId+"_"+cpeId+"_"+i).html(h);
					}else{
						$("#w90_"+tdlId+"_"+cpeId+"_"+i).html('');
					}
				});
			}
		},'json');
	},
	//当地游
	ground : function(gdlId,cpeId,year,month,now){

		month =(month<10 ? "0"+month:month);
		now =(now<10 ? "0"+now:now);
		
		var url = "/search/ground/price?startDate="+year+"-"+month+"-"+now+"&gdlId="+gdlId;
		
		$.post(url,function(data){
			if(data.length==0){
				for(var i =0;i<6;i++){
					$("#w90_"+gdlId+"_"+cpeId+"_"+i).html('');
				}
			}else{
				$.each(data,function(i,value){
					//alert(value.id);
					if(null != value.gpeSign){
						var h = "总人数"+value.gpeSign+"<br/>";
						
						if(cpeId == '0'){
							h+= "批发"+value.gpeWholesaleAdult+"元<br/>"
							  + "零售"+value.gpeRetailAdult+"元<br/>";
						}else if(cpeId == '1'){
							h+= "批发"+value.gpeWholesaleChild+"元<br/>"
							  + "零售"+value.gpeRetailChild+"元<br/>";
						}
						$("#w90_"+gdlId+"_"+cpeId+"_"+i).html(h);
					}else{
						$("#w90_"+gdlId+"_"+cpeId+"_"+i).html('');
					}
				});
			}
		},'json');
	},
	//签证
	management : function(gdlId,cpeId,year,month,now){

		month =(month<10 ? "0"+month:month);
		now =(now<10 ? "0"+now:now);
		
		var url = "/search/management/price?startDate="+year+"-"+month+"-"+now+"&mdlId="+gdlId;
		
		$.post(url,function(data){
			if(data.length==0){
				for(var i =0;i<6;i++){
					$("#w90_"+gdlId+"_"+cpeId+"_"+i).html('');
				}
			}else{
				$.each(data,function(i,value){
					//alert(value.id);
					if(null != value.mdlPriceTeam){
						var h = "批发"+value.mdlPriceTeam+"元<br/>"
							  + "零售"+value.mdlPriceSeal+"元<br/>";
						$("#w90_"+gdlId+"_"+cpeId+"_"+i).html(h);
					}else{
						$("#w90_"+gdlId+"_"+cpeId+"_"+i).html('');
					}
				});
			}
		},'json');
	},
	//导游
	guide : function(gdlId,cpeId,year,month,now){

		month =(month<10 ? "0"+month:month);
		now =(now<10 ? "0"+now:now);
		
		var url = "/search/guide/price?startDate="+year+"-"+month+"-"+now+"&gdlId="+gdlId+"&gdlServiceCode="+cpeId;
		
		$.post(url,function(data){
			if(data.length==0){
				for(var i =0;i<6;i++){
					$("#w90_"+gdlId+"_"+cpeId+"_"+i).html('');
				}
			}else{
				$.each(data,function(i,value){
					//alert(value.id);
					if(null != value.gpeClusterPrice){
						var h = "组团"+value.gpeClusterPrice+"元<br/>"
							  + "直客"+value.gpeGuestPrice+"元<br/>";
						$("#w90_"+gdlId+"_"+cpeId+"_"+i).html(h);
					}else{
						$("#w90_"+gdlId+"_"+cpeId+"_"+i).html('');
					}
				});
			}
		},'json');
	},
	//租车
	texi : function(hdlid,cpeId,year,month,now){
		
		
		month =(month<10 ? "0"+month:month);
		now =(now<10 ? "0"+now:now);
		
		var url = "/search/texi/price?startDate="+year+"-"+month+"-"+now+"&idType="+cpeId;
		
		cpeId = cpeId.split("_");
		
		$.post(url,function(data){
			if(data.length==0){
				for(var i =0;i<6;i++){
					$("#w90_"+hdlid+"_"+cpeId[0]+"_"+cpeId[1]+"_"+i).html('');
				}
			}else{
				$.each(data,function(i,value){
					//alert(value.id);
					if(null != value.tcpSign){
						var h = "量"+value.tcpSign+"位<br/>"
							  + "批"+value.tcpCombinationPrice+"元<br/>"
							  + "零"+value.tcpRetailPrice+"元<br/>";
						$("#w90_"+hdlid+"_"+cpeId[0]+"_"+cpeId[1]+"_"+i).html(h);
					}else{
						$("#w90_"+hdlid+"_"+cpeId[0]+"_"+cpeId[1]+"_"+i).html('');
					}
				});
			}
		},'json');
		
		//for(var i = 0; i < 6; i++){
			//var dat = date.getDate()+i;
			//$("#w90_"+hdlid+"_"+roomid+"_"+i).html("量20间<br>批190元<br>零180元");
			
		//}
	},
	//特色餐
	cafeteria : function(hdlid,cpeId,year,month,now){
		var div = "div_room_"+cpeId;
		
		month =(month<10 ? "0"+month:month);
		now =(now<10 ? "0"+now:now);
		
		var url = "/search/cafeteria/price?startDate="+year+"-"+month+"-"+now+"&cpeId="+cpeId;
		$.post(url,function(data){
			if(data.length==0){
				for(var i =0;i<6;i++){
					$("#w90_"+hdlid+"_"+cpeId+"_"+i).html('');
				}
			}else{
				$.each(data,function(i,value){
					//alert(value.id);
					if (value.cpcIsSign == '01') {
						var h = "不限量<br/>"
						+ "批"+value.cpcCombinationPrice+"元<br/>"
						+ "零"+value.cpcRetailPrice+"元<br/>";
						$("#w90_"+hdlid+"_"+cpeId+"_"+i).html(h);
					} else if(null != value.cpcSign) {
						var h = "量"+value.cpcSign+"位<br/>"
						+ "批"+value.cpcCombinationPrice+"元<br/>"
						+ "零"+value.cpcRetailPrice+"元<br/>";
						$("#w90_"+hdlid+"_"+cpeId+"_"+i).html(h);
					} else {
						$("#w90_"+hdlid+"_"+cpeId+"_"+i).html('');
					}
				});
			}
		},'json');
		
		//for(var i = 0; i < 6; i++){
			//var dat = date.getDate()+i;
			//$("#w90_"+hdlid+"_"+roomid+"_"+i).html("量20间<br>批190元<br>零180元");
			
		//}
	},
	//酒店
	hotel : function(hdlid,roomid,year,month,now){
		var div = "div_room_"+roomid;
		
		month =(month<10 ? "0"+month:month);
		now =(now<10 ? "0"+now:now);
		
		var url = "/search/hotel/price?startDate="+year+"-"+month+"-"+now+"&hdlId="+hdlid+"&hheId="+roomid;
		$.post(url,function(data){
			if(data.length==0){
				for(var i =0;i<6;i++){
					$("#w90_"+hdlid+"_"+roomid+"_"+i).html('');
				}
			}else{
				$.each(data,function(i,value){
					//alert(value.id);
					if(null != value.hnpSign){
						var h = "量"+value.hnpSign+"间<br/>"
							  + "批"+value.hnpCombinationPrice+"元<br/>"
							  + "零"+value.hnpRetailPrice+"元<br/>";
						$("#w90_"+hdlid+"_"+roomid+"_"+i).html(h);
					}else{
						$("#w90_"+hdlid+"_"+roomid+"_"+i).html('');
					}
				});
			}
		},'json');
		
		//for(var i = 0; i < 6; i++){
			//var dat = date.getDate()+i;
			//$("#w90_"+hdlid+"_"+roomid+"_"+i).html("量20间<br>批190元<br>零180元");
			
		//}
	},
	//门票
	ticket : function(tdlid,tclId,year,month,now){
		var div = "div_room_"+tdlid;
		
		month =(month<10 ? "0"+month:month);
		now =(now<10 ? "0"+now:now);
		
		var url = "/search/ticket/price?startDate="+year+"-"+month+"-"+now+"&tclId="+tclId;
		$.post(url,function(data){
			if(data.length==0){
				for(var i =0;i<6;i++){
					$("#w90_"+tdlid+"_"+tclId+"_"+i).html('');
				}
			}else{
				$.each(data,function(i,value){
					//alert(value.id);
					if(null != value.tplSign || null != value.tplCombinationPrice){
						var h = "";
							if('01' == value.tplIsSign) h += "不限量";
							else h+= "量"+value.tplSign+"张";
							h+= "<br/>";
							h+= "批"+value.tplCombinationPrice+"元<br/>"
							  + "零"+value.tplRetailPrice+"元<br/>";
						$("#w90_"+tdlid+"_"+tclId+"_"+i).html(h);
					}else{
						$("#w90_"+tdlid+"_"+tclId+"_"+i).html('');
					}
				});
			}
		},'json');
		
		//for(var i = 0; i < 6; i++){
			//var dat = date.getDate()+i;
			//$("#w90_"+hdlid+"_"+roomid+"_"+i).html("量20间<br>批190元<br>零180元");
			
		//}
	}
}


////////////////////////////////////////////////////////////// 通用js 分割 //////////////////////////////////////////////////////////////////

$(".select_block").each(function(){
	if($(this).height()>90){
		$(this).children(".more_a").show();
		$(this).css({"height":"40px","overflow":"hidden"});
	}
})

	
/*查询通用点击 详情*/
$(".zh_block").on("click",".clistctma_ctl",function(){
		initHideTr();
		$(this).parent().parent().next().show();
		$(".chakan_a").text("查看").css("background-color","#EB6464");
})
$(".zh_block").on("click",".g_block_2 .close_a",function(){
	$("tr[tid='tr_detail']").hide();
});


/*查询通用点击 预定*/
$(".chakan_a").die("click").live("click",function(){
	if($(this).text()=="查看"){
		$(".chakan_a").text("查看").css("background-color","#EB6464");
		
		$(this).text("查看中").css("background-color","#969696");
		
		initHideTr();
		$(this).parent().parent().next().next().show();
		//显示
		$(".chakan_cont").show();
	}
	else{
		$("tr[tid='tr_list']").hide();
		$(this).text("查看").css("background-color","#EB6464");
	}
})

//初始化隐藏tr
function initHideTr(){
	$("tr[tid='tr_detail']").hide();
	$("tr[tid='tr_list']").hide();
}