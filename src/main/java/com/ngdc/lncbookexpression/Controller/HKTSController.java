package com.ngdc.lncbookexpression.Controller;

import com.ngdc.lncbookexpression.convert.List2Select;
import com.ngdc.lncbookexpression.dao.SpatialExpression.GeSrp150867Repository;
import com.ngdc.lncbookexpression.dao.TemporalExpression.*;
import com.ngdc.lncbookexpression.dto.HKTSdto;
import com.ngdc.lncbookexpression.dto.Patterndto;
import com.ngdc.lncbookexpression.model.TemporalExpression.TauCerebellum;
import com.ngdc.lncbookexpression.model.TemporalExpression.TauSrp150867;
import com.ngdc.lncbookexpression.model.TemporalExpression.TauSubcellular;
import com.ngdc.lncbookexpression.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hkts")
public class HKTSController {

    @Autowired
    BrowseService browseService;
    @Autowired
    TauHpaRepository tauHpaRepository;
    @Autowired
    TauEncodeRepository tauEncodeRepository;
    @Autowired
    TauSubcellularRepository tauSubcellularRepository;
    @Autowired
    TauSrp150867Repository tauSrp150867Repository;
    @Autowired
    TauCcleRepository tauCcleRepository;

    @RequestMapping(value = "/hpa")
    @ResponseBody
    public Map hpa(HKTSdto hktSdto, @RequestParam(value = "page",defaultValue = "0") int page,
                     @RequestParam(value = "size", defaultValue = "10") int size,
                     @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                     @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchHKTS(hktSdto,page,size,"tau_hpa",sortName,sortOrder);
    }

    @RequestMapping(value = "/encode")
    @ResponseBody
    public Map encode(HKTSdto hktSdto, @RequestParam(value = "page",defaultValue = "0") int page,
                    @RequestParam(value = "size", defaultValue = "10") int size,
                    @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                    @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchHKTS(hktSdto,page,size,"tau_encode",sortName,sortOrder);
    }

    @RequestMapping(value = "/ccle")
    @ResponseBody
    public Map ccle(HKTSdto hktSdto, @RequestParam(value = "page",defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "10") int size,
                                   @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                   @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchHKTS(hktSdto,page,size,"tau_ccle",sortName,sortOrder);
    }

    @RequestMapping(value = "/subcellular")
    @ResponseBody
    public List subcellular(HKTSdto hktSdto, @RequestParam(value = "page",defaultValue = "0") int page,
                    @RequestParam(value = "size", defaultValue = "10") int size,
                    @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                    @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchSubcellular(hktSdto,page,size,"tau_subcellular",sortName,sortOrder);
    }

    @RequestMapping("/srp150867")
    public Map srp150867() {
        List<TauSrp150867> tauSrp150867 = tauSrp150867Repository.findAll();
        Map map = new HashMap();
        map.put("geneinfo",tauSrp150867);
        return map;
    }

    @RequestMapping("/srp150867byid")
    public Map srp150867bygeneid(String geneid) {
        List<TauSrp150867> tauSrp150867 = tauSrp150867Repository.findByGeneid(geneid);
        Map map = new HashMap();
        map.put("geneinfo",tauSrp150867);
        return map;
    }


    @RequestMapping("/hpa/tissuename")
    public Map<String, Object> hpa(){
        List<String> list = tauHpaRepository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/hpa/geneidlist")
    public Map<String, Object> hpaid(@RequestParam("type") String type){
        List<String> list = tauHpaRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hpa/symbollist")
    public Map<String, Object> hpasymbol(@RequestParam("type") String type){
        List<String> list = tauHpaRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/encode/tissuename")
    public Map<String, Object> encode(){
        List<String> list = tauEncodeRepository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/encode/geneidlist")
    public Map<String, Object> encodeid(@RequestParam("type") String type){
        List<String> list = tauEncodeRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/encode/symbollist")
    public Map<String, Object> encodesymbol(@RequestParam("type") String type){
        List<String> list = tauEncodeRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/subcellular/tissuename")
    public Map<String, Object> subcellular(){
        List<String> list = tauSubcellularRepository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/ccle/tissuename")
    public Map<String, Object> ccle(){
        List<String> list = tauCcleRepository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/ccle/geneidlist")
    public Map<String, Object> ccleid(@RequestParam("type") String type){
        List<String> list = tauCcleRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/ccle/symbollist")
    public Map<String, Object> cclesymbol(@RequestParam("type") String type){
        List<String> list = tauCcleRepository.findSymbol(type);
        return List2Select.convert(list);
    }

}
