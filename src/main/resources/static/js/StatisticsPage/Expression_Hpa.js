option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    tooltip: {},
    title: {
        left: 'left',
        text: 'Tissue-Specific Genes in Normal Tissues',
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
        data: ["Adrenal","Appendix","Bone Marrow","Brain","Colon"," Duodenum", "Endometrium","Esophagus","Fallopian Tube",
            "Fat", "Gall Bladder","Heart","Kidney","Liver", "Lung","Lymphnode","Ovary","Pancreas","Placenta","Prostate Gland",
            "Rectum","Salivary Secreting Gland","Skeletal Muscle", "Small Intestine","Smooth Muscle","Spleen","Stomach","Testis",
            "Thyroid Gland","Tonsil","Urinary Bladder","Zone of Skin"]
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
        name: 'Gene Number',
        nameLocation: "center",
        nameGap: 35,
        splitLine:{show: true},
        boundaryGap: [0, 0.01],
        nameTextStyle: {
            fontSize: 16.5,
            fontWeight: 'bold'
        },
    },
    series: [{
        name: "LncRNA",
        data: [93,20,713,223,14,86,43,50,120,53,27,87,158,116,48,53,76,25,189,153,67,62,184,75,9,92,80,1057,135,26,20,291,],
        type: 'bar',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(220, 220, 220, 0.8)'
        }
    },
        {
            name: "Protein Coding",
            data: [98,25,154,833,32,113,26,106,197,86,30,103,207,251,64,49,52,43,160,70,38,67,229,73,19,65,77,1059,74,51,25,229,],
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
                color: 'rgba(220, 220, 220, 0.8)'
            }
        },
    ]
};
var hpa = echarts.init(document.getElementById('hpa'));
hpa.setOption(option);

window.addEventListener("resize",function(){
    hpa.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    hpa.resize();
});
