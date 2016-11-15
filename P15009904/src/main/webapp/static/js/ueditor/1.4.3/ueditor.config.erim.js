(function () {

    // Ueditor相对地址，系统默认
    var URL   = "http://admin.jialvlianhe.com/ueditor/1.4.3/";

    window.UEDITOR_CONFIG = {

        //为编辑器实例添加一个路径，这个不能被注释
        UEDITOR_HOME_URL: URL

        // 服务器统一请求接口路径
        , serverUrl: URL + "jsp/controller.jsp"

        //工具栏上的所有的功能按钮和下拉框，可以在new编辑器的实例时选择自己需要的从新定义
        ,toolbars:[["source","undo","redo","insertunorderedlist","insertorderedlist","unlink","link","cleardoc","selectall","insertimage","emotion","insertvideo","attachment","date","time","horizontal","spechars","blockquote","bold","italic","underline","strikethrough","forecolor","backcolor","superscript","subscript","justifyleft","justifycenter","justifyright","justifyjustify","indent","removeformat","formatmatch","autotypeset","pasteplain","insertcode","paragraph","rowspacingbottom","rowspacingtop","lineheight","fontfamily","fontsize","imagenone","imageleft","imageright","imagecenter","inserttable","deletetable","mergeright","mergedown","splittorows","splittocols","splittocells","mergecells","insertcol","insertrow","deletecol","deleterow","insertparagraphbeforetable","print","searchreplace","preview","help"]]

    };
})();
