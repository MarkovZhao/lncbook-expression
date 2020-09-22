package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeCcle;
import com.ngdc.lncbookexpression.model.CoExpression.CeHeart;
import com.ngdc.lncbookexpression.model.CoExpression.CeHpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import java.util.List;

public interface CeHeartRepository extends JpaRepository<CeHeart,String> {
    List<CeHeart> findAll();
    Page<CeHeart> findByGeneid(String geneid, Pageable pageable);
    Page<CeHeart> findByLncname(String geneid, Pageable pageable);
    Page<CeHeart> findByPcg(String geneid, Pageable pageable);
    Page<CeHeart> findByPcgname(String pcg_name, Pageable pageable);

    Page<CeHeart> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CeHeart> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CeHeart> findByDistanceAfter(float a, Pageable pageable);
    Page<CeHeart> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_heart u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_heart u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_heart u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_heart u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
