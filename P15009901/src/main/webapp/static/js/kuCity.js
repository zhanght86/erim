(function($) {
    var allCities = ['安庆|anqing|aq','蚌埠|bangbu|bb','巢湖|chaohu|ch','池州|chizhou|cz','滁州|chuzhou|cz','阜阳|fuyang|fy','合肥|hefei|hf','淮北|huaibei|hb','淮南|huainan|hn','黄山|huangshan|hn','六安|liuan|la','马鞍山|maanshan|mas','宿州|suzhouu|sz','铜陵|tongling|tl','芜湖|wuhu|wh','宣城|xuancheng|xc','亳州|boZhou|bz','北京|beijing|bj','福州|fuzhou|fz','龙岩|longyan|ly','南平|nanping|np','宁德|ningde|nd','莆田|putian|pt','泉州|quanzhou|qz','三明|sanming|sm','厦门|xiamen|xm','漳州|zhangzhou|zz','白银|baiyin|by','定西|dingxi|dx','甘南|gannan|fn','嘉峪关|jiayuguan|jyg','金昌|jinchang|jc','酒泉|jiuquan|jq','兰州|lanzhou|lz','临夏|linxia|lx','陇南|longnan|ln','平凉|pingliang|pl','庆阳|qingyang|ql','天水|tianshui|ts','武威|wuwei|ww','张掖|zhangye|zy','潮州|chaozhou|cz','东莞|dongGuan|dw','佛山|foshan|fs','广州|guangzhou|gz','河源|heyuan|hy','惠州|huizhou|hz','江门|jiangmen|jm','揭阳|jieyang|jy','茂名|maoming|mm','梅州|meizhou|mz','清远|qingyuan|qy','汕头|shantou|st','汕尾|shanwei|sw','韶关|shaoguan|sg','深圳|shenzhen|sz','阳江|yangjiang|yj','云浮|yunfu|yf','湛江|zhanjiang|zj','肇庆|zhaoqing|zq','中山|zhongshan|zs','珠海|zhuhai|zh','百色|baise|bs','北海|beihai|bh','崇左|chongzuo|cz','防城港|fangchenggang|fcg','桂林|guilin|gl','贵港|guigang|gg','河池|hechi|hc','贺州|hezhou|hz','来宾|laibin|lb','柳州|liuzhou|lz','南宁|nanning|nn','钦州|qinzhou|qz','梧州|wuzhou|wz','玉林|yulin|yl','安顺|anshun|as','毕节|bijie|bj','贵阳|guiyang|gy','六盘水|liupanshui|lps','黔东|qiandong|qd','黔南|qiannan|qn','黔西|qianxi|qx','铜仁|tongren|tr','遵义|zunyi|zy','白沙|baisha|bs','保亭|baoting|bt','昌江|changjiang|cj','澄迈县|chengmaixian|cmx','定安县|dinganxian|dax','东方|dongfang|df','海口|haikou|hk','乐东|ledong|ld','临高县|lingaoxian|lgx','陵水|lingshui|ls','琼海|qionghai|qh','琼中|qiongzhong|qz','三亚|sanya|sy','屯昌县|tunchangxian|tcx','万宁|wanning|wn','文昌|wenchang|wc','五指山|wuzhishan|wqs','儋州|danZhou|dz','保定|baoding|bd','沧州|cangzhou|cz','承德|chengde|cd','邯郸|handan|hd','衡水|hengshui|hs','廊坊|langfang|lf','秦皇岛|qinhuangdao|qhd','石家庄|shijiazhuang|sjz','唐山|tangshan|ts','邢台|xingtai|xt','张家口|zhangjiakou|zjk','安阳|anyang|ay','鹤壁|hebi|hb','济源|jiyuan|jy','焦作|jiaozuo|jz','开封|kaifeng|kf','洛阳|luoyang|ly','南阳|nanyang|ny','平顶山|pingdingshan|pds','三门峡|sanmenxia|smx','商丘|shangqiu|sq','新乡|xinxiang|xx','信阳|xinyang|xy','许昌|xuchang|xc','郑州|zhengzhou|zz','周口|zhoukou|zk','驻马店|zhumadian|zmd','漯河|luoHe|lh','濮阳|puYang|py','大庆|daqing|dq','大兴安岭|daxinganling|dxal','哈尔滨|haerbin|heb','鹤岗|hegang|hg','黑河|heihe|hh','鸡西|jixi|jx','佳木斯|jiamusi|jms','牡丹江|mudanjiang|mdj','七台河|qitaihe|qth','齐齐哈尔|qiqihaer|qqhe','双鸭山|shuangyashan|sys','绥化|suihua|sh','伊春|yichun|yc','鄂州|ezhou|ez','恩施|enshi|es','黄冈|huanggang|hg','黄石|huangshi|hs','荆门|jingmen|jm','荆州|jingzhou|jz','潜江|qianjiang|qj','神农架|shennongjia|snj','十堰|shiyan|sy','随州|suizhou|sz','天门|tianmen|tm','武汉|wuhan|wh','仙桃|xiantao|xt','咸宁|xianning|xn','襄樊|xiangfan|xf','孝感|xiaogan|xg','宜昌|yichang|yc','常德|changde|cd','长沙|changsha|cs','郴州|chenzhou|cz','衡阳|hengyang|hy','怀化|huaihua|hh','娄底|loudi|ld','邵阳|shaoyang|sy','湘潭|xiangtan|xt','湘西|xiangxi|xx','益阳|yiyang|yy','永州|yongzhou|yz','岳阳|yueyang|yy','张家界|zhangjiajie|zjj','株洲|zhuzhou|zz','白城|baicheng|bc','白山|baishan|bs','长春|changchun|cc','吉林|jilin|jl','辽源|liaoyuan|ly','四平|siping|sp','松原|songyuan|sy','通化|tonghua|th','延边|yanbian|yb','常州|changzhou|cz','淮安|huaian|ha','连云港|lianyungang|lyg','南京|nanjing|nj','南通|nantong|nt','苏州|suzhou|sz','宿迁|suqian|sq','泰州|taizhou|tz','无锡|wuxi|wx','徐州|xuzhou|xz','盐城|yancheng|yc','扬州|yangzhou|yz','镇江|zhenjiang|zj','抚州|fuzhou|fz','赣州|ganzhou|gz','吉安|jian|ja','景德镇|jingdezhen|jdz','九江|jiujiang|jj','南昌|nanchang|nc','萍乡|Pingxiang|px','上饶|shangrao|hr','新余|xinyu|xy','宜春|yichun|yc','鹰潭|yingtan|yt','鞍山|anshan|as','本溪|benxi|bx','朝阳|chaoyang|cy','大连|dalian|dl','丹东|dandong|dd','抚顺|fushun|fs','阜新|fuxin|fx','葫芦岛|huludao|hld','锦州|jinzhou|jz','辽阳|liaoyang|ly','盘锦|panjin|pj','沈阳|shenyang|sy','铁岭|tieling|tl','营口|yingkou|yk','阿拉善盟|alashanmeng|alsm','巴彦淖尔|bayannaoer|byne','包头|baotou|bt','赤峰|chifeng|cf','鄂尔多斯|eerduosi|eeds','呼和浩特|huhehaote|hhht','呼伦贝尔|hulunbeier|hlbe','通辽|tongliao|tl','乌海|wuhai|wh','乌兰察布|wulanchabushi|wlcbs','锡林郭勒|xilinguole|xlgl','兴安盟|xinganmeng|xam','固原|guyuan|gy','石嘴山|shizuishan|szs','吴忠|wuzhong|wz','银川|yinchuan|yc','果洛|guoluo|gl','海北|haibei|hb','海东|haidong|hd','海南|hainan|hn','海西|haixi|hx','黄南|huangnan|hn','西宁|xining|xn','玉树|yushu|ys','滨州|binzhou|bz','德州|dezhou|dz','东营|dongying|dy','菏泽|heze|hz','济南|jinan|jn','济宁|jining|jn','莱芜|laiwu|lw','聊城|liaocheng|lc','临沂|linyi|ly','青岛|qingdao|qd','日照|rizhao|rz','泰安|taian|ta','威海|weihai|wh','潍坊|weifang|wf','烟台|yantai|yt','枣庄|zaozhuang|zz','淄博|zibo|zb','长治|changzhi|cz','大同|datong|dt','晋城|jincheng|jc','晋中|jinzhong|jz','临汾|linfen|lf','吕梁|lvliang|ll','朔州|shuozhou|sz','太原|taiyuan|ty','忻州|xinzhou|xz','阳泉|yangquan|yq','运城|yuncheng|yc','安康|ankang|ak','宝鸡|baoji|bj','汉中|hanzhong|hz','商洛|shangluo|sl','铜川|tongchuan|tc','渭南|weinan|wn','西安|xian|xn','咸阳|xianyang|xy','延安|yanan|ya','榆林|yulin|yl','上海|shanghai|sh','阿坝|aba|aba','巴中|bazhong|bz','成都|chengdu|cd','达州|dazhou|dz','德阳|deyang|dy','甘孜|ganzi|gz','广安|guangan|ga','广元|guangyuan|gy','乐山|leshan|ls','凉山|liangshan|ls','眉山|meishan|ms','绵阳|mianyang|my','南充|nanchong|nc','内江|neijiang|nj','攀枝花|panzhihua|pzh','遂宁|suining|sn','雅安|yaan|ya','宜宾|yibin|yb','资阳|ziyang|zy','自贡|zigong|zg','泸州|luZhou|lz','天津|tianjin|tj','阿里|ali|al','昌都|changdu|cd','拉萨|lasa|ls','林芝|linzhi|lz','那曲|naqu|nq','日喀则|rikaze|qkz','山南|shannan|sn','阿克苏|akesu|aks','阿拉尔|alaer|ale','巴音郭楞|bayinguoleng|bygl','博尔塔拉|boertala|betl','昌吉|changji|cj','哈密|hami|hm','和田|hetian|ht','喀什|kashi|ks','克拉玛依|kelamayi|klmy','克孜|kezi|kz','石河子|shihezi|shz','图木舒克|tumushuke|mtsk','吐鲁番|tulufan|tlf','乌鲁木齐|wulumuqi|wlmq','五家渠|wujiaqu|wjq','伊犁|yili|yl','保山|baoshan|bs','楚雄|chuxiong|cx','大理|dali|dl','德宏|dehong|dh','迪庆|diqing|dq','红河|Honghe|hh','昆明|kunming|km','丽江|lijiang|lj','临沧|lincang|lc','怒江|nujiang|nj','曲靖|qujing|qj','思茅|simao|sm','文山|wenshan|ws','西双版纳|xishuangbanna|xsbn','玉溪|yuxi|yx','昭通|zhaotong|zt','杭州|hangzhou|hz','湖州|huzhou|hz','嘉兴|jiaxing|jx','金华|jinhua|jh','丽水|lishui|ls','宁波|ningbo|nb','绍兴|shaoxing|sx','台州|taizhou|tz','温州|wenzhou|wz','舟山|zhoushan|zs','衢州|quzhou|qz','重庆|chongqing|cq','香港|xianggang|xg','澳门|aomen|am','高雄|gaoxiong|gx','花莲|hualian|hl','基隆|jilong|jl','嘉义|jiayi|jy','台北|taibei|tb','台东|taidong|td','台南|tainan|tn','台中|taizhong|tz','中卫|zhongwei|zw','塔城|tacheng|tc','阿勒泰|aletai|alt','乌苏里江|wusulijiang|wslj','赤壁市|chibishi|cbs','顺德|shunde|sd'];
       var regEx = /^([\u4E00-\u9FA5\uf900-\ufa2d]+)\|(\w+)\|(\w)\w*$/i, // 匹配汉字，拼音
        regExChiese = /([\u4E00-\u9FA5\uf900-\ufa2d]+)/, // 只匹配拼音
        reg_ad = /^[a-d]$/i, // 匹配首字母为 a-h
        reg_eh = /^[e-h]/i, // 匹配首字母为 i-p
        reg_il = /^[i-l]/i, // 匹配首字母为 q-z
        reg_mp = /^[m-p]/i, // 匹配首字母为 q-z
        reg_qt = /^[q-t]/i, // 匹配首字母为 q-z
        reg_ux = /^[u-x]/i, // 匹配首字母为 q-z
        reg_yz = /^[y-z]/i; // 匹配首字母为 q-z

    //构建城市分类字面量
    var city = {
        hot: {},
        ABCD:{},
        EFGH: {},
        IJKL:{},
        MNOP: {},
        QRST:{},
        UVWX:{},
        YZ: {}
    };

    //城市按首字母分类，填充到分类字面量
    (function() {
        for (var i = 0, len = allCities.length; i < len; i++) {
            var part = regEx.exec(allCities[i]),
                en = part[1], //中文名
                letter = part[2], //拼音
                spletter = part[3], //拼音简写
                first = letter[0].toUpperCase(), //拼音首字母
                ltPart; //当前字母下的城市

            if (reg_ad.test(first)) {
                ltPart = 'ABCD';
            } else if (reg_eh.test(first)) {
                ltPart = 'EFGH';
            } else if (reg_il.test(first)) {
                ltPart = 'IJKL';
            }else if (reg_mp.test(first)) {
                ltPart = 'MNOP';
            }else if (reg_qt.test(first)) {
                ltPart = 'QRST';
            }else if (reg_ux.test(first)) {
                ltPart = 'UVWX';
            }else if (reg_yz.test(first)) {
                ltPart = 'YZ';
            }

            city[ltPart][first] ? city[ltPart][first].push(en) : (city[ltPart][first] = [], city[ltPart][first].push(en));

            //设置前16个城市为热门城市
//            wxy remenchengshi
           /* if (i < 16) {
                city.hot['hot'] ? city.hot['hot'].push(part[1]) : (city.hot['hot'] = [], city.hot['hot'].push(part[1]));
            }*/
                city.hot['hot']=['张家界','长沙','北京','上海','广州','深圳','海口',' 三亚','厦门','桂林','成都','重庆','武汉','贵阳','西安','西宁','南昌','南京','苏州','杭州','宁波','济南','青岛','大连','沈阳','哈尔滨','拉萨','日喀则','香港','台北'];
        }
    })();

    var KuCitylu = function(target) {
        this.target = target; // 输入框
        this.container = null; //插件容器
        this.resultct = null; //搜索结果容器
        this.isKeyslect = false; //是否在用上下键选择
        this.isContainerExit = false; // 插件容器是否已存在
    };

    KuCitylu.prototype = {
        constructor: KuCitylu,
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
            var template = '<div class="kucity"><div class="citybox"><h3 class="kucity_header">热门城市(支持汉字/拼音搜索)</h3><ul class="kucity_nav"><li class="active">热门城市</li><li>ABCD</li><li>EFGH</li><li>IJKL</li><li>MNOP</li><li>QRST</li><li>UVWX</li><li>YZ</li></ul><div class="kucity_body"></div></div><ul class="result"></ul></div>';
            $('body').append(template);

            this.container = $('.kucity');
            this.resultct = $('.result');

            for (var group in city) {
                var itemKey = [];

                for (var item in city[group]) {
                    itemKey.push(item);
                }
                itemKey.sort();
                var itembox = $('<div class="kucity_item">');
                itembox.addClass(group);

                for (var i = 0, iLen = itemKey.length; i < iLen; i++) {

                    var dl = $('<dl>'),
                    	dt = '<dt>' + (itemKey[i] == 'hot' ? '' : itemKey[i]) + '</dt>',
                        dd = $('<dd>'),
                        str = '';

                    for (var j = 0, jLen = city[group][itemKey[i]].length; j < jLen; j++) {
                        str += '<span>' + city[group][itemKey[i]][j] + '</span>'
                    }

                    dd.append(str);
                    dl.append(dt).append(dd);
                    itembox.append(dl);
                }
                $('.kucity_body').append(itembox);
                this.container.find('.hot').addClass('active');
            }
            this.isContainerExit = true;
        },
        //创建搜索结果列表
        creatResult: function(re, value) {
            var result = re.result,
                len = result.length,
                str = '';
            if (!!len) {
                for (var i = 0; i < len; i++) {
                    str += '<li><span class="name">' + result[i].cityName + '</span><span class="letter">' + result[i].py + '</span></li>'
                }
                this.container.find('.result').html('').html(str).find('li').eq(0).addClass('active');
            } else {
                this.container.find('.result').html('<li>没有找到<span class="noresult">' + value + '</span>相关信息</li>');
            }
        },
        //列表切换
        tabChange: function() {
            $('.kucity_nav').on('click', 'li', function(e) {
                var current = $(e.target),
                    index = current.index();

                current.addClass('active').siblings().removeClass('active');
                $('.kucity_item').eq(index).addClass('active').siblings().removeClass('active');
                $(' .kucity_body').scrollTop(0);

            })
        },
        //城市选择
        citySelect: function() {
            var self = this;
            $('.kucity_item dd').on('click', 'span', function(e) {
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

    var kucity = null;
    $.fn.kucity = function(options) {
        var target = $(this);
        target.on('focus', function(e) {
            var top = $(this).offset().top + $(this).outerHeight(),
                left = $(this).offset().left;
            kucity = kucity ? kucity : new KuCitylu(target);
            kucity.target = $(e.target);
            kucity.init();
            kucity.container.show().offset({
                'top': top + 2,
                'left': left
            });
            kucity.triggleShow(true);
            kucity.resultct.on('click', 'li', function() {
                kucity.target.val($(this).find('.name').text());
                kucity.triggleShow('all');
            });
        });
        return this;
    };
})(jQuery);