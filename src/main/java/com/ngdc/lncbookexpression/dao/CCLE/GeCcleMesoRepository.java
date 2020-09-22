package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleMeso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleMesoRepository extends JpaRepository<GeCcleMeso,String> {
    List<GeCcleMeso> findByGeneid(String geneid);
}
