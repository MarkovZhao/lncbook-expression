package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleSkcm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleSkcmRepository extends JpaRepository<GeCcleSkcm,String> {
    List<GeCcleSkcm> findByGeneid(String geneid);
}
