package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleLeukemiaother;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleLeukemiaotherRepository extends JpaRepository<GeCcleLeukemiaother,String> {
    List<GeCcleLeukemiaother> findByGeneid(String geneid);
}
