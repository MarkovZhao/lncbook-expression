package com.ngdc.lncbookexpression.dao.CancerMap;

import com.ngdc.lncbookexpression.model.CancerMap.Cm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CmRepository extends JpaRepository<Cm,String> {
    List<Cm> findAll();
    List<Cm> findByCancer(String cancer);
    List<Cm> findByCountry(String country);
    List<Cm> findByContinent(String continent);
    List<Cm> findByDeathrank(String deathrank);


    @Query(value ="select distinct u.cancer from cm u where u.cancer like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findCancer(String symbol);

    @Query(value ="select distinct u.country from cm u where u.country like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findCountry(String symbol);
}
