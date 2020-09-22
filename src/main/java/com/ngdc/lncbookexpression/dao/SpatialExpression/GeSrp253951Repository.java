package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeSrp253951;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeSrp253951Repository extends JpaRepository<GeSrp253951,String> {
    List<GeSrp253951> findByGeneid(String geneid);
}
