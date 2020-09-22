option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    tooltip: {},
    title: {
        left: 'left',
        text: 'Featured Genes in 9 Biological Contexts',
        textStyle:{
            fontSize:16,
        }
    },
    legend: {
        x: '75%',
        y: 'top',
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
        },
        nameTextStyle: {
            fontSize: 15,
            fontFamily: 'Arial Narrow',
            fontWeight: 'bold',
            padding: [0,0,0,0],
        },
        data: ["1","2","3","4","5","6", "7","8","9"],
        labels: {
            rotation: 0,
            style: {
                fontSize:'16px',
                fontcolor: '#000000',
                fontWeight: 'bold',
            },
        },
    },
    yAxis: {
        type: 'value',
        name: 'Gene Counts',
        nameLocation: "center",
        nameGap: 45,
        splitLine:{show: true},
        boundaryGap: [0, 0.01],
        nameTextStyle: {
            fontSize: 15,
            fontFamily: 'Arial Narrow',
            fontWeight: 'bold'
        },
    },
    series: [{
        name: "LncRNA",
        data: [18829,4854,1166,293,45,3,1,0,0],
        type: 'bar',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(220, 220, 220, 0.8)'
        }
    },
        {
            name: "Protein Coding",
            data: [2919,5259,5242,2940,908,137,15,0,0],
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
                color: 'rgba(220, 220, 220, 0.8)'
            }
        },
    ]
};
var featured = echarts.init(document.getElementById('featured'));
featured.setOption(option);

window.addEventListener("resize",function(){
    featured.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    featured.resize();
});
