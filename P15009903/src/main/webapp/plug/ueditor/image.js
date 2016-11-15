/*
 * 配置：
 * 1. 修改ueditor.config.js 中的路径
 * 2. 添加ueditor.jar 和commons-fileupload-1.2.2.jar 到lib更好
 * 3. 如果为strut2集成，则需要添加过滤器继承原有的过滤器，对imageUp.jsp进行过滤
 * 4. 如果单独使用工具类，则建议使用script的方式，不要使用input
 * 	  如下：
 *  <input id="upload" type="text" value=""/>
	<script id="myeditor"></script>
	<span  id="image">ddd</span>
	 单独使用时，不用渲染，获取editor即可。否则在ie会出问题。
   5. 如果只需要渲染，则直接调用render方法即可。
 * UEditor单独图片上传工具类
 */
(function($){
	var image = {
		editor:null,
		init:function(editorid,keyid){
			var _editor =this.getEditor(editorid);
			_editor.ready(function () {
			    _editor.setDisabled();
			    _editor.hide();
			    _editor.addListener('beforeInsertImage', function (t, args) {
			        $("#"+keyid).val(args[0].src);
			    });
			});
		},
		getEditor:function(editorid){
			this.editor = UE.getEditor(editorid);
			return this.editor;
		},
		show:function(id){
			var _editor = this.editor;
           //注意这里只需要获取编辑器，无需渲染，如果强行渲染，在IE下可能会不兼容（切记）
           //和网上一些朋友的代码不同之处就在这里
			$("#"+id).click(function(){
				var image = _editor.getDialog("insertimage");
				image.render();
				image.open();
			});
		},
		render:function(editorid){
			var _editor = this.getEditor(editorid);
			_editor.render();
		}
	};
	$(function(){
		image.init("myeditor","upload");
		image.show("image");
	});
})(jQuery);