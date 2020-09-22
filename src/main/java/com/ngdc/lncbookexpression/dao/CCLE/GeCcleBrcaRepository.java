package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleBrca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleBrcaRepository extends JpaRepository<GeCcleBrca,String> {
    List<GeCcleBrca> findByGeneid(String geneid);
}
