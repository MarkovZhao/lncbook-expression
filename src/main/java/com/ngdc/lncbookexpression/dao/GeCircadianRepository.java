package com.ngdc.lncbookexpression.dao;

import com.ngdc.lncbookexpression.model.GeCircadian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCircadianRepository extends JpaRepository<GeCircadian,String> {
    List<GeCircadian> findByGeneid(String geneid);
}
