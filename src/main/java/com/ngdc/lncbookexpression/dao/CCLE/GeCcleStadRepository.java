package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleStad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleStadRepository extends JpaRepository<GeCcleStad,String> {
    List<GeCcleStad> findByGeneid(String geneid);
}
