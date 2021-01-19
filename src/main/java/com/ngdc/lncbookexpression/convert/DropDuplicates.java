package com.ngdc.lncbookexpression.convert;

import com.ngdc.lncbookexpression.model.GeneInfo;

import java.util.*;

public class DropDuplicates {
    public static List<Map<String, Object>> convert(List<GeneInfo> raw_maps) {
        List<Map<String,Object>> maps = new ArrayList<>();
        for (int i = 0; i < raw_maps.size(); i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("geneid",raw_maps.get(i).getGeneid());
            map.put("symbol",raw_maps.get(i).getSymbol());
            map.put("classification",raw_maps.get(i).getClassification());
            map.put("chromosome",raw_maps.get(i).getChromosome());
            map.put("strand",raw_maps.get(i).getStrand());
            map.put("start",raw_maps.get(i).getStart());
            map.put("end",raw_maps.get(i).getEnd());
            map.put("length",raw_maps.get(i).getLength());
            map.put("transNumber",raw_maps.get(i).getTransNumber());
            map.put("gene_length",raw_maps.get(i).getGene_length());
            maps.add(map);

        }
        HashSet hashset = new HashSet(maps);
        maps.clear();
        maps.addAll(hashset);
        return maps;
    }
}
