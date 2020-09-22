package com.ngdc.lncbookexpression.dao.TemporalExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.FtSrp168391;
import com.ngdc.lncbookexpression.model.TemporalExpression.TauSrp168391;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FtSrp168391Repository extends JpaRepository<FtSrp168391,String> {
    List<FtSrp168391> findByGeneid(String geneid);
    @Query(value ="select distinct u.max_name from ft_srp168391 u order by length (u.max_name) asc, u.max_name asc", nativeQuery = true)
    List<String> findname();

    @Query(value ="select distinct u.symbol from ft_srp168391 u where u.symbol like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from ft_srp168391 u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findGeneid(String geneid);
}
