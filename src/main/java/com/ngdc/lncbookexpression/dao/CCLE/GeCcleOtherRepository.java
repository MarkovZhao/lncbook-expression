package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleOther;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleOtherRepository extends JpaRepository<GeCcleOther,String> {
    List<GeCcleOther> findByGeneid(String geneid);
}
