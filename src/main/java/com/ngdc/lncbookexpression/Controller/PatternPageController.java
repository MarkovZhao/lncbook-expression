package com.ngdc.lncbookexpression.Controller;

import com.ngdc.lncbookexpression.convert.List2Select;
import com.ngdc.lncbookexpression.dao.TemporalExpression.*;
import com.ngdc.lncbookexpression.dto.Patterndto;
import com.ngdc.lncbookexpression.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pattern")
public class PatternPageController {
    @Autowired
    BrowseService browseService;

    @Autowired
    FtBrainRepository ftBrainRepository;
    @Autowired
    FtCerebellumRepository ftCerebellumRepository;
    @Autowired
    FtHeartRepository ftHeartRepository;
    @Autowired
    FtKidneyRepository ftKidneyRepository;
    @Autowired
    FtLiverRepository ftLiverRepository;
    @Autowired
    FtOvaryRepository ftOvaryRepository;
    @Autowired
    FtTestisRepository ftTestisRepository;
    @Autowired
    FtSrp011546Repository ftSrp011546Repository;
    @Autowired
    FtSrp061636Repository ftSrp061636Repository;
    @Autowired
    FtSrp168391Repository ftSrp168391Repository;

    @RequestMapping("/brain")
    public Map patternbrain(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size,
                             @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                             @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchPattern(patterndto,page,size,"ft_brain",sortName,sortOrder);
    }

    @RequestMapping(value = "/cerebellum")
    @ResponseBody
    public Map patterncerebellum(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                            @RequestParam(value = "size", defaultValue = "10") int size,
                            @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                            @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchPattern(patterndto,page,size,"ft_cerebellum",sortName,sortOrder);
    }


    @RequestMapping(value = "/heart")
    @ResponseBody
    public Map patternheart(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                 @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                 @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchPattern(patterndto,page,size,"ft_heart",sortName,sortOrder);
    }

    @RequestMapping(value = "/kidney")
    @ResponseBody
    public Map patternkidney(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                 @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                 @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchPattern(patterndto,page,size,"ft_kidney",sortName,sortOrder);
    }

    @RequestMapping(value = "/liver")
    @ResponseBody
    public Map patternliver(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                 @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                 @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchPattern(patterndto,page,size,"ft_liver",sortName,sortOrder);
    }

    @RequestMapping(value = "/ovary")
    @ResponseBody
    public Map patternovary(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                 @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                 @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchPattern(patterndto,page,size,"ft_ovary",sortName,sortOrder);
    }

    @RequestMapping(value = "/testis")
    @ResponseBody
    public Map patterntestis(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                 @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                 @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchPattern(patterndto,page,size,"ft_testis",sortName,sortOrder);
    }

    @RequestMapping(value = "/preimplantation1")
    @ResponseBody
    public Map patternpreimplantation1(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size,
                             @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                             @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchPattern(patterndto,page,size,"ft_srp011546",sortName,sortOrder);
    }

    @RequestMapping(value = "/preimplantation2")
    @ResponseBody
    public Map patternpreimplantation2(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                                       @RequestParam(value = "size", defaultValue = "10") int size,
                                       @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                       @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchPattern(patterndto,page,size,"ft_srp061636",sortName,sortOrder);
    }

    @RequestMapping(value = "/differentiation")
    @ResponseBody
    public Map differentiation(Patterndto patterndto, @RequestParam(value = "page",defaultValue = "0") int page,
                                       @RequestParam(value = "size", defaultValue = "10") int size,
                                       @RequestParam(value = "sortName",defaultValue = "geneid") String sortName,
                                       @RequestParam(value = "sortOrder",defaultValue = "asc") String sortOrder) {
        return browseService.searchPattern(patterndto,page,size,"ft_srp168391",sortName,sortOrder);
    }

