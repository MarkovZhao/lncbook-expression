package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleMb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleMbRepository extends JpaRepository<GeCcleMb,String> {
    List<GeCcleMb> findByGeneid(String geneid);
}
