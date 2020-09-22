package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleLusc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleLuscRepository extends JpaRepository<GeCcleLusc,String> {
    List<GeCcleLusc> findByGeneid(String geneid);
}
