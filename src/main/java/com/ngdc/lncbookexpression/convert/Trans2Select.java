package com.ngdc.lncbookexpression.convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trans2Select {
    public static List<Map<String, Object>> convert(List<String> stringList) {
        List<Map<String,Object>> maps = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            Map<String,Object> map = new HashMap<>();
            String u = "";
            if(!stringList.get(i).equals("NA")){
                u = stringList.get(i) + "|Transcript ID";
                map.put("id",u);
                map.put("text",u);
                maps.add(map);
            }
        }
//        Map<String, Object> result = new HashMap<>();
//        result.put("results", maps);
        return maps;
    }

}
