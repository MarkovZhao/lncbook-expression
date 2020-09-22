package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeCcle;
import com.ngdc.lncbookexpression.model.CoExpression.CeHbv;
import com.ngdc.lncbookexpression.model.CoExpression.CeHpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CeHbvRepository extends JpaRepository<CeHbv,String> {
    List<CeHbv> findAll();
    Page<CeHbv> findByGeneid(String geneid, Pageable pageable);
    Page<CeHbv> findByLncname(String geneid, Pageable pageable);
    Page<CeHbv> findByPcg(String geneid, Pageable pageable);
    Page<CeHbv> findByPcgname(String pcg_name, Pageable pageable);

    Page<CeHbv> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CeHbv> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CeHbv> findByDistanceAfter(float a, Pageable pageable);
    Page<CeHbv> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_hbv u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_hbv u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_hbv u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_hbv u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
