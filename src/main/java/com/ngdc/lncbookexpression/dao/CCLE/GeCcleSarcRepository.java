package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleSarc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleSarcRepository extends JpaRepository<GeCcleSarc,String> {
    List<GeCcleSarc> findByGeneid(String geneid);
}
