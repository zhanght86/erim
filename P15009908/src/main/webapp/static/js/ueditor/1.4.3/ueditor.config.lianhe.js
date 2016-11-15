
(function () {

    /**
     * 此处配置写法适用于UEditor小组成员开发使用，外部部署用户请按照上述说明方式配置即可，建议保留下面两行，以兼容可在具体每个页面配置window.UEDITOR_HOME_URL的功能。
     */
    var tmp = location.protocol.indexOf("file")==-1 ? location.pathname : location.href;
    URL = window.UEDITOR_HOME_URL||tmp.substr(0,tmp.lastIndexOf("\/")+1).replace("_examples/","").replace("website/","");//这里你可以配置成ueditor目录在您网站的相对路径或者绝对路径（指以http开头的绝对路径）

    /**
     * 配置项主体。注意，此处所有涉及到路径的配置别遗漏URL变量。
     */
    window.UEDITOR_CONFIG = {

        //为编辑器实例添加一个路径，这个不能被注释
        UEDITOR_HOME_URL: URL

        // 服务器统一请求接口路径
        , serverUrl: URL + "jsp/controller.jsp"

        //工具栏上的所有的功能按钮和下拉框，可以在new编辑器的实例时选择自己需要的从新定义
        , toolbars: [[
            'bold', //加粗
            'snapscreen', //截图
            'simpleupload', //单图上传
            'forecolor', //字体颜色
            'justifyleft', //居左对齐
            'justifyright', //居右对齐
            'justifycenter', //居中对齐
        ]]

        ,initialFrameWidth:500  //初始化编辑器宽度,默认1000
        ,initialFrameHeight:320  //初始化编辑器高度,默认320
        ,catchRemoteImageEnable:false //抓取远程图片是否开启,默认true
    };

    function getUEBasePath(docUrl, confUrl) {

        return getBasePath(docUrl || self.document.URL || self.location.href, confUrl || getConfigFilePath());

    }

    function getConfigFilePath() {

        var configPath = document.getElementsByTagName('script');

        return configPath[ configPath.length - 1 ].src;

    }

    function getBasePath(docUrl, confUrl) {

        var basePath = confUrl;


        if (/^(\/|\\\\)/.test(confUrl)) {

            basePath = /^.+?\w(\/|\\\\)/.exec(docUrl)[0] + confUrl.replace(/^(\/|\\\\)/, '');

        } else if (!/^[a-z]+:/i.test(confUrl)) {

            docUrl = docUrl.split("#")[0].split("?")[0].replace(/[^\\\/]+$/, '');

            basePath = docUrl + "" + confUrl;

        }

        return optimizationPath(basePath);

    }

    function optimizationPath(path) {

        var protocol = /^[a-z]+:\/\//.exec(path)[ 0 ],
            tmp = null,
            res = [];

        path = path.replace(protocol, "").split("?")[0].split("#")[0];

        path = path.replace(/\\/g, '/').split(/\//);

        path[ path.length - 1 ] = "";

        while (path.length) {

            if (( tmp = path.shift() ) === "..") {
                res.pop();
            } else if (tmp !== ".") {
                res.push(tmp);
            }

        }

        return protocol + res.join("/");

    }

    window.UE = {
        getUEBasePath: getUEBasePath
    };

})();
