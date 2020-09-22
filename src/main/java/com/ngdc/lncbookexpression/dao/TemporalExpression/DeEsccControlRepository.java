package com.ngdc.lncbookexpression.dao.TemporalExpression;

import com.ngdc.lncbookexpression.model.TemporalExpression.DeCoronaryNormal;
import com.ngdc.lncbookexpression.model.TemporalExpression.DeEsccControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeEsccControlRepository extends JpaRepository <DeEsccControl,String> {
    List<DeEsccControl> findByGeneid(String geneid);

    List<DeEsccControl> findBySymbolLike(String symbol);

    @Query(value ="select distinct u.symbol from de_escc_control u where u.symbol like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from de_escc_control u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findGeneid(String geneid);
}
