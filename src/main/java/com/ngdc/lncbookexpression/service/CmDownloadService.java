package com.ngdc.lncbookexpression.service;

import com.ngdc.lncbookexpression.convert.CmConversion;
import com.ngdc.lncbookexpression.convert.StringConversion;
import com.ngdc.lncbookexpression.dto.Cmdto;
import com.ngdc.lncbookexpression.model.CancerMap.Cm;
import com.ngdc.lncbookexpression.model.TimeFeatured;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CmDownloadService {

    @PersistenceContext
    private EntityManager em;
    public Map searchCancerMap(Cmdto cmdto, String sortName, String sortOrder) {
        Map map = new HashMap();
        String select = "select * from cm s where ";
        String filter= CancerMapFilter(cmdto);
        select += filter + " order by " + sortName +" "+  sortOrder;
        System.out.println(select);
        Query query = em.createNativeQuery(select);
        List<Object> objects = query.getResultList();
        int total_size = objects.size();
        List<Cm> cm= null;
        cm = CmConversion.convert(objects);
        map.put("cm", cm);
        return map;
    }


    public String CancerMapFilter(Cmdto cmdto){
        String filter="1=1";
        if ("".equals(cmdto.getCancer().length())) {
            filter += " and s.cancer = "+cmdto.getCancer();
        }
        if (!StringUtils.isEmpty(cmdto.getContinent())) {
            filter += " and s.continent = "+cmdto.getContinent();
        }
        if ("".equals(cmdto.getCountry().length())) {
            filter += " and s.country = "+cmdto.getCountry();
        }

        if (!StringUtils.isEmpty(cmdto.getNew_number_min())&&!StringUtils.isEmpty(cmdto.getNew_number_max()) ) {
            filter +=" and s.new_number >= "+cmdto.getNew_number_min()+" and s.new_number <="+cmdto.getNew_number_max();
        }else if (!StringUtils.isEmpty(cmdto.getNew_number_min())) {
            filter += " and s.new_number >= "+cmdto.getNew_number_min();
        }else if (!StringUtils.isEmpty(cmdto.getNew_number_max())) {
            filter += " and s.new_number <= "+cmdto.getNew_number_max();
        }

        if (!StringUtils.isEmpty(cmdto.getDeath_number_min())&&!StringUtils.isEmpty(cmdto.getDeath_number_max()) ) {
            filter +=" and s.death_number >= "+cmdto.getDeath_number_min()+" and s.death_number <="+cmdto.getDeath_number_max();
        }else if (!StringUtils.isEmpty(cmdto.getDeath_number_min())) {
            filter += " and s.death_number >= "+cmdto.getDeath_number_min();
        }else if (!StringUtils.isEmpty(cmdto.getDeath_number_max())) {
            filter += " and s.death_number <= "+cmdto.getDeath_number_max();
        }

        if (!StringUtils.isEmpty(cmdto.getPrevalence_number_min())&&!StringUtils.isEmpty(cmdto.getPrevalence_number_max()) ) {
            filter +=" and s.prevalence_number >= "+cmdto.getPrevalence_number_min()+" and s.prevalence_number <="+cmdto.getPrevalence_number_max();
        }else if (!StringUtils.isEmpty(cmdto.getPrevalence_number_min())) {
            filter += " and s.prevalence_number >= "+cmdto.getPrevalence_number_min();
        }else if (!StringUtils.isEmpty(cmdto.getPrevalence_number_max())) {
            filter += " and s.prevalence_number <= "+cmdto.getPrevalence_number_max();
        }

        return filter;
    }
}
