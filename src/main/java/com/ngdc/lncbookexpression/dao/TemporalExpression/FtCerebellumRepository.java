package com.ngdc.lncbookexpression.dao.TemporalExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.FtCerebellum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FtCerebellumRepository extends JpaRepository<FtCerebellum,String> {
    List<FtCerebellum> findByGeneid(String geneid);
    @Query(value ="select distinct u.max_name from ft_cerebellum u order by u.max_name asc,length (u.max_name) asc, u.max_name asc", nativeQuery = true)
    List<String> findname();

    @Query(value ="select distinct u.symbol from ft_cerebellum u where u.symbol like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from ft_cerebellum u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findGeneid(String geneid);
}
