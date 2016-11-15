$(function () {
    var sWidth = $("#focus").width();
    var len = $("#focus ul li").length;
    var index = 0;
    var picTimer;
    var btn = "<div class='btnBg'></div><div class='btn'>";
    for (var i = 0; i < len; i++) {
        btn += "<span></span>";
    }
    btn += "</div><div class='preNext pre'></div><div class='preNext next'></div>";
    $("#focus").append(btn);
    $("#focus .btnBg").css("opacity", 0);
    $("#focus .btn span").css("opacity", 0.4).mouseenter(function () {
        index = $("#focus .btn span").index(this);
        showPics(index);
    }).eq(0).trigger("mouseenter");
    $(".preNext").css("opacity", 0.0).hover(function () {
        $(this).stop(true, false).animate({ "opacity": "0.5" }, 300);
    }, function () {
        $(this).stop(true, false).animate({ "opacity": "0" }, 300);
    });
    $(".pre").click(function () {
        index -= 1;
        if (index == -1) { index = len - 1; }
        showPics(index);
    });
    $(".next").click(function () {
        index += 1;
        if (index == len) { index = 0; }
        showPics(index);
    });
    $("#focus ul").css("width", sWidth * (len));
    $("#focus").hover(function () {
        clearInterval(picTimer);
    }, function () {
        picTimer = setInterval(function () {
            showPics(index);
            index++;
            if (index == len) { index = 0; }
        }, 2800);
    }).trigger("mouseleave");
    function showPics(index) {
        var nowLeft = -index * sWidth;
        $("#focus ul").stop(true, false).animate({ "left": nowLeft }, 300);
        $("#focus .btn span").stop(true, false).animate({ "opacity": "0.4" }, 300).eq(index).stop(true, false).animate({ "opacity": "1" }, 300);
    }
   
});
function $_MM(id){return document.getElementById(id)}
 for(var i=2;i<7;i++){
    $_MM("rigrht"+i).style.display="none"
    }
    /*选项卡*/
function show_about(mid1,id){
//还原所有的className
    for(var k=1;k<7;k++){
        $_MM("gongsi"+k).className = "about_zx";
    }
//修改当前的className
    $_MM(mid1).className = "about_gs";
//隐藏所有的内容
    for(var i=1;i<7;i++){
        $_MM("rigrht"+i).style.display ="none";
    }
    //显示一个对应的内容
    $_MM(id).style.display = "block";
} 
