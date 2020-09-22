package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeCcle;
import com.ngdc.lncbookexpression.model.CoExpression.CeHpa;
import com.ngdc.lncbookexpression.model.CoExpression.CeTestis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CeTestisRepository extends JpaRepository<CeTestis,String> {
    List<CeTestis> findAll();
    Page<CeTestis> findByGeneid(String geneid, Pageable pageable);
    Page<CeTestis> findByLncname(String geneid, Pageable pageable);
    Page<CeTestis> findByPcg(String geneid, Pageable pageable);
    Page<CeTestis> findByPcgname(String pcg_name, Pageable pageable);

    Page<CeTestis> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CeTestis> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CeTestis> findByDistanceAfter(float a, Pageable pageable);
    Page<CeTestis> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_testis u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_testis u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_testis u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_testis u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
