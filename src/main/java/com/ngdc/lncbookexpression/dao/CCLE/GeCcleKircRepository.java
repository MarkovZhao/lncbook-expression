package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleKirc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleKircRepository extends JpaRepository<GeCcleKirc,String> {
    List<GeCcleKirc> findByGeneid(String geneid);
}
