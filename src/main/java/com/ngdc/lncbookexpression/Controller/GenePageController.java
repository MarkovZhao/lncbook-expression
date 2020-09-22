package com.ngdc.lncbookexpression.Controller;

import com.ngdc.lncbookexpression.dao.GeneInfoRepository;
import com.ngdc.lncbookexpression.model.GeneInfo;
import com.ngdc.lncbookexpression.service.imp.GenePageServiceImpl;
import com.ngdc.lncbookexpression.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/gene")
public class GenePageController {

    @Autowired
    GenePageServiceImpl genePageService;

    @RequestMapping("/info")
    public GeneInfoVO info(String geneid) {
        return genePageService.findGeneInfo(geneid);
    }


    @RequestMapping("/alternative")
    public GeneAlternativeVO alternative(String geneid) {
        return genePageService.findGeneAlternative(geneid);
    }

    @RequestMapping("/subcellular")
    public GESubcellularVO subcellular(String geneid) {
        return genePageService.findGESubcellular(geneid);
    }

    @RequestMapping("/hpa")
    public GEHpaVO geHpaVO(String geneid) {
        return genePageService.findGEHpa(geneid);
    }

    @RequestMapping("/encode")
    public GEEncodeVO geEncodeVO(String geneid) {
        return genePageService.findGEEncode(geneid);
    }

    @RequestMapping("/development")
    public TissueDeveVO tissuedevo(String geneid) {
        return genePageService.findGeTissueDEVO(geneid);
    }

    @RequestMapping("/preimplantation")
    public GePreimplantationVO gePreimplantationVO(String geneid) { return genePageService.findGePreimplantationVO(geneid); }

    @RequestMapping("/exosome")
    public GeExosomeVO geExosomeVO(String geneid) { return genePageService.findGeExosomeVO(geneid); }

    @RequestMapping("/differentiation")
    public GEDifferentiationVO geDifferentiationVO(String geneid) {return genePageService.findGEDifferentiationVO(geneid); }

    @RequestMapping("/ccle")
    public GECellVO geCellVO(String geneid) {
        return genePageService.findGECellVO(geneid);
    }

    @RequestMapping("/circadian")
    public GECircadianVO geCircadianVO(String geneid) {
        return genePageService.findGECircadianVO(geneid);
    }

    @RequestMapping("/virus")
    public GEVirusVO geVirusVO(String geneid) {
        return genePageService.findGEVirusVO(geneid);
    }


}

