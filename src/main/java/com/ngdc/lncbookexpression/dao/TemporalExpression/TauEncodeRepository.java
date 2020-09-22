package com.ngdc.lncbookexpression.dao.TemporalExpression;

import com.ngdc.lncbookexpression.model.TemporalExpression.TauEncode;
import com.ngdc.lncbookexpression.model.TemporalExpression.TauHpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TauEncodeRepository extends JpaRepository<TauEncode,String> {
    List<TauEncode> findByGeneid(String geneid);
    List<TauEncode> findBySymbolLike(String symbol);

    @Query(value ="select distinct u.max_name from tau_encode u order by u.max_name asc", nativeQuery = true)
    List<String> findname();

    @Query(value ="select distinct u.symbol from tau_encode u where u.symbol like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from tau_encode u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findGeneid(String geneid);
}
