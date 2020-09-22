package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleLihc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleLihcRepository extends JpaRepository<GeCcleLihc,String> {
    List<GeCcleLihc> findByGeneid(String geneid);
}
