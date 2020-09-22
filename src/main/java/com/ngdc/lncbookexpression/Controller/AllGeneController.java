package com.ngdc.lncbookexpression.Controller;

import com.ngdc.lncbookexpression.convert.List2Select;
import com.ngdc.lncbookexpression.dao.FeaturedAllRepository;
import com.ngdc.lncbookexpression.dao.GeneInfoRepository;
import com.ngdc.lncbookexpression.model.FeaturedAll;
import com.ngdc.lncbookexpression.model.GeneInfo;
import com.ngdc.lncbookexpression.model.Interaction;
import com.ngdc.lncbookexpression.view.FeaturedVO;
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
@RequestMapping("/all")
public class AllGeneController {
    @Autowired
    GeneInfoRepository geneInfoRepository;
    @RequestMapping(value = "/lncall")
    @ResponseBody
    public Map lncrnas(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(Sort.Order.asc("geneid")));
        Page<GeneInfo> result = geneInfoRepository.findAll(pageable);
        Map map = new HashMap();
        map.put("total",result.getTotalElements());
        map.put("geneinfo",result.getContent());
        map.put("page",page);
        return map;

    }

    @RequestMapping("/geneid")
    public FeaturedVO featuredgene(String term) {
        FeaturedVO featuredVO = new FeaturedVO();
        List<GeneInfo> geneInfo = geneInfoRepository.findBySourceid(term);
        featuredVO.setGeneinfo(geneInfo);
        return featuredVO;
    }

    @RequestMapping("/symbol")
    public FeaturedVO featuredsymbol(String term) {
        FeaturedVO featuredVO = new FeaturedVO();
        List<GeneInfo> geneInfo = geneInfoRepository.findBySymbolLike("%"+term+"%");
        featuredVO.setGeneinfo(geneInfo);
        return featuredVO;
    }

    @RequestMapping("/classification")
    public Map classification(@RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "size",defaultValue = "10") int size,
                                  String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<GeneInfo> result = geneInfoRepository.findByClassification(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneinfo",result.getContent());
        return map;
    }


    @RequestMapping("/chromosome")
    public Map chromosome(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10") int size,
                              String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<GeneInfo> result = geneInfoRepository.findByChromosome(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneinfo",result.getContent());
        return map;
    }

    @RequestMapping("/symlist")
    public Map<String, Object> symlist(@RequestParam("type") String type){
        List<String> list = geneInfoRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/geneidlist")
    public Map<String, Object> genelist(@RequestParam("type") String type){
        List<String> list = geneInfoRepository.findSourceid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/chromosomelist")
    public Map<String, Object> chromosomelist(@RequestParam("type") String type){
        List<String> list = geneInfoRepository.findChromosome(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/classificationlist")
    public Map<String, Object> classificationlist(@RequestParam("type") String type){
        List<String> list = geneInfoRepository.findClassification(type);
        return List2Select.convert(list);
    }
}
