package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleGlioma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleGliomaRepository extends JpaRepository<GeCcleGlioma,String> {
    List<GeCcleGlioma> findByGeneid(String geneid);
}
