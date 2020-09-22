package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeEncode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeEncodeRepository extends JpaRepository<GeEncode,String> {
    List<GeEncode> findByGeneid(String geneid);
}
