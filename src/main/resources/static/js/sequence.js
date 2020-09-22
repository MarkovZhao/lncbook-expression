$(function () {
    $('#collapse_toggle').collapse('hide'
    );
});

//转录本序列信息
$(function () {
    var transid = window.location.href.split("=")[1];
    $.ajax({
        url: '/lncbook/trans/transcriptSeq?transid=' + transid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#seq1").html('加载中...');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var trans_seq = data["sequence0"][0].seq.toUpperCase();
        var seq_name = transid;
        $("#seq1").html('>' + seq_name +"<br>"+ trans_seq);
    }
});

