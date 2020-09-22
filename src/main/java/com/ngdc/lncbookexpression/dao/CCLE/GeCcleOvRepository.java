package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleOv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleOvRepository extends JpaRepository<GeCcleOv,String> {
    List<GeCcleOv> findByGeneid(String geneid);
}
