package com.ngdc.lncbookexpression.dao;

import com.ngdc.lncbookexpression.model.SpatialFeatured;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpatialFeaturedRepository extends JpaRepository<SpatialFeatured,String> {
    List<SpatialFeatured> findByGeneid(String geneid);
}
