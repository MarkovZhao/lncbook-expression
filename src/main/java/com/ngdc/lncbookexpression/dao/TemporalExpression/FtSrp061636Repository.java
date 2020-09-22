package com.ngdc.lncbookexpression.dao.TemporalExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.FtSrp061636;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FtSrp061636Repository extends JpaRepository<FtSrp061636,String> {
    List<FtSrp061636> findByGeneid(String geneid);
    @Query(value ="select distinct u.max_name from ft_srp061636 u order by u.max_name asc", nativeQuery = true)
    List<String> findname();

    @Query(value ="select distinct u.symbol from ft_srp061636 u where u.symbol like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from ft_srp061636 u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findGeneid(String geneid);
}
