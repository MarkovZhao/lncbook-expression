package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleCll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleCllRepository extends JpaRepository<GeCcleCll,String> {
    List<GeCcleCll> findByGeneid(String geneid);
}
