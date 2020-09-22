package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleSofttissue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleSofttissueRepository extends JpaRepository<GeCcleSofttissue,String> {
    List<GeCcleSofttissue> findByGeneid(String geneid);
}
