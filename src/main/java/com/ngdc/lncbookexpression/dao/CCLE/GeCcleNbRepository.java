package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleNb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleNbRepository extends JpaRepository<GeCcleNb,String> {
    List<GeCcleNb> findByGeneid(String geneid);
}
