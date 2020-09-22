package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeLiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeLiverRepository extends JpaRepository <GeLiver, String> {
    List<GeLiver> findByGeneid(String geneid);
}
