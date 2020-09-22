package com.ngdc.lncbookexpression.service.imp;

import com.ngdc.lncbookexpression.dao.LiteratureRepository;
import com.ngdc.lncbookexpression.dao.SpatialExpression.FeaturedRepository;
import com.ngdc.lncbookexpression.model.Featured;
import com.ngdc.lncbookexpression.model.Literature;
import com.ngdc.lncbookexpression.service.FeaturedPageService;
import com.ngdc.lncbookexpression.view.FeaturedVO;
import com.ngdc.lncbookexpression.view.LiteratureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeaturedPageImpl implements FeaturedPageService {
    @Autowired
    FeaturedRepository featuredRepository;
    @Autowired
    LiteratureRepository literatureRepository;
    @Override
    public FeaturedVO findGeneInfo(String geneid) {

        FeaturedVO featuredVO = new FeaturedVO();
        List<Featured> featured = featuredRepository.findByGeneid(geneid);
        featuredVO.setFeatured(featured);
        return featuredVO;
    }
    @Override
    public LiteratureVO findLiteratureVO(String geneid) {
        LiteratureVO literatureVO = new LiteratureVO();
        List<Literature> literature = literatureRepository.findByGeneid(geneid);
        literatureVO.setLiterature(literature);
        return literatureVO;
    }
}
