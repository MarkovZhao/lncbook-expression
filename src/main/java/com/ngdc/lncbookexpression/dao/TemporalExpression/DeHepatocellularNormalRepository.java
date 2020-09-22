package com.ngdc.lncbookexpression.dao.TemporalExpression;

import com.ngdc.lncbookexpression.model.TemporalExpression.DeEsccControl;
import com.ngdc.lncbookexpression.model.TemporalExpression.DeHepatocellularNormal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeHepatocellularNormalRepository extends JpaRepository<DeHepatocellularNormal,String> {
    List<DeHepatocellularNormal> findByGeneid(String geneid);

    List<DeHepatocellularNormal> findBySymbolLike(String symbol);

    @Query(value ="select distinct u.symbol from de_hepatocellular_normal u where u.symbol like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from de_hepatocellular_normal u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findGeneid(String geneid);
}
