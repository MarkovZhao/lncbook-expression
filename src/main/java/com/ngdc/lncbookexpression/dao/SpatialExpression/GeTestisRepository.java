package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeTestis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeTestisRepository extends JpaRepository <GeTestis,String> {
    List <GeTestis> findByGeneid(String geneid);
}
