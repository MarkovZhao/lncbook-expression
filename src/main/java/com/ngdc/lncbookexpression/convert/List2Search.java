package com.ngdc.lncbookexpression.convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List2Search {
    public static Map<String, Object> convert(List<String> stringList) {
        List<Map<String,Object>> maps = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            Map<String,Object> map = new HashMap<>();
            String u = "";
            if(!stringList.get(i).equals("NA")){
                if(stringList.get(i).contains("HSALNG")){
                    u = stringList.get(i) + "|Gene ID";
                }else if (stringList.get(i).contains("HSALNT|ENST|")){
                    u = stringList.get(i) + "|Transcript ID";
                }else {
                    u = stringList.get(i) + "|Gene Name";
                }
                map.put("id",u);
                map.put("text",u);
                maps.add(map);
            }
        }
        Map<String, Object> result = new HashMap<>();
        result.put("results", maps);
        return result;
    }
}
