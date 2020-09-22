package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeBrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeBrainRepository extends JpaRepository <GeBrain, String> {
    List <GeBrain> findByGeneid(String geneid);
}
