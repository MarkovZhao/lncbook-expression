package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleDlbc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleDlbcRepository extends JpaRepository<GeCcleDlbc,String> {
    List<GeCcleDlbc> findByGeneid(String geneid);
}
