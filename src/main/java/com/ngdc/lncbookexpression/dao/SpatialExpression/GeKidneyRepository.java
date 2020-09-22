package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeKidney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeKidneyRepository extends JpaRepository <GeKidney, String> {
    List<GeKidney> findByGeneid(String geneid);
}
