var hkts_table = (function (url) {
    $('#featured_table').bootstrapTable('destroy');
    $('#featured_table').bootstrapTable({
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
                    return "<a href='/lncexpdb/gene?geneid=" + value + "'target='_blank'>" + value + "</a>"
                },
                // sortable: true

            },
            {
                title: 'Gene Symbol',
                field: 'symbol',
                align: 'center'
            },
            {
                title: '<a title="Tissue-Specific Index, τ value interpolates the entire range between 0 for housekeeping genes and 1 for strictly one-tissue-specific genes.">'+'&tau; value'+'' + ' <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'tau',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },

            {
                title: '<a title="Biological contition that shows the maximum TPM value">'+'Max Expression'+'' + ' <span class="glyphicon glyphicon-question-sign"></span></a>',
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
                    return Number(value).toFixed(3)
                }
            },
            {
                title: 'Min TPM',
                field: 'min_value',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },
            {
                title: 'Median',
                field: 'median',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },
            {
                title: 'Average TPM',
                field: 'avg',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },

            {
                title: '<a title="Coefficient of Variation">'+'CV'+'' + ' <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'cv',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },

            {
                title: 'Breadth',
                field: 'brand',
                align: "center",
                sortable: true,
            },

            {
                title: '<a title="Goodness of fit.">R<SUP>2</SUP> <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'r_squared',
                sortable: true,
                formatter: function (data, type, row) {
                    if (data === -1) {
                        return 'N/A';
                    }  else {
                        return Number(data).toFixed(3)
                    }
                }
            },

            {
                title: 'P Value',
                field: 'p_value',
                sortable: true,
                formatter: function (data, type, row) {
                    if (data === -1) {
                        return 'N/A';
                    }  else {
                        return Number(data).toFixed(3)
                    }
                }
            },

            {
                title: '<a title="K is the number of clusters for grouping genes with similar time-course expression pattern.">K = 4 <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'k_4',
                sortable: true,
                formatter: function (data, type, row) {
                    if (data === "1"||data === "1.0") {
                        return 'Cluster 1';
                    } else if (data === "2"||data === "2.0") {
                        return "Cluster 2"
                    } else if (data === "3"||data === "3.0") {
                        return "Cluster 3"
                    } else if (data === "4"||data === "4.0") {
                        return "Cluster 4"
                    } else {
                        return "N/A"
                    }
                }
            },

            {
                title: 'K = 5',
                field: 'k_5',
                sortable: true,
                formatter: function (data, type, row) {
                    if (data === "1"||data === "1.0") {
                        return 'Cluster 1';
                    } else if (data === "2"||data === "2.0") {
                        return "Cluster 2"
                    } else if (data === "3"||data === "3.0") {
                        return "Cluster 3"
                    } else if (data === "4"||data === "4.0") {
                        return "Cluster 4"
                    } else if (data === "5"||data === "5.0") {
                        return "Cluster 5"
                    } else {
                        return "N/A"
                    }
                }
            },

            {
                title: 'K = 6',
                field: 'k_6',
                sortable: true,
                formatter: function (data, type, row) {
                    if (data === "1"||data === "1.0") {
                        return 'Cluster 1';
                    } else if (data === "2"||data === "2.0") {
                        return "Cluster 2"
                    } else if (data === "3"||data === "3.0") {
                        return "Cluster 3"
                    } else if (data === "4"||data === "4.0") {
                        return "Cluster 4"
                    } else if (data === "5"||data === "5.0") {
                        return "Cluster 5"
                    } else if (data === "6"||data === "6.0") {
                        return "Cluster 6"
                    } else {
                        return "N/A"
                    }
                }
            },

            {
                title: 'K = 7',
                field: 'k_7',
                sortable: true,
                formatter: function (data, type, row) {
                    if (data === "1"||data === "1.0") {
                        return 'Cluster 1';
                    } else if (data === "2"||data === "2.0") {
                        return "Cluster 2"
                    } else if (data === "3"||data === "3.0") {
                        return "Cluster 3"
                    } else if (data === "4"||data === "4.0") {
                        return "Cluster 4"
                    } else if (data === "5"||data === "5.0") {
                        return "Cluster 5"
                    } else if (data === "6"||data === "6.0") {
                        return "Cluster 6"
                    } else if (data === "7"||data === "7.0") {
                        return "Cluster 7"
                    } else {
                        return "N/A"
                    }
                }
            },

            {
                title: 'K = 8',
                field: 'k_8',
                sortable: true,
                formatter: function (data, type, row) {
                    if (data === "1"||data === "1.0") {
                        return 'Cluster 1';
                    } else if (data === "2"||data === "2.0") {
                        return "Cluster 2"
                    } else if (data === "3"||data === "3.0") {
                        return "Cluster 3"
                    } else if (data === "4"||data === "4.0") {
                        return "Cluster 4"
                    } else if (data === "5"||data === "5.0") {
                        return "Cluster 5"
                    } else if (data === "6"||data === "6.0") {
                        return "Cluster 6"
                    } else if (data === "7"||data === "7.0") {
                        return "Cluster 7"
                    } else if (data === "8"||data === "8.0") {
                        return "Cluster 8"
                    } else {
                        return "N/A"
                    }
                }
            },

            {
                title: 'Chart',
                field: 'ls_amplitude',
                align: "center",
                formatter: function (value, row, index) {
                    return "<a name='view_expression'  data-id='" + row.geneid + "'><span class=\"glyphicon glyphicon-plus\"></span></a>";
                }
            },
        ]
    });
});

