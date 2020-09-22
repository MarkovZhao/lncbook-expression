package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleBlca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleBlcaRepository extends JpaRepository<GeCcleBlca,String> {
    List<GeCcleBlca> findByGeneid(String geneid);
}
