package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleGiantcell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleGiantCellRepository extends JpaRepository<GeCcleGiantcell,String> {
    List<GeCcleGiantcell> findByGeneid(String geneid);
}
