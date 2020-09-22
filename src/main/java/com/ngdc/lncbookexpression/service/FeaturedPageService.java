package com.ngdc.lncbookexpression.service;

import com.ngdc.lncbookexpression.view.FeaturedVO;
import com.ngdc.lncbookexpression.view.LiteratureVO;

public interface FeaturedPageService {
    FeaturedVO findGeneInfo(String geneid);
    LiteratureVO findLiteratureVO(String geneid);
}
