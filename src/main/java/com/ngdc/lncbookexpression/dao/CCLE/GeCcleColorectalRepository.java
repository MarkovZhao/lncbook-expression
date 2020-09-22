package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleColorectal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleColorectalRepository extends JpaRepository<GeCcleColorectal,String> {
    List<GeCcleColorectal> findByGeneid(String geneid);
}
