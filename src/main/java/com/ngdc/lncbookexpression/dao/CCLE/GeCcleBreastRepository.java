package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleBileDuct;
import com.ngdc.lncbookexpression.model.CCLE.GeCcleBreast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleBreastRepository extends JpaRepository<GeCcleBreast,String> {
    List<GeCcleBreast> findByGeneid(String geneid);
}
