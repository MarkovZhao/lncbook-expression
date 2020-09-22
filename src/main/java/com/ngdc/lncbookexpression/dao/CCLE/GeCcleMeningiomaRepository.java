package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleMeningioma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleMeningiomaRepository extends JpaRepository<GeCcleMeningioma,String> {
    List<GeCcleMeningioma> findByGeneid(String geneid);
}
