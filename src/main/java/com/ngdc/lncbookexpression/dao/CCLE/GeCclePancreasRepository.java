package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCclePancreas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCclePancreasRepository extends JpaRepository<GeCclePancreas,String> {
    List<GeCclePancreas> findByGeneid(String geneid);
}
