package com.ngdc.lncbookexpression.service;

import com.ngdc.lncbookexpression.model.GeneInfo;
import com.ngdc.lncbookexpression.view.*;

import java.util.List;

public interface CancerMapService {
    CancerVO findCancer(String cancer);

    CountryVO findCountry(String country);

    DeathRankVO findDeathrank(String deathrank);

    CancerAllVO findAll();
}
