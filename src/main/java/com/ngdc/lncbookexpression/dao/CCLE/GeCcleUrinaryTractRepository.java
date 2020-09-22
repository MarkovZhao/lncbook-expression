package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleUrinaryTract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleUrinaryTractRepository extends JpaRepository<GeCcleUrinaryTract,String> {
    List<GeCcleUrinaryTract> findByGeneid(String geneid);
}
