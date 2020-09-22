package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeSrp061636;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeSrp061636Repository extends JpaRepository <GeSrp061636, String>{
    List <GeSrp061636> findByGeneid(String geneid);
}
