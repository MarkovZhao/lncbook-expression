package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleMesothelioma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleMesotheliomaRepository extends JpaRepository<GeCcleMesothelioma,String> {
    List<GeCcleMesothelioma> findByGeneid(String geneid);
}
