package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleMm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleMmRepository extends JpaRepository<GeCcleMm,String> {
    List<GeCcleMm> findByGeneid(String geneid);
}
