package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleMelanoma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleMelanomaRepository extends JpaRepository<GeCcleMelanoma,String> {
    List<GeCcleMelanoma> findByGeneid(String geneid);
}
