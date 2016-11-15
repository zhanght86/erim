/**
 * 登录
 */
var login = {
	
	//验证表单
	validationEngine : function(){
		$("#form1").validationEngine({   
            validationEventTriggers : "blur", 
            inlineValidation        : false,   
            promptPosition          : "topLeft"
        });
	},
	
	//提交表单
	subform : function(){
		//提交表单时验证表单元素
      	$("div[class='anniu3']").click(function() { 
    		//验证通过时提交表单
    		if($('#form1').validationEngine('validate')){
    			$("#form1").submit();
    		}
        });  
	},
	
	//输入
	input: {
		//用户名
		username : function(){
			var data = $("input[name='username']");
		}
	}
}

login.validationEngine();
login.subform();
//login.input.username();