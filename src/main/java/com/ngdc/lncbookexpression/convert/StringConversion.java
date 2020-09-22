package com.ngdc.lncbookexpression.convert;

import com.ngdc.lncbookexpression.model.Featured;
import com.ngdc.lncbookexpression.model.TimeFeatured;

import java.util.List;
import java.util.stream.Collectors;

public class StringConversion {
    public static TimeFeatured convert(Object obj) {
        Object[] a =  (Object[]) obj;
        TimeFeatured timeFeatured = new TimeFeatured();
        timeFeatured.setGeneid(String.valueOf(a[0]));
        timeFeatured.setGenename(String.valueOf(a[1]));
        timeFeatured.setBrain(String.valueOf(a[2]));
        timeFeatured.setCerebellum(String.valueOf(a[3]));
        timeFeatured.setHeart(String.valueOf(a[4]));
        timeFeatured.setKidney(String.valueOf(a[5]));
        timeFeatured.setLiver(String.valueOf(a[6]));
        timeFeatured.setTestis(String.valueOf(a[7]));
        timeFeatured.setOvary(String.valueOf(a[8]));
        return timeFeatured;
    }
    public static List<TimeFeatured> convert(List<Object> objects){
        List<TimeFeatured> timeFeatured =  objects.stream().map(e -> convert(e)).collect(Collectors.toList());
        return timeFeatured;
    }
}
