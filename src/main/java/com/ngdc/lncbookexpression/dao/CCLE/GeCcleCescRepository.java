package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleCesc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleCescRepository extends JpaRepository<GeCcleCesc,String> {
    List<GeCcleCesc> findByGeneid(String geneid);
}