var url1 = "/lncexpdb/pattern/differentiation";
var current_url = url1;
hkts_table(url1)

$('#tissuename').select2({
    ajax: {
        url: "/lncexpdb/pattern/differentiation/tissuename",
        dataType: 'json'
    }
});

if ($('#chkBrowse').is(":checked")) {
    $('#tissuename').attr("disabled", true);
    $('#tau1').attr("disabled", true);
    $('#tau2').attr("disabled", true);
    $('#cv1').attr("disabled", true);
    $('#cv2').attr("disabled", true);
    $('#minBreadth').attr("disabled", true);
    $('#maxBreadth').attr("disabled", true);
    $('#tsr').show();
    $('#hkr').show();
    $('#dy').show();

}else if($('#chkTissue').is(":checked")){
    $('#tissuename').attr("disabled", false);
    $('#tau1').attr("disabled", true);
    $('#tau2').attr("disabled", true);
    $('#cv1').attr("disabled", true);
    $('#cv2').attr("disabled", true);
    $('#minBreadth').attr("disabled", true);
    $('#maxBreadth').attr("disabled", true);
    $('#tsr').hide();
    $('#hkr').hide();
    $('#dy').hide();
}else if($('#chkDiy').is(":checked")){
    $('#tissuename').attr("disabled", true);
    $('#tau1').attr("disabled", false);
    $('#tau2').attr("disabled", false);
    $('#cv1').attr("disabled", false);
    $('#cv2').attr("disabled", false);
    $('#minBreadth').attr("disabled", false);
    $('#maxBreadth').attr("disabled", false);
    $('#tsr').hide();
    $('#hkr').hide();
    $('#dy').hide();
}

$('#chkBrowse').on('click', function (e) {
    $('#tissuename').attr("disabled", true);
    $('#tau1').attr("disabled", true);
    $('#tau2').attr("disabled", true);
    $('#cv1').attr("disabled", true);
    $('#cv2').attr("disabled", true);
    $('#minBreadth').attr("disabled", true);
    $('#maxBreadth').attr("disabled", true);
    $('#tsr').show();
    $('#hkr').show();
    $('#dy').show();

});

$('#chkTissue').on('click', function (e) {
    $('#tissuename').attr("disabled", false);
    $('#tau1').attr("disabled", true);
    $('#tau2').attr("disabled", true);
    $('#cv1').attr("disabled", true);
    $('#cv2').attr("disabled", true);
    $('#minBreadth').attr("disabled", true);
    $('#maxBreadth').attr("disabled", true);
    $('#tsr').hide();
    $('#hkr').hide();
    $('#dy').hide();

});

