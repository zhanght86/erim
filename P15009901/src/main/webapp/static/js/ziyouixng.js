// JavaScript Document
//清空value
function oo(id) {
    $_MM(id).value = ""
}

function $_MM(id) {
    return document.getElementById(id)
}


//初始状态隐藏除第一个以后的所有内容
function show_MM(mid1, id) {
    //还原所有的className
    for (var k = 1; k < 8; k++) {
        $_MM("T" + k).className = "newsChannel";
    }
    //修改当前的className
    $_MM(mid1).className = "newsChannelTwo";
    //隐藏所有的内容
    for (var i = 1; i < 8; i++) {
        $_MM("ul" + i).style.display = "none";
    }
    //显示一个对应的内容
    $_MM(id).style.display = "block";
}

//酒店特效
//显示隐藏
$(function() {
    $("#tishi,#zuhetishi").hide()
    $(document).ready(function() {
        $(".beijing").click(function() {
            $(".tishi_box_zuhe").hide()
            $("#tishi").toggle(0);
        });
    });
});
//显示隐藏组合搜索
$(function() {
    $("body").load(function() {
    })
    $(".startDate,.endDate,.beijing").click(function() {
        $("#xiang_gang,#zhehe_box").hide()
        $(".lijisuosuo1").show()
    })
})
$(function() {
    $(document).ready(function() {
        $("#zuhe,#zuheSS").click(function() {
            $(".tishi_box_zuhe").show()
            $("#tishi,.lijisuosuo1").hide()
            $(".guanbi_box,.remen_a,.remen_a_a").click(function() {
                $("#zuhetishi").hide()
                $(".lijisuosuo1").show()
            });
        });
    });
});

//日历获取焦点隐藏提示语
$(function() {
    $(".startDate,.endDate").click(function() {
        $(".tsyuyuan,.tishi_box,.tishi_box_zuhe,.gjzh").hide();
    });
})
//香港搜索
$(function() {
    $("#xiang_box,.jdzh11").click(function() {
        $(".tsyuyuan,.lijisuosuo11").hide()
        $(".gjzh").show()
    });
})
//显示按钮国际
$(function() {
    $(".startDate,.endDate,.xianggang,.tsyuyuan,#guanbi_max").click(function() {
        $(".lijisuosuo11").show()
        $(".gjzh").hide()

    })
})
function huoqu(mid, id, mmid) {
    $_MM(mid).value = $_MM(id).innerHTML;
    $_MM(mmid).style.display = "none";
}

function $_MM(id) {
    return document.getElementById(id);
}

//初始状态隐藏除第一个以后的所有内容
function shows(TitleId1, id) {
    //还原所有的className
    for (var k = 1; k < 9; k++) {
        $_MM("Title" + k).className = "jiudian_left";
    }
    //修改当前的className
    $_MM(TitleId1).className = "jiudian_left1";
    //隐藏所有的内容
    for (var i = 1; i < 9; i++) {
        $_MM("list_jiudian" + i).style.display = "none";
    }
    //显示一个对应的内容
    $_MM(id).style.display = "block";
}

//超级自由行里面的
/*function showssuper(TitleId1, id) {
    //还原所有的className
    for (var k = 1; k < 9; k++) {
        $_MM("Title" + k).className = "jiudian_super_left";
    }
    //修改当前的className
    $_MM(TitleId1).className = "jiudian_super_left1";
    //隐藏所有的内容
    for (var i = 1; i < 9; i++) {
        $_MM("list_jiudian" + i).style.display = "none";
    }
    //显示一个对应的内容
    $_MM(id).style.display = "block";
}*/

//超级自由行结束
//单选框切换
function First1() {
    for (var i = 2; i < 3; i++) {
        $_MM("danxuan" + i).style.display = "none";
    }
}

function shows1(id) {
    for (var i = 1; i < 3; i++) {
        $_MM("danxuan" + i).style.display = "none";
    }
    $_MM(id).style.display = "block";

}

//初始状态隐藏除第一个以后的所有内容
function huochepiao(mid1, id) {
    //还原所有的className
    for (var k = 1; k < 3; k++) {
        $_MM("huohche_zz" + k).className = "huohce_top_che";
    }
    //修改当前的className
    $_MM(mid1).className = "huohce_top_zhan";
    //隐藏所有的内容
    for (var i = 1; i < 3; i++) {
        $_MM("zhanzhan" + i).style.display = "none";
    }
    //显示一个对应的内容
    $_MM(id).style.display = "block";
}

//国际机票选项
function $_MM(id) {
    return document.getElementById(id)
}


//初始状态隐藏除第一个以后的所有内容
function show_M(mid1, id) {
    //还原所有的className
    for (var k = 1; k < 3; k++) {
        $_MM("ji" + k).className = "guonejipiao1";
    }
    //修改当前的className
    $_MM(mid1).className = "guonejipiao";
    //隐藏所有的内容
    for (var i = 1; i < 3; i++) {
        $_MM("feiji" + i).style.display = "none";
    }
    //显示一个对应的内容
    $_MM(id).style.display = "block";
}




//国内接送的js特效
$("#tab-wrap label").click(function() {
    $(this).siblings().removeClass("active");
    $(this).addClass("active");
    $("#tab-con .tab-con1").hide().eq($(this).prevAll().length).show();
});
//国外接送的js特效
$("#tab-wrapp label").click(function() {
    $(this).siblings().removeClass("activee");
    $(this).addClass("activee");
    $("#tab-conn .tab-conn1").hide().eq($(this).prevAll().length).show();
});
//总的tab切换
$("#tab_p li").click(function() {
    $(this).siblings().removeClass("arc");
    $(this).addClass("arc");
    $("#tab-n .tab-n1").hide().eq($(this).prevAll().length).show();
});

