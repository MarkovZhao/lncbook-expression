package com.ngdc.lncbookexpression.service;

import com.ngdc.lncbookexpression.convert.DEConversion;
import com.ngdc.lncbookexpression.convert.HKTSConversion;
import com.ngdc.lncbookexpression.convert.PatternConversion;
import com.ngdc.lncbookexpression.dto.DEdto;
import com.ngdc.lncbookexpression.dto.HKTSdto;
import com.ngdc.lncbookexpression.dto.Patterndto;
import com.ngdc.lncbookexpression.model.SpatialExpression.FtBrain;
import com.ngdc.lncbookexpression.model.TemporalExpression.DeColorectalNormal;
import com.ngdc.lncbookexpression.model.TemporalExpression.TauBrain;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DownloadService {
    @PersistenceContext
    private EntityManager em;
    public Map searchHKTS(HKTSdto hktSdto, int page, int size, String name, String sortName, String sortOrder) {
        Map map = new HashMap();
        String select = "select * from " + name + " s where ";
        String filter= HKTSFilter(hktSdto);
        select += filter + " order by ABS(" + sortName +") "+  sortOrder;
        System.out.println(select);
        Query query = em.createNativeQuery(select);
        List<Object> objects = query.getResultList();
        int total_size = objects.size();
        List<TauBrain> tauBrain= null;
//        tauBrain = HKTSConversion.convert(objects);
        tauBrain = HKTSConversion.convert(objects.subList(0,total_size));
        map.put("total",total_size);
        map.put("geneInfo", tauBrain);
        map.put("page", page);
        return map;
    }

    public String HKTSFilter(HKTSdto hktsDto){
        String filter="1=1";

        if (!StringUtils.isEmpty(hktsDto.getGeneid())) {
            filter += " and s.geneid = "+hktsDto.getGeneid();
        }

        if (!StringUtils.isEmpty(hktsDto.getSymbol())) {
            filter += " and s.symbol = "+hktsDto.getSymbol();
        }

        if (!StringUtils.isEmpty(hktsDto.getCv1())&&!StringUtils.isEmpty(hktsDto.getCv2()) ) {
            filter +=" and s.cv >= "+hktsDto.getCv1()+" and s.cv <="+hktsDto.getCv2();
        }else if (!StringUtils.isEmpty(hktsDto.getCv1())) {
            filter += " and s.cv >= "+hktsDto.getCv1();
        }else if (!StringUtils.isEmpty(hktsDto.getCv2())) {
            filter += " and s.cv <= "+hktsDto.getCv2();
        }
        if (!StringUtils.isEmpty(hktsDto.getTau1())&&!StringUtils.isEmpty(hktsDto.getTau2()) ) {
            filter += " and s.tau >= "+hktsDto.getTau1()+" and s.tau <="+hktsDto.getTau2();
        }else if (!StringUtils.isEmpty(hktsDto.getTau1())) {
            filter += " and s.tau >= " + hktsDto.getTau1();
        }else if (!StringUtils.isEmpty(hktsDto.getTau2())) {
            filter += " and s.tau <= " + hktsDto.getTau2();
        }
        if (!StringUtils.isEmpty(hktsDto.getMinbreadth())&&!StringUtils.isEmpty(hktsDto.getMaxbreadth())) {
            filter += " and s.brand >= "+hktsDto.getMinbreadth()+" and s.brand <="+hktsDto.getMaxbreadth();
        }else if (!StringUtils.isEmpty(hktsDto.getMinbreadth())) {
            filter += " and s.brand >= "+hktsDto.getMaxbreadth();
        }else if (!StringUtils.isEmpty(hktsDto.getMaxbreadth())) {
            filter += " and s.brand <= "+hktsDto.getMaxbreadth();
        }
        if (!StringUtils.isEmpty(hktsDto.getMaxname())) {
            filter += " and s.max_name = "+hktsDto.getMaxname();
        }
        if (!StringUtils.isEmpty(hktsDto.getMaxvalue())) {
            filter += " and s.max_value >= "+hktsDto.getMaxvalue();
        }
        return filter;
    }

    public Map searchPattern(Patterndto patterndto, int page, int size, String name,String sortName, String sortOrder) {
        Map map = new HashMap();
        String select = "select * from " + name + " s where ";
        String filter= PatternFilter(patterndto);
        select += filter + " order by ABS(" + sortName +") "+  sortOrder;
        System.out.println(select);
        Query query = em.createNativeQuery(select);
        List<Object> objects = query.getResultList();
        int total_size = objects.size();
        List<FtBrain> patternBrain= null;
        patternBrain = PatternConversion.convert(objects.subList(0,total_size));
        map.put("total",total_size);
        map.put("geneInfo", patternBrain);
        map.put("page", page);
        return map;
    }

    public String PatternFilter(Patterndto patterndto){
        String filter="1=1";
        if (!StringUtils.isEmpty(patterndto.getGeneid())) {
            filter += " and s.geneid = "+patterndto.getGeneid();
        }
        if (!StringUtils.isEmpty(patterndto.getSymbol())) {
            filter += " and s.symbol = "+patterndto.getSymbol();
        }
        if (!StringUtils.isEmpty(patterndto.getCv1())&&!StringUtils.isEmpty(patterndto.getCv2()) ) {
            filter +=" and s.cv >= "+patterndto.getCv1()+" and s.cv <="+patterndto.getCv2();
        }else if (!StringUtils.isEmpty(patterndto.getCv1())) {
            filter += " and s.cv >= "+patterndto.getCv1();
        }else if (!StringUtils.isEmpty(patterndto.getCv2())) {
            filter += " and s.cv <= "+patterndto.getCv2();
        }
        if (!StringUtils.isEmpty(patterndto.getTau1())&&!StringUtils.isEmpty(patterndto.getTau2()) ) {
            filter += " and s.tau >= "+patterndto.getTau1()+" and s.tau <="+patterndto.getTau2();
        }else if (!StringUtils.isEmpty(patterndto.getTau1())) {
            filter += " and s.tau >= " + patterndto.getTau1();
        }else if (!StringUtils.isEmpty(patterndto.getTau2())) {
            filter += " and s.tau <= " + patterndto.getTau2();
        }
        if (!StringUtils.isEmpty(patterndto.getMinbreadth())&&!StringUtils.isEmpty(patterndto.getMaxbreadth())) {
            filter += " and s.brand >= "+patterndto.getMinbreadth()+" and s.brand <="+patterndto.getMaxbreadth();
        }else if (!StringUtils.isEmpty(patterndto.getMinbreadth())) {
            filter += " and s.brand >= "+patterndto.getMaxbreadth();
        }else if (!StringUtils.isEmpty(patterndto.getMaxbreadth())) {
            filter += " and s.brand <= "+patterndto.getMaxbreadth();
        }
        if (!StringUtils.isEmpty(patterndto.getMaxname())) {
            filter += " and s.max_name = "+patterndto.getMaxname();
        }
        if (!StringUtils.isEmpty(patterndto.getMaxvalue())) {
            filter += " and s.max_value >= "+patterndto.getMaxvalue();
        }
        if (!StringUtils.isEmpty(patterndto.getP_value())){
            filter += " and s.p_value <=" + patterndto.getP_value();
        }
        if (!StringUtils.isEmpty(patterndto.getR_squared())) {
            filter +=" and s.r_squared >="+patterndto.getR_squared();
        }
        return filter;
    }

    public Map searchDE(DEdto dEdto, int page, int size, String name, String sortName, String sortOrder) {
        Map map = new HashMap();
        String select = "select * from " + name + " s where ";
        String filter= DEFilter(dEdto);
        select += filter + " order by ABS(" + sortName +") "+  sortOrder;
        System.out.println(select);
        Query query = em.createNativeQuery(select);
        List<Object> objects = query.getResultList();
        int total_size = objects.size();
        List<DeColorectalNormal> deColorectalNormal= null;
        deColorectalNormal = DEConversion.convert(objects.subList(0,total_size));
        map.put("total",total_size);
        map.put("geneInfo", deColorectalNormal);
        map.put("page", page);
        return map;
    }

    public String DEFilter(DEdto dEdto){
        String filter="1=1";

        if (!StringUtils.isEmpty(dEdto.getGeneid())) {
            filter += " and s.geneid = "+dEdto.getGeneid();
        }
        if (!StringUtils.isEmpty(dEdto.getSymbol())) {
            filter += " and s.symbol = "+dEdto.getSymbol();
        }
        if (!StringUtils.isEmpty(dEdto.getPadj())){
            filter += " and s.padj <=" + dEdto.getPadj();
        }
        if (!StringUtils.isEmpty(dEdto.getPvalue())) {
            filter +=" and s.pvalue <="+dEdto.getPvalue();
        }
        if (!StringUtils.isEmpty(dEdto.getBasemean())) {
            filter +=" and s.basemean >="+dEdto.getBasemean();
        }
        if (!StringUtils.isEmpty(dEdto.getLog1())&&!StringUtils.isEmpty(dEdto.getLog2())) {
            filter += " and (s.log2foldchange >= "+dEdto.getLog2()+" or s.log2foldchange <="+dEdto.getLog1() + ")";
        }else if (!StringUtils.isEmpty(dEdto.getLog1())) {
            filter += " and s.log2foldchange <= "+dEdto.getLog1();
        }else if (!StringUtils.isEmpty(dEdto.getLog2())) {
            filter += " and s.log2foldchange >= "+dEdto.getLog2();
        }

        return filter;
    }
}
