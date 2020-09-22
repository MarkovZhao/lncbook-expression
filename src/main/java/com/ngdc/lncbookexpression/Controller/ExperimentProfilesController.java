package com.ngdc.lncbookexpression.Controller;

import com.ngdc.lncbookexpression.convert.List2Select;
import com.ngdc.lncbookexpression.dao.ExperimentProfileRepository;
import com.ngdc.lncbookexpression.dto.Featuredto;
import com.ngdc.lncbookexpression.model.ExperimentProfile;
import com.ngdc.lncbookexpression.model.Featured;
import com.ngdc.lncbookexpression.model.GeneInfo;
import com.ngdc.lncbookexpression.service.BrowseService;
import com.ngdc.lncbookexpression.service.imp.GenePageServiceImpl;
import com.ngdc.lncbookexpression.view.ExpressionLevelVO;
import com.ngdc.lncbookexpression.view.FeaturedVO;
import com.ngdc.lncbookexpression.view.GeneInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class ExperimentProfilesController {
    @Autowired
    ExperimentProfileRepository experimentProfileRepository;
    @Autowired
    BrowseService browseService;
    @Autowired
    GenePageServiceImpl genePageService;

    @RequestMapping(value = "/allprofile")
    @ResponseBody
    public Map allprofile(Featuredto featuredto, @RequestParam(value = "page",defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size,
                        @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                        @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchFeature(featuredto,page,size,"experiment_profile",sortName,sortOrder);
    }

    @RequestMapping("/level")
    public ExpressionLevelVO expressionLevelVO(String geneid) {
        return genePageService.findExpressionLevelVO(geneid);
    }

    @RequestMapping("/symbol")
    public FeaturedVO featuredsymbol(String term) {
        FeaturedVO featuredVO = new FeaturedVO();
        List<ExperimentProfile> experimentProfile = experimentProfileRepository.findBySymbolLike("%"+term+"%");
        featuredVO.setGeneinfo(experimentProfile);
        return featuredVO;
    }

    @RequestMapping("/classification")
    public Map classification(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10") int size,
                              String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<ExperimentProfile> experimentProfile = experimentProfileRepository.findByClassification(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",experimentProfile.getTotalElements());
        map.put("geneinfo",experimentProfile.getContent());
        return map;
    }

    @RequestMapping("/symlist")
    public Map<String, Object> symlist(@RequestParam("type") String type){
        List<String> list = experimentProfileRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/geneidlist")
    public Map<String, Object> genelist(@RequestParam("type") String type){
        List<String> list = experimentProfileRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/classificationidlist")
    public Map<String, Object> classificationlist(@RequestParam("type") String type){
        List<String> list = experimentProfileRepository.findClassification(type);
        return List2Select.convert(list);
    }
}
