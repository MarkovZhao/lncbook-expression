//HPA Table
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/LncExpDB/hkts/hpa?geneid=' + '\'' + geneid + '\'',
        type: 'POST',
        dataType: 'json',
        cache: false,
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });

    function erryFunction() {
        alert("error");
    }

    function succFunction(data) {
        data = data["geneInfo"];
        var ccle_info = [];
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['tau'] = data[i].tau;
            gene_arry['max_name'] = data[i].max_name;
            gene_arry['max_value'] = data[i].max_value;
            gene_arry['min_name'] = data[i].min_name;
            gene_arry['min_value'] = data[i].min_value;
            gene_arry['avg'] = data[i].avg;
            gene_arry['median'] = data[i].median;
            gene_arry['cv'] = data[i].cv;
            gene_arry['brand'] = data[i].brand;
            ccle_info.push(gene_arry)
        }

        $('#hpa_table').DataTable({
            searching: false,
            lengthChange: false,
            paging: false,
            info: false,
            ordering:false,
            scrollX:false,
            AutoWidth:false,
            data: ccle_info,
            columns: [
                {data: "geneid"},
                {data: 'tau',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'max_name'},
                {data: 'max_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'min_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'median',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'avg',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'cv',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'brand'},
            ]
        });
    }
});

//ENCODE Primary Cell Line Table
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/LncExpDB/hkts/encode?geneid=' + '\'' + geneid + '\'',
        type: 'POST',
        dataType: 'json',
        cache: false,
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });

    function erryFunction() {
        alert("error");
    }

    function succFunction(data) {
        data = data["geneInfo"];
        var ccle_info = [];
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['tau'] = data[i].tau;
            gene_arry['max_name'] = data[i].max_name;
            gene_arry['max_value'] = data[i].max_value;
            gene_arry['min_name'] = data[i].min_name;
            gene_arry['min_value'] = data[i].min_value;
            gene_arry['avg'] = data[i].avg;
            gene_arry['median'] = data[i].median;
            gene_arry['cv'] = data[i].cv;
            gene_arry['brand'] = data[i].brand;
            ccle_info.push(gene_arry)
        }

        $('#encode_table').DataTable({
            searching: false,
            lengthChange: false,
            paging: false,
            info: false,
            ordering:false,
            scrollX:false,
            AutoWidth:false,
            data: ccle_info,
            columns: [
                {data: "geneid"},
                {data: 'tau',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'max_name'},
                {data: 'max_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'min_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'median',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'avg',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'cv',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'brand'},
            ]
        });
    }
});

//CCLE Table
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/LncExpDB/hkts/ccle?geneid=' + '\'' + geneid + '\'',
        type: 'POST',
        dataType: 'json',
        cache: false,
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });

    function erryFunction() {
        alert("error");
    }

    function succFunction(data) {
        data = data["geneInfo"];
        var ccle_info = [];
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['tau'] = data[i].tau;
            gene_arry['max_name'] = data[i].max_name;
            gene_arry['max_value'] = data[i].max_value;
            gene_arry['min_name'] = data[i].min_name;
            gene_arry['min_value'] = data[i].min_value;
            gene_arry['avg'] = data[i].avg;
            gene_arry['median'] = data[i].median;
            gene_arry['cv'] = data[i].cv;
            gene_arry['brand'] = data[i].brand;
            ccle_info.push(gene_arry)
        }

        $('#ccle_table').DataTable({
            searching: false,
            lengthChange: false,
            paging: false,
            info: false,
            ordering:false,
            scrollX:false,
            AutoWidth:false,
            data: ccle_info,
            columns: [
                {data: "geneid"},
                {data: 'tau',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'max_name'},
                {data: 'max_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'min_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'median',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'avg',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'cv',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'brand'},
            ]
        });
    }
});

