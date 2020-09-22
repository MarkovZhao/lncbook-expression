package com.ngdc.lncbookexpression.dao;

import com.ngdc.lncbookexpression.model.GeneInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.List;

@Repository
public interface GeneInfoRepository extends JpaRepository<GeneInfo, String> {
    List<GeneInfo> findByGeneid(String geneid);
    List<GeneInfo> findBySourceid(String sourceid);
    List<GeneInfo> findBySymbolLike(String symbol);
    List<GeneInfo> findAll();
    Page<GeneInfo> findByGeneid(String geneid, Pageable pageable);
    Page<GeneInfo> findByClassification(String classification, Pageable pageable);
    Page<GeneInfo> findByChromosome(String chromosome, Pageable pageable);

    @Query(value ="select distinct u.symbol from gene_info u where u.symbol like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from gene_info u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findGeneid(String geneid);

    @Query(value ="select distinct u.sourceid from gene_info u where u.sourceid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSourceid(String geneid);

    @Query(value ="select distinct u.classification from gene_info u where u.classification like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findClassification(String geneid);

    @Query(value ="select distinct u.chromosome from gene_info u where u.chromosome like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findChromosome(String chromosome);
}
