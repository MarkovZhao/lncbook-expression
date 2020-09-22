package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleUcec;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleUcecRepository extends JpaRepository<GeCcleUcec,String> {
    List<GeCcleUcec> findByGeneid(String geneid);
}
