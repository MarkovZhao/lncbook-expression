package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleHnsc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleHnscRepository extends JpaRepository<GeCcleHnsc,String> {
    List<GeCcleHnsc> findByGeneid(String geneid);
}
