package com.ngdc.lncbookexpression.dao.TemporalExpression;

import com.ngdc.lncbookexpression.model.TemporalExpression.DeColorectalNormal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeColorectalNormalRepository extends JpaRepository<DeColorectalNormal,String> {
    List<DeColorectalNormal> findByGeneid(String geneid);
    List<DeColorectalNormal> findBySymbolLike(String symbol);

    @Query(value ="select distinct u.symbol from de_colorectal_normal u where u.symbol like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from de_colorectal_normal u where u.geneid like %?1% limit 0,10 ", nativeQuery = true)
    List<String> findGeneid(String geneid);

}
