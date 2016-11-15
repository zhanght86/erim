/**
 * Created by 王笑洋 on 2015/11/25.
 */
function $$(a) {
    if (typeof a == "string") {
        return document.getElementById(a)
    }
    return a
}
function addClass(c, b) {
    var a = new RegExp("(^|\\s)" + b + "(\\s|$)");
    if (!a.test(c.className)) {
        c.className = c.className + " " + b
    }
}
function removeClass(c, b) {
    var a = new RegExp("(^|\\s)" + b + "(\\s|$)", "g");
    c.className = c.className.replace(a, " ")
}
function hide(a) {
    a.style.display = "none"
}
function show(a) {
    a.style.display = ""
}
var FlashAdv = function(g, c, b, d, a, f, e) {
    this.wrap = $$(g);
    this.dots = $$(b);
    this.num = c;
    this.height = a || 358;
    this.intermission = f || 4000;
    this.duration = e || 50;
    this.si = null
};
FlashAdv.prototype = {
    creat: function() {
        this.wrap.style.width = this.width * this.num + "px";
        this.index = 0;
        for (var a = 0; a < this.wrap.children.length; a++) {
            this.wrap.children[a].style.width = this.width + "px"
        }
    },
    slide: function(c) {
        var g = this,
            b = -g.width * c,
            e = parseFloat(g.wrap.style.left) || 0,
            f = b - e,
            d = Math.abs(f / g.duration),
            a = f == 0 ? 1 : Math.abs(f) / f;
        g.si && clearInterval(g.si);
        g.si = setInterval(function() {
                e = parseFloat(g.wrap.style.left) || 0;
                if (Math.abs(b - e) <= d) {
                    clearInterval(g.si);
                    d = Math.abs(b - e)
                }
                g.wrap.style.left = e + a * d + "px"
            },
            1)
    },
    changeDot: function(a) {
        for (var b = 0; b < this.dots.children.length; b++) {
            this.dots.children[b].style.background = "#B3B3B3"
        }
        this.dots.children[a].style.background = "#397ee5"
    },
    autoPlay: function() {
        var a = this;
        a.autoSi = setInterval(function() {
                var b = (a.index - 0 + 1) % a.num;
                a.slide(b);
                a.index = b
            },
            a.intermission)
    },
    bindEvent: function() {
        var d = this,
            c, b = function(e) {
                d.slide(e);
                d.index = e;
                clearInterval(d.autoSi);
                d.autoPlay()
            };
        for (var a = 0; a < this.dots.children.length; a++) {
            addEvent(this.dots.children[a], "click",
                function(f) {
                    var g = f.target || f.srcElement;
                    b(g.getAttribute("index"))
                })
        }
    }
};
function SlideShow(a) {
    this.initial(a)
}
SlideShow.prototype = {
    defaultOptions: {
        effect: "slide",
        activeClass: "tbui_slideshow_active",
        interval: 4000,
        slide: {
            speed: 1
        },
        fade: {
            speed: 1
        }
    },
    initial: function(b) {
        b = $.extend({},
            this.defaultOptions, b);
        var a = this;
        this.options = b;
        this.animating = false;
        this.current = 0;
        this.vendorPrefix = this._getVendorPrefix();
        this.$nav = $(b.nav);
        this.$navItem = this.$nav.children();
        this.total = this.$navItem.size();
        this.$container = $(b.target);
        this.$list = this.$container.children(".tbui_slideshow_list");
        this.$tokens = this.$list.children();
        /*if (!b.width) {
            b.width = this.$container.width()
        }
        if (!b.height) {
            b.height = this.$container.height()
        }
        this.$container.add(this.$list).css({
            width: b.width,
            height: b.height
        });*/
        this.interval = b.interval || 200;
        this.$navItem.first().addClass(b.activeClass);
        this.$tokens.first().show();
        this.$navItem.hover(function() {
                var c = this;
                if (b.auto) {
                    a.stop()
                }
                this.delayHandler = setTimeout(function() {
                        a.delayHandler = null;
                        a.setActive($(c).index())
                    },
                    200)
            },
            function() {
                if (b.auto) {
                    a.play()
                }
                if (this.delayHandler) {
                    clearTimeout(this.delayHandler)
                }
            });
        this.effectHandler = this["_" + b.effect];
        if (b.auto) {
            this.play();
            this.$list.hover(function() {
                    a.stop()
                },
                function() {
                    a.play()
                })
        }
        if (b.next) {
            $(b.next).click(function(c) {
                c.preventDefault();
                c.stopPropagation();
                a.next()
            })
        }
        if (b.prev) {
            $(b.prev).click(function(c) {
                c.preventDefault();
                c.stopPropagation();
                a.prev()
            })
        }
    },
    setActive: function(a) {
        if (!this.animating && a !== this.current) {
            this.$navItem.removeClass(this.options.activeClass).eq(a).addClass(this.options.activeClass);
            this.effectHandler(a)
        }
    },
    next: function() {
        var a = this.current + 1;
        if (a == this.total) {
            a = 0
        }
        this.setActive(a)
    },
    prev: function() {
        var a = this.current - 1;
        if (a == -1) {
            a = this.total - 1
        }
        this.setActive(a)
    },
    play: function() {
        var a = this;
        if (this.autoHandler == null) {
            this.autoHandler = setInterval(function() {
                    a.next()
                },
                this.options.interval)
        }
    },
    stop: function() {
        clearInterval(this.autoHandler);
        this.autoHandler = null
    },
    _slide: function(f) {
        var d, g, b, c, e, a, h;
        var i = this;
        this.animating = true;
        d = this.current;
        h = f > d ? 1 : -1;
        g = f > d ? -this.options.width: this.options.width;
        c = f;
        this.$tokens.eq(d).siblings().css({
            display: "none",
            left: 0,
            zIndex: 0
        });
        this.$tokens.eq(c).css({
            display: "block",
            left: h * this.options.width,
            zIndex: 10
        });
        if (this.vendorPrefix) {
            e = this.vendorPrefix;
            a = e + "Transform";
            b = e + "TransitionDuration";
            this.$list[0].style[a] = "translateX(" + g + "px)";
            this.$list[0].style[b] = this.options.slide.speed + "ms";
            this.$list.on("transitionend webkitTransitionEnd oTransitionEnd otransitionend MSTransitionEnd",
                function() {
                    i.$list[0].style[a] = "";
                    i.$list[0].style[b] = "";
                    i.$tokens.eq(c).css({
                        left: 0
                    });
                    i.$tokens.eq(d).css({
                        display: "none",
                        left: 0,
                        zIndex: 0
                    });
                    i.animating = false;
                    i.current = c;
                    i.$list.unbind("transitionend webkitTransitionEnd oTransitionEnd otransitionend MSTransitionEnd")
                })
        } else {
            i.$list.stop().animate({
                    left: g
                },
                this.options.slide.speed,
                function() {
                    i.$list.css({
                        left: 0
                    });
                    i.$tokens.eq(c).css({
                        left: 0
                    });
                    i.$tokens.eq(d).css({
                        display: "none",
                        left: 0,
                        zIndex: 0
                    });
                    i.current = c;
                    i.animating = false
                })
        }
    },
    _fade: function(c) {
        var a = this;
        var d, b;
        this.animating = true;
        d = this.current;
        b = c;
        this.$tokens.eq(b).css({
            display: "none",
            left: 0,
            zIndex: 10
        });
        this.$tokens.eq(d).stop().fadeOut(this.options.fade.speed);
        this.$tokens.eq(b).stop().fadeIn(this.options.fade.speed, (function() {
            a.$tokens.eq(b).css({
                zIndex: 0
            });
            a.animating = false;
            a.current = b
        }))
    },
    _getVendorPrefix: function() {
        var a, b, c, d, e;
        a = document.body || document.documentElement;
        c = a.style;
        d = "Transition";
        e = ["Moz", "Webkit", "Khtml", "O", "ms"];
        b = 0;
        while (b < e.length) {
            if (typeof c[e[b] + d] === "string") {
                return e[b]
            }
            b++
        }
        return false
    }
};
 (function(g) {
    var b = g("#other-prod"),
        d = b.find("ul"),
        f = g(".all-app");
    f.click(function() {
        a()
    });
    function c() {
        f.addClass("actived");
        f.attr("show", 1);
        b.slideDown()
    }
    function e() {
        f.attr("show", 0);
        f.removeClass("actived");
        b.slideUp()
    }
    function a() {
        if (f.attr("show") == 1) {
            e()
        } else {
            c()
        }
    }
})(jQuery);
