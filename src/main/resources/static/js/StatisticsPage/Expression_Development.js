option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    title: {
        left: 'left',
        text: 'Dynamic Protein Coding Genes',
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
            avoidLabelOverlap: true,
            label: {
                textStyle:{
                    fontSize:14.5,
                    fontWeight:"bold",
                }
            },
            center:['57%','55%'],
            data: [
                {value: 3143, name: 'Brain'},
                {value: 2846, name: 'Cerebellum'},
                {value: 1307, name: 'Heart'},
                {value: 1147, name: 'Kidney'},
                {value: 1289, name: 'Liver'},
                {value: 1775, name: 'Ovary'},
                {value: 2360, name: 'Testis'},
            ]
        }
    ]
};
var pcg_development = echarts.init(document.getElementById('pcg_development'));
pcg_development.setOption(option);

window.addEventListener("resize",function(){
    pcg_development.resize();
});

option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    title: {
        left: 'left',
        text: 'Dynamic lncRNAs',
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
                {value: 492, name: 'Brain'},
                {value: 692, name: 'Cerebellum'},
                {value: 92, name: 'Heart'},
                {value: 177, name: 'Kidney'},
                {value: 157, name: 'Liver'},
                {value: 683, name: 'Ovary'},
                {value: 4755, name: 'Testis'},
            ]
        }
    ]
};
var lnc_development = echarts.init(document.getElementById('lnc_development'));
lnc_development.setOption(option);

window.addEventListener("resize",function(){
    lnc_development.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    lnc_development.resize();
    pcg_development.resize();
});