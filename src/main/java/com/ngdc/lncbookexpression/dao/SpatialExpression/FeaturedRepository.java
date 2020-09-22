package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.Featured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeaturedRepository extends JpaRepository<Featured, String> {
    List<Featured> findByGeneid(String geneid);
}
