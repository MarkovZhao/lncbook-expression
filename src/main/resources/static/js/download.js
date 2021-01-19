function download_metadata() {
    $("d_meta").button('loading');
    var element = document.createElement('a');
    var a = [];
    for (var i = 0; i < cc.length; i ++) {
        a.push(cc[i])
    }

    $.ajax({
        url: "/lncexpdb/repository/",
        type: "POST",
        data: jQuery.param(
            {
                terms: a
            }, true
        ),
        dataType: "text",
        success: function (d) {
            element.setAttribute("href","data:text/csv;charset=utf-8," + encodeURIComponent(d));
            element.setAttribute("download","lncexpdb_download.csv");
            element.style.display = "none";
            document.body.appendChild(element);
            element.click();
            document.body.removeChild(element);

        }
    }
    )
}