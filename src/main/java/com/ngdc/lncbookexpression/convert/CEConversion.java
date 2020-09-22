package com.ngdc.lncbookexpression.convert;

import com.ngdc.lncbookexpression.model.CoExpression.CeBrain;
import com.ngdc.lncbookexpression.model.TemporalExpression.DeColorectalNormal;

import java.util.List;
import java.util.stream.Collectors;

public class CEConversion {

    public static CeBrain convert(Object obj) {
        Object[] a =  (Object[]) obj;
        CeBrain ceBrain = new CeBrain();
        ceBrain.setPcc(Float.parseFloat(a[0].toString()));
        ceBrain.setPvalue(Float.parseFloat(a[1].toString()));
        ceBrain.setGeneid(String.valueOf(a[2]));
        ceBrain.setPcg(String.valueOf(a[3]));
        ceBrain.setLncname(String.valueOf(a[4]));
        ceBrain.setLnclocation(String.valueOf(a[5]));
        ceBrain.setPcgname(String.valueOf(a[6]));
        ceBrain.setPcglocation(String.valueOf(a[7]));
        ceBrain.setDistance(Float.parseFloat(a[8].toString()));
        return ceBrain;
    }
    public static List<CeBrain> convert(List<Object> objects){
        List<CeBrain> ceBrain =  objects.stream().map(e -> convert(e)).collect(Collectors.toList());
        return ceBrain;
    }
}