$('#chkDiy').on('click', function (e) {
    $('#tissuename').attr("disabled", true);
    $('#tau1').attr("disabled", false);
    $('#tau2').attr("disabled", false);
    $('#cv1').attr("disabled", false);
    $('#cv2').attr("disabled", false);
    $('#minBreadth').attr("disabled", false);
    $('#maxBreadth').attr("disabled", false);
    $('#tsr').hide();
    $('#hkr').hide();
    $('#dy').hide();

});

$('#tissuename').change(function () {
    var tissue = $('#tissuename').val();
    var tissue_url = '/lncexpdb/pattern/differentiation' + "?" + "maxname=" + '"' + tissue + '"' + '&tau1=0.9&tau2=1&maxvalue=10';
    current_url = tissue_url;
    hkts_table(tissue_url);
});

$('#hkr').on("click",function () {
    var type = $('#type').val();
    $('#tissuename').empty();
    hk_url = '/lncexpdb/pattern/differentiation?tau1=0&tau2=0.35&maxvalue=10'
    current_url = hk_url;
    hkts_table(hk_url)
});


$('#tsr').click(function () {
    var type = $('#type').val();
    $('#tissuename').empty();
    ts_url = '/lncexpdb/pattern/differentiation?tau1=0.9&tau2=1&maxvalue=10'
    current_url = ts_url;
    hkts_table(ts_url)
});

$('#dy').on("click",function () {
    var type = $('#type').val();
    $('#tissuename').empty();
    dy_url = '/lncexpdb/pattern/' + type + '?' + 'r_squared=0.7&p_value=0.05'
    current_url = dy_url;
    hkts_table(dy_url)
});

$('#tau').on('click', function () {
    $('#tissuename').attr("disabled",true);
    var $btn = $(this).button("loading");
    $('#tissuename').empty();
    var tau1 = $('input[name="tau1"]').val();
    var tau2 = $('input[name="tau2"]').val();
    var minBreadth = $('input[name="minBreadth"]').val();
    var maxBreadth = $('input[name="maxBreadth"]').val();
    var cv1 = $('input[name="cv1"]').val();
    var cv2 = $('input[name="cv2"]').val();
    var url = '/lncexpdb/pattern/differentiation' + "?tau1="+ tau1 + '&tau2=' + tau2 + '&minbreadth=' + minBreadth + '&maxbreadth=' + maxBreadth + '&cv1=' + cv1 + '&cv2=' + cv2;
    current_url = url;
    hkts_table(url);
    $btn.button("reset")
});

$("#reset").on('click', function () {

    $('input[name="tau1"]').val(0);
    $('input[name="tau2"]').val(1);
    $('input[name="cv1"]').val(0);
    $('input[name="cv2"]').val(3);
    $('input[name="minBreadth"]').val(0);
    $('input[name="maxBreadth"]').val(16);
    var url = "/lncexpdb/pattern/differentiation";
    current_url = url;
    hkts_table(url);
    var url_tissue = "/lncexpdb/pattern/differentiation/tissuename";
    $('#tissuename').select2({
        ajax: {
            url: url_tissue,
            dataType: 'json'
        }
    });
});

$("#download").on("click",function () {
    $("#download").button("loading");
    var element = document.createElement('a');
    var file_name = "LncExpDB_" + current_url.split("/lncexpdb/pattern")[1] + ".csv"
    console.log(current_url.split("/lncexpdb/pattern")[1]);
    // var download_url = "/lncexpdb/download" + current_url.split("/lncexpdb/hkts")[1];
    // var fileName = "ddd.csv";
    // var form = $("<form></form>").attr("action",download_url).attr("method","post");
    // form.append($("<input></input>").attr("type","hidden").attr("name","fileName").attr("value",fileName));
    // form.appendTo("body").submit().remove();
    $.ajax(
        {
            url: "/lncexpdb/download" + current_url.split("/lncexpdb/pattern")[1],
            type: "POST",
            dataType: "text",
            success: function (d) {
                element.setAttribute('href', 'data:text/csv;charset=utf-8,' + encodeURIComponent(d));
                element.setAttribute('download',file_name);
                element.style.display = 'none';
                document.body.appendChild(element);
                element.click();
                document.body.removeChild(element);
                $("#download").button("reset");
            }
        }
    )
})

