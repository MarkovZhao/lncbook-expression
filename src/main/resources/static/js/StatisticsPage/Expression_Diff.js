option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data: ['Protein-Upregulated', 'Protein-Downregulated', 'LncRNA-Downregulated', 'LncRNA-Upregulated'],
        textStyle:{
            fontSize:14,
            fontWeith:'bold',
        },
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        axisLabel: {
            interval: 0,
            textStyle: {
                fontSize:14.5,
                fontWeight:'bold',
            }
        },
        nameTextStyle: {
            fontSize: 18,
            fontWeight: 'bold',
            padding: [0,0,0,0],
        },
    },
    yAxis: {
        type: 'category',
        data: ['Colorectal', 'Coronary', 'Pancreatic', 'Hepatocellular', 'ESCC'],
        axisLabel: {
            interval: 0,
            textStyle: {
                fontWeight:"bold",
                fontSize:14.5,
            }
        },
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold'
        },
    },
    series: [
        {
            name: 'LncRNA-Upregulated',
            type: 'bar',
            stack: '总量',
            label: {
                show: false,
                position: 'insideRight'
            },
            data: [128, 159, 17, 135, 102]
        },
        {
            name: 'LncRNA-Downregulated',
            type: 'bar',
            stack: '总量',
            label: {
                show: false,
                position: 'insideRight'
            },
            data: [-2, -962, -34, -16, -179]
        },
        {
            name: 'Protein-Upregulated',
            type: 'bar',
            stack: '总量',
            label: {
                show: false,
                position: 'insideRight'
            },
            data: [41, 569, 244, 168, 57]
        },
        {
            name: 'Protein-Downregulated',
            type: 'bar',
            stack: '总量',
            label: {
                show: false,
                position: 'insideRight'
            },
            data: [-14, -1176, -19, -7, -930]
        },
    ]
};


var exosome = echarts.init(document.getElementById('diff_exosome'));
exosome.setOption(option);

window.addEventListener("resize",function(){
    exosome.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    exosome.resize();
});

option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data: ['Protein-Upregulated', 'Protein-Downregulated', 'LncRNA-Downregulated', 'LncRNA-Upregulated'],
        textStyle:{
            fontSize:14,
            fontWeith:'bold',
        },
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        axisLabel: {
            interval: 0,
            textStyle: {
                fontSize:14.5,
                fontWeight:'bold',
            }
        },
        nameTextStyle: {
            fontSize: 18,
            fontWeight: 'bold',
            padding: [0,0,0,0],
        },
    },
    yAxis: {
        type: 'category',
        data: ['HIV', 'HBV',"HCV","SARS-CoV-2"],
        axisLabel: {
            interval: 0,
            textStyle: {
                fontWeight:"bold",
                fontSize:14.5,
            }
        },
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold'
        },
    },
    series: [
        {
            name: 'LncRNA-Upregulated',
            type: 'bar',
            stack: '总量',
            label: {
                show: false,
                position: 'insideRight'
            },
            data: [0, 94, 0, 357]
        },
        {
            name: 'LncRNA-Downregulated',
            type: 'bar',
            stack: '总量',
            label: {
                show: false,
                position: 'insideRight'
            },
            data: [-2, -530, -2, -8]
        },
        {
            name: 'Protein-Upregulated',
            type: 'bar',
            stack: '总量',
            label: {
                show: false,
                position: 'insideRight'
            },
            data: [0, 37, 0, 316]
        },
        {
            name: 'Protein-Downregulated',
            type: 'bar',
            stack: '总量',
            label: {
                show: false,
                position: 'insideRight'
            },
            data: [-2, -228, -2, -341]
        },
    ]
};

var virus = echarts.init(document.getElementById('diff_virus'));
virus.setOption(option);

window.addEventListener("resize",function(){
    virus.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    virus.resize();
});