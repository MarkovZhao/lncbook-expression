package com.ngdc.lncbookexpression.convert;

import com.ngdc.lncbookexpression.model.CoExpression.CeBrain;
import com.ngdc.lncbookexpression.model.Interaction;
import com.ngdc.lncbookexpression.model.TemporalExpression.DeColorectalNormal;

import java.util.List;
import java.util.stream.Collectors;

public class CEConversion {

    public static Interaction convert(Object obj) {
        Object[] a =  (Object[]) obj;
        Interaction interaction = new Interaction();
        interaction.setGeneid(String.valueOf(a[0]));
        interaction.setPcg(String.valueOf(a[1]));
        interaction.setContext(String.valueOf(a[2]));
        interaction.setBreadth(Integer.parseInt(a[3].toString()));
        interaction.setLncname(String.valueOf(a[4]));
        interaction.setPcgname(String.valueOf(a[5]));
        interaction.setDistance(Integer.parseInt(a[6].toString()));
        interaction.setLnclocation(String.valueOf(a[7]));
        interaction.setPcglocation(String.valueOf(a[8]));
        return interaction;
    }
    public static List<Interaction> convert(List<Object> objects){
        List<Interaction> interaction =  objects.stream().map(e -> convert(e)).collect(Collectors.toList());
        return interaction;
    }
}
