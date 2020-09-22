$('#main_search').select2({
    minimumInputLength: 1,
    ajax: {
        url: '/LncExpDB/browse/search',
        data: function (params) {
            var query = {
                type: params.term
            };
            return query;
        },
        cache: false
    },
    templateResult: formatState
});

function formatState (state) {
    var $state = $("<span>" + state.text.split("|")[0]+"</span><span style='float: right'><kbd>" + state.text.split("|")[1]+"</kbd></span>");
    return $state;
};

$('#main_search').on('select2:select', function (e) {
    if ($('#main_search').val().split("|")[1] == "Gene ID") {
        $.ajax({
            url: '/LncExpDB/browse/searchgene?geneid='+$('#main_search').val().split("|")[0],
            type: 'POST',
            dataType: 'json',
            cache: false,
            success: succFunction //成功执行方法
        });
        function succFunction(data) {
            var entries = data["search"]
            var id = entries[0]["geneid"]
            $(location).attr('href', '/LncExpDB/gene?geneid='+id);
        }
    }
    if ($('#main_search').val().split("|")[1] == "Gene Name") {
        $.ajax({
            url: '/LncExpDB/browse/searchsymbol?symbol='+$('#main_search').val().split("|")[0],
            type: 'POST',
            dataType: 'json',
            cache: false,
            success: succFunction //成功执行方法
        });
        function succFunction(data) {
            var entries = data["search"]
            var id = entries[0]["geneid"]
            $(location).attr('href', '/LncExpDB/gene?geneid='+id);
        }
    }
    if ($('#main_search').val().split("|")[1] == "Transcript ID") {
        $.ajax({
            url: '/LncExpDB/browse/searchtranscript?transcriptid='+$('#main_search').val().split("|")[0],
            type: 'POST',
            dataType: 'json',
            cache: false,
            success: succFunction //成功执行方法
        });
        function succFunction(data) {
            var entries = data["search"]
            var id = entries[0]["geneid"]
            $(location).attr('href', '/LncExpDB/gene?geneid='+id);
        }
    }
});

$("#radar").on('click',function () {
    var tempwindow=window.open('_blank')
    tempwindow.location.href="/LncExpDB/featured";
})