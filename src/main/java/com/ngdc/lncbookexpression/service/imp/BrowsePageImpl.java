package com.ngdc.lncbookexpression.service.imp;

import com.ngdc.lncbookexpression.dao.GeneInfoRepository;
import com.ngdc.lncbookexpression.model.GeneInfo;
import com.ngdc.lncbookexpression.service.BrowsePageService;
import com.ngdc.lncbookexpression.view.GeneInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowsePageImpl implements BrowsePageService {

    @Autowired
    private GeneInfoRepository geneInfoRepository;

    @Override
    public GeneInfoVO findGeneInfo(String geneid) {

        GeneInfoVO geneInfoVO =new GeneInfoVO();
        List<GeneInfo> geneInfo = geneInfoRepository.findByGeneid(geneid);
        geneInfoVO.setGeneInfo(geneInfo);
        return geneInfoVO;

    }
}
