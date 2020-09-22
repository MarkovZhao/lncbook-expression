var pos_fix = function (a) {
    $(document).scrollTop($(a).offset().top-64)
};

window.onscroll = function(){
    var t = document.documentElement.scrollTop || document.body.scrollTop;
    var top_div = 62 - t;
    if( t <= 15 ) {
        document.getElementById('sidebar_scroll').style.position = "fixed";
    }
    else {
        document.getElementById('sidebar_scroll').style.position = "static";
    }
};

// function getScrollTop(){
//     return document.body.scrollTop;
// }
//
// function getScrollHeight(){
//     return document.body.clientHeight;
// }
//
// function getWindowHeight(){
//     var windowHeight = 0;
//     if(document.compatMode == "CSS1Compat")
//     {
//         windowHeight = document.documentElement.clientHeight;
//     }
//     else
//     {
//         windowHeight = document.body.clientHeight;
//     }
//     return windowHeight;
// }
//
// window.onscroll = function(){
//     if((getScrollHeight() - getScrollTop() - getWindowHeight()) > 61) {
//         $('.fixed').css('position', 'relative');
//     }
//     else {
//         $('.fixed').css('position','fixed');
//     }
// }