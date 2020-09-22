option = {
    textStyle: {
        fontFamily:"Arial Narrow",
        fontSize: 16,
    },
    tooltip: {},
    title: {
        left: 'left',
        text: 'Exon Number of Transcripts',
        textStyle:{
            fontSize:18,
            fontWeight:'bold',
        },
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
        axisLabel: {
            interval: 0,
            textStyle: {
                fontSize:14.5,
                fontWeight:'bold',
            }
        },
        name: 'Exon Number of Transcripts',
        nameLocation: "center",
        nameGap: 30,
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold',
            padding: [0,0,0,0],
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
        name: 'Percentage of Transcripts',
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
        data: [12.915, 34.711, 23.985, 13.096, 7.066, 3.655, 1.983, 1.094, 1.494],
        type: 'bar',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(220, 220, 220, 0.8)'
        }
    },
        {
            name: "Protein Coding",
            data: [1.554, 13.236, 13.862, 13.659, 11.77, 8.959, 6.174, 4.466, 26.321],
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
                color: 'rgba(220, 220, 220, 0.8)'
            }
        },
    ]
};
var myChart = echarts.init(document.getElementById('exons_of_transcript'));
myChart.setOption(option);

window.addEventListener("resize",function(){
    myChart.resize();
});