package com.ngdc.lncbookexpression.service.imp;

import com.ngdc.lncbookexpression.dao.CancerMap.CmRepository;
import com.ngdc.lncbookexpression.model.CancerMap.Cm;
import com.ngdc.lncbookexpression.service.CancerMapService;
import com.ngdc.lncbookexpression.view.CancerAllVO;
import com.ngdc.lncbookexpression.view.CancerVO;
import com.ngdc.lncbookexpression.view.CountryVO;
import com.ngdc.lncbookexpression.view.DeathRankVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancerMapServiceImpl implements CancerMapService {
    @Autowired
    CmRepository cmRepository;

    @Override
    public CancerVO findCancer(String cancer) {

        CancerVO cancerVO = new CancerVO();
        List<Cm> cm = cmRepository.findByCancer(cancer);
        System.out.println(cm);
        cancerVO.setCm(cm);
        return cancerVO;
    }

    @Override
    public CountryVO findCountry(String country) {

        CountryVO countryVO = new CountryVO();
        List<Cm> cm = cmRepository.findByCountry(country);
        System.out.println(cm);
        countryVO.setCm(cm);
        return countryVO;
    }

    @Override
    public DeathRankVO findDeathrank(String deathrank) {

        DeathRankVO deathRankVO = new DeathRankVO();
        List<Cm> cm = cmRepository.findByDeathrank(deathrank);
        deathRankVO.setCm(cm);
        return deathRankVO;
    }

    @Override
    public CancerAllVO findAll() {

        CancerAllVO cancerAllVO = new CancerAllVO();
        List<Cm> cm = cmRepository.findAll();
        cancerAllVO.setCm(cm);
        return cancerAllVO;
    }
}
