package com.ngdc.lncbookexpression.dao;

import ch.qos.logback.core.boolex.EvaluationException;
import com.ngdc.lncbookexpression.model.CoExpression.CeBrain;
import com.ngdc.lncbookexpression.model.Interaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface InteractionRepository extends PagingAndSortingRepository<Interaction,String> {
    List<Interaction> findAll();
    Page<Interaction> findByGeneid(String geneid, Pageable pageable);
    Page<Interaction> findByLncname(String geneid, Pageable pageable);
    Page<Interaction> findByPcg(String geneid, Pageable pageable);
    Page<Interaction> findByPcgname(String pcg_name, Pageable pageable);

    @Query(value ="select distinct u.geneid from interaction u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncid(String geneid);
    @Query(value ="select distinct u.lncname from interaction u where u.lncname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findLncname(String geneid);
    @Query(value ="select distinct u.pcg from interaction u where u.pcg like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgid(String geneid);
    @Query(value ="select distinct u.pcgname from interaction u where u.pcgname like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findPcgname(String geneid);
}
