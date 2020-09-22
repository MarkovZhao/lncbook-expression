package com.ngdc.lncbookexpression.dao.TemporalExpression;

import com.ngdc.lncbookexpression.model.TemporalExpression.DeColorectalNormal;
import com.ngdc.lncbookexpression.model.TemporalExpression.DeCoronaryNormal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeCoronaryNormalRepository extends JpaRepository<DeCoronaryNormal,String> {
    List<DeCoronaryNormal> findByGeneid(String geneid);

    List<DeCoronaryNormal> findBySymbolLike(String symbol);

    @Query(value ="select distinct u.symbol from de_coronary_normal u where u.symbol like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from de_coronary_normal u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findGeneid(String geneid);
}
