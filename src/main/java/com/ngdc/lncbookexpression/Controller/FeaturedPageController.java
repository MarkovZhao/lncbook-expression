package com.ngdc.lncbookexpression.Controller;

import com.ngdc.lncbookexpression.dao.LiteratureRepository;
import com.ngdc.lncbookexpression.dao.SpatialExpression.FeaturedRepository;
import com.ngdc.lncbookexpression.dto.Spatialdto;
import com.ngdc.lncbookexpression.dto.Temporaldto;
import com.ngdc.lncbookexpression.model.Featured;
import com.ngdc.lncbookexpression.model.Literature;
import com.ngdc.lncbookexpression.service.FeaturedPageService;
import com.ngdc.lncbookexpression.service.SpatialService;
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
import java.util.Map;

@RestController
@RequestMapping("/featured")
public class FeaturedPageController {
    @Autowired
    FeaturedPageService featuredPageService;
    @Autowired
    FeaturedRepository featuredRepository;
    @Autowired
    LiteratureRepository literatureRepository;
    @Autowired
    SpatialService spatialService;
    @RequestMapping(value = "/lncall")
    @ResponseBody
    public Map lncrnas(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(Sort.Order.asc("geneid")));
        Page<Featured> result = featuredRepository.findAll(pageable);
        Map map = new HashMap();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        map.put("page",page);
        return map;

    }

    @RequestMapping("/temporal")
    public Map temporalfilter(Temporaldto temporaldto, @RequestParam(value = "page",defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size,
                              @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                              @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return spatialService.searchTemporal(temporaldto,page,size,sortName,sortOrder);
    }

    @RequestMapping("/spatial")
    public Map spatialfilter(Spatialdto spatialdto, @RequestParam(value = "page",defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size,
                             @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                             @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return spatialService.searchSpatial(spatialdto,page,size,sortName,sortOrder);
    }

}
