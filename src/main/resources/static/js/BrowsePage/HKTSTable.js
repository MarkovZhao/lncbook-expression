var hkts_table = (function (url) {
    $('#hkts_table').bootstrapTable('destroy');
    $('#hkts_table').bootstrapTable({
        method: "get",
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
        showColumns:true,
        showExport: true,
        exportDataType: 'all',
        exportTypes:[ 'csv', 'txt'],
        formatLoadingMessage: function () {
            return "<h4>Please wait...</h4>";
        },
        queryParams: function queryParams(params) {
            var param ={
                page: params.pageNumber-1,
                size: params.pageSize,
                sortName: params.sortName,      //排序列名
                sortOrder: params.sortOrder,     //排序
            };
            return param;
        },
        columns: [
            {
                title: 'Gene ID',
                field: 'geneid',
                align: "center",
                formatter: function(value,row,index){
                    return "<a href='https://bigd.big.ac.cn/LncExpDB/gene?geneid=" + value + "'target='_blank'>" + value + "</a>"
                },
                // sortable: true

            },
            {
                title: 'Tau Value',
                field: 'tau',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(2)
                }
            },

            {
                title: 'Max Name',
                field: 'max_name',
                align: "center",
                sortable: true,
            },
            {
                title: 'Max TPM',
                field: 'max_value',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(2)
                }
            },
            {
                title: 'Min Name',
                field: 'min_name',
                align: "center",
                sortable: true,
            },
            {
                title: 'Min TPM',
                field: 'min_value',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(2)
                }
            },
            {
                title: 'Average TPM',
                field: 'avg',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(2)
                }
            },

            {
                title: 'C.V',
                field: 'cv',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(2)
                }
            },

            {
                title: 'Expression Breadth',
                field: 'brand',
                align: "center",
                sortable: true,
            },

        ]
    });
});

var url1 = "/LncExpDB/hkts/brain";
hkts_table(url1)


$("#hkts_filter").on('click',function () {
    var all_params = new Array();
    var datatype = "";
    $(".hkts_datatype").each(function(){

        if ($(this).is(":checked")) {
            datatype = $(this).attr("id").split("_")[1];
            $(this).attr("disabled","disabled");
            console.log(datatype);
        }
    });

    $(".hkts_filter").each(function(){
        var param_name = $(this).attr("name");
        var param_data = $(this).val();
        if (param_data != "") {
            var param = param_name + '=' + param_data;
            console.log(param)
            all_params.push(param);
            console.log(all_params)
        }
    });
    if (all_params.length == 0) {
        var url = '/LncExpDB/hkts/' + datatype;
    } else {
        var url = '/LncExpDB/hkts/' + datatype + '?' + all_params.join("&");
    }
    console.log(url)
    hkts_table(url);

    $(".check_feature").each(function(){
        $(this).removeAttr("disabled");
        $(this).attr('checked',false);
    });

})

$(".hkts_datatype").on('click',function () {

    if ($("#hkts_brain").is(":checked")) {
        $(".hkts_datatype").each(function(){
            if ($(this).attr("id") != "hkts_brain") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#hkts_cerebellum").is(":checked")) {
        $(".hkts_datatype").each(function(){
            if ($(this).attr("id") != "hkts_cerebellum") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#hkts_heart").is(":checked")) {
        $(".hkts_datatype").each(function(){
            if ($(this).attr("id") != "hkts_heart") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#hkts_kidney").is(":checked")) {
        $(".hkts_datatype").each(function(){
            if ($(this).attr("id") != "hkts_kidney") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#hkts_liver").is(":checked")) {
        $(".hkts_datatype").each(function(){
            if ($(this).attr("id") != "hkts_liver") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#hkts_ovary").is(":checked")) {
        $(".hkts_datatype").each(function(){
            if ($(this).attr("id") != "hkts_ovary") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#hkts_testis").is(":checked")) {
        $(".hkts_datatype").each(function(){
            if ($(this).attr("id") != "hkts_testis") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#hkts_pre1").is(":checked")) {
        $(".hkts_datatype").each(function(){
            if ($(this).attr("id") != "hkts_pre1") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#hkts_pre2").is(":checked")) {
        $(".hkts_datatype").each(function(){
            if ($(this).attr("id") != "hkts_pre2") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if ($("#hkts_differentiation").is(":checked")) {
        $(".hkts_datatype").each(function(){
            if ($(this).attr("id") != "hkts_differentiation") {
                $(this).attr("disabled","disabled")
            }
        })
    }

    else if (!$(this).is(":checked")) {
        $(".hkts_datatype").each(function(){
            $(this).removeAttr("disabled")
        })
    }
})

$("#hkts_reset").on('click', function () {
    test = [];
    all_params = [];
    $(".hkts_datatype").each(function(){
        $(this).removeAttr("disabled");
        $(this).attr('checked',false);
    });
    $(".check_feature").each(function(){
        $(this).removeAttr("disabled");
        $(this).attr('checked',false);
    });

    $('input[name="tau1"]').val(0);
    $('input[name="tau2"]').val(1);
    $('input[name="cv1"]').val(0);
    $('input[name="cv2"]').val(5);
    var url = "/LncExpDB/hkts/brain";
    hkts_table(url);
});

