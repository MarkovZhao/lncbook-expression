package com.ngdc.lncbookexpression.Controller;

import com.ngdc.lncbookexpression.convert.List2Select;
import com.ngdc.lncbookexpression.dao.CircadianRepository;
import com.ngdc.lncbookexpression.dao.TemporalExpression.*;
import com.ngdc.lncbookexpression.dto.CIdto;
import com.ngdc.lncbookexpression.dto.DEdto;
import com.ngdc.lncbookexpression.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/de")
public class DEController {

    @Autowired
    BrowseService browseService;
    @Autowired
    DeColorectalNormalRepository deColorectalNormalRepository;
    @Autowired
    DeCoronaryNormalRepository deCoronaryNormalRepository;
    @Autowired
    DePancreaticNormalRepository dePancreaticNormalRepository;
    @Autowired
    DeHepatocellularNormalRepository deHepatocellularNormalRepository;
    @Autowired
    DeEsccControlRepository deEsccControlRepository;
    @Autowired
    DeHivNormalRepository deHivNormalRepository;
    @Autowired
    DeHbvNormalRepository deHbvNormalRepository;
    @Autowired
    DeHcvNormalRepository deHcvNormalRepository;
    @Autowired
    DeSARS2NormalRepository deSARS2NormalRepository;
    @Autowired
    CircadianRepository circadianRepository;

    @RequestMapping(value = "/colorectal")
    @ResponseBody
    public Map colorectal(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size,
                          @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                          @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchDE(dEdto,page,size,"de_colorectal_normal",sortName,sortOrder);
    }

    @RequestMapping("/colorectal/geneidlist")
    public Map<String, Object> colorectalid(@RequestParam("type") String type){
        List<String> list = deColorectalNormalRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/colorectal/symbollist")
    public Map<String, Object> colorectalsymbol(@RequestParam("type") String type){
        List<String> list = deColorectalNormalRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/coronary")
    @ResponseBody
    public Map coronary(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size,
                          @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                          @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchDE(dEdto,page,size,"de_coronary_normal",sortName,sortOrder);
    }

    @RequestMapping("/coronary/geneidlist")
    public Map<String, Object> coronaryid(@RequestParam("type") String type){
        List<String> list = deCoronaryNormalRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/coronary/symbollist")
    public Map<String, Object> coronarysymbol(@RequestParam("type") String type){
        List<String> list = deCoronaryNormalRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/pancreatic")
    @ResponseBody
    public Map pancreatic(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size,
                        @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                        @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchDE(dEdto,page,size,"de_pancreatic_normal",sortName,sortOrder);
    }

    @RequestMapping("/pancreatic/geneidlist")
    public Map<String, Object> pancreaticid(@RequestParam("type") String type){
        List<String> list = dePancreaticNormalRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/pancreatic/symbollist")
    public Map<String, Object> pancreaticysymbol(@RequestParam("type") String type){
        List<String> list = dePancreaticNormalRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/hepatocellular")
    @ResponseBody
    public Map hepatocellular(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size,
                          @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                          @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchDE(dEdto,page,size,"de_hepatocellular_normal",sortName,sortOrder);
    }

    @RequestMapping("/hepatocellular/geneidlist")
    public Map<String, Object> hepatocellularid(@RequestParam("type") String type){
        List<String> list = deHepatocellularNormalRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hepatocellular/symbollist")
    public Map<String, Object> hepatocellularsymbol(@RequestParam("type") String type){
        List<String> list = deHepatocellularNormalRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/escc")
    @ResponseBody
    public Map escc(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size,
                              @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                              @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchDE(dEdto,page,size,"de_escc_control",sortName,sortOrder);
    }

    @RequestMapping("/escc/geneidlist")
    public Map<String, Object> esccid(@RequestParam("type") String type){
        List<String> list = deEsccControlRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/escc/symbollist")
    public Map<String, Object> esccsymbol(@RequestParam("type") String type){
        List<String> list = deEsccControlRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/hiv")
    @ResponseBody
    public Map hiv(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                    @RequestParam(value = "size", defaultValue = "10") int size,
                    @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                    @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchDE(dEdto,page,size,"de_hiv_normal",sortName,sortOrder);
    }

    @RequestMapping("/hiv/geneidlist")
    public Map<String, Object> hivid(@RequestParam("type") String type){
        List<String> list = deHivNormalRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hiv/symbollist")
    public Map<String, Object> hivsymbol(@RequestParam("type") String type){
        List<String> list = deHivNormalRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/hbv")
    @ResponseBody
    public Map hbv(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                   @RequestParam(value = "size", defaultValue = "10") int size,
                   @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                   @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchDE(dEdto,page,size,"de_hbv_normal",sortName,sortOrder);
    }

    @RequestMapping("/hbv/geneidlist")
    public Map<String, Object> hbvid(@RequestParam("type") String type){
        List<String> list = deHbvNormalRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hbv/symbollist")
    public Map<String, Object> hbvsymbol(@RequestParam("type") String type){
        List<String> list = deHbvNormalRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/hcv")
    @ResponseBody
    public Map hcv(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                   @RequestParam(value = "size", defaultValue = "10") int size,
                   @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                   @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchDE(dEdto,page,size,"de_hcv_normal",sortName,sortOrder);
    }

    @RequestMapping("/hcv/geneidlist")
    public Map<String, Object> hcvid(@RequestParam("type") String type){
        List<String> list = deHcvNormalRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hcv/symbollist")
    public Map<String, Object> hcvsymbol(@RequestParam("type") String type){
        List<String> list = deHcvNormalRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/sars2")
    @ResponseBody
    public Map sars2(DEdto dEdto, @RequestParam(value = "page",defaultValue = "0") int page,
                   @RequestParam(value = "size", defaultValue = "10") int size,
                   @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                   @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchDE(dEdto,page,size,"de_sars2_normal",sortName,sortOrder);
    }

    @RequestMapping("/sars2/geneidlist")
    public Map<String, Object> sars2id(@RequestParam("type") String type){
        List<String> list = deHcvNormalRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/sars2/symbollist")
    public Map<String, Object> sars2symbol(@RequestParam("type") String type){
        List<String> list = deHcvNormalRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/circadian")
    @ResponseBody
    public List circadian(CIdto cIdto, @RequestParam(value = "page",defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size,
                          @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                          @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchCI(cIdto,page,size,"circadian",sortName,sortOrder);
    }

    @RequestMapping("/circadian/geneidlist")
    public Map<String, Object> circadianid(@RequestParam("type") String type){
        List<String> list = circadianRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/circadian/symbollist")
    public Map<String, Object> circadiansymbol(@RequestParam("type") String type){
        List<String> list = circadianRepository.findSymbol(type);
        return List2Select.convert(list);
    }

}
