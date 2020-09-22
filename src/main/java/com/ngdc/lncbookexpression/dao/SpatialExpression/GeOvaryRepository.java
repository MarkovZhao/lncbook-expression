package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeOvary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeOvaryRepository extends JpaRepository<GeOvary,String> {
    List<GeOvary> findByGeneid(String geneid);
}
