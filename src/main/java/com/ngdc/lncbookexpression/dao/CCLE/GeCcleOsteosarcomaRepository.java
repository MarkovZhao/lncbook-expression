package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleOsteosarcoma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleOsteosarcomaRepository extends JpaRepository<GeCcleOsteosarcoma,String> {
    List<GeCcleOsteosarcoma> findByGeneid(String geneid);
}
