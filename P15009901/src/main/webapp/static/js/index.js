    /*bar右边开始*/
    $('.all-sort-list > .item').hover(function(){
          var eq = $('.all-sort-list > .item').index(this),       //获取当前滑过是第几个元素
            h = $('.all-sort-list').offset().top,           //获取当前下拉菜单距离窗口多少像素
            s = $(window).scrollTop(),                  //获取游览器滚动了多少高度
            i = $(this).offset().top,                 //当前元素滑过距离窗口多少像素
            item = $(this).children('.item-list').height(),       //下拉菜单子类内容容器的高度
            sort = $('.all-sort-list').height();            //父类分类列表容器的高度
          
          if ( item < sort ){                     
            if ( eq == 0 ){
              $(this).children('.item-list').css('top', (i-h));
            } else {
              $(this).children('.item-list').css('top', (i-h)+1);
            }
          } else {
            if ( s > h ) {                      
              if ( i-s > 0 ){                   
                $(this).children('.item-list').css('top', (s-h)+2 );
              } else {
                $(this).children('.item-list').css('top', (s-h)-(-(i-s))+2 );
              }
            } else {
              $(this).children('.item-list').css('top', 3 );
            }
          } 

          $(this).addClass('hover');
          $(this).children('.item-list').css('display','block');
        },function(){
          $(this).removeClass('hover');
          $(this).children('.item-list').css('display','none');
        });

        $('.item > .item-list > .close').click(function(){
          $(this).parent().parent().removeClass('hover');
          $(this).parent().hide();
        });
        /*bar右边结束*/ 
        /*主题推荐*/
  $('.indexthemetop ul li').mouseover(function(){
    var liindex = $('.indexthemetop ul li').index(this);
    $(this).addClass('indexthemetopullihover').siblings().removeClass('indexthemetopullihover');
    $('.indexthemecenterbiger div.indexsalecenter').eq(liindex).show().siblings('.indexthemecenterbiger div.indexsalecenter').hide();
  });
  /*特价*/
  $('.indexsaletop ul li').mouseover(function(){
    var liindex = $('.indexsaletop ul li').index(this);
    $(this).addClass('indexsaletopullihover').siblings().removeClass('indexsaletopullihover');
    $('.indexsalecenterbiger div.indexsalecenter').eq(liindex).show().siblings('.indexsalecenterbiger div.indexsalecenter').hide();
  });
  /*当地；旅游*/
  $('.indextourtop ul li').mouseover(function(){
    var liindex = $('.indextourtop ul li').index(this);
    $(this).addClass('indextourtopullihover').siblings().removeClass('indextourtopullihover');
    $('.indextourcenterbiger div.indextourcenter').eq(liindex).show().siblings('.indextourcenterbiger div.indextourcenter').hide();
  });
  
