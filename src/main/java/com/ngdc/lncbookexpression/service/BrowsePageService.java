package com.ngdc.lncbookexpression.service;

import com.ngdc.lncbookexpression.model.GeneInfo;
import com.ngdc.lncbookexpression.view.GeneInfoVO;

public interface BrowsePageService {
    GeneInfoVO findGeneInfo(String geneid);

}
