package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleThca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleThcaRepository extends JpaRepository<GeCcleThca,String> {
    List<GeCcleThca> findByGeneid(String geneid);
}
