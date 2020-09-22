package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeCerebellum;
import com.ngdc.lncbookexpression.model.CoExpression.CeCoronary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CeCoronaryRepository extends JpaRepository<CeCoronary,String> {
    List<CeCoronary> findAll();
    Page<CeCoronary> findByGeneid(String geneid, Pageable pageable);
    Page<CeCoronary> findByLncname(String geneid, Pageable pageable);
    Page<CeCoronary> findByPcg(String geneid, Pageable pageable);
    Page<CeCoronary> findByPcgname(String pcg_name, Pageable pageable);

    Page<CeCoronary> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CeCoronary> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CeCoronary> findByDistanceAfter(float a, Pageable pageable);
    Page<CeCoronary> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_coronary u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_coronary u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_coronary u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_coronary u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