var ce_table = (function (url) {
    $('#ce_table').bootstrapTable('destroy');
    $('#ce_table').bootstrapTable({
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
        formatLoadingMessage: function () {
            return "<h4>Please wait...</h4>";
        },
        queryParams: function queryParams(params) {
            var param ={
                page: params.pageNumber-1,
                size: params.pageSize,
                sortName: params.sortName,      //排序列名
                sortOrder: params.sortOrder     //排序
            };
            return param;
        },
        columns: [
            {
                title: 'LncRNA ID',
                field: 'geneid',
                align: "center",
                formatter: function(value,row,index){
                    return "<a href='https://bigd.big.ac.cn/lncexpdb/gene?geneid=" + value + "'target='_blank'>" + value + "</a>"
                },
                // sortable: true

            },
            {
                title: 'LncRNA Symbol',
                field: 'lncname',
                align: "center",
                // sortable: true
            },

            {
                title: 'LncRNA Location',
                field: 'lnclocation',
                align: "center",
                // sortable: true
            },

            {
                title: '<a title="PCG: Protein-Coding Gene">'+'PCG ID'+ ' <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'pcg',
                align: "center",
            },
            {
                title: 'PCG Symbol',
                field: 'pcgname',
                align: "center",
                formatter: function(value,row,index){
                    return "<a href='https://www.genecards.org/cgi-bin/carddisp.pl?gene=" + value + "'target='_blank'>" + value + "</a>"
                },
                // sortable: true,
            },
            {
                title: 'PCG Location',
                field: 'pcglocation',
                align: "center",
                // sortable: true,
            },
            {
                title: '<a title="Pearson Correlation Coefficient">'+'R'+'' + ' <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'pcc',
                align: "center",
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                },
            },
            {
                title: 'P value',
                field: 'pvalue',
                align: "center",
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                },
            },

            {
                title: '<a title="Trans indicates that lncRNA and PCG are located in different chromosomes.">Distance <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'distance',
                align: "center",
                formatter: function(value,row,index){
                    if (value==-1) {
                        return "<i>Trans</i>"
                    } else {
                        return value;
                    }
                },
            },
        ]
    });
});

var url1 = "/lncexpdb/ce/differentiation";
ce_table(url1)

if ($('#ce_chkBrowse').is(":checked")) {
    $('#ce_tissuename').attr("disabled", true);
    $('#ce_tau1').attr("disabled", true);
    $('#ce_tau2').attr("disabled", true);
    $('#ce_cv1').attr("disabled", true);
    $('#ce_cv2').attr("disabled", true);
    $('#ce_minBreadth').attr("disabled", true);
    $('#ce_maxBreadth').attr("disabled", true);
    $('#ce_tsr').show();
    $('#ce_hkr').show();
    // $('#ce_tau').hide();
    // $('#ce_reset').hide()
}else if($('#ce_chkTissue').is(":checked")){
    $('#ce_tissuename').attr("disabled", false);
    $('#ce_tau1').attr("disabled", true);
    $('#ce_tau2').attr("disabled", true);
    $('#ce_cv1').attr("disabled", true);
    $('#ce_cv2').attr("disabled", true);
    $('#ce_minBreadth').attr("disabled", true);
    $('#ce_maxBreadth').attr("disabled", true);
    $('#ce_tsr').hide();
    $('#ce_hkr').hide();
    // $('#ce_tau').hide();
    // $('#ce_reset').hide()
}else if($('#ce_chkDiy').is(":checked")){
    $('#ce_tissuename').attr("disabled", true);
    $('#ce_tau1').attr("disabled", false);
    $('#ce_tau2').attr("disabled", false);
    $('#ce_cv1').attr("disabled", false);
    $('#ce_cv2').attr("disabled", false);
    $('#ce_minBreadth').attr("disabled", false);
    $('#ce_maxBreadth').attr("disabled", false);
    $('#ce_tsr').hide();
    $('#ce_hkr').hide();
    // $('#ce_tau').show();
    // $('#ce_reset').show()
}

