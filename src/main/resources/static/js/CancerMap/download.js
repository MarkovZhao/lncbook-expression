$('#select_cancer1').select2({
    minimumInputLength: 1,
    ajax: {
        url: '/lncexpdb/cancermap/browse/cancerlist',
        data: function (params) {
            var query = {
                type: params.term
            };
            return query;
        },
        cache: false
    }
});

$('#select_country1').select2({
    minimumInputLength: 1,
    ajax: {
        url: '/lncexpdb/cancermap/browse/countrylist',
        data: function (params) {
            var query = {
                type: params.term
            };
            return query;
        },
        cache: false
    }
});

$('#download').on('click', function () {
    var $btn = $(this).button("loading");
    var cancer = $('#select_cancer1').val();
    var country = $("#select_country1").val();
    var new_number_min = $('input[name="new_number_min"]').val();
    var new_number_max = $('input[name="new_number_max"]').val();
    var death_number_min = $('input[name="death_number_min"]').val();
    var death_number_max = $('input[name="death_number_max"]').val();
    var prevalence_number_min = $('input[name="prevalence_number_min"]').val();
    var prevalence_number_max = $('input[name="prevalence_number_max"]').val();
    var url = '/lncexpdb/cancermap/browse/download' + "?country=\"" + country + "\"&cancer=\"" + cancer + "\"&new_number_min="+ new_number_min + '&new_number_max=' + new_number_max + '&death_number_min=' + death_number_min + '&death_number_max=' + death_number_max + '&prevalence_number_min=' + prevalence_number_min + '&prevalence_number_max=' + prevalence_number_max;
    current_url = url
    console.log(url)
    $("#download").button("loading");
    var element = document.createElement('a');
    var file_name = "CancerMap_" + current_url.split("/lncexpdb/cancermap/browse/download")[1] + ".csv"
    $.ajax(
        {
            url: current_url,
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
    $btn.button("reset")
});
