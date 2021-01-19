var pattern_table = (function (url) {
    $('#pattern_table').bootstrapTable('destroy');
    $('#pattern_table').bootstrapTable({
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
        dataField: "geneInfo",
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
                sortName: params.sortName,      //排序列名
                sortOrder: params.sortOrder     //排序
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
                title: 'P value',
                field: 'p_value',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(2)
                }
            },

            {
                title: 'R squared',
                field: 'r_squared',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(2)
                }
            },
            {
                title: 'K=4',
                field: 'k_4',
                align: "center",
                sortable: true,
            },
            {
                title: 'K=5',
                field: 'k_5',
                align: "center",
                sortable: true,
            },
            {
                title: 'K=6',
                field: 'k_6',
                align: "center",
                sortable: true,
            },
            {
                title: 'K=7',
                field: 'k_7',
                align: "center",
                sortable: true,
            },
            {
                title: 'K=8',
                field: 'k_8',
                align: "center",
                sortable: true
            },

        ]
    });
});

var url1 = "/lncexpdb/pattern/brain";
pattern_table(url1)


$("#filter").on('click',function () {
    var all_params = new Array();
    var datatype = "";
    $(".datatype").each(function(){

        if ($(this).is(":checked")) {
            datatype = $(this).attr("id");
            $(this).attr("disabled","disabled");
            console.log(datatype);
        }
    });

    $(".pattern_filter").each(function(){
        var param_name = $(this).attr("name");
        var param_data = $(this).val();
        var param = param_name + '=' + param_data;
        console.log(param)
        all_params.push(param);
        console.log(all_params)
    });

    var url = '/lncexpdb/pattern/' + datatype + '?' + all_params.join("&");
    console.log(url)
    pattern_table(url);

    $(".check_feature").each(function(){
        $(this).removeAttr("disabled");
        $(this).attr('checked',false);
    });

})

$(".datatype").on('click',function () {

    if ($("#brain").is(":checked")) {
        $(".datatype").each(function(){
            if ($(this).attr("id") != "brain") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#cerebellum").is(":checked")) {
        $(".datatype").each(function(){
            if ($(this).attr("id") != "cerebellum") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#heart").is(":checked")) {
        $(".datatype").each(function(){
            if ($(this).attr("id") != "heart") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#kidney").is(":checked")) {
        $(".datatype").each(function(){
            if ($(this).attr("id") != "kidney") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#liver").is(":checked")) {
        $(".datatype").each(function(){
            if ($(this).attr("id") != "liver") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#testis").is(":checked")) {
        $(".datatype").each(function(){
            if ($(this).attr("id") != "testis") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#ovary").is(":checked")) {
        $(".datatype").each(function(){
            if ($(this).attr("id") != "ovary") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#pre1").is(":checked")) {
        $(".datatype").each(function(){
            if ($(this).attr("id") != "pre1") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#pre2").is(":checked")) {
        $(".datatype").each(function(){
            if ($(this).attr("id") != "pre2") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#differentiation").is(":checked")) {
        $(".datatype").each(function(){
            if ($(this).attr("id") != "differentiation") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if (!$(this).is(":checked")) {
        $(".datatype").each(function(){
            $(this).removeAttr("disabled")
        })
    }
})

$("#reset").on('click', function () {
    test = [];
    all_params = [];
    $(".datatype").each(function(){
        $(this).removeAttr("disabled");
        $(this).attr('checked',false);
    });
    var url = "/lncexpdb/pattern/brain";
    pattern_table(url);
});

