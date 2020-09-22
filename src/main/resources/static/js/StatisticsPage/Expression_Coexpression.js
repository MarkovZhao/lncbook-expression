option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    tooltip: {},
    title: {
        left: 'left',
        text: 'Coexpression Between LncRNA and Protein-coding Genes',
        textStyle:{
            fontSize:18,
            fontWeight:'bold',
        }
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
        name: "Number of contexts",
        nameGap: 30,
        nameLocation: "center",
        axisLabel: {
            interval: 0,
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
        data: ["1","2","3","4","5",">=6"]
    },
    yAxis: {
        type: 'value',
        name: 'Log10(1+interactions)',
        axisLabel: {
            interval: 0,
            textStyle: {
                fontWeight:"bold",
                fontSize:14.5,
            }
        },
        nameLocation: "center",
        nameGap: 30,
        splitLine:{show: true},
        boundaryGap: [0, 0.01],
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold',
            padding: [0,0,0,0],
        },
    },
    series: [{
        name: "LncRNA",
        data: [7.438,6,4.303,2.842,1.114,0],
        type: 'bar',
        showBackground: true,
        barWidth: 45,
        backgroundStyle: {
            color: 'rgba(220, 220, 220, 0.8)'
        },
    },
    ]
};
var coexpression = echarts.init(document.getElementById('coexpression'));
coexpression.setOption(option);

window.addEventListener("resize",function(){
    coexpression.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    coexpression.resize();
});
