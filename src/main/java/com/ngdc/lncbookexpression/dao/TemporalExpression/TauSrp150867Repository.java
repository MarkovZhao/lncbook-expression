package com.ngdc.lncbookexpression.dao.TemporalExpression;

import com.ngdc.lncbookexpression.model.TemporalExpression.TauSrp150867;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TauSrp150867Repository extends JpaRepository<TauSrp150867,String> {
    List<TauSrp150867> findByGeneid(String geneid);
    List<TauSrp150867> findAll();
}
