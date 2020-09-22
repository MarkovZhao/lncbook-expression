package com.ngdc.lncbookexpression.convert;

import com.ngdc.lncbookexpression.model.Circadian;
import com.ngdc.lncbookexpression.model.CoExpression.CeBrain;

import java.util.List;
import java.util.stream.Collectors;

public class CIConversion {
    public static Circadian convert(Object obj) {
        Object[] a =  (Object[]) obj;
        Circadian circadian = new Circadian();
        circadian.setGeneid(String.valueOf(a[0]));
        circadian.setJtk_pvalue(Float.parseFloat(a[1].toString()));
        circadian.setJtk_bhq(Float.parseFloat(a[2].toString()));
        circadian.setJtk_period(Float.parseFloat(a[3].toString()));
        circadian.setJtk_adjphase(Float.parseFloat(a[4].toString()));
        circadian.setJtk_amplitude(Float.parseFloat(a[5].toString()));
        circadian.setLs_pvalue(Float.parseFloat(a[6].toString()));
        circadian.setLs_bhq(Float.parseFloat(a[7].toString()));
        circadian.setLs_period(Float.parseFloat(a[8].toString()));
        circadian.setLs_adjphase(Float.parseFloat(a[9].toString()));
        circadian.setLs_amplitude(Float.parseFloat(a[10].toString()));

        circadian.setMeta2d_pvalue(Float.parseFloat(a[11].toString()));
        circadian.setMeta2d_bhq(Float.parseFloat(a[12].toString()));
        circadian.setMeta2d_period(Float.parseFloat(a[13].toString()));
        circadian.setMeta2d_phase(Float.parseFloat(a[14].toString()));
        circadian.setMeta2d_base(Float.parseFloat(a[15].toString()));
        circadian.setMeta2d_amp(Float.parseFloat(a[16].toString()));
        circadian.setMeta2d_ramp(Float.parseFloat(a[17].toString()));
        circadian.setMeta2d_adjphase(Float.parseFloat(a[18].toString()));
        circadian.setMeta2d_amplitude(Float.parseFloat(a[19].toString()));
        circadian.setSymbol(String.valueOf(a[20]));

        return circadian;
    }
    public static List<Circadian> convert(List<Object> objects){
        List<Circadian> circadian =  objects.stream().map(e -> convert(e)).collect(Collectors.toList());
        return circadian;
    }
}
