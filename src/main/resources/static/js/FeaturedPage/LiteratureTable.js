var literature_table = (function (url) {
    $('#literature').bootstrapTable('destroy');
    $('#literature').bootstrapTable({
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
        dataField: "literature",
        queryParamsType: "",
        silent: true,  //刷新事件必须设
        sidePagination: "server",//分页方式：client客户端分页，server服务端分页（*）
        contentType: "application/x-www-form-urlencoded",//请求远程数据的内容类型。
        showExport: true,
        exportDataType: 'all',
        exportTypes:[ 'csv', 'txt'],
        formatLoadingMessage: function () {
            return "please waiting";
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
                    return "<a href='/gene?geneid=" + value + "'target='_blank'>" + value + "</a>"
                },

            },

            {
                title: 'Gene Symbol',
                field: 'symbol',
                align: "center",
            },

            {
                title: 'Gene Name',
                field: 'name',
                align: "center",
            },

            {
                title: '<a href="#" target="_blank" class="tooltip-test" data-toggle="tooltip" title' +
                    '="Based on their genomic locations in respect to protein-coding genes, we classified lncRNAs into ' +
                    'seven groups, Intergenic, Intronic (S), Intronic (AS), Overlapping (S), Overlapping (AS), Sense, ' +
                    'and Antisense. S in the bracket represents that lncRNAs are in the same strand of protein-coding RNAs,' +
                    ' and AS represents lncRNAs are in the antisense strand of protein-coding RNAs.">'+'Classification'+'' +
                    '<span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'classification',
                align: "center",
            },

            {
                title: 'Pubmed ID',
                field: 'pubmed_id',
                align: "center",
                formatter: function(value,row,index){
                    return "<a href='https://pubmed.ncbi.nlm.nih.gov/" + value + "'target='_blank'>" + value + "</a>"
                },
            },

            {
                title: 'Title',
                field: 'title',
                align: "center"
            },
            {
                title: 'Journal',
                field: 'journal',
                align: "center"
            },
            {
                title: 'Year',
                field: 'year',
                align: "center"
            },
            {
                title: 'Abstract',
                field: 'abstracts',
                align: "center",

            },
        ]
    });
});

var url = "http://localhost:8080/featured/literature";
literature_table(url);

