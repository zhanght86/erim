<link rel="stylesheet" type="text/css" href="$staticRoot/css/jipiao.css">
<div class="jd_block">
	<p class="tit_1 ml20">
		<img src="$staticRoot/images/jp_03.png" alt="添加机票" title="添加机票">添加单程直飞航班机票
	</p>
	<form method="post" id="form1">
		<div class="g_line"></div>
		<div class="flt_box mr60">
			<span class="ml55"><b></b></span>
			<div class="cb"></div>
			<div class="input_block clearfix">
				<div class="label_left w130">机票类型：</div>
				<div class="input_right input_right_wauto">
					<label class="w130"><input type="radio" id="start1"
						name="ptdIsInternational" value="01" checked />国内</label> <label><input
						type="radio" id="start2" name="ptdIsInternational" value="02" />国际·港澳台</label>
				</div>
			</div>
			<div class="input_block clearfix">
				<div class="label_left">所属航空公司：</div>
				<div class="input_right input_right_wauto">
					<input class="w130 validate[required]" name="ptdCompany">
				</div>
			</div>
			<div class="input_block clearfix">
				<div class="label_left">航班号：</div>
				<div class="input_right input_right_wauto">
					<input class="w130 validate[required]" name="ptdNumber">
				</div>
			</div>
			<div class="input_block clearfix">
				<div class="label_left">机型：</div>
				<div class="input_right input_right_wauto">
					<input class="w130 validate[required]" name="ptdModel">
				</div>
			</div>
			<div class="input_block clearfix">
				<div class="label_left">舱位：</div>
				<div class="input_right input_right_wauto">
					<label> 经济舱 </label><span class="tishi_box w90"><input
						type="text" class="w65" name="ptdClassEconomy">个</span> 座位 <label
						class="w65 ml15">商务舱</label><span class="tishi_box w90"><input
						type="text" class="w65" name="ptdClassBusiness">个</span> 座位
				</div>
			</div>
			<div class="input_block clearfix">
				<div class="label_left">出发国家：</div>
				<div class="input_right input_right_wauto">
					<label class="w130"><input type="radio" id="start1"
						onclick="$('#start_gj').hide();$('#start_gn').show();"
						name="ptdStartState" value="01" checked />国内</label> <label><input
						type="radio" id="start2"
						onclick="$('#start_gj').show();$('#start_gn').hide();"
						name="ptdStartState" value="02" />国际·港澳台</label>
				</div>
			</div>
			<div class="input_block clearfix" id="start_gn">
				<div class="label_left">出发地：</div>
				<div class="input_right input_right_wauto">
					<select class="w90" name="ptdStartProvince" style="width: 100px;">
						#foreach($item in $provinces.keySet())
						<option value="$item">$provinces.get($item)</option> #end
					</select> <span>市</span> <select name="ptdStartCity" style="width: 90px;"></select>
				</div>
			</div>
			<div class="input_block clearfix" id="start_gj">
				<div class="label_left">出发地：</div>
				<div class="input_right input_right_wauto">
					#foreach($item in $state.keySet()) <label class="w60"> <input
						type="radio" name="ptdExternal" value="$item">
						$state.get($item)
					</label> #end <br> <select class="w90" name="ptdForeign"
						style="width: 100px;">
						<option value=""></option> #foreach($item in $country.keySet())
						<option value="$item">$country.get($item)</option> #end
					</select> <span> 国家</span> <select name="ptdForeignCity"
						style="width: 90px;"></select>
				</div>
			</div>
			<div class="input_block clearfix">
				<div class="label_left">起飞时间：</div>
				<div class="input_right input_right_wauto">
					<input type="text" class="w80 validate[required]"
						name="ptdStartTime"
						onfozy="WdatePicker({skin:'whyGreen',dateFmt:'H:mm'})"> <label
						class="ml15">起飞机场/航站楼： </label> <input type="text"
						class="w130 validate[required]" name="ptdTerminal">
				</div>
			</div>
			<div class="input_block clearfix">
				<div class="label_left">到达国家：</div>
				<div class="input_right input_right_wauto">
					<label class="w130"><input type="radio" id="end1"
						onclick="$('#end_gj').hide();$('#end_gn').show();"
						name="ptdEndCountry" value="01" checked />国内</label> <label><input
						type="radio" id="end2"
						onclick="$('#end_gj').show();$('#end_gn').hide();"
						name="ptdEndCountry" value="02" />国际·港澳台</label>
				</div>
			</div>
			<div class="input_block clearfix" id="end_gn">
				<div class="label_left">目的地：</div>
				<div class="input_right input_right_wauto">
					<select class="w90" name="ptdEndProvince" style="width: 100px;">
						#foreach($item in $provinces.keySet())
						<option value="$item">$provinces.get($item)</option> #end
					</select> <span>市</span> <select name="ptdEndCity" style="width: 90px;"></select>
				</div>
			</div>
			<div class="input_block clearfix" id="end_gj">
				<div class="label_left">目的地：</div>
				<div class="input_right input_right_wauto">
					#foreach($item in $state.keySet()) <label class="w60"> <input
						type="radio" name="endExternal" value="$item">
						$state.get($item)
					</label> #end <br> <select class="w90" name="endForeign"
						style="width: 100px;">
						<option value=""></option> #foreach($item in $country.keySet())
						<option value="$item">$country.get($item)</option> #end
					</select> <span> 国家</span> <select name="endForeignCity"
						style="width: 90px;"></select>

				</div>
			</div>
			<div class="input_block clearfix">
				<div class="label_left">落地时间：</div>
				<div class="input_right input_right_wauto">
					<input type="text" class="w80 validate[required]" name="ptdEndTime"
						onfozy="WdatePicker({skin:'whyGreen',dateFmt:'H:mm'})"> <label
						class="ml15">落地机场/航站楼： </label> <input type="text"
						class="w130 validate[required]" name="ptdEndTerminal">
				</div>
			</div>
			<div class="input_block clearfix">
				<div class="label_left">飞机餐：</div>
				<div class="input_right input_right_wauto">
					#foreach($item in $models.keySet()) <label class="checkbox inline">
						<input class="input-xlarge" type="radio" name="ptdCostFood"
						value="$item">$models.get($item)
					</label> #end
				</div>
			</div>
			<div class="input_block clearfix">
				<div class="label_left">机场建设费：</div>
				<div class="input_right input_right_wauto">
					<input type="text" class="w130 validate[required]"
						name="ptdCostMaching"> <label class="ml15"> 燃油附加费：
					</label> <input type="text" class="w130 validate[required]"
						name="ptdCostFuel">
				</div>
			</div>
			<div class="carinfo_ctbl">
				<span></span>
				<div class="carinfo_ctblrbtn">
					<button type="button" class="carinfo_sub"
						onclick="subform.update('form1','$appRoot/planeticket/detail/insert');">确定</button>
					<button type="button" onclick="index.load(page.url);"
						class="carinfo_qu">返回</button>
				</div>
			</div>
		</div>
	</form>
</div>

<script type="text/javascript">
	//初始化省为北京市
	var initProvinceId = 1;
	//初始化省市县
	index.initProvince(1, 'ptdStartProvince', 'ptdStartCity');
	//初始化省市县
	index.initProvince(1, 'ptdEndProvince', 'ptdEndCity');

	//默认国内 国际线路隐藏
	$("#start_gj").hide();
	$("#end_gj").hide();

	//初始化国家
	$("select[name='ptdForeign']").change(function() {
		index.country($(this).val(), $("select[name='ptdForeignCity']"));
	});
	$("select[name='endForeign']").change(function() {
		index.country($(this).val(), $("select[name='endForeignCity']"));
	});
</script>