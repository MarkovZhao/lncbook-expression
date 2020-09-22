package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeCcle;
import com.ngdc.lncbookexpression.model.CoExpression.CeEncode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CeCcleRepository extends JpaRepository<CeCcle,String> {
    List<CeCcle> findAll();
    Page<CeCcle> findByGeneid(String geneid, Pageable pageable);
    Page<CeCcle> findByLncname(String geneid, Pageable pageable);
    Page<CeCcle> findByPcg(String geneid,Pageable pageable);
    Page<CeCcle> findByPcgname(String pcg_name, Pageable pageable);

    Page<CeCcle> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CeCcle> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CeCcle> findByDistanceAfter(float a, Pageable pageable);
    Page<CeCcle> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_ccle u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_ccle u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_ccle u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_ccle u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
