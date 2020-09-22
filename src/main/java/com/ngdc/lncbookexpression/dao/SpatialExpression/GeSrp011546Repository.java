package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeSrp011546;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeSrp011546Repository extends JpaRepository<GeSrp011546,String> {
    List<GeSrp011546> findByGeneid(String geneid);
}
