package com.ngdc.lncbookexpression.Controller;

import com.alibaba.fastjson.JSON;
import com.ngdc.lncbookexpression.dao.TemporalExpression.*;
import com.ngdc.lncbookexpression.dto.DEdto;
import com.ngdc.lncbookexpression.dto.HKTSdto;
import com.ngdc.lncbookexpression.dto.Patterndto;
import com.ngdc.lncbookexpression.service.BrowseService;
import com.ngdc.lncbookexpression.service.DownloadService;
import org.apache.tomcat.util.json.JSONParser;

import org.json.JSONArray;
import org.json.CDL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;


@RestController
@RequestMapping("/download")
public class DownloadController {

    @Autowired
    DownloadService downloadService;
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
    public String hpa(HKTSdto hktSdto, @RequestParam(value = "page",defaultValue = "0") int page,
                   @RequestParam(value = "size", defaultValue = "10") int size,
                   @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                   @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchHKTS(hktSdto,page,size,"tau_hpa",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchHKTS(hktSdto,page,size,"tau_hpa",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/encode")
    @ResponseBody
    public String encode(HKTSdto hktSdto, @RequestParam(value = "page",defaultValue = "0") int page,
                      @RequestParam(value = "size", defaultValue = "10") int size,
                      @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                      @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchHKTS(hktSdto,page,size,"tau_encode",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchHKTS(hktSdto,page,size,"tau_encode",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/ccle")
    @ResponseBody
    public String ccle(HKTSdto hktSdto, @RequestParam(value = "page",defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size,
                         @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                         @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchHKTS(hktSdto,page,size,"tau_ccle",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchHKTS(hktSdto,page,size,"tau_ccle",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/brain")
    @ResponseBody
    public String brain(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size,
                        @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                        @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchPattern(patterndto,page,size,"ft_brain",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchPattern(patterndto,page,size,"ft_brain",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/cerebellum")
    @ResponseBody
    public String cerebellum(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size,
                        @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                        @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchPattern(patterndto,page,size,"ft_cerebellum",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchPattern(patterndto,page,size,"ft_cerebellum",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/heart")
    @ResponseBody
    public String heart(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size,
                             @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                             @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchPattern(patterndto,page,size,"ft_heart",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchPattern(patterndto,page,size,"ft_heart",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/kidney")
    @ResponseBody
    public String kidney(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size,
                        @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                        @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchPattern(patterndto,page,size,"ft_kidney",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchPattern(patterndto,page,size,"ft_kidney",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/liver")
    @ResponseBody
    public String liver(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size,
                         @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                         @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchPattern(patterndto,page,size,"ft_liver",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchPattern(patterndto,page,size,"ft_liver",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/ovary")
    @ResponseBody
    public String ovary(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size,
                        @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                        @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchPattern(patterndto,page,size,"ft_ovary",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchPattern(patterndto,page,size,"ft_ovary",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/testis")
    @ResponseBody
    public String testis(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size,
                        @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                        @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchPattern(patterndto,page,size,"ft_testis",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchPattern(patterndto,page,size,"ft_testis",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/preimplantation1")
    @ResponseBody
    public String preimplantation1(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size,
                         @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                         @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchPattern(patterndto,page,size,"ft_srp011546",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchPattern(patterndto,page,size,"ft_srp011546",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/preimplantation2")
    @ResponseBody
    public String preimplantation2(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "10") int size,
                                   @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                   @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchPattern(patterndto,page,size,"ft_srp061636",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchPattern(patterndto,page,size,"ft_srp061636",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/differentiation")
    @ResponseBody
    public String differentiation(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "10") int size,
                                   @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                   @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchPattern(patterndto,page,size,"ft_srp168391",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchPattern(patterndto,page,size,"ft_srp168391",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/colorectal")
    @ResponseBody
    public String colorectal(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "10") int size,
                                  @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                  @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchDE(dEdto,page,size,"de_colorectal_normal",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchDE(dEdto,page,size,"de_colorectal_normal",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/coronary")
    @ResponseBody
    public String coronary(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size,
                             @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                             @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchDE(dEdto,page,size,"de_colorectal_normal",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchDE(dEdto,page,size,"de_colorectal_normal",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/pancreatic")
    @ResponseBody
    public String pancreatic(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size,
                           @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                           @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchDE(dEdto,page,size,"de_pancreatic_normal",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchDE(dEdto,page,size,"de_pancreatic_normal",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/hepatocellular")
    @ResponseBody
    public String hepatocellular(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size,
                             @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                             @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchDE(dEdto,page,size,"de_hepatocellular_normal",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchDE(dEdto,page,size,"de_hepatocellular_normal",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/escc")
    @ResponseBody
    public String escc(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                 @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                 @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchDE(dEdto,page,size,"de_escc_normal",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchDE(dEdto,page,size,"de_escc_normal",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/hiv")
    @ResponseBody
    public String hiv(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                       @RequestParam(value = "size", defaultValue = "10") int size,
                       @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                       @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchDE(dEdto,page,size,"de_hiv_normal",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchDE(dEdto,page,size,"de_hiv_normal",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/hbv")
    @ResponseBody
    public String hbv(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                      @RequestParam(value = "size", defaultValue = "10") int size,
                      @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                      @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchDE(dEdto,page,size,"de_hbv_normal",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchDE(dEdto,page,size,"de_hbv_normal",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/hcv")
    @ResponseBody
    public String hcv(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                      @RequestParam(value = "size", defaultValue = "10") int size,
                      @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                      @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchDE(dEdto,page,size,"de_hcv_normal",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchDE(dEdto,page,size,"de_hcv_normal",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    @RequestMapping(value = "/sars2")
    @ResponseBody
    public String sars2(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                      @RequestParam(value = "size", defaultValue = "10") int size,
                      @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                      @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {

        System.out.println(downloadService.searchDE(dEdto,page,size,"de_sars2_normal",sortName,sortOrder).get("geneInfo"));
        String json = JSON.toJSONString(downloadService.searchDE(dEdto,page,size,"de_sars2_normal",sortName,sortOrder).get("geneInfo"));
        System.out.println(json);
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }


}
