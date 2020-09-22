package com.ngdc.lncbookexpression.dao.TemporalExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.FtSrp011546;
import com.ngdc.lncbookexpression.model.TemporalExpression.TauSrp011546;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FtSrp011546Repository extends JpaRepository<FtSrp011546,String> {
    List<FtSrp011546> findByGeneid(String geneid);
    @Query(value ="select distinct u.max_name from ft_srp011546 u order by u.max_name asc", nativeQuery = true)
    List<String> findname();

    @Query(value ="select distinct u.symbol from ft_srp011546 u where u.symbol like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from ft_srp011546 u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findGeneid(String geneid);
}
