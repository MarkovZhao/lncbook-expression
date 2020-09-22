package com.ngdc.lncbookexpression.dao;

import com.ngdc.lncbookexpression.model.GeneAlternative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneAlternativeRepository extends JpaRepository<GeneAlternative,String> {
    List<GeneAlternative> findByGeneid(String geneid);
}
