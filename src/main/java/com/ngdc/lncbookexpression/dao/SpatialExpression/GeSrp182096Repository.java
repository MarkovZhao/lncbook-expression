package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeSrp182096;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeSrp182096Repository extends JpaRepository<GeSrp182096,String> {
    List<GeSrp182096> findByGeneid(String geneid);
}
