package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleOvary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleOvaryRepository extends JpaRepository<GeCcleOvary,String> {
    List<GeCcleOvary> findByGeneid(String geneid);
}
