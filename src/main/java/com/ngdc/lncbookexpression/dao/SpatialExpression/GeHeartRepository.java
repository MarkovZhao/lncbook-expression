package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeHeart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeHeartRepository extends JpaRepository <GeHeart, String>{
    List<GeHeart> findByGeneid(String geneid);
}
