package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleLuad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleLuadRepository extends JpaRepository<GeCcleLuad,String> {
    List<GeCcleLuad> findByGeneid(String geneid);
}
