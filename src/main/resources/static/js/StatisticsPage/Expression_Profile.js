option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    tooltip: {},
    title: {
        left: 'left',
        text: 'Expression Profiles of LncRNA Genes',
        textStyle:{
            fontSize:18,
            fontWeight:'bold',
        }
    },
    legend: {
        x: '75%',
        y: 'top',
        textStyle:{
            fontSize:14,
            fontWeith:'bold',
        },
        data: ['LncRNA', 'Protein Coding']
    },
    grid:{
        bottom :30,
        left: 30,
        right: 30,
        containLabel: true,
    },
    toolbox: {
        show: true,
        feature: {
            saveAsImage: {
                show:true,
                pixelRatio: 8,
                title: "Save"
            }
        }
    },
    xAxis: {
        type: 'category',
        nameLocation: "center",
        axisLabel: {
            interval: 0,
            rotate: 30,
            textStyle: {
                fontSize:14.5,
                fontWeight:'bold',
            }
        },
        nameGap: 35,
        boundaryGap: [0, 0.01],
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold'
        },
        data: ["Normal Tissue/Cell Line","Organ Development","Preimplantation Embryo", "Cell Differentiation","Subcellular Localization","Exosome","Cancer Cell Line","Circadian Rhythm","Virus Infection"]
    },
    yAxis: {
        type: 'value',
        axisLabel: {
            interval: 0,
            textStyle: {
                fontWeight:"bold",
                fontSize:14.5,
            }
        },
        name: 'Gene Number',
        nameLocation: "center",
        nameGap: 50,
        splitLine:{show: true},
        boundaryGap: [0, 0.01],
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold'
        },
        padding: [0,0,50,0],
    },
    series: [{
        name: "LncRNA",
        data: [63845,47710,34789,17675,19606,83438,35279,9157,21162],
        type: 'bar',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(220, 220, 220, 0.8)'
        },
        barWidth: 35,
    },
    {
        name: "Protein Coding",
        data: [18544,18085,15650,15194,13708,18534,16893,12064,14335],
        type: 'bar',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(220, 220, 220, 0.8)'
        },
        barWidth: 35,
    },
    ]
};
var profile = echarts.init(document.getElementById('profile'));
profile.setOption(option);

window.addEventListener("resize",function(){
    profile.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    profile.resize();
});