//Development Table
var development_table = (function (tissue) {
    var geneid = window.location.href.split("=")[1].split("#")[0];

    $.ajax({
        url: '/LncExpDB/pattern/' +  tissue + '?geneid=' + '\'' + geneid + '\'',
        type: 'POST',
        dataType: 'json',
        cache: false,
        success: succFunction //成功执行方法
    });

    function succFunction(data) {
        var ccle_info = [];
        var data = data['geneInfo'];
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['tau'] = data[i].tau;
            gene_arry['max_name'] = data[i].max_name;
            gene_arry['max_value'] = data[i].max_value;
            gene_arry['min_name'] = data[i].min_name;
            gene_arry['min_value'] = data[i].min_value;
            gene_arry['avg'] = data[i].avg;
            gene_arry['median'] = data[i].median;
            gene_arry['cv'] = data[i].cv;
            gene_arry['brand'] = data[i].brand;
            ccle_info.push(gene_arry)
        }

        $('#development_hkts_table').DataTable({
            searching: false,
            lengthChange: false,
            paging: false,
            info: false,
            ordering:false,
            scrollX:false,
            destroy: true,
            AutoWidth:false,
            data: ccle_info,
            columns: [
                {data: "geneid"},
                {data: 'tau',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'max_name'},
                {data: 'max_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'min_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'median',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'avg',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'cv',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'brand'},
            ]
        });
    }
});

development_table("brain")
$("#development").on("change",function () {
    var tissue = $(this).val();
    development_table(tissue)
})

//Cell Differentiation Table
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/LncExpDB/pattern/differentiation?geneid=' + '\'' + geneid + '\'',
        type: 'POST',
        dataType: 'json',
        cache: false,
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });

    function erryFunction() {
        alert("error");
    }

    function succFunction(data) {
        var ccle_info = [];
        var data = data['geneInfo'];
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['tau'] = data[i].tau;
            gene_arry['max_name'] = data[i].max_name;
            gene_arry['max_value'] = data[i].max_value;
            gene_arry['min_name'] = data[i].min_name;
            gene_arry['min_value'] = data[i].min_value;
            gene_arry['avg'] = data[i].avg;
            gene_arry['median'] = data[i].median;
            gene_arry['cv'] = data[i].cv;
            gene_arry['brand'] = data[i].brand;
            ccle_info.push(gene_arry)
        }

        $('#differentiation_hkts_table').DataTable({
            searching: false,
            lengthChange: false,
            paging: false,
            info: false,
            ordering:false,
            scrollX:false,
            AutoWidth:false,
            data: ccle_info,
            columns: [
                {data: "geneid"},
                {data: 'tau',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'max_name'},
                {data: 'max_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'min_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'median',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'avg',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'cv',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'brand'},
            ]
        });
    }
});


//Development Table
var preimplantation_hkts_table = (function (tissue) {
    var geneid = window.location.href.split("=")[1].split("#")[0];

    $.ajax({
        url: '/LncExpDB/pattern/' +  tissue + '?geneid=' + '\'' + geneid + '\'',
        type: 'POST',
        dataType: 'json',
        cache: false,
        success: succFunction //成功执行方法
    });

    function succFunction(data) {
        var ccle_info = [];
        var data = data['geneInfo'];
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['tau'] = data[i].tau;
            gene_arry['max_name'] = data[i].max_name;
            gene_arry['max_value'] = data[i].max_value;
            gene_arry['min_name'] = data[i].min_name;
            gene_arry['min_value'] = data[i].min_value;
            gene_arry['avg'] = data[i].avg;
            gene_arry['median'] = data[i].median;
            gene_arry['cv'] = data[i].cv;
            gene_arry['brand'] = data[i].brand;
            ccle_info.push(gene_arry)
        }

        $('#preimplantation_hkts_table').DataTable({
            searching: false,
            lengthChange: false,
            paging: false,
            info: false,
            ordering:false,
            scrollX:false,
            destroy: true,
            AutoWidth:false,
            data: ccle_info,
            columns: [
                {data: "geneid"},
                {data: 'tau',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'max_name'},
                {data: 'max_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'min_value',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'median',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'avg',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'cv',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'brand'},
            ]
        });
    }
});

preimplantation_hkts_table("preimplantation1")
$("#preimplantation").on("change",function () {
    var tissue = $(this).val();
    console.log(tissue)
    preimplantation_hkts_table(tissue)
})