package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleLcml;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleLcmlRepository extends JpaRepository<GeCcleLcml,String> {
    List<GeCcleLcml> findByGeneid(String geneid);
}
