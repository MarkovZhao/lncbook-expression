package com.ngdc.lncbookexpression.dao;

import com.ngdc.lncbookexpression.model.ExperimentProfile;
import com.ngdc.lncbookexpression.model.FeaturedAll;
import com.ngdc.lncbookexpression.model.GeneInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeaturedAllRepository extends JpaRepository<FeaturedAll,String> {
    List<FeaturedAll> findByGeneid(String geneid);
    List<FeaturedAll> findBySymbolLike(String symbol);
    Page<FeaturedAll> findByClassification(String classification, Pageable pageable);
    List<FeaturedAll> findAll();

    Page<GeneInfo> findByGeneid(String geneid, Pageable pageable);

    @Query(value ="select distinct u.symbol from featured_all u where u.symbol like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from featured_all u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findGeneid(String geneid);

    @Query(value ="select distinct u.classification from featured_all u where u.classification like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findClassification(String geneid);

}
