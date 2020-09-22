package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleGbm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleGbmRepository extends JpaRepository<GeCcleGbm,String> {
    List<GeCcleGbm> findByGeneid(String geneid);
}
