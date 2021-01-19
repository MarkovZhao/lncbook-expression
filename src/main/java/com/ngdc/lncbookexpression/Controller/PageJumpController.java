package com.ngdc.lncbookexpression.Controller;

import com.ngdc.lncbookexpression.service.CancerMapService;
import com.ngdc.lncbookexpression.service.GenePageService;
import com.ngdc.lncbookexpression.view.CancerVO;
import com.ngdc.lncbookexpression.view.CountryVO;
import com.ngdc.lncbookexpression.view.GeneInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PageJumpController {

    @Autowired
    private GenePageService genePageService;

    @Autowired
    private CancerMapService cancerMapService;

    @RequestMapping(value = "/gene")
    public ModelAndView gene(@RequestParam("geneid") String geneid, HttpSession httpSession) {

        GeneInfoVO geneInfo = genePageService.findGeneInfo(geneid);
        Map <String, Object> map = new HashMap<>();
        if (geneInfo == null) {
            map.put("url","./");
            return new ModelAndView("common/error",map);
        }
        else {
            map.put("geneid",geneid);
            return new ModelAndView("genepage",map);
        }

    }
    @RequestMapping({"/home","/"})
    public String home(){

        return "home";
    }

    @RequestMapping("/statistics")
    public String statistic(){

        return "statistic";
    }

    @RequestMapping("/genes")
    public String browse(){

        return "browse";
    }

    @RequestMapping("/help")
    public String help(){

        return "help";
    }

    @RequestMapping("/downloads")
    public String download(){

        return "download";
    }

    @RequestMapping("/contact")
    public String contact(){

        return "contact";
    }

    @RequestMapping("/blast")
    public String blast(){
        return "blast";
    }

    @RequestMapping("/featured")
    public String featured(){

        return "featured";
    }

    @RequestMapping("/development")
    public String development(){

        return "development";
    }

    @RequestMapping("/normal")
    public String hpa(){

        return "hpa";
    }

    @RequestMapping("/subcellular")
    public String subcellular(){

        return "subcellular";
    }

    @RequestMapping("/ccle")
    public String cell_line(){

        return "ccle";
    }

    @RequestMapping("/exosome")
    public String exosome(){

        return "exosome";
    }

    @RequestMapping("/virus")
    public String virus(){

        return "virus";
    }

    @RequestMapping("/differentiation")
    public String differentiation(){

        return "differentiation";
    }

    @RequestMapping("/circadian")
    public String circadian(){

        return "circadian";
    }

    @RequestMapping("/preimplantation")
    public String preimplantation(){

        return "preimplantation";
    }

    @RequestMapping("/allgene")
    public String all(){

        return "all";
    }

    @RequestMapping("/interactions")
    public String interaction(){

        return "interaction";
    }

    @RequestMapping("/capacity")
    public String profile(){

        return "capacity";
    }

    @RequestMapping(value = "/cancermap")
    public ModelAndView main(@RequestParam("country") String country,
                             @RequestParam("cancer") String cancer,HttpSession httpSession) {


        CountryVO countryVO = cancerMapService.findCountry(country);

        CancerVO cancerVO = cancerMapService.findCancer(cancer);
        Map <String, Object> map = new HashMap<>();
        if ((countryVO == null) || (cancerVO == null)){
            map.put("url","./");
            return new ModelAndView("common/error",map);
        }
        else {
            map.put("country",country);
            map.put("cancer",cancer);
            return new ModelAndView("countrypage",map);
        }

    }

    @RequestMapping("/cancermap/home")
    public String cancermap(){

        return "cancermap";
    }

    @RequestMapping("/cancermap/countrypage")
    public String country(){

        return "countrypage";
    }

    @RequestMapping("/cancermap/download")
    public String cmdownload(){
        return "cmdownload";
    }

    @RequestMapping("/cancermap/contact")
    public String cmcontact(){
        return "cmcontact";
    }
}
