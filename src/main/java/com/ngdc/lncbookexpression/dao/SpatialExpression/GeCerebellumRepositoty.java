package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeCerebellum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCerebellumRepositoty extends JpaRepository <GeCerebellum, String>{
    List <GeCerebellum> findByGeneid(String geneid);
}
