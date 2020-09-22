package com.ngdc.lncbookexpression.dao;

import com.ngdc.lncbookexpression.model.Literature;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LiteratureRepository extends JpaRepository<Literature,String> {
    List<Literature> findByGeneid(String geneid);
    Page<Literature> findByGeneid(String geneid, Pageable pageable);
}
