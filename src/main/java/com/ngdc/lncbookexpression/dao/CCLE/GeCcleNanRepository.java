package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleNan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleNanRepository extends JpaRepository<GeCcleNan,String> {
    List<GeCcleNan> findByGeneid(String geneid);
}
