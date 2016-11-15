function enableSubmit(bool){
	if(bool)$("#submit").removeAttr("disabled");
	else $("#submit").attr("disabled","disabled");
}

function v_submitbutton(){
	if($("#agree").attr("checked")!="checked") {
		enableSubmit(false);
		$(".readagreement-wrap").css("outline","1px solid #fff");
		return;
	}else{
		$(".readagreement-wrap").css("outline","1px solid #fff");
	}
	for(f in flags) if(!flags[f]) {
		enableSubmit(false); 
		return;
	}
	enableSubmit(true);
}

function showAgreement(){
	$("#readagreement").removeAttr("onclick");
	$("#agreement").show();
	$("#agreement iframe").attr("src",$appRoot/login/tiaokuan);//此处为链接地址
}

function agree(){
	$("#agreement").hide();
	$("#readagreement").attr("onclick","showAgreement();");
	if($("#agree").attr("checked")!="checked") $("#agree").trigger("click");
}

function onReadAgreementClick(){
	return;
	if($("#agree").attr("checked")){
		$("#agree").removeAttr("checked");
	}else{
		$("#agree").attr("checked","checked");
	}
	v_submitbutton();
}

var flags = [false,false,false,false];

//邮箱验证，网上找到的正则
var RegEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
var Regplane = /^1[3|4|5|8][0-9]\d{8}$/;
function lineState(name,state,msg){
	if(state=="none"){$("#line_"+name+" .tips div").attr("class","none"); return;}
	if(state=="corect"){$("#line_"+name+" .tips div").attr("class","corect");return;}
	$("#line_"+name+" .tips span").text(msg);$("#line_"+name+" .tips div").attr("class","error");
}

function v_account(){
	var account = $("#account").val();
	if(!RegEmail.test(account)) {lineState("account","error","邮箱格式不正确"); flags[0]=false;enableSubmit(false);}
	else{lineState("account","corect","");flags[0] = true;}
	v_submitbutton();
}

function v_name(){
	var name = $("#name").val();
	if(name.length==0) {
		lineState("name","error","不得为空"); 
		flags[1]=false;
	}else{
		if(!Regplane.test(name)){
			lineState("name","error","手机号码格式不正确"); flags[1]=false;enableSubmit(false);
		}else{
			lineState("name","corect",""); 
			flags[1] = true;
		}
	}
	v_submitbutton();
}

function v_password(){
	var password = $("#password").val();
	if(password.length<6) {
		lineState("password","error","必须多于或等于6个字符"); 
		flags[2]=false;
	}else{
		if(password.length>16){
			lineState("password","error","必须少于或等于16个字符"); 
			flags[2]=false;
		}else{
			lineState("password","corect","");
			flags[2] = true;
		}
	}
	v_repeat();
	v_submitbutton();
}

function v_repeat(){
	if(!flags[2]) {
		lineState("repeat","none",""); 
		return;
	}
	if($("#password").val()!=$("#repeat").val()) {
		lineState("repeat","error","密码不一致"); 
		flags[3]=false;
	}else{
		lineState("repeat","corect","");
		flags[3] = true;
	}
	v_submitbutton();
}

function adaptValue(){
	return true;
}


/*校验码*/
function adaptValue2(){
	return true;
}
function enableSt(bool){
	if(bool)$("#submit2").removeAttr("disabled");
	else $("#submit2").attr("disabled","disabled");
}
var Regver = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
var Regcheck = /^1[3|4|5|8][0-9]\d{8}$/;
function lineSt(name,state,msg){
	if(state=="none"){$("#line2_"+name+" .tips2 div").attr("class","none"); return;}
	if(state=="corect"){$("#line2_"+name+" .tips2 div").attr("class","corect");return;}
	$("#line2_"+name+" .tips2 span").text(msg);$("#line2_"+name+" .tips2 div").attr("class","error");
}

function v_verification(){
	var account = $("#verification").val();
	if(!Regver.test(verification)) {lineSt("verification","error","邮箱格式不正确"); flags[0]=false;enableSt(false);}
	else{lineSt("verification","corect","");flags[0] = true;}
}
function v_check(){
	var check = $("#check").val();
	if(check.length==0) {
		lineSt("check","error","不得为空"); 
		flags[1]=false;
	}else{
		if(!Regcheck.test(check)){
			lineSt("check","error","手机号码格式不正确"); flags[1]=false;enableSt(false);
		}else{
			lineSt("check","corect",""); 
			flags[1] = true;
		}
	}
}