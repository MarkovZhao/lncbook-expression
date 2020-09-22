package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeEncode;
import com.ngdc.lncbookexpression.model.CoExpression.CeHpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CeEncodeRepository extends JpaRepository<CeEncode,String> {
    List<CeEncode> findAll();
    Page<CeEncode> findByGeneid(String geneid, Pageable pageable);
    Page<CeEncode> findByLncname(String geneid, Pageable pageable);
    Page<CeEncode> findByPcg(String geneid,Pageable pageable);
    Page<CeEncode> findByPcgname(String pcg_name, Pageable pageable);

    Page<CeEncode> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CeEncode> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CeEncode> findByDistanceAfter(float a, Pageable pageable);
    Page<CeEncode> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_encode u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_encode u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_encode u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_encode u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
