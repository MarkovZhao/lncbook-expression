package com.ngdc.lncbookexpression.Controller;

import com.alibaba.fastjson.JSON;
import com.ngdc.lncbookexpression.convert.List2Select;
import com.ngdc.lncbookexpression.dao.CancerMap.CmRepository;
import com.ngdc.lncbookexpression.dto.Cmdto;
import com.ngdc.lncbookexpression.dto.DEdto;
import com.ngdc.lncbookexpression.service.CancerMapService;
import com.ngdc.lncbookexpression.service.CmDownloadService;
import com.ngdc.lncbookexpression.view.CancerAllVO;
import com.ngdc.lncbookexpression.view.CancerVO;
import com.ngdc.lncbookexpression.view.CountryVO;
import com.ngdc.lncbookexpression.view.DeathRankVO;
import org.json.CDL;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cancermap/browse")
public class CmController {
    @Autowired
    CancerMapService cancerMapService;

    @Autowired
    CmDownloadService cmDownloadService;

    @Autowired
    CmRepository cmRepository;

    @RequestMapping("/all")
    public CancerAllVO cancerall() {
        return  cancerMapService.findAll();
    }

    @RequestMapping("/cancer")
    public CancerVO cancer(String cancer) {
        return cancerMapService.findCancer(cancer);
    }

    @RequestMapping("/country")
    public CountryVO country(String country) {
        return cancerMapService.findCountry(country);
    }


    @RequestMapping("/deathrank")
    public DeathRankVO deathrank(String deathrank) {
        return cancerMapService.findDeathrank(deathrank);
    }

    @RequestMapping("/cancerlist")
    public Map<String, Object> cancerlist(@RequestParam("type") String type){
        List<String> list = cmRepository.findCancer(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/countrylist")
    public Map<String, Object> countrylist(@RequestParam("type") String type){
        List<String> list = cmRepository.findCountry(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/download")
    @ResponseBody
    public String download(Cmdto cmdto, @RequestParam(value = "sortName",defaultValue = "country") String sortName,
                   @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
//        return cmDownloadService.searchCancerMap(cmdto,sortName,sortOrder);

        String json = JSON.toJSONString(cmDownloadService.searchCancerMap(cmdto,sortName,sortOrder).get("cm"));
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        System.out.println(csv);
        return csv;
    }
}
