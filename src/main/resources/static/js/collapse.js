
$(document).ready(function() {
    $('.panel-group').on('hide.bs.collapse show.bs.collapse', '.panel-collapse', function (e) {
        var $this   = $(this);
        $this.prev().find("span").toggleClass("glyphicon glyphicon-triangle-bottom");
        $this.prev().find("span").toggleClass("glyphicon glyphicon-triangle-right");
    })

});