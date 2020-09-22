package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeBrain;
import com.ngdc.lncbookexpression.model.CoExpression.CeCcle;
import com.ngdc.lncbookexpression.model.CoExpression.CeHpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CeBrainRepository extends JpaRepository<CeBrain,String> {
    List<CeBrain> findAll();
    Page<CeBrain> findByGeneid(String geneid, Pageable pageable);
    Page<CeBrain> findByLncname(String geneid, Pageable pageable);
    Page<CeBrain> findByPcg(String geneid, Pageable pageable);
    Page<CeBrain> findByPcgname(String pcg_name, Pageable pageable);

    Page<CeBrain> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CeBrain> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CeBrain> findByDistanceAfter(float a, Pageable pageable);
    Page<CeBrain> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_brain u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_brain u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_brain u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_brain u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
