package com.ngdc.lncbookexpression.convert;

import com.ngdc.lncbookexpression.model.FeaturedAll;

import java.util.List;
import java.util.stream.Collectors;

public class FeatureConversion {
    public static FeaturedAll convert(Object obj) {
        Object[] a =  (Object[]) obj;
        FeaturedAll featuredAll = new FeaturedAll();
        featuredAll.setGeneid(String.valueOf(a[0]));
        featuredAll.setClassification(String.valueOf(a[1]));
        featuredAll.setSymbol(String.valueOf(a[2]));
        featuredAll.setNormal(String.valueOf(a[3]));
        featuredAll.setCcle(String.valueOf(a[4]));
        featuredAll.setSubcellular(String.valueOf(a[5]));
        featuredAll.setDevelopment(String.valueOf(a[6]));
        featuredAll.setPreimplantation(String.valueOf(a[7]));
        featuredAll.setDifferentiation(String.valueOf(a[8]));
        featuredAll.setCircadian(String.valueOf(a[9]));
        featuredAll.setExosome(String.valueOf(a[10]));
        featuredAll.setVirus(String.valueOf(a[11]));

        return featuredAll;
    }
    public static List<FeaturedAll> convert(List<Object> objects){
        List<FeaturedAll> featuredAll =  objects.stream().map(e -> convert(e)).collect(Collectors.toList());
        return featuredAll;
    }
}
