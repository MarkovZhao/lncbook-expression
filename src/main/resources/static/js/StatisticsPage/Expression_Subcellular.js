option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    tooltip: {},
    title: {
        left: 'left',
        text: 'Subcellular-Specific Genes in HEK293T Cell Line',
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
        nameGap: 30,
        axisLabel: {
            interval: 0,
            rotate: 30,
            textStyle: {
                fontSize:14.5,
                fontWeight:'bold',
            }
        },
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold',
            padding: [0,0,0,0],
        },
        data: ["Cytosol","Nucleus","Nuclear Pore","Nuclear Lamina","Nucleolus","Mitochondrial Matrix",
        "ER Lumen","Outer Mito. Membrane","ER Membrane"]
    },
    yAxis: {
        type: 'value',
        name: 'Gene Number',
        axisLabel: {
            interval: 0,
            textStyle: {
                fontWeight:"bold",
                fontSize:14.5,
            }
        },
        nameLocation: "center",
        nameGap: 45,
        splitLine:{show: true},
        boundaryGap: [0, 0.01],
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold'
        },
    },
    series: [{
        name: "LncRNA",
        data: [39,3836,14,2595,430,79,0,70,132],
        type: 'bar',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(220, 220, 220, 0.8)'
        }
    },
        {
            name: "Protein Coding",
            data: [197,1429,11,1349,427,156,0,678,1054],
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
                color: 'rgba(220, 220, 220, 0.8)'
            }
        },
    ]
};
var subcellular = echarts.init(document.getElementById('subcellular'));
subcellular.setOption(option);

window.addEventListener("resize",function(){
    subcellular.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    subcellular.resize();
});
