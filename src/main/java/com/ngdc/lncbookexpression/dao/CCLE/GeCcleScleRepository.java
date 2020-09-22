package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleSclc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleScleRepository extends JpaRepository<GeCcleSclc,String> {
    List<GeCcleSclc> findByGeneid(String geneid);
}
