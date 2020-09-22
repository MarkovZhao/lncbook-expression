option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    title: {
        text: 'Overview of Featured Genes',
        left: 'left',
        textStyle:{
            fontSize:18,
            fontWeight:'bold',
        },
        margin: 40,
    },
    grid: {
        left: '70%',
        top: "30%",
    },
    tooltip: {
        show: false,
    },
    radar: {
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
            { name: 'Organ Development', max: 8000},
            { name: 'Preimplantaion Embryo', max: 8000},
            { name: 'Cell Differentiation', max: 8000},
            { name: 'Subcellular Localization', max: 8000},
            { name: 'Exosome', max: 8000},
            { name: 'Cancer Cell Line', max: 8000},
            { name: 'Virus Infection', max: 8000},
            { name: 'Circadian Rhythm', max:8000},
        ],
        axisLabel: {           // 坐标轴文本标签，详见axis.axisLabel
            show: false,
            textStyle: {
                color: '#247bd7' // 坐标轴刻度文字的样式
            }
        },
    },
    series: [{
        type: 'radar',
        label: {
            textStyle:{
                fontSize:14.5,
                fontWeight:"bold",
            }
        },
        // areaStyle: {normal: {}},
        data: [
            {
                value: [7498, 7922, 4343, 1232, 5292, 1538, 2907,985, 1740],
                name: 'LncRNA',
            },

            // {
            //     value: [6030, 12503, 3667, 6939, 2928, 913,3793,3804,5578],
            //     name: 'Protein Coding'
            // }

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