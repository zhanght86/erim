    //签约房 增加房两
    $("#qy_add").click(function() {
        var num = $("#qy_num").val();
        var addNum = Number(num) + 1;
        //超售
        var cs_num = $("#xl_num").val();
        $("#qy_num").attr("value", addNum);
        $("#span_surplus").html(addNum+Number(cs_num));
    });
    //签约房 减少房量
    $("#qy_jian").click(function() {
        var num = $("#qy_num").val();
        if("0" != num){
            var addNum = Number(num) - 1;
            //超售
           var cs_num = $("#xl_num").val();
           $("#qy_num").attr("value", addNum);
           $("#span_surplus").html(addNum+Number(cs_num));
        }
    });
    
    //房量失去焦点 判断是否是正整数  如果不是则改为1
    $("#qy_num").blur(function() {
         var inputval = $(this).val();
         //正整数正则
         var number   = /^[1-9]\d*$/;
         if(!number.test(inputval)){
             $(this).attr("value",0);
         }
    });
    
    //限量失去焦点 判断是否是正整数  如果不是则改为1
    $("#xl_num").blur(function() {
         var inputval = $(this).val();
         //正整数正则
         var number   = /^[1-9]\d*$/;
         if(!number.test(inputval)){
             $(this).attr("value",0);
         }
    });
    
    //限售超售  增加
    $("#xl_add").click(function() {
        var num = $("#xl_num").val();
        var addNum = Number(num) + 1;
        
        //签约房
        var qy_num = $("#qy_num").val();
        $("#xl_num").attr("value", addNum);
        $("#span_surplus").html(addNum+Number(qy_num));
    });
    
    //限售超售  较少    
    $("#xl_jian").click(function() {
        var num = $("#xl_num").val();
        if("0" != num){
            var addNum = Number(num) - 1;
            
            //签约房
            var qy_num = $("#qy_num").val();
        
           $("#xl_num").attr("value",addNum);
           $("#span_surplus").html(addNum+Number(qy_num));
        }
    });
    
    //批量设置
    $('#btnset').click(function() {
        $(".showinfo").hide();
        $('#fix_mask_roomnum').fadeIn(100);
        $('#fix_roomnum').slideDown(200);
    });
    $('#fix_roomnum .quxiao').click(function() {
        $('#fix_mask_roomnum').fadeOut(100);
        $('#fix_roomnum').slideUp(200);
    });
    $('#fix_roomnum .queren').click(function() {
        $('#fix_mask_roomnum').fadeOut(100);
        $('#fix_roomnum').slideUp(200);
    });
    
    //房量设置
    $('.tadd').click(function() {
        $(".showinfo").hide();
        $('#fix_mask_update').fadeIn(100);
        $('#fix_update').slideDown(200);
    });
    $('#fix_update .quxiao').click(function() {
        $('#fix_mask_update').fadeOut(100);
        $('#fix_update').slideUp(200);
    });
    $('#fix_update .queren').click(function() {
        $('#fix_mask_update').fadeOut(100);
        $('#fix_update').slideUp(200);
    });
    
    $("[id^=del_]").off().on("click", function() {
        var id = $(this).attr("id").split("_").pop();
        if (confirm("确定删除此条信息？")) {
            form.sub({
                id : id
            }, _appRoot+"/hotel/roomnum/delete", _appRoot+"/hotel/roomnum/list");
        };
    });
    //房间
    var room = {
        lx : '',
        sj : ''
    };
    
    //点击TD
    $("#tdroom td").live('click', function(e) {
        if ((!$.browser.msie && e.button == 0) || ($.browser.msie && e.button == 1)) {
            room.lx = $(this).attr("lx");
            room.sj = $(this).attr("sj");
    
            Mouse(e);
            jQuery(".showinfo").css({
                top : toppos,
                left : leftpos
            }).fadeIn(100);
        }
    });
    
    //鼠标点击
    var MouseEvent = function(e) {
        this.x = e.pageX;
        this.y = e.pageY;
    };
    var Mouse = function(e) {
        var kdheight = jQuery(document).scrollTop();
        mouse = new MouseEvent(e);
        leftpos = mouse.x + 10;
        toppos = mouse.y - kdheight + 10;
    };
    
    //关房
    $("#choseRoom").click(function() {
        var url = _appRoot+"/hotel/roomnum/updateRoom";
    
        //提交
        $.post(url, {
            hdlId : $hotelRoom.hdlId,
            hrnDate : room.sj,
            hheId : room.lx,
            hrnIsOpen : 0
        }, function(data) {
            wxcalert(data);
        }, 'json');
    });