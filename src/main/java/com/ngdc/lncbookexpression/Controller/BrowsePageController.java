package com.ngdc.lncbookexpression.Controller;

import com.ngdc.lncbookexpression.convert.*;
import com.ngdc.lncbookexpression.dao.FeaturedAllRepository;
import com.ngdc.lncbookexpression.dao.GeneInfoRepository;
import com.ngdc.lncbookexpression.dao.SearchRepository;
import com.ngdc.lncbookexpression.dto.DEdto;
import com.ngdc.lncbookexpression.dto.Featuredto;
import com.ngdc.lncbookexpression.model.*;
import com.ngdc.lncbookexpression.service.BrowseService;
import com.ngdc.lncbookexpression.service.imp.GenePageServiceImpl;
import com.ngdc.lncbookexpression.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/browse")
public class BrowsePageController {
    @Autowired
    GeneInfoRepository geneInfoRepository;
    @Autowired
    FeaturedAllRepository featuredAllRepository;
    @Autowired
    SearchRepository searchRepository;
    @Autowired
    GenePageServiceImpl genePageService;
    @Autowired
    BrowseService browseService;

    @RequestMapping(value = "/lncall")
    @ResponseBody
//    public Map lncrnas() {
//        List<FeaturedAll> featuredAll = featuredAllRepository.findAll();
//        Map map = new HashMap();
//        map.put("geneinfo",featuredAll);
//        return map;
//    }
    public Map featured(Featuredto featuredto, @RequestParam(value = "page",defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size,
                        @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                        @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchFeature(featuredto,page,size,"featured_all",sortName,sortOrder);
    }

    @RequestMapping("/geneid")
    public FeaturedVO featuredgene(String term) {
        FeaturedVO featuredVO = new FeaturedVO();
        List<FeaturedAll> featuredAll = featuredAllRepository.findByGeneid(term);
        featuredVO.setGeneinfo(featuredAll);
        return featuredVO;
    }

    @RequestMapping("/classification")
    public Map featured_classification(@RequestParam(value = "page",defaultValue = "1") int page,
                                       @RequestParam(value = "size",defaultValue = "10") int size,
                                       String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<FeaturedAll> featuredAll = featuredAllRepository.findByClassification(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",featuredAll.getTotalElements());
        map.put("geneinfo",featuredAll.getContent());
        return map;
    }

    @RequestMapping("/symbol")
    public FeaturedVO featuredsymbol(String term) {
        FeaturedVO featuredVO = new FeaturedVO();
        List<FeaturedAll> featuredAll = featuredAllRepository.findBySymbolLike("%"+term+"%");
        featuredVO.setGeneinfo(featuredAll);
        return featuredVO;
    }


    @RequestMapping("/chromosome")
    public Map chromosome( @RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10")int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size,Sort.by(Sort.Order.asc("geneid")));
        Page<FeaturedAll> result = featuredAllRepository.findByClassification(term,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneinfo",result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/symlist")
    public Map<String, Object> symlist(@RequestParam("type") String type){
        List<String> list = featuredAllRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/geneidlist")
    public Map<String, Object> genelist(@RequestParam("type") String type){
        List<String> list = featuredAllRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/classificationlist")
    public Map<String, Object> classificationlist2(@RequestParam("type") String type){
        List<String> list = featuredAllRepository.findClassification(type);
        return List2Select.convert(list);
    }


    @RequestMapping("/search")
    public Map<String, Object> search(@RequestParam("type") String type){
        List<String> geneid = searchRepository.findSourceid(type);
        List<String> symbol = searchRepository.findSymbol(type);
        List<String> transcriptid = searchRepository.findTranscriptid(type);
        List<Map<String,Object>> maps = new ArrayList<>();
        maps.addAll(Gene2Select.convert(geneid));
        maps.addAll(Symbol2Select.convert(symbol));
        maps.addAll(Trans2Select.convert(transcriptid));

        Map<String, Object> result = new HashMap<>();
        result.put("results", maps);
        return result;
    }

    @RequestMapping("/searchgene")
    public SearchVO searchVO(String geneid) {
        return genePageService.findGeneVO(geneid);
    }

    @RequestMapping("/searchsymbol")
    public SearchSymbolVO searchSymbolVO(String symbol) {
        return genePageService.findSymbolVO(symbol);
    }

    @RequestMapping("/searchtranscript")
    public SearchTranscriptVO searchTranscriptVO(String transcriptid) {
        return genePageService.findTranscriptVO(transcriptid);
    }
}
