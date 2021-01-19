package com.ngdc.lncbookexpression.Controller;

import com.alibaba.fastjson.JSON;
import com.ngdc.lncbookexpression.dao.CoExpression.*;
import com.ngdc.lncbookexpression.dao.InteractionRepository;
import com.ngdc.lncbookexpression.model.CoExpression.CeBrain;
import com.ngdc.lncbookexpression.service.BrowseService;
import org.json.CDL;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/download/ce")
public class DownloadCEController {
    @Autowired
    CeBrainRepository ceBrainRepository;
    @Autowired
    CeCerebellumRepository ceCerebellumRepository;
    @Autowired
    CeHeartRepository ceHeartRepository;
    @Autowired
    CeKidneyRepository ceKidneyRepository;
    @Autowired
    CeLiverRepository ceLiverRepository;
    @Autowired
    CeOvaryRepository ceOvaryRepository;
    @Autowired
    CeTestisRepository ceTestisRepository;
    @Autowired
    CeSrp011546Repository ceSrp011546Repository;
    @Autowired
    CeSrp061636Repository ceSrp061636Repository;
    @Autowired
    BrowseService browseService;
    @Autowired
    CeHpaRepository ceHpaRepository;
    @Autowired
    CeEncodeRepository ceEncodeRepository;
    @Autowired
    CeCcleRepository ceCcleRepository;
    @Autowired
    CeSubcellularRepository ceSubcellularRepository;
    @Autowired
    CeSrp168391Repository ceSrp168391Repository;
    @Autowired
    CeColorectalRepository ceColorectalRepository;
    @Autowired
    CeCoronaryRepository ceCoronaryRepository;
    @Autowired
    CeHepatocellularRepository ceHepatocellularRepository;
    @Autowired
    CePancreaticRepository cePancreaticRepository;
    @Autowired
    CeEsccRepository ceEsccRepository;
    @Autowired
    CeHbvRepository ceHbvRepository;
    @Autowired
    CeSars2Repository ceSars2Repository;

    @Autowired
    InteractionRepository interactionRepository;


    @RequestMapping("/brainbylncid")
    public Map brainbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeBrain> result = ceBrainRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

}
