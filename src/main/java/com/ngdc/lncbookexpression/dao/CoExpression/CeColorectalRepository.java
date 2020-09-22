package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeColorectal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CeColorectalRepository extends JpaRepository<CeColorectal,String> {
    List<CeColorectal> findAll();
    Page<CeColorectal> findByGeneid(String geneid, Pageable pageable);
    Page<CeColorectal> findByLncname(String geneid, Pageable pageable);
    Page<CeColorectal> findByPcg(String geneid, Pageable pageable);
    Page<CeColorectal> findByPcgname(String pcg_name, Pageable pageable);

    Page<CeColorectal> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CeColorectal> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CeColorectal> findByDistanceAfter(float a, Pageable pageable);
    Page<CeColorectal> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_colorectal u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_colorectal u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_colorectal u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_colorectal u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
