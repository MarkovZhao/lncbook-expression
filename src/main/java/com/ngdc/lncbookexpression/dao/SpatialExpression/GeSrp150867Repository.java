package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeSrp150867;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeSrp150867Repository extends JpaRepository <GeSrp150867, String> {
    List <GeSrp150867> findByGeneid(String geneid);

}
