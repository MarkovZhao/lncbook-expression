package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleAll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleAllRepository extends JpaRepository <GeCcleAll,String>{
    List<GeCcleAll> findByGeneid(String geneid);
}
