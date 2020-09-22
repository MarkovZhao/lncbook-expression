package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleLungNsc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleLungNscRepository extends JpaRepository<GeCcleLungNsc,String> {
    List<GeCcleLungNsc> findByGeneid(String geneid);
}
