package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleLymphomaOther;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleLymphomaOtherRepository extends JpaRepository<GeCcleLymphomaOther,String> {
    List<GeCcleLymphomaOther> findByGeneid(String geneid);
}
