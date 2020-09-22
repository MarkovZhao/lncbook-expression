package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleBileDuct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleBileDuctRepository extends JpaRepository<GeCcleBileDuct,String> {
    List<GeCcleBileDuct> findByGeneid(String geneid);
}
