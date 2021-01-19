$('#select_cancer').select2({
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

$('#select_country').select2({
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

$("#search").on("click",function () {

    var country = $("#select_country").val();
    var cancer = $("#select_cancer").val();
    $(location).attr('href', '/lncexpdb/cancermap?country=' + country + '&cancer=' + cancer);
})