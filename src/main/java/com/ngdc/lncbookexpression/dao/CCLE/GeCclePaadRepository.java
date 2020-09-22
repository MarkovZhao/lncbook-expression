package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCclePaad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCclePaadRepository extends JpaRepository<GeCclePaad,String> {
    List<GeCclePaad> findByGeneid(String geneid);
}
