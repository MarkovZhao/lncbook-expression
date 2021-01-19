var genetable = (function (url) {
    $('#lnc_table').bootstrapTable('destroy');
    $('#lnc_table').bootstrapTable({
        method: "post",
        url: url,
        striped: true, //是否显示行间隔色
        cache: false,//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,//是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        //pageNumber:1,//初始化加载第一页，默认第一页
        pageSize: 10,//每页的记录行数（*）
        pageList: [5, 10, 20, 30],
        search: false,
        dataField: "geneinfo",
        queryParamsType: "",
        silent: true,  //刷新事件必须设
        sidePagination: "server",//分页方式：client客户端分页，server服务端分页（*）
        contentType: "application/x-www-form-urlencoded",//请求远程数据的内容类型。
        showExport: true,
        exportDataType: 'all',
        exportTypes:[ 'csv', 'txt'],
        formatLoadingMessage: function () {
            return "<h4>Please wait...</h4>";
        },
        queryParams: function queryParams(params) {
            var param ={
                page: params.pageNumber-1,
                size: params.pageSize
            };
            return param;
        },
        columns: [
            {
                title: 'Gene ID',
                field: 'geneid',
                align: "center",
                formatter: function(value,row,index){
                    return "<a href='https://bigd.big.ac.cn/lncexpdb/gene?geneid=" + value + "'target='_blank'>" + value + "</a>"
                },
                // sortable: true

            },
            {
                title: 'Gene Symbol',
                field: 'symbol',
                align: "center",
                // sortable: true
            },
            {
                title: '<a href="/lncexpdb/help#classification" target="_blank" title' + '="Based on their genomic locations in respect to protein-coding genes, we classified lncRNAs into ' +
                    'seven groups, Intergenic, Intronic (S), Intronic (AS), Overlapping (S), Overlapping (AS), Sense, ' +
                    'and Antisense. S in the bracket represents that lncRNAs are in the same strand of protein-coding RNAs,' +
                    ' and AS represents lncRNAs are in the antisense strand of protein-coding RNAs.">'+'Classification'+' ' +
                    '<span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'classification',
                align: "center",
                // sortable: true
            },
            {
                title: 'Chromosome',
                field: 'chromosome',
                align: "center"
            },
            {
                title: 'Strand',
                field: 'strand',
                align: "center"
            },
            {
                title: 'Start',
                field: 'start',
                align: "center"
            },
            {
                title: 'End',
                field: 'end',
                align: "center"
            },
            {
                title: 'Gene Length',
                field: 'gene_length',
                align: "center"
            },
            {
                title: 'Exon Length',
                field: 'length',
                align: "center"
            },
            {
                title: 'Transcript Number',
                field: 'transNumber',
                align: "center",
                // sortable: true
            }]
    });
});

var url1 = "/lncexpdb/all/geneidlist";

$('#featurelnc').select2({
    minimumInputLength: 1,
    ajax: {
        url: url1,
        data: function (params) {
            var query = {
                type: params.term
            };
            return query;
        },
        cache: false
    }
});

$('#feature_sect1').change(function () {

    if ($('#feature_sect1').val() == "geneid") {
        url1 = "/lncexpdb/all/geneidlist";
        $('#featurelnc').attr('data-placeholder', 'eg. HSALNG000002');
    } else if ($('#feature_sect1').val() == "symbol") {
        url1 = "/lncexpdb/all/symlist";
        $('#featurelnc').attr('data-placeholder', 'eg. MALAT1');
    } else if ($('#feature_sect1').val() == "classification") {
        url1 = "/lncexpdb/all/classificationlist";
        $('#featurelnc').attr('data-placeholder', 'eg. Intergenic');
    } else if ($('#feature_sect1').val() == "chromosome") {
        url1 = "/lncexpdb/all/chromosomelist";
        $('#featurelnc').attr('data-placeholder', 'eg. chr1');
    }
    $('#featurelnc').select2({
        minimumInputLength: 1,
        ajax: {
            url: url1,
            data: function (params) {
                var query = {
                    type: params.term
                };
                return query;
            },
            cache: false
        }
    });
})


var list = document.getElementById("featurelnc");
if(list.options[0].value==""){
    var url = '/lncexpdb/all/lncall';
    genetable(url)
}

$('.feature').change(function () {
    var dis = $('.feature').val();
    var v2 = $(".select_filter").val();
    var url = '/lncexpdb/all/' +v2 + '?term=' + dis;
    console.log(url)
    genetable(url);
    if($(this).val() != null && $(this).val()!=""){
        $('#featurelnc_cancel').show();
    }else{
        $('#featurelnc_cancel').hide();
    }
    $("#featurelnc_cancel").on("click",function () {
        var url = '/lncexpdb/all/lncall';
        genetable(url);
        $("#featurelnc").empty();
        $('#featurelnc_cancel').hide();
    });

    var val = $('.feature').val();
    if(val=="" || val==null){
        var url = '/lncexpdb/all/lncall';
        genetable(url)
    }
});

$('#classification').change(function () {
    var dis = $('#classification').val();
    if (dis != "All") {
        url_classification = '/lncexpdb/all/classification' + "?term=" + encodeURIComponent(dis);
        genetable(url_classification);
    }else{
        url = '/lncexpdb/all/lncall';
        genetable(url);
    }

})

$('#chrome').change(function () {
    var dis = $('#chrome').val();
    if (dis != "All") {
        url_chromosome = '/lncexpdb/all/chromosome' + "?term=" + encodeURIComponent(dis);
        genetable(url_chromosome);
    }else{
    url = '/lncexpdb/all/lncall';
    genetable(url);
}
})