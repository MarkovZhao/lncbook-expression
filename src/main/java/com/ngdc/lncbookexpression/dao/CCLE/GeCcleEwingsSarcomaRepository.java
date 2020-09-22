package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleEwingsSarcoma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleEwingsSarcomaRepository extends JpaRepository<GeCcleEwingsSarcoma,String> {
    List<GeCcleEwingsSarcoma> findByGeneid(String geneid);
}
