option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    tooltip: {},
    title: {
        left: 'left',
        text: 'Cell-Specific Genes in Cancer Cell Lines',
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
            fontSize: 18,
            fontWeight: 'bold',
            padding: [0,0,0,0],
        },
        data: ["All","Bile duct","BLCA","BRCA","COAD/READ","DLBC", "ESCA","GBM","Glioma","HNSC",
            "KIRC","LAML","LCML","LIHC", "LUAD","Lung_NSC","LUSC","Lymphoma Other","MM","NB","OV","PAAD","PRAD",
            "SARC","SCLC","SKCM","STAD","THCA","UCEC"]
    },
    yAxis: {
        type: 'value',
        name: 'Gene Counts',
        nameLocation: "center",
        nameGap: 35,
        axisLabel: {
            interval: 0,
            textStyle: {
                fontWeight:"bold",
                fontSize:14.5,
            }
        },
        splitLine:{show: true},
        boundaryGap: [0, 0.01],
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold'
        },
    },
    series: [{
        name: "LncRNA",
        data: [91, 30, 0, 8, 14, 142, 65, 6,2,78,54,96,56,6,0,0,0,411,110,221,33,3,61,133,127,67,0,1,14,],
        type: 'bar',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(220, 220, 220, 0.8)'
        }
    },
        {
            name: "Protein Coding",
            data: [35, 18, 0, 6, 21, 52, 9,0,1,81,27,84,28,21,0,0,0,90,31,135,17,6,42,40,106,39,1,1,1,],
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
                color: 'rgba(220, 220, 220, 0.8)'
            }
        },
    ]
};
var ccle = echarts.init(document.getElementById('ccle'));
ccle.setOption(option);

window.addEventListener("resize",function(){
    ccle.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    ccle.resize();
});
