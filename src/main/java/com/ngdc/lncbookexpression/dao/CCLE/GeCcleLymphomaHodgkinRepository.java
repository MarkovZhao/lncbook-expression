package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleLymphomaHodgkin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleLymphomaHodgkinRepository extends JpaRepository<GeCcleLymphomaHodgkin,String> {
    List<GeCcleLymphomaHodgkin> findByGeneid(String geneid);
}
