package com.ngdc.lncbookexpression.convert;

import com.ngdc.lncbookexpression.model.TemporalExpression.DeColorectalNormal;
import com.ngdc.lncbookexpression.model.TemporalExpression.TauBrain;

import java.util.List;
import java.util.stream.Collectors;

public class HKTSConversion {

    public static TauBrain convert(Object obj) {
        Object[] a =  (Object[]) obj;
        TauBrain tauBrain = new TauBrain();
        tauBrain.setGeneid(String.valueOf(a[0]));
        tauBrain.setTau(Float.parseFloat(a[1].toString()));
        tauBrain.setMax_name(String.valueOf(a[2]));
        tauBrain.setMax_value(Float.parseFloat(a[3].toString()));
        tauBrain.setMin_name(String.valueOf(a[4]));
        tauBrain.setMin_value(Float.parseFloat(a[5].toString()));
        tauBrain.setAvg(Float.parseFloat(a[6].toString()));
        tauBrain.setMedian(Float.parseFloat(a[7].toString()));
        tauBrain.setCv(Float.parseFloat(a[8].toString()));
        tauBrain.setBrand(Integer.parseInt(a[9].toString()));
        tauBrain.setSymbol(String.valueOf(a[10]));
        return tauBrain;
    }
    public static List<TauBrain> convert(List<Object> objects){
        List<TauBrain> tauBrain =  objects.stream().map(e -> convert(e)).collect(Collectors.toList());
        return tauBrain;
    }
}
