package com.ngdc.lncbookexpression.dao.TemporalExpression;

import com.ngdc.lncbookexpression.model.TemporalExpression.TauSubcellular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TauSubcellularRepository extends JpaRepository<TauSubcellular,String> {
    List<TauSubcellular> findByGeneid(String geneid);

    @Query(value ="select distinct u.max_name from tau_subcellular u", nativeQuery = true)
    List<String> findname();
}
