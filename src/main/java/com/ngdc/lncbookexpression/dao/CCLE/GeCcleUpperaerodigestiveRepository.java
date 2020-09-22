package com.ngdc.lncbookexpression.dao.CCLE;

import com.ngdc.lncbookexpression.model.CCLE.GeCcleUpperaerodigestive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeCcleUpperaerodigestiveRepository extends JpaRepository<GeCcleUpperaerodigestive,String> {
    List<GeCcleUpperaerodigestive> findByGeneid(String geneid);
}
