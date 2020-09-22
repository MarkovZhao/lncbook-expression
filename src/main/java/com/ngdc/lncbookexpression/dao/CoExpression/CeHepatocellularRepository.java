package com.ngdc.lncbookexpression.dao.CoExpression;

import com.ngdc.lncbookexpression.model.CoExpression.CeCerebellum;
import com.ngdc.lncbookexpression.model.CoExpression.CeHepatocellular;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CeHepatocellularRepository extends JpaRepository<CeHepatocellular,String> {
    List<CeHepatocellular> findAll();
    Page<CeHepatocellular> findByGeneid(String geneid, Pageable pageable);
    Page<CeHepatocellular> findByLncname(String geneid, Pageable pageable);
    Page<CeHepatocellular> findByPcg(String geneid, Pageable pageable);
    Page<CeHepatocellular> findByPcgname(String pcg_name, Pageable pageable);

    Page<CeHepatocellular> findByPccBetweenAndPvalueBetweenAndDistanceBetween(float a, float b, float c, float d, float e, float f, Pageable pageable);

    Page<CeHepatocellular> findByDistanceBetween(float a, float b, Pageable pageable);
    Page<CeHepatocellular> findByDistanceAfter(float a, Pageable pageable);
    Page<CeHepatocellular> findByDistanceBefore(float a, Pageable pageable);

    @Query(value ="select distinct u.geneid from ce_hepatocellular u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from ce_hepatocellular u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from ce_hepatocellular u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from ce_hepatocellular u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
