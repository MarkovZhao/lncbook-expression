package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleEsca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleEscaRepository extends JpaRepository<GeCcleEsca,String> {
    List<GeCcleEsca> findByGeneid(String geneid);
}
