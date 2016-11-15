/**
 * 导游相关
 */
var guide = {

	//路径
	url : {
		schedule : _appRoot + "/index",
		order    : _appRoot + "/order",
		records  : _appRoot + "/record",
		gallery  : _appRoot + "/photo",
		userinfo : _appRoot + "/userinfo"
	},
	//初始化
	init : function(data){
		//1|档期管理;;;2|订单管理;;;3|个人动态;;;4|个人相册;;;5|个人信息
		window.location = '1'==data?guide.url.schedule:
						  '2'==data?guide.url.order:
						  '3'==data?guide.url.records:
						  '4'==data?guide.url.gallery:
						  '5'==data?guide.url.userinfo:"";
	},
	//个人动态
	records : {
		id   : 0,
		//初始化
		init : function(){
			$(".remove_btn").click(function () {
	         	$("#remove_popup").show();
	         	guide.records.id = $(this).attr("id");
	         });
		},
		//删除
		dele : function(){
			$(".shuxian").click(function(){
				if(guide.records.id > 0){
					var url = _appRoot + "/delRecords?id="+guide.records.id;
					window.location = url;
				}
			})
		}
	},
	//表单id
	checkForm : function(formid){
		$("#"+formid).validationEngine({   
			scroll          : false,
			focusFirstField : true,
			showOneMessage  : true,
            promptPosition  : "topLeft"
        });
		return $("#"+formid).validationEngine('validate');
	}
};