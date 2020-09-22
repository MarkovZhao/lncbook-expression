package com.ngdc.lncbookexpression.service;

import com.ngdc.lncbookexpression.convert.SpatialConversion;
import com.ngdc.lncbookexpression.convert.StringConversion;
import com.ngdc.lncbookexpression.dto.Spatialdto;
import com.ngdc.lncbookexpression.dto.Temporaldto;
import com.ngdc.lncbookexpression.model.SpatialFeatured;
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
public class SpatialService {

    @PersistenceContext
    private EntityManager em;
    public Map searchTemporal(Temporaldto temporaldto, int page, int size, String sortName, String sortOrder) {
        Map map = new HashMap();
        String select = "select * from time_featured s where ";
        String filter= temporalFilter(temporaldto);
        select += filter + " order by " + sortName +" "+  sortOrder;
        System.out.println(select);
        Query query = em.createNativeQuery(select);
        List<Object> objects = query.getResultList();
        int total_size = objects.size();
        List<TimeFeatured> timeFeatured= null;
        timeFeatured = StringConversion.convert(objects);
        map.put("geneinfo", timeFeatured);
        return map;
    }

    public Map searchSpatial(Spatialdto spatialdto, int page, int size, String sortName, String sortOrder) {
        Map map = new HashMap();
        String select = "select * from spatial_featured s where ";
        String filter= SpatialFilter(spatialdto);
        select += filter + " order by " + sortName +" "+  sortOrder;
        System.out.println(select);
        Query query = em.createNativeQuery(select);
        List<Object> objects = query.getResultList();
        int total_size = objects.size();
        List<SpatialFeatured> spatialFeatured= null;
        if(page <= ((total_size/size)-1)) {
            spatialFeatured = SpatialConversion.convert(objects.subList(page * size, page * size + size));
        }else{
            spatialFeatured = SpatialConversion.convert(objects.subList(page * size, total_size));
        }
        map.put("total",total_size);
        map.put("geneInfo", spatialFeatured);
        map.put("page", page);
        return map;
    }

    public String temporalFilter(Temporaldto temporaldto){
        String filter="1=1";
        if (!StringUtils.isEmpty(temporaldto.getBrain())){
            filter += " and s.brain =" + temporaldto.getBrain();
        }
        if (!StringUtils.isEmpty(temporaldto.getCerebellum())) {
            filter +=" and s.cerebellum ="+temporaldto.getCerebellum();
        }
        if (!StringUtils.isEmpty(temporaldto.getHeart())) {
            filter += " and s.heart ="+temporaldto.getHeart();
        }
        if (!StringUtils.isEmpty(temporaldto.getKidney())) {
            filter += " and s.kidney ="+temporaldto.getKidney();
        }
        if (!StringUtils.isEmpty(temporaldto.getLiver())) {
            filter += " and s.liver ="+temporaldto.getLiver();
        }
        if (!StringUtils.isEmpty(temporaldto.getOvary())) {
            filter += " and s.ovary ="+temporaldto.getOvary();
        }
        if (!StringUtils.isEmpty(temporaldto.getTestis())) {
            filter += " and s.testis ="+temporaldto.getTestis();
        }
        return filter;
    }

    public String SpatialFilter(Spatialdto spatialdao){
        String filter="1=1";
        if (!StringUtils.isEmpty(spatialdao.getCcle())){
            filter += " and s.ccle =" + spatialdao.getCcle();
        }
        if (!StringUtils.isEmpty(spatialdao.getSubcellular())) {
            filter +=" and s.subcellular ="+spatialdao.getSubcellular();
        }
        if (!StringUtils.isEmpty(spatialdao.getColorectal())) {
            filter += " and s.colorectal ="+spatialdao.getColorectal();
        }
        if (!StringUtils.isEmpty(spatialdao.getCoronary())) {
            filter += " and s.coronary ="+spatialdao.getCoronary();
        }
        if (!StringUtils.isEmpty(spatialdao.getPancreatic())) {
            filter += " and s.pancreatic ="+spatialdao.getPancreatic();
        }
        if (!StringUtils.isEmpty(spatialdao.getHepatocellular())) {
            filter += " and s.hepatocellular ="+spatialdao.getHepatocellular();
        }
        if (!StringUtils.isEmpty(spatialdao.getEscc())) {
            filter += " and s.escc ="+spatialdao.getEscc();
        }
        if (!StringUtils.isEmpty(spatialdao.getHbv())) {
            filter += " and s.hbv ="+spatialdao.getHbv();
        }
        if (!StringUtils.isEmpty(spatialdao.getHiv1())) {
            filter += " and s.hiv1 ="+spatialdao.getHiv1();
        }
        if (!StringUtils.isEmpty(spatialdao.getHcv())) {
            filter += " and s.hcv ="+spatialdao.getHcv();
        }
        if (!StringUtils.isEmpty(spatialdao.getSars2())) {
            filter += " and s.sars2 ="+spatialdao.getSars2();
        }
        return filter;
    }
}
