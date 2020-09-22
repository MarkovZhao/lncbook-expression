option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    title: {
        text: 'Overview of Featured Genes',
        left: 'left',
        textStyle:{
            fontSize:16,
        }
    },
    grid: [{
        left: 300,
        bottom: '10%',
        top: 20,
        right: '10%'
    }],
    tooltip: {},
    radar: {
        // shape: 'circle',
        name: {
            textStyle: {
                color: '#fff',
                backgroundColor: '#999',
                borderRadius: 10,
                padding: [3, 5]
            }
        },
        center:['60%','55%'],
        indicator: [
            { name: 'Normal Tissue/Cell Line', max: 8000},
            { name: 'Organ Development', max: 15000},
            { name: 'Preimplantaion Embryo', max: 8000},
            { name: 'Cell Differentiation', max: 8000},
            { name: 'Subcellular Localization', max: 8000},
            { name: 'Exosome', max: 8000},
            { name: 'Cancer Cell Line', max: 8000},
            { name: 'Virus Infection', max: 8000},
            { name: 'Circadian Rhythm', max:8000},
        ]
    },
    series: [{
        type: 'radar',
        // areaStyle: {normal: {}},
        data: [
            {
                value: [7498, 7922, 4343, 1232, 5292, 1538, 2907,985, 1740],
                name: 'LncRNA',
            },

            {
                value: [6030, 12740, 3667, 6939, 3793, 2927,3804,913,5577],
                name: 'Protein Coding',
            }

        ]
    }]
};

var radar = echarts.init(document.getElementById('radar'));
radar.setOption(option);

window.addEventListener("resize",function(){
    radar.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    radar.resize();
});