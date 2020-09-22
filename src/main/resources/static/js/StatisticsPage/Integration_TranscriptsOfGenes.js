option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    tooltip: {

    },
    title: {
        left: 'left',
        text: 'Transcript Number of Genes',
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
        name: 'Transcript Number of Genes',
        nameLocation: "center",
        nameGap: 30,
        axisLabel: {
            interval: 0,
            textStyle: {
                fontSize:14.5,
                fontWeight:'bold',
            }
        },
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold'
        },
        data: [1, 2, 3, 4, 5, 6, 7, 8, ">8"]
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
        name: 'Percentage of Genes',
        nameLocation: "center",
        nameGap: 35,
        splitLine:{show: true},
        boundaryGap: [0, 0.01],
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold'
        },
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b}: {c}%'
    },
    series: [{
        name: "LncRNA",
        data: [64.818, 12.283, 5.505, 3.366, 2.210, 1.678, 1.328, 1.031, 7.781],
        type: 'bar',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(220, 220, 220, 0.8)'
        }
    },
        {
            name: "Protein Coding",
            data: [13.618, 10.161, 8.971, 7.948, 7.612, 6.663, 6.167, 5.148, 33.713],
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
                color: 'rgba(220, 220, 220, 0.8)'
            }
        },
    ]
};
var myChart1 = echarts.init(document.getElementById('transcripts_of_gene'));
myChart1.setOption(option);

window.addEventListener("resize",function(){
    myChart1.resize();
});