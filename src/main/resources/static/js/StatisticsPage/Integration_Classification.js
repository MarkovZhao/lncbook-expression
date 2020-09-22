option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    title: {
        left: 'left',
        text: 'Gene Classification',
        textStyle:{
            fontSize:18,
            fontWeight:'bold',
        }
    },
    toolbox: {
        show: true,
        feature: {
            saveAsImage: {
                show:true,
                pixelRatio: 7,
                title: "Save"
            }
        }
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b}: {c} ({d}%)'
    },
    // legend: {
    //     orient: 'vertical',
    //     left: 10,
    //     data: ['Intergenic', 'Sense', 'Antisense', 'Intronic (S)', 'Intronic (AS)', 'Overlapping (S)', 'Overlapping (S)']
    // },
    series: [
        {
            name: 'Classificaiton',
            type: 'pie',
            radius: "70%",
            label: {
                textStyle:{
                    fontSize:14.5,
                    fontWeight:"bold",
                }
            },
            center:['57%','55%'],
            avoidLabelOverlap: true,
            data: [
                {value: 55302, name: 'Intergenic'},
                {value: 17694, name: 'Sense'},
                {value: 27471, name: 'Antisense'},
                {value: 1535, name: 'Intronic (S)'},
                {value: 1722, name: 'Intronic (AS)'},
                {value: 218, name: 'Overlapping (S)'},
                {value: 377, name: 'Overlapping (AS)'},
            ],

        }
    ]
};

var myChart3 = echarts.init(document.getElementById('gene_classification'));
myChart3.setOption(option);

window.addEventListener("resize",function(){
    myChart3.resize();
});

option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    title: {
        left: 'left',
        text: 'Transcript Classification',
        textStyle:{
            fontSize:18,
            fontWeight:'bold',
        }
    },
    toolbox: {
        show: true,
        feature: {
            saveAsImage: {
                show:true,
                pixelRatio: 7,
                title: "Save"
            }
        }
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b}: {c} ({d}%)'
    },
    // legend: {
    //     orient: 'vertical',
    //     left: 10,
    //     data: ['Intergenic', 'Sense', 'Antisense', 'Intronic (S)', 'Intronic (AS)', 'Overlapping (S)', 'Overlapping (S)']
    // },
    series: [
        {
            name: 'Classificaiton',
            label: {
                textStyle:{
                    fontSize:14.5,
                    fontWeight:"bold",
                }
            },
            center:['57%','55%'],
            type: 'pie',
            radius: "70%",
            avoidLabelOverlap: true,
            data: [
                {value: 216545, name: 'Intergenic'},
                {value: 36773, name: 'Sense'},
                {value: 117839, name: 'Antisense'},
                {value: 2047, name: 'Intronic (S)'},
                {value: 3975, name: 'Intronic (AS)'},
                {value: 1037, name: 'Overlapping (S)'},
                {value: 2983, name: 'Overlapping (AS)'},
            ]
        }
    ]
};
var myChart4 = echarts.init(document.getElementById('trans_classification'));
myChart4.setOption(option);

window.addEventListener("resize",function(){
    myChart4.resize();
});