    @RequestMapping("/brain/tissuename")
    public Map<String, Object> brain(){
        List<String> list = ftBrainRepository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/brain/geneidlist")
    public Map<String, Object> brainid(@RequestParam("type") String type){
        List<String> list = ftBrainRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/brain/symbollist")
    public Map<String, Object> brainsymbol(@RequestParam("type") String type){
        List<String> list = ftBrainRepository.findSymbol(type);
        return List2Select.convert(list);
    }


    @RequestMapping("/cerebellum/tissuename")
    public Map<String, Object> cerebellum(){
        List<String> list = ftCerebellumRepository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/cerebellum/geneidlist")
    public Map<String, Object> cerebellumid(@RequestParam("type") String type){
        List<String> list = ftCerebellumRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/cerebellum/symbollist")
    public Map<String, Object> cerebellumsymbol(@RequestParam("type") String type){
        List<String> list = ftCerebellumRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/heart/tissuename")
    public Map<String, Object> heart(){
        List<String> list = ftHeartRepository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/heart/geneidlist")
    public Map<String, Object> heartid(@RequestParam("type") String type){
        List<String> list = ftHeartRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/heart/symbollist")
    public Map<String, Object> heartsymbol(@RequestParam("type") String type){
        List<String> list = ftHeartRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/kidney/tissuename")
    public Map<String, Object> kidney(){
        List<String> list = ftKidneyRepository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/kidney/geneidlist")
    public Map<String, Object> kidneyid(@RequestParam("type") String type){
        List<String> list = ftKidneyRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/kidney/symbollist")
    public Map<String, Object> kidneysymbol(@RequestParam("type") String type){
        List<String> list = ftKidneyRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/liver/tissuename")
    public Map<String, Object> liver(){
        List<String> list = ftLiverRepository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/liver/geneidlist")
    public Map<String, Object> liverid(@RequestParam("type") String type){
        List<String> list = ftLiverRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/liver/symbollist")
    public Map<String, Object> liversymbol(@RequestParam("type") String type){
        List<String> list = ftLiverRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/ovary/tissuename")
    public Map<String, Object> ovary(){
        List<String> list = ftOvaryRepository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/ovary/geneidlist")
    public Map<String, Object> ovaryid(@RequestParam("type") String type){
        List<String> list = ftOvaryRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/ovary/symbollist")
    public Map<String, Object> ovarysymbol(@RequestParam("type") String type){
        List<String> list = ftOvaryRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/testis/tissuename")
    public Map<String, Object> testis(){
        List<String> list = ftTestisRepository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/testis/geneidlist")
    public Map<String, Object> testisid(@RequestParam("type") String type){
        List<String> list = ftTestisRepository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/testis/symbollist")
    public Map<String, Object> testissymbol(@RequestParam("type") String type){
        List<String> list = ftTestisRepository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation1/tissuename")
    public Map<String, Object> preimplantation1(){
        List<String> list = ftSrp011546Repository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation1/geneidlist")
    public Map<String, Object> preimplantation1id(@RequestParam("type") String type){
        List<String> list = ftSrp011546Repository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation1/symbollist")
    public Map<String, Object> preimplantation1symbol(@RequestParam("type") String type){
        List<String> list = ftSrp011546Repository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation2/tissuename")
    public Map<String, Object> preimplantation2(){
        List<String> list = ftSrp061636Repository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation2/geneidlist")
    public Map<String, Object> preimplantation2id(@RequestParam("type") String type){
        List<String> list = ftSrp061636Repository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation2/symbollist")
    public Map<String, Object> preimplantation2symbol(@RequestParam("type") String type){
        List<String> list = ftSrp061636Repository.findSymbol(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/differentiation/tissuename")
    public Map<String, Object> differentiation(){
        List<String> list = ftSrp168391Repository.findname();
        return List2Select.convert(list);
    }

    @RequestMapping("/differentiation/geneidlist")
    public Map<String, Object> differentiationid(@RequestParam("type") String type){
        List<String> list = ftSrp168391Repository.findGeneid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/differentiation/symbollist")
    public Map<String, Object> differentiationsymbol(@RequestParam("type") String type){
        List<String> list = ftSrp168391Repository.findSymbol(type);
        return List2Select.convert(list);
    }

}
