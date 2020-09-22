package com.ngdc.lncbookexpression.dao.SpatialExpression;

import com.ngdc.lncbookexpression.model.SpatialExpression.GeExorbase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeExorbaseRepository extends JpaRepository <GeExorbase, String> {
    List <GeExorbase> findByGeneid(String geneid);
}
