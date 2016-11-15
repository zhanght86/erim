(function($) {
    var internationalCities = ['香港|gxianggang|gxg', '曼谷|gmangu|gmg', '首尔|gshouer|gse', '东京|gdongjing|gdj','普吉|gpujing|gpj','新加坡|gxinjiapo|gxjp', '台北|gtaibei|gtb', '清迈|gqingmai|gqm', '吉隆坡|gjilongpo|gjlp','悉尼|gxini|gxn','澳门|gaomen|gam','阪大|gdaban|gdb', '伦敦|glundun|gld', '洛杉矶|gluoshanji|glsj','纽约|gniuyue|gny','马尼拉|gmanila|gmnl', '墨尔本|gmoerben|gmeb', '温哥华|gwengehua|gwgh', '巴黎|gbali|gbl','槟城|gbincheng|gbc','多伦多|gduolunduo|gdld','胡志明市|ghuzhimingshi|ghzms', '旧金山|gjiujinshan|gjjs', '金边|gjinbian|gjb', '雅加达|gyajiada|gyjd','济州岛|gjizhoudao|gjzd','高雄|ggaoxiong|ggx','釜山|gfushan|gfs', '暹粒|gxianli|gxl', '法兰克福|gfalankefu|gflkf','香港|yxianggang|yxg', '首尔|yshouer|yse','曼谷|ymangu|ymg','吉隆坡|yjinglongpo|yjlp', '东京|ydongjing|ydj', '台北|ytaibei|ytb','悉尼|yxini|yxn','澳门|yaomen|yam', '普吉|ypiji|ypj', '墨尔本|ymoerben|ymeb','胡志明市|yhuzhimingshi|yhzms','大阪|ydaban|ydb', '巴厘岛|ybalidao|ybld', '马尼拉|ymanila|ymnl','河内|yhenei|yhn','加德满都|yjiademandu|yjdmd', '金边|yjinbian|yjb', '雅加达|yyajiada|yyjd','马累|ymalei|yml','暹粒|yxianli|yxl', '迪拜|ydibai|ydb', '釜山|yfushan|yfs','名古屋|ymingguwu|ymgw','奥克兰|yaokelan|yakl', '布里斯班|ybulisiban|yblsb', '槟城|ybincheng|ybc','高雄|ygaoxiong|ygx','新德里|yxindeli|yxdl', '济州岛|yjizhoudao|yjzd','纽约|mniuyue|mny','洛杉矶|mluoshaji|mlsj','多伦多|mduolunduo|mdld','温哥华|mwengehua|mwgh','旧金山|mjiujinshan|mjjs','芝加哥|mzhijiage|mzjg','华盛顿|mhuashengdun|mhsd','西雅图|mxiyatu|mxyt','波士顿|mboshidun|mbsd','火奴鲁鲁|mhuonululu|mhnll','达拉斯|mdalasi|mdls','拉斯维加斯|mlasiweijiasi|mlswjs','费城|mfeicheng|mfc','圣保罗|mshengbaoluo|msbl','明尼拉波利斯|mmingnilabolisi|mmnlbls','渥太华|mwotaihua|mwth','凤凰城|mfenghuangcheng|mfhc','迈阿密|mmaiami|mmam','丹佛|mdanfo|mdf','奥兰多|maolanduo|mald','卡尔加里|mkaerjiali|mkejl','埃德蒙顿|maidemengdun|madmd','布宜诺斯艾利|mboyinuosiaili|mbynsal','里约日内卢|mliyuerineilu|mlyrnl','匹兹堡|mpizibao|mpzb','伦敦|olundun|old','巴黎|obali|obl','法兰克福|ofalankefu|oflkf','莫斯科|omosike|omsk','阿姆斯特丹|oamusitedan|oamstd','罗马|oluoma|olm','米兰|omilan|oml','马德里|omadeli|omdl','慕尼黑|omunihei|omnh','柏林|obolin|obl','斯德哥尔摩|osidegeermo|osdgem','伊斯坦布尔|oyisitanbuer|oystbe','伯明翰|obominghan|obmh','巴塞罗那|obasailuona|obsln','雅典|oyadian|oyd','哥本哈根|ogebenhagen|ogbhg','苏黎世|osulishi|osls','墨西哥城|omoxigecheng|omxgc','迈阿密|omaiami|omam','丹佛|odanfo|odf','奥兰多|oaolanduo|oald','卡尔加里|okaerjiali|okejl','布鲁塞尔|obulusaier|oblse','赫尔辛基|oheerxinji|ohexj','爱丁堡|oaidingbao|oadb','维也纳|oweiyena|opzb','格拉斯哥|ogelasige|oglsg','日内瓦|orineiwa|ornw','圣彼得堡|oshengbidebao|osbdb','都柏林|odubolin|odbl','汉堡|ohanbao|ohb','杜塞尔多夫|odusaierduofu|odsedf','布拉格|obulage|oblg','布达佩斯|obudapeisi|obdps','基辅|ojifu|ojf','开罗|fkailuo|fkl','约翰内斯堡|fyuehanneisibao|fyhnsb','内罗毕|fneiluobi|fnlb','开普敦|fkaipudun|fkpd','毛里求斯|fmaosiqiusi|fmlqs','拉各斯|flagesi|flgs','喀土穆|fkatumu|fktm','亚的斯亚贝巴|fyadisiyabeiba|fydsybb','阿克拉|fakela|fakl','达累斯萨拉姆|fdaleisisalamu|fdlsslm','塞舌尔|fsaisheer|fsse','阿尔及尔|faerjier|faeje','的黎波里|fdeliboli|fdlbl','阿布贾|fabujia|fabj','卡萨布兰卡|fkasabulanka|fksblk','突尼斯|ftunisi|ftns'];
    var interregEx = /^([\u4E00-\u9FA5\uf900-\ufa2d]+)\|(\w+)\|(\w)\w*$/i, // 匹配汉字，拼音
        interregExChiese = /([\u4E00-\u9FA5\uf900-\ufa2d]+)/, // 只匹配拼音
        interreg_gat = /^[ga]$/i, // 匹配首字母为 国际港澳台
        interreg_eh = /^[yd]/i, // 匹配首字母为 亚洲、大洋洲
        interreg_il = /^[m]/i, // 匹配首字母为 美洲
        interreg_mp = /^[o]/i, // 匹配首字母为 欧洲
        interreg_qt = /^[f]/i; // 匹配首字母为 非洲

    //构建城市分类字面量
    var intercity = {
        interhot: {},
        dayangzhou:{},
        EFGH: {},
        IJKL:{},
        MNOP: {},
        QRST:{}

    };

    //城市按首字母分类，填充到分类字面量
    (function() {
        for (var i = 0, interlen = internationalCities.length; i < interlen; i++) {
            var interpart =interregEx.exec(internationalCities[i]),
                interen = interpart[1], //中文名
                interletter = interpart[2], //拼音
                interspletter = interpart[3], //拼音简写
                interfirst = interletter[0].toUpperCase(), //拼音首字母
                interltPart; //当前字母下的城市

            if (interreg_gat.test(interfirst)) {
                interltPart = 'dayangzhou';
            } else if (interreg_eh.test(interfirst)) {
                interltPart = 'EFGH';
            } else if (interreg_il.test(interfirst)) {
                interltPart = 'IJKL';
            }else if (interreg_mp.test(interfirst)) {
                interltPart = 'MNOP';
            }else if (interreg_qt.test(interfirst)) {
                interltPart = 'QRST';
            }

            intercity[interltPart][interfirst] ? intercity[interltPart][interfirst].push(interen) : (intercity[interltPart][interfirst] = [], intercity[interltPart][interfirst].push(interen));

            //设置前16个城市为热门城市
            if (i < 16) {
                intercity.interhot['interhot'] ? intercity.interhot['interhot'].push(interpart[1]) : (intercity.interhot['interhot'] = [], intercity.interhot['interhot'].push(interpart[1]));
            }
        }
    })();

    var InterKuCity = function(target) {
        this.target = target; // 输入框
        this.container = null; //插件容器
        this.resultct = null; //搜索结果容器
        this.isKeyslect = false; //是否在用上下键选择
        this.isContainerExit = false; // 插件容器是否已存在
    };

    InterKuCity.prototype = {
        constructor: InterKuCity,
        //初始化
        init: function() {
            this.creatItem();
            this.tabChange();
            this.citySelect();
            this.inputSearch();
            this.keySelect();
            this.stopPropagation();
        },
        //创建市列表
        creatItem: function() {
            if(this.isContainerExit) return;
            var intertemplate = '<div class="interkucity"><div class="citybox"><h3 class="interkucity_header">国际热门</h3><ul class="interkucity_nav"><li class="active">热门城市</li><li>国际·港澳台</li><li>亚洲/大洋洲</li><li>美洲</li><li>欧洲</li><li>非洲</li></ul><div class="interkucity_body"></div></div><ul class="result"></ul></div>';
            $('body').append(intertemplate);

            this.container = $('.interkucity');
            this.resultct = $('.result');

            for (var intergroup in intercity) {
                var interitemKey = [];

                for (var interitem in intercity[intergroup]) {
                    interitemKey.push(interitem);
                }
                interitemKey.sort();
                var interitembox = $('<div class="interkucity_item">');
                interitembox.addClass(intergroup);

                for (var i = 0, iLen = interitemKey.length; i < iLen; i++) {

                    var interdl = $('<dl>'),
                        interdd = $('<dd>'),
                        interstr = '';

                    for (var j = 0, jLen =intercity[intergroup][interitemKey[i]].length; j < jLen; j++) {
                        interstr += '<span>' + intercity[intergroup][interitemKey[i]][j] + '</span>'
                    }

                    interdd.append(interstr);
                    interdl.append(interdd);
                    interitembox.append(interdl);
                }
                $('.interkucity_body').append(interitembox);
                this.container.find('.interhot').addClass('active');
            }
            this.isContainerExit = true;
        },
        //创建搜索结果列表
        creatResult: function(re, value) {
            var interresult = re.result,
                interlen = interresult.length,
                interstr = '';
            if (!!interlen) {
                for (var i = 0; i < interlen; i++) {
                	interstr += '<li><span class="name">' + interresult[i].cityName + '</span><span class="letter">' + interresult[i].py + '</span></li>'
                }
                this.container.find('.result').html('').html(interstr).find('li').eq(0).addClass('active');
            } else {
                this.container.find('.result').html('<li>没有找到<span class="noresult">' + value + '</span>相关信息</li>');
            }
        },
        //列表切换
        tabChange: function() {
            $('.interkucity_nav').on('click', 'li', function(e) {
                var current = $(e.target),
                    index = current.index();

                current.addClass('active').siblings().removeClass('active');
                $('.interkucity_item').eq(index).addClass('active').siblings().removeClass('active');
                $(' .interkucity_body').scrollTop(0);

            })
        },
        //城市选择
        citySelect: function() {
            var self = this;
            $('.interkucity_item dd').on('click', 'span', function(e) {
                self.target.val(($(e.target).text()));
                self.container.hide();
            })
        },
        //上下键选择搜索结果
        keySelect: function() {
            var self = this;
            this.target.on('keydown', function(e){
                var current = self.resultct.find('.active').index();
                if(current !== -1){
                    switch(e.keyCode){
                        //上
                        case 38: 
                            keyActive(false);
                            break;
                        //下
                        case 40:
                            keyActive(true);
                            break;
                        //确定
                        case 13: 
                            self.isKeyslect = false;
                            self.target.val(self.resultct.find('.active .name').text());
                            self.triggleShow('all');
                            self.target.blur();
                            break;
                        default: 
                            self.isKeyslect = false;
                            break;
                    }

                    function keyActive(isInorder) {
                        var max = self.resultct.find('li').length - 1;
                        if(isInorder){
                            current = current == max ? 0 : current + 1;
                        }else{
                            current = current == 0 ? max : current - 1;
                        }
                        self.resultct.find('li').eq(current).addClass('active').siblings().removeClass('active');
                        self.isKeyslect = true;
                    }
                }
            })
        },
        //搜索
        inputSearch: function() {
            var self = this;
            this.target.on('keyup', function(e) {
                if(!self.isKeyslect){
                    self.throttle(search, this);
                }
            })
            // 输入框搜索
            function search(e) {
                var container = self.container;
                self.triggleShow(false);
                var value = $(this).val();
                if (value) {
                    var url = 'https://sjipiao.alitrip.com/city_search.do?_ksTS=1439362066383_11337&lines=10&_input_charset=utf-8&needProvince=true&q=' + value;
                    $.ajax({
                        url: url,
                        type: 'get',
                        dataType: 'jsonp'
                    }).done(function(re) {
                        self.creatResult(re, value);
                    })
                } else {
                    self.triggleShow(true);
                }
            }
        },
        //列表，结果，整体 显示切换
        triggleShow: function(open) {
            var container = this.container;
            if (open === 'all') {
                container.hide()
            } else if (open) {
                container.find('.citybox').show().end().find('.result').hide();
            } else {
                container.find('.citybox').hide().end().find('.result').show();
            }
        },
        //函数节流
        throttle: function(fn, context) {
            clearTimeout(fn.tId);
            fn.tId = setTimeout(function(){
                fn.call(context);
            }, 100)
        },
        //阻止事件冒泡
        stopPropagation: function() {
            var self = this;
            //阻止事件冒泡
            this.container.on('click', stopPropagation);
            this.target.on('click', stopPropagation);
            //页面点击 隐藏
            $(document).on('click', function() {
                self.container.hide();
            })
            function stopPropagation(e) {
                e.stopPropagation();
            }
        }
    };

    var interkucity = null;
    $.fn.interkucity = function(options) {
        var target = $(this);
        target.on('focus', function(e) {
            var top = $(this).offset().top + $(this).outerHeight(),
                left = $(this).offset().left;
            interkucity = interkucity ? interkucity : new InterKuCity(target);
            interkucity.target = $(e.target);
            interkucity.init();
            interkucity.container.show().offset({
                'top': top + 7,
                'left': left
            });
            interkucity.triggleShow(true);
            interkucity.resultct.on('click', 'li', function() {
                interkucity.target.val($(this).find('.name').text());
                interkucity.triggleShow('all');
            });
        });
        return this;
    };
})(jQuery);
