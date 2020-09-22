package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeHpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeHpaRepository extends JpaRepository<GeHpa,String> {
    List<GeHpa> findByGeneid(String geneid);
}
