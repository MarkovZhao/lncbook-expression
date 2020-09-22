package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeCcle;
import com.ngdc.lncbookexpression.model.CoExpression.CeHpa;
import com.ngdc.lncbookexpression.model.CoExpression.CeSars2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CeSars2Repository extends JpaRepository<CeSars2,String> {
    List<CeSars2> findAll();
    Page<CeSars2> findByGeneid(String geneid, Pageable pageable);
    Page<CeSars2> findByLncname(String geneid, Pageable pageable);
    Page<CeSars2> findByPcg(String geneid, Pageable pageable);
    Page<CeSars2> findByPcgname(String pcg_name, Pageable pageable);

    Page<CeSars2> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CeSars2> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CeSars2> findByDistanceAfter(float a, Pageable pageable);
    Page<CeSars2> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_sars2 u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_sars2 u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_sars2 u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_sars2 u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
