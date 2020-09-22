package com.ngdc.lncbookexpression.convert;

import com.ngdc.lncbookexpression.model.SpatialFeatured;
import com.ngdc.lncbookexpression.model.TimeFeatured;

import java.util.List;
import java.util.stream.Collectors;

public class SpatialConversion {
    public static SpatialFeatured convert(Object obj) {
        Object[] a =  (Object[]) obj;
        SpatialFeatured spatialFeatured = new SpatialFeatured();
        spatialFeatured.setGeneid(String.valueOf(a[0]));
        spatialFeatured.setCcle(String.valueOf(a[1]));
        spatialFeatured.setSubcellular(String.valueOf(a[2]));
        spatialFeatured.setColorectal(String.valueOf(a[3]));
        spatialFeatured.setCoronary(String.valueOf(a[4]));
        spatialFeatured.setPancreatic(String.valueOf(a[5]));
        spatialFeatured.setHepatocellular(String.valueOf(a[6]));
        spatialFeatured.setEscc(String.valueOf(a[7]));
        spatialFeatured.setHiv1(String.valueOf(a[8]));
        spatialFeatured.setHbv(String.valueOf(a[9]));
        spatialFeatured.setHcv(String.valueOf(a[10]));
        spatialFeatured.setSars2(String.valueOf(a[11]));

        return spatialFeatured;
    }
    public static List<SpatialFeatured> convert(List<Object> objects){
        List<SpatialFeatured> spatialFeatured =  objects.stream().map(e -> convert(e)).collect(Collectors.toList());
        return spatialFeatured;
    }
}
