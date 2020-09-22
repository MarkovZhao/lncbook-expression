package com.ngdc.lncbookexpression.convert;

import com.ngdc.lncbookexpression.model.TemporalExpression.DeColorectalNormal;

import java.util.List;
import java.util.stream.Collectors;

public class DEConversion {

    public static DeColorectalNormal convert(Object obj) {
        Object[] a =  (Object[]) obj;
        DeColorectalNormal deColorectalNormal = new DeColorectalNormal();
        deColorectalNormal.setGeneid(String.valueOf(a[0]));
        deColorectalNormal.setBasemean(Float.parseFloat(a[1].toString()));
        deColorectalNormal.setLog2foldchange(Float.parseFloat(a[2].toString()));
        deColorectalNormal.setLfcse(Float.parseFloat(a[3].toString()));
        deColorectalNormal.setStat(Float.parseFloat(a[4].toString()));
        deColorectalNormal.setPvalue(Float.parseFloat(a[5].toString()));
        deColorectalNormal.setPadj(Float.parseFloat(a[6].toString()));
        deColorectalNormal.setSymbol(String.valueOf(a[7]));
        return deColorectalNormal;
    }
    public static List<DeColorectalNormal> convert(List<Object> objects){
        List<DeColorectalNormal> deColorectalNormal =  objects.stream().map(e -> convert(e)).collect(Collectors.toList());
        return deColorectalNormal;
    }
}