$('#ce_chkBrowse').on('click', function (e) {
    $('#ce_tissuename').attr("disabled", true);
    $('#ce_tau1').attr("disabled", true);
    $('#ce_tau2').attr("disabled", true);
    $('#ce_cv1').attr("disabled", true);
    $('#ce_cv2').attr("disabled", true);
    $('#ce_minBreadth').attr("disabled", true);
    $('#ce_maxBreadth').attr("disabled", true);
    $('#ce_tsr').show();
    $('#ce_hkr').show();
    $("#featurelnc").empty();
    $('#featurelnc_cancel').hide();
    // $('#ce_tau').hide();
    // $('#ce_reset').hide()
});

$('#ce_chkTissue').on('click', function (e) {
    $('#ce_tissuename').attr("disabled", false);
    $('#ce_tau1').attr("disabled", true);
    $('#ce_tau2').attr("disabled", true);
    $('#ce_cv1').attr("disabled", true);
    $('#ce_cv2').attr("disabled", true);
    $('#ce_minBreadth').attr("disabled", true);
    $('#ce_maxBreadth').attr("disabled", true);
    $('#ce_tsr').hide();
    $('#ce_hkr').hide();
    $("#featurelnc").empty();
    $('#featurelnc_cancel').hide();
    // $('#ce_tau').hide();
    // $('#ce_reset').hide()
});

$('#ce_chkDiy').on('click', function (e) {
    $('#ce_tissuename').attr("disabled", true);
    $('#ce_tau1').attr("disabled", false);
    $('#ce_tau2').attr("disabled", false);
    $('#ce_cv1').attr("disabled", false);
    $('#ce_cv2').attr("disabled", false);
    $('#ce_minBreadth').attr("disabled", false);
    $('#ce_maxBreadth').attr("disabled", false);
    $('#ce_tsr').hide();
    $('#ce_hkr').hide();
    $("#featurelnc").empty();
    $('#featurelnc_cancel').hide();
    // $('#ce_tau').show();
    // $('#ce_reset').show();
});

$('#ce_chkTissue').on("click", function () {
    var url_tissue = "/lncexpdb/hkts/differentiation/tissuename";
    console.log(url_tissue)
    $('#ce_tissuename').select2({
        ajax: {
            url: url_tissue,
            dataType: 'json'
        }
    });
});

$('#ce_hkr').on("click",function () {
    var type = $('#ce_type').val();
    $('#ce_tissuename').empty();
    $("#ce_table").bootstrapTable('refreshOptions', {url:'/lncexpdb/ce/differentiationdistance?start=-2&end=-0.1',  silent: true, pageNumber: 1, pageSize: 10});
});

$('#ce_tsr').click(function () {
    var type = $('#ce_type').val();
    $('#ce_tissuename').empty();
    $("#ce_table").bootstrapTable('refreshOptions', {url:'/lncexpdb/ce/differentiationdistance?start=0',  silent: true, pageNumber: 1, pageSize: 10});
});

$('#ce_tau').on('click', function () {
    $('#ce_tissuename').attr("disabled",true);
    var $btn = $(this).button("loading");
    var type = $('#ce_type').val();
    $('#ce_tissuename').empty();
    var pvalue = $('input[name="ce_tau2"]').val();
    var pcc = $('input[name="ce_minBreadth"]').val();
    var mindis = $('input[name="ce_cv1"]').val();
    var maxdis = $('input[name="ce_cv2"]').val();
    var url = '/lncexpdb/ce/differentiationfilter?pvalue_start=0&pvalue_end=' + pvalue + '&pcc_start=' + pcc + '&pcc_end=1' + '&distance_start=' + mindis + '&distance_end=' + maxdis;
    ce_table(url);
    $btn.button("reset")
});

