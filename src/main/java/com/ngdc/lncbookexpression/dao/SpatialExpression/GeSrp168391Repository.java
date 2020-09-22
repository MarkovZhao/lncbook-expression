package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeBrain;
import com.ngdc.lncbookexpression.model.SpatialExpression.GeSrp168391;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeSrp168391Repository extends JpaRepository <GeSrp168391, String>{
    List<GeSrp168391> findByGeneid(String geneid);
}
