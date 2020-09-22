package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeCerebellum;
import com.ngdc.lncbookexpression.model.CoExpression.CePancreatic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CePancreaticRepository extends JpaRepository<CePancreatic,String> {
    List<CePancreatic> findAll();
    Page<CePancreatic> findByGeneid(String geneid, Pageable pageable);
    Page<CePancreatic> findByLncname(String geneid, Pageable pageable);
    Page<CePancreatic> findByPcg(String geneid, Pageable pageable);
    Page<CePancreatic> findByPcgname(String pcg_name, Pageable pageable);

    Page<CePancreatic> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CePancreatic> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CePancreatic> findByDistanceAfter(float a, Pageable pageable);
    Page<CePancreatic> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_pancreatic u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_pancreatic u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_pancreatic u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_pancreatic u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
