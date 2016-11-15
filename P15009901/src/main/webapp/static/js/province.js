	//选择国内 国际变化
	$("select[province='country']").change(function(){
		var v = $(this).val();
		//国际/港澳台
		if("02" == v){
			$("label[province='gn']").hide();
			$("label[province='gj']").show();
			//初始化省
			$("select[province='province']").val("");
			$("select[province='city']").html("<option value=''></option>");
		}
		//国内
		else if("01" == v){
			$("label[province='gn']").show();
			$("label[province='gj']").hide();
			$("label[province='gjj']").hide();
			//初始化国际
			$("select[province='selgj']").val("");
			$("input[province='inputgj']").attr("value","");
		}
		//空
		else{
			//初始化省
			$("select[province='province']").val("");
			$("select[province='city']").html("<option value=''></option>");
			//初始化国际
			$("select[province='selgj']").val("");
			$("input[province='inputgj']").attr("value","");
			
			$("label[province='gn']").hide();
			$("label[province='gj']").hide();
			$("label[province='gjj']").hide();
		}
	});
	
	//选择地区为国外时变化
	$("select[province='selgj']").change(function(){
		var v = $(this).val();
		//如果选择国际时国家框显示
		if("04" == v){
			$("label[province='gjj']").show();
		}else{
			$("label[province='gjj']").hide();
			$("input[province='inputgj']").attr("value","");
		}
	});
	
	//省切换
	$("select[province='province']").change(function(){
		//省
		var province = $(this).val();
		if("" == province){
			$("select[province='city']").html("<option value=''></option>");
		}else{
			//省
			$.post("/ajaxGetRegion","regionid="+province,function(data){
				var htm = "<option value=''></option>";
				$.each(data,function(i,item){
					htm += "<option value='"+i+"'>"+item+"</option>";
				});	
				$("select[province='city']").html(htm);
			},"json");
		}
	});
