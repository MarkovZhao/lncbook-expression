package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeCcle;
import com.ngdc.lncbookexpression.model.CoExpression.CeHpa;
import com.ngdc.lncbookexpression.model.CoExpression.CeSrp061636;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CeSrp061636Repository extends JpaRepository<CeSrp061636,String> {
    List<CeSrp061636> findAll();
    Page<CeSrp061636> findByGeneid(String geneid, Pageable pageable);
    Page<CeSrp061636> findByLncname(String geneid, Pageable pageable);
    Page<CeSrp061636> findByPcg(String geneid, Pageable pageable);
    Page<CeSrp061636> findByPcgname(String pcg_name, Pageable pageable);

    Page<CeSrp061636> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CeSrp061636> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CeSrp061636> findByDistanceAfter(float a, Pageable pageable);
    Page<CeSrp061636> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_srp061636 u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_srp061636 u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_srp061636 u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_srp061636 u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
