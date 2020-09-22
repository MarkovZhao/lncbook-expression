option = {
    textStyle: {
        fontFamily:"Arial Narrow",
        fontSize: 16,
    },
    title: {
        left: 'left',
        text: 'Featured Genes in 9 Biological Contexts',
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
        name: 'Number of Contexts',
        nameLocation: "center",
        nameGap: 45,
        boundaryGap: [0, 0.01],
        data: ["1","2","3","4","5","6","7","8","9"],
        axisLabel: {
            interval: 0,
            textStyle: {
                fontSize:14.5,
                fontWeight:'bold',
            }
        },
    },
    yAxis: {
        type: 'value',
        name: 'Gene Count Count Count',
        nameLocation: "center",
        nameGap: 45,
        splitLine:{show: true},
        boundaryGap: [0, 0.01],
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
