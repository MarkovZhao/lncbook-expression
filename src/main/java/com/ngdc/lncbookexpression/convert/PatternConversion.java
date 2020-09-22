package com.ngdc.lncbookexpression.convert;

import com.ngdc.lncbookexpression.model.SpatialExpression.FtBrain;

import java.util.List;
import java.util.stream.Collectors;

public class PatternConversion {

    public static FtBrain convert(Object obj) {
        Object[] a =  (Object[]) obj;
        FtBrain patternBrain = new FtBrain();
        patternBrain.setGeneid(String.valueOf(a[0]));
        patternBrain.setTau(Float.parseFloat(a[1].toString()));
        patternBrain.setMax_name(String.valueOf(a[2]));
        patternBrain.setMax_value(Float.parseFloat(a[3].toString()));
        patternBrain.setMin_name(String.valueOf(a[4]));
        patternBrain.setMin_value(Float.parseFloat(a[5].toString()));
        patternBrain.setAvg(Float.parseFloat(a[6].toString()));
        patternBrain.setMedian(Float.parseFloat(a[7].toString()));
        patternBrain.setCv(Float.parseFloat(a[8].toString()));
        patternBrain.setBrand(Integer.parseInt(a[9].toString()));
        patternBrain.setP_value(Float.parseFloat(a[10].toString()));
        patternBrain.setR_squared(Float.parseFloat(a[11].toString()));
        patternBrain.setK_4(String.valueOf(a[12]));
        patternBrain.setK_5(String.valueOf(a[13]));
        patternBrain.setK_6(String.valueOf(a[14]));
        patternBrain.setK_7(String.valueOf(a[15]));
        patternBrain.setK_8(String.valueOf(a[16]));
        patternBrain.setSymbol(String.valueOf(a[17]));
        return patternBrain;
    }
    public static List<FtBrain> convert(List<Object> objects){
        List<FtBrain> patternBrain =  objects.stream().map(e -> convert(e)).collect(Collectors.toList());
        return patternBrain;
    }
}
