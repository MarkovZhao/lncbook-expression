package com.ngdc.lncbookexpression.convert;

import com.ngdc.lncbookexpression.model.CancerMap.Cm;
import com.ngdc.lncbookexpression.model.TimeFeatured;

import java.util.List;
import java.util.stream.Collectors;

public class CmConversion {
    public static Cm convert(Object obj) {
        Object[] a =  (Object[]) obj;
        Cm cm = new Cm();
        cm.setCancer(String.valueOf(a[1]));
        cm.setNew_number(String.valueOf(a[2]));
        cm.setNew_rank(String.valueOf(a[3]));
        cm.setNew_percent(String.valueOf(a[4]));
        cm.setNew_cumrisk(String.valueOf(a[5]));
        cm.setDeath_number(String.valueOf(a[6]));
        cm.setDeathrank(String.valueOf(a[7]));
        cm.setDeath_percent(String.valueOf(a[8]));
        cm.setDeath_cumrisk(String.valueOf(a[9]));
        cm.setPrevalence_number(String.valueOf(a[10]));
        cm.setPrevalence_prop(String.valueOf(a[11]));
        cm.setCountry(String.valueOf(a[12]));
        cm.setContinent(String.valueOf(a[13]));
        return cm;
    }
    public static List<Cm> convert(List<Object> objects){
        List<Cm> cm =  objects.stream().map(e -> convert(e)).collect(Collectors.toList());
        return cm;
    }
}
