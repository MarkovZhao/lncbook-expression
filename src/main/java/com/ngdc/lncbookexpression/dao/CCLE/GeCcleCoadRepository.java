package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleCoad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleCoadRepository extends JpaRepository<GeCcleCoad,String> {
    List<GeCcleCoad> findByGeneid(String geneid);
}
