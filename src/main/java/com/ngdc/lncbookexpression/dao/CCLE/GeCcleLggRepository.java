package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleLgg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleLggRepository extends JpaRepository<GeCcleLgg,String> {
    List<GeCcleLgg> findByGeneid(String geneid);
}
