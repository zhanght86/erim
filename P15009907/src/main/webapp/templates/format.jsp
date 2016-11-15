<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
<title>佳旅联合</title>
<meta name="keywords" content="生产商注册页面" />
<meta name="description" content="生产商注册页面" />
<!--注册页样式 start-->
<link rel="stylesheet" type="text/css"
	href="$staticRoot/css/regedit.css">
<!--注册页样式 end-->
</head>
<body>
	<header class="mb28">
		<a href="#"> <img src="images/login_logo.png" width="287"
			height="62"></a> <img class="fr pt15" src="images/login_step2.png"
			width="152" height="38">
	</header>
	<div class="g_cont pt15 pb40">
		<h2 class="g_tit_1 pl110 mb20">填写资料</h2>
		<p class="g_txt_1 pl110 mb10">
			(带 <em>*</em> 号的表示为必填项目)
		</p>
		<div class="form_block">
			<label>品牌名称：</label> <input type="text" class="txt_w240">
		</div>
		<div class="form_block">
			<label>公司名称：</label> <input type="text" class="txt_w240"> <em>*</em>
			<span>（可以使用中文，但禁止使用特殊符号）</span>
		</div>
		<div class="form_block">
			<label>公司传真：</label> <input type="text" class="txt_w240"> <em>*</em>
			<span class="error">所填信息不能为空</span>
		</div>
		<div class="form_block">
			<label>公司地址：</label> <select class="sel_w100">
				<option>河北省</option>
				<option>山东省</option>
			</select> <select class="sel_w100">
				<option>河北省</option>
				<option>山东省</option>
			</select> <select class="sel_w100">
				<option>河北省</option>
				<option>山东省</option>
			</select> <br> <input type="text" class="txt_w320 ml220 mt18"
				placeholder="请输入详细地址">
		</div>
		<div class="form_block">
			<label>地图标注：</label> <input type="text" class="txt_w240"> <br>
			<textarea class="txt_box ml220 mt18"></textarea>
		</div>
		<div class="form_block">
			<label>公司性质：</label> <select class="sel_w100">
				<option>专线商</option>
				<option></option>
			</select> <select class="sel_w100">
				<option></option>
				<option>山东省</option>
			</select> 旅游驻&nbsp;&nbsp;<select class="sel_w100">
				<option></option>
				<option>山东省</option>
			</select> 专线
		</div>
		<div class="form_block">
			<label>可服务同业区域：</label> <select class="sel_w100">
				<option>河北省</option>
				<option>山东省</option>
			</select> <select class="sel_w100">
				<option>河北省</option>
				<option>山东省</option>
			</select> <select class="sel_w100">
				<option>河北省</option>
				<option>山东省</option>
			</select>
		</div>
		<div class="form_block">
			<label>可服务同业区域：</label> <span class="yr_img"></span> <input id="img"
				style="border: none;" type="file">
		</div>
		<div class="form_block">
			<label>经营许可证扫描件：</label> <span class="yr_img"></span> <input id="img"
				style="border: none;" type="file">
		</div>
		<div class="form_block">
			<label>负责人证明：</label> <span class="yr_img"></span> <input id="img"
				style="border: none;" type="file">
		</div>
		<div class="form_block2 mt60">
			<p class="g_txt_1">
				<label> <input name="Fruit" type="checkbox" />
					&nbsp;&nbsp;&nbsp;同意佳佳旅行网服务条款 <a href="#">查看条款</a> 并核实你所填写信息无误
				</label>
			</p>
			<br> <input type="submit" value="提交信息">
		</div>
	</div>
	#include("company/regedit/footer.vm")
</body>
</html>
