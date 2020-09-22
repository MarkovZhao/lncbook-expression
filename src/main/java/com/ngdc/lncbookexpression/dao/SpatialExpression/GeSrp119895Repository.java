package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeSrp119895;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeSrp119895Repository extends JpaRepository<GeSrp119895,String> {
    List<GeSrp119895> findByGeneid(String geneid);
}
