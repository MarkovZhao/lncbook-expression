package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCclePrad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCclePradRepository extends JpaRepository<GeCclePrad,String> {
    List<GeCclePrad> findByGeneid(String geneid);
}
