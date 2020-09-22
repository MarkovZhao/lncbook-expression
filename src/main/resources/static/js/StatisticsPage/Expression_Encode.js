option = {
    textStyle: {
        fontFamily:"Arial Narrow"
    },
    tooltip: {},
    title: {
        left: 'left',
        text: 'Tissue-Specific Genes in ENCODE Primary Cell Lines',
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
            interval: 1,
            rotate: 50,
            textStyle: {
                fontWeight:"bold",
                fontSize:14.5,
            },
            formatter: function (value) {
                let valueText = ''
                if (value.length > 5) {
                    valueText = value.substring(0,18) + '...'
                } else {
                    valueText = value
                }
                return valueText
            }
        },
        nameTextStyle: {
            fontSize: 10,
            fontFamily: 'Arial',
            fontWeight: 'bold',
            padding: [0,0,0,0],
        },
        data: ["Airway Epithelial","Aortic Smooth Muscle","Articular Cchondrocyte of Knee Joint","Astrocyte","Bladder Microvascular Endothelial","Bronchial Epithelial","Bronchial Smooth Muscle","Bronchus Fibroblast of Lung","Cardiac Atrium Fibroblast","Cardiac Ventricle Fibroblast","Dermis Blood Vessel Endothelial","Dermis Lymphatic Vessel Endothelial","Dermis Microvascular Lymphatic Vessel Endothelial","Endometrial Microvascular Endothelial","Endothelial Cell of Coronary Artery","Epithelial Cell of Alveolus of Lung","Epithelial Cell of Proximal Tubule","Epithelial Cell of Umbilical Artery","Fibroblast of Dermis","Fibroblast of Lung","Fibroblast of The Aortic Adventitia","Fibroblast of Villous Mesenchyme","Glomerular Endothelial Cell","Hair Follicle Dermal Papilla Cell","Hair Follicular Keratinocyte","Kidney Epithelial","Lung Microvascular Endothelial","Mammary Epithelial","Mammary Microvascular Endothelial","Melanocyte of Skin","Mesangial","Mesenchymal Stem Cell of Adipose","Mesenchymal Stem Cell of The Bone Marrow","Mesenchymal Stem Cell of Wharton'S Jelly","Myometrial","Nasal Cavity Respiratory Epithelium Epithelial Cell of Viscerocranial Mucosa","Osteoblast","Pericardium Fibroblast","Pericyte","Placental Epithelial","Pulmonary Artery Endothelial","Regular Cardiac Myocyte","Renal Cortical Epithelial","Skeletal Muscle Myoblast","Skeletal Muscle Satellite","Smooth Muscle Cell of Bladder","Smooth Muscle Cell of The Coronary Artery","Smooth Muscle Cell of The Pulmonary Artery","Smooth Muscle Cell of The Umbilical Artery","Smooth Muscle Cell of Trachea","Subcutaneous Preadipocyte","Thoracic Aorta Endothelial","Tracheal Epithelial","Uterine Smooth Muscle","Vein Endothelial",],
    },
    yAxis: {
        type: 'value',
        name: 'Gene Number',
        nameLocation: "center",
        nameGap: 35,
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
        data: [26,26,275,156,58,31,18,5,42,20,16,52,7,44,6,42,33,16,89,8,139,36,55,100,23,62,13,145,10,247,12,147,95,15,20,28,18,16,57,415,6,3,137,76,30,7,8,7,48,24,42,286,12,16,60,],
        type: 'bar',
        showBackground: true,
        backgroundStyle: {
            color: 'rgba(220, 220, 220, 0.8)'
        }
    },
        {
            name: "Protein Coding",
            data: [156,29,53,47,6,52,7,11,38,54,36,58,12,34,1,36,42,16,36,14,12,8,67,49,92,115,7,72,25,130,55,28,38,8,23,53,4,30,10,119,4,11,177,171,4,20,7,17,20,9,2,6,25,11,5,],
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
                color: 'rgba(220, 220, 220, 0.8)'
            }
        },
    ]
};
var encode = echarts.init(document.getElementById('encode'));
encode.setOption(option);

window.addEventListener("resize",function(){
    encode.resize();
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
    encode.resize();
});
