package com.ngdc.lncbookexpression.service;

import com.ngdc.lncbookexpression.convert.*;
import com.ngdc.lncbookexpression.dto.*;
import com.ngdc.lncbookexpression.model.Circadian;
import com.ngdc.lncbookexpression.model.CoExpression.CeBrain;
import com.ngdc.lncbookexpression.model.Featured;
import com.ngdc.lncbookexpression.model.FeaturedAll;
import com.ngdc.lncbookexpression.model.Interaction;
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
public class BrowseService {
    @PersistenceContext
    private EntityManager em;
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

        if(page <= ((total_size/size)-1)) {
            patternBrain = PatternConversion.convert(objects.subList(page * size, page * size + size));
        }else{
            patternBrain = PatternConversion.convert(objects.subList(page * size, total_size));
        }
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

    public Map searchDE(DEdto dEdto, int page, int size, String name,String sortName, String sortOrder) {
        Map map = new HashMap();
        String select = "select * from " + name + " s where ";
        String filter= DEFilter(dEdto);
        select += filter + " order by ABS(" + sortName +") "+  sortOrder;
        System.out.println(select);
        Query query = em.createNativeQuery(select);
        List<Object> objects = query.getResultList();
        int total_size = objects.size();
        List<DeColorectalNormal> deColorectalNormal= null;

        if(page <= ((total_size/size)-1)) {
            deColorectalNormal = DEConversion.convert(objects.subList(page * size, page * size + size));
        }else{
            deColorectalNormal = DEConversion.convert(objects.subList(page * size, total_size));
        }
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
        if(page <= ((total_size/size)-1)) {
            tauBrain = HKTSConversion.convert(objects.subList(page * size, page * size + size));
        }else{
            tauBrain = HKTSConversion.convert(objects.subList(page * size, total_size));
        }
        map.put("total",total_size);
        map.put("geneInfo", tauBrain);
        map.put("page", page);
        return map;
    }