$("#ce_reset").on('click', function () {

    $('input[name="ce_tau1"]').val(0);
    $('input[name="ce_tau2"]').val(1);
    $('input[name="ce_cv1"]').val(0);
    $('input[name="ce_cv2"]').val(1);
    $('input[name="ce_minBreadth"]').val(0);
    $('input[name="ce_maxBreadth"]').val(1000);
    $("#featurelnc").empty();
    $('#featurelnc_cancel').hide();
    var url = "/lncexpdb/ce/differentiation";
    ce_table(url);
});


// Interaction Select2
var url1 = "/lncexpdb/ce/differentiationlncid";

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
    var type = $('#ce_type').val();
    console.log(type)
    if ($('#feature_sect1').val() == "lncid") {
        url1 = "/lncexpdb/ce/differentiationlncid";
        $('#featurelnc').attr('data-placeholder', 'eg. HSALNG000002');
    } else if ($('#feature_sect1').val() == "lncname") {
        url1 = "/lncexpdb/ce/differentiationlncname";
        $('#featurelnc').attr('data-placeholder', 'eg. MALAT1');
    } else if ($('#feature_sect1').val() == "pcgid") {
        url1 = "/lncexpdb/ce/differentiationpcgid";
        $('#featurelnc').attr('data-placeholder', 'eg. ENSG00000152078.10');
    } else if ($('#feature_sect1').val() == "pcgname") {
        url1 = "/lncexpdb/ce/differentiationpcgname";
        $('#featurelnc').attr('data-placeholder', 'eg. TLCD4');
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
    var url = '/lncexpdb/ce/differentiation';
    ce_table(url)
}

$('.feature').change(function () {
    var dis = $('.feature').val();
    var v2 = $(".filter").val();
    var url = '/lncexpdb/ce/differentiationby' + v2 + '?term=' + dis;
    console.log(url)
    ce_table(url);
    if($(this).val() != null && $(this).val()!=""){
        $('#featurelnc_cancel').show();
    }else{
        $('#featurelnc_cancel').hide();
    }
    $("#featurelnc_cancel").on("click",function () {
        var url = '/lncexpdb/ce/differentiation';
        ce_table(url);
        $("#featurelnc").empty();
        $('#featurelnc_cancel').hide();
    });

    var val = $('.feature').val();
    if(val=="" || val==null){
        var url = '/lncexpdb/ce/differentiation';
        ce_table(url)
    }
});

// Featured Select2
var url1 = "/lncexpdb/pattern/differentiation/geneidlist";

$('#featurelnc2').select2({
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

$('#feature_sect2').change(function () {
    var type = $('#type').val();

    if ($('#feature_sect2').val() == "geneid") {
        url1 = "/lncexpdb/pattern/differentiation" + "/geneidlist";
        $('#featurelnc2').attr('data-placeholder', 'eg. HSALNG000002');
    } else if ($('#feature_sect2').val() == "symbol") {
        url1 = "/lncexpdb/pattern/differentiation" + "/symbollist";
        $('#featurelnc2').attr('data-placeholder', 'eg. MALAT1');
    }
    $('#featurelnc2').select2({
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


var list = document.getElementById("featurelnc2");
if(list.options[0].value==""){
    var url = '/lncexpdb/pattern/differentiation';
    hkts_table(url)
}

$('.feature2').change(function () {
    var dis = $('.feature2').val();
    var v2 = $(".filter2").val();
    var url = '/lncexpdb/pattern/differentiation' + "?" + v2 + '=' + "'" + dis + "'";

    hkts_table(url);
    if($(this).val() != null && $(this).val()!=""){
        $('#featurelnc_cancel2').show();
    }else{
        $('#featurelnc_cancel2').hide();
    }

    $("#featurelnc_cancel2").on("click",function () {
        var url = '/lncexpdb/pattern/differentiation';
        hkts_table(url);
        $("#featurelnc2").empty();
        $('#featurelnc_cancel2').hide();
    });

    var val = $('.feature2').val();
    if(val=="" || val==null){
        var url = '/lncexpdb/pattern/differentiation';
        hkts_table(url)
    }
});

