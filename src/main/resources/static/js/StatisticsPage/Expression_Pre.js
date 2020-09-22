option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    title: {
        left: 'left',
        text: 'Time-Specific Protein Coding Genes',
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
            name: 'Time-specific lncRNA genes',
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
                {value: 11, name: 'Zygote'},
                {value: 12, name: '2-Cell'},
                {value: 308, name: '4-Cell'},
                {value: 101, name: '8-Cell'},
                {value: 70, name: 'Morulae'},
                {value: 77, name: 'Earlyblastocyst'},
                {value: 51, name: 'Middleblastocyst'},
                {value: 117, name: 'Lateblastocyst'},
            ]
        }
    ]
};
var pcg_pre = echarts.init(document.getElementById('pcg_pre'));
pcg_pre.setOption(option);

window.addEventListener("resize",function(){
    pcg_pre.resize();
});

option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    title: {
        left: 'left',
        text: 'Time-Specific LncRNAs',
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
            name: 'dynamic genes',
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
                {value: 301, name: 'Zygote'},
                {value: 376, name: '2-Cell'},
                {value: 2839, name: '4-Cell'},
                {value: 1367, name: '8-Cell'},
                {value: 1025, name: 'Morulae'},
                {value: 844, name: 'Earlyblastocyst'},
                {value: 367, name: 'Middleblastocyst'},
                {value: 723, name: 'Lateblastocyst'},
            ]
        }
    ]
};
var lnc_pre = echarts.init(document.getElementById('lnc_pre'));
lnc_pre.setOption(option);

window.addEventListener("resize",function(){
    lnc_pre.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    pcg_pre.resize();
    lnc_pre.resize();
});