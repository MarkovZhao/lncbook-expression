package com.ngdc.lncbookexpression.dao;

import com.ngdc.lncbookexpression.model.TimeFeatured;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.List;

public interface TimeFeaturedRepository extends JpaRepository<TimeFeatured,String> {
    List<TimeFeatured> findByGeneid(String geneid);
}