    public List searchSubcellular(HKTSdto hktSdto, int page, int size, String name, String sortName, String sortOrder) {
        Map map = new HashMap();
        String select = "select * from " + name + " s where ";
        String filter= HKTSFilter(hktSdto);
        select += filter + " order by ABS(" + sortName +") "+  sortOrder;
        System.out.println(select);
        Query query = em.createNativeQuery(select);
        List<Object> objects = query.getResultList();
        int total_size = objects.size();
        List<TauBrain> tauBrain= null;
        tauBrain = HKTSConversion.convert(objects);
        return tauBrain;
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

    public Map searchCE(CEdto cEdto, int page, int size, String name) {
        Map map = new HashMap();
        String select = "select * from " + name + " s where ";
        String filter= CEFilter(cEdto);
        select += filter;
        System.out.println(select);
        Query query = em.createNativeQuery(select);
        List<Object> objects = query.getResultList();
        int total_size = objects.size();
        List<Interaction> interaction= null;
        if (total_size!=1) {
            if (page <= ((total_size / size) - 1)) {
                interaction = CEConversion.convert(objects.subList(page * size, page * size + size));
            } else {
                interaction = CEConversion.convert(objects.subList(page * size, total_size));
            }
        }
        else if (total_size==1) {
            interaction = CEConversion.convert(objects.subList(0,1));
        }

        map.put("total",total_size);
        map.put("geneInfo", interaction);
        map.put("page", page);
        return map;
    }

    public String CEFilter(CEdto cEdto){
        String filter="1=1";
        if (!StringUtils.isEmpty(cEdto.getGeneid())){
            filter += " and s.geneid =" + cEdto.getGeneid();
        }
        if (!StringUtils.isEmpty(cEdto.getLncname())) {
            filter +=" and s.lncname ="+cEdto.getLncname();
        }
        if (!StringUtils.isEmpty(cEdto.getPcg())) {
            filter +=" and s.pcg ="+cEdto.getPcg();
        }
        if (!StringUtils.isEmpty(cEdto.getPcgname())) {
            filter +=" and s.pcgname ="+cEdto.getPcgname();
        }
        if (!StringUtils.isEmpty(cEdto.getPcc())) {
            filter +=" and s.pcc >="+cEdto.getPcc();
        }
        if (!StringUtils.isEmpty(cEdto.getPvalue())) {
            filter +=" and s.pvalue <="+cEdto.getPvalue();
        }
        if (!StringUtils.isEmpty(cEdto.getMin_dis())) {
            if (Float.parseFloat(cEdto.getMin_dis()) == -1) {
                filter += " and s.distance <= " + cEdto.getMin_dis();
            } else if (Float.parseFloat(cEdto.getMin_dis()) == -2) {
                filter += " and s.distance >= 0";
            }
        }
        if (!StringUtils.isEmpty(cEdto.getMin_dis())&&!StringUtils.isEmpty(cEdto.getMax_dis())) {
            filter += " and s.distance >= "+cEdto.getMin_dis()+" and s.distance <="+cEdto.getMax_dis();
        }else if (!StringUtils.isEmpty(cEdto.getMin_dis())) {
            filter += " and s.distance >= "+cEdto.getMin_dis();
        }else if (!StringUtils.isEmpty(cEdto.getMax_dis())) {
            filter += " and s.distance <= "+cEdto.getMax_dis();
        }
        return filter;
    }

    public List searchCI(CIdto cIdto, int page, int size, String name, String sortName, String sortOrder) {
        Map map = new HashMap();
        String select = "select * from " + name + " s where ";
        String filter= CIFilter(cIdto);
        select += filter + " order by ABS(" + sortName +") "+  sortOrder;
        System.out.println(select);
        Query query = em.createNativeQuery(select);
        List<Object> objects = query.getResultList();
        int total_size = objects.size();
        List<Circadian> circadian= null;
        circadian = CIConversion.convert(objects);
        return circadian;
    }

    public String CIFilter(CIdto cIdto){
        String filter="1=1";
        if (!StringUtils.isEmpty(cIdto.getGeneid())){
            filter += " and s.geneid =" + cIdto.getGeneid();
        }
        if (!StringUtils.isEmpty(cIdto.getJtk_pvalue())) {
            filter +=" and s.jtk_pvalue ="+cIdto.getJtk_pvalue();
        }
        if (!StringUtils.isEmpty(cIdto.getJtk_bhq())) {
            filter +=" and s.jtk_bhq ="+cIdto.getJtk_bhq();
        }
        if (!StringUtils.isEmpty(cIdto.getJtk_period())) {
            filter +=" and s.jtk_period ="+cIdto.getJtk_period();
        }
        return filter;
    }

    public Map searchFeature(Featuredto featuredto, int page, int size, String name, String sortName, String sortOrder) {
        Map map = new HashMap();
        String select = "select * from " + name + " s where ";
        String filter= FeatureFilter(featuredto);
        select += filter + " order by ABS(" + sortName +") "+  sortOrder;
        System.out.println(select);
        Query query = em.createNativeQuery(select);
        List<Object> objects = query.getResultList();
        int total_size = objects.size();
        List<FeaturedAll> featuredall = null;
        if(page <= ((total_size/size)-1)) {
            featuredall = FeatureConversion.convert(objects.subList(page * size, page * size + size));
        }else{
            featuredall = FeatureConversion.convert(objects.subList(page * size, total_size));
        }
        map.put("total",total_size);
        map.put("geneInfo", featuredall);
        map.put("page", page);
        return map;
    }

    public String FeatureFilter(Featuredto featuredto){
        String filter="1=1";
        if (!StringUtils.isEmpty(featuredto.getGeneid())){
            filter += " and s.geneid =" + featuredto.getGeneid();
        }
        if (!StringUtils.isEmpty(featuredto.getSymbol())) {
            filter +=" and s.symbol ="+featuredto.getSymbol();
        }
        if (!StringUtils.isEmpty(featuredto.getClassification())) {
            filter +=" and s.classification ="+featuredto.getClassification();
        }
        if ((!StringUtils.isEmpty(featuredto.getNormal()))&&((!featuredto.getNormal().equals("'NA'")))) {
            System.out.println(featuredto.getNormal());
            filter +=" and s.normal ="+featuredto.getNormal();
        }
        if ((!StringUtils.isEmpty(featuredto.getDevelopment()))&&((!featuredto.getDevelopment().equals("'NA'")))) {
            filter +=" and s.development ="+featuredto.getDevelopment();
        }
        if ((!StringUtils.isEmpty(featuredto.getPreimplantation()))&&((!featuredto.getPreimplantation().equals("'NA'")))) {
            filter +=" and s.preimplantation ="+featuredto.getPreimplantation();
        }
        if ((!StringUtils.isEmpty(featuredto.getDifferentiation()))&&((!featuredto.getDifferentiation().equals("'NA'")))) {
            filter +=" and s.differentiation ="+featuredto.getDifferentiation();
        }
        if ((!StringUtils.isEmpty(featuredto.getSubcellular()))&&((!featuredto.getSubcellular().equals("'NA'")))) {
            filter +=" and s.subcellular ="+featuredto.getSubcellular();
        }
        if ((!StringUtils.isEmpty(featuredto.getExosome()))&&((!featuredto.getExosome().equals("'NA'")))) {
            filter +=" and s.exosome ="+featuredto.getExosome();
        }
        if ((!StringUtils.isEmpty(featuredto.getVirus()))&&((!featuredto.getVirus().equals("'NA'")))) {
            filter +=" and s.virus ="+featuredto.getVirus();
        }
        if ((!StringUtils.isEmpty(featuredto.getCcle()))&&((!featuredto.getCcle().equals("'NA'")))) {
            filter +=" and s.ccle ="+featuredto.getCcle();
        }
        if ((!StringUtils.isEmpty(featuredto.getCircadian()))&&((!featuredto.getCircadian().equals("'NA'")))) {
            filter +=" and s.circadian ="+featuredto.getCircadian();
        }
        return filter;
    }
}
