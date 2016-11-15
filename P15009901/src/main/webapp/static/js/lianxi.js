	$(function(){

				$("#btn1").click(function(){
					var txt=  "提示文字，提示文字，提示文字，提示文字，提示文字，提示文字";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
				});
				
				$("#btn2").click(function(){
					var txt=  "提示文字，提示文字，提示文字，提示文字，提示文字，提示文字";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.confirm);

				});
				
				$("#btn3").click(function(){
					var txt=  "提示文字，提示文字，提示文字，提示文字，提示文字，提示文字";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.warning);
				});
				
				$("#btn4").click(function(){
					var txt=  "提示文字，提示文字，提示文字，提示文字，提示文字，提示文字";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
				});
				
				$("#btn5").click(function(){
					var txt=  "提示文字，提示文字，提示文字，提示文字，提示文字，提示文字";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
				});
				
				$("#btn6").click(function(){
					var txt=  "请输入";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.input,{
						onOk:function(v){
							console.log(v);
						}
					});
				});
				
				$("#btn7").click(function(){
					var txt=  "<input tyle='text' value='请输入联系方式'/>";
					var option = {
						title: "联系方式",
						btn: parseInt("0011",2),
						onOk: function(){
							console.log("确认");
						}
					}
					window.wxc.xcConfirm(txt, "custom", option);
				});
				
				$("#btn8").click(function(){
					var txt=  "默认";
					window.wxc.xcConfirm(txt);
				});
			});