package com.ngdc.lncbookexpression.dao;

import com.ngdc.lncbookexpression.model.GeneInfo;
import com.ngdc.lncbookexpression.model.GeneInfoTrick;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneInfoTrickRepository extends JpaRepository<GeneInfoTrick,String> {
    List<GeneInfoTrick> findAll();
    Page<GeneInfoTrick> findByGeneid(String geneid, Pageable pageable);
    Page<GeneInfoTrick> findByClassification(String classification, Pageable pageable);
    Page<GeneInfoTrick> findByChromosome(String chromosome, Pageable pageable);

}
