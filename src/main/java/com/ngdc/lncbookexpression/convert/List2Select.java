package com.ngdc.lncbookexpression.convert;

import java.util.*;

public class List2Select {
    public static Map<String, Object> convert(List<String> stringList) {
        List<Map<String,Object>> maps = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            Map<String,Object> map = new HashMap<>();
            if(!stringList.get(i).equals("N/A")&&(!stringList.get(i).equals(""))){
                map.put("id",stringList.get(i));
                map.put("text",stringList.get(i));
                maps.add(map);
            }
        }
//        HashSet set = new HashSet(maps);
//        maps.clear();
//        maps.addAll(set);
        Map<String, Object> result = new HashMap<>();
        result.put("results", maps);
        return result;
    }
}