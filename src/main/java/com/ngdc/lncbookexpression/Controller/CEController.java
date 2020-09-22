package com.ngdc.lncbookexpression.Controller;


import com.ngdc.lncbookexpression.convert.List2Select;
import com.ngdc.lncbookexpression.dao.CoExpression.*;
import com.ngdc.lncbookexpression.dao.InteractionRepository;
import com.ngdc.lncbookexpression.dto.CEdto;
import com.ngdc.lncbookexpression.dto.DEdto;
import com.ngdc.lncbookexpression.model.CoExpression.*;
import com.ngdc.lncbookexpression.model.Interaction;
import com.ngdc.lncbookexpression.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ce")
public class CEController {

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

    @RequestMapping(value = "/brain")
    public Map brain(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeBrain> result =ceBrainRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

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

    @RequestMapping("/brainbylncname")
    public Map brainbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeBrain> result = ceBrainRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/brainbypcgid")
    public Map brainbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "size",defaultValue = "10") int size,
                           String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeBrain> result = ceBrainRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/brainbypcgname")
    public Map brainbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeBrain> result = ceBrainRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/brainfilter")
    public Map brainfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                          @RequestParam(value = "size",defaultValue = "10")int size,
                          @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                          @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                          @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                          @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                          @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                          @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeBrain> result;
        result = ceBrainRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/braindistance")
    public Map braindistance(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10")int size,
                            @RequestParam(value = "start",defaultValue = "0") float start,
                            @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeBrain> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceBrainRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceBrainRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceBrainRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/brainlncid")
    public Map<String, Object> brainlncid(@RequestParam("type")String type){
        List<String> list = ceBrainRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/brainlncname")
    public Map<String, Object> brainlncname(@RequestParam("type")String type){
        List<String> list = ceBrainRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/brainpcgid")
    public Map<String, Object> brainpcgid(@RequestParam("type")String type){
        List<String> list = ceBrainRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/brainpcgname")
    public Map<String, Object> brainpcgname(@RequestParam("type")String type){
        List<String> list = ceBrainRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/cerebellum")
    public Map cerebellum(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCerebellum> result =ceCerebellumRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/cerebellumbylncid")
    public Map cerebellumbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCerebellum> result = ceCerebellumRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/cerebellumbylncname")
    public Map cerebellumbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10") int size,
                              String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCerebellum> result = ceCerebellumRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/cerebellumbypcgid")
    public Map cerebellumbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCerebellum> result = ceCerebellumRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/cerebellumbypcgname")
    public Map cerebellumbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10") int size,
                              String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCerebellum> result = ceCerebellumRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/cerebellumfilter")
    public Map cerebellumfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "size",defaultValue = "10")int size,
                           @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                           @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                           @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                           @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                           @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                           @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCerebellum> result;
        result = ceCerebellumRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/cerebellumdistance")
    public Map cerebellumdistance(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10")int size,
                             @RequestParam(value = "start",defaultValue = "0") float start,
                             @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCerebellum> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceCerebellumRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceCerebellumRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceCerebellumRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/cerebellumlncid")
    public Map<String, Object> cerebellumlncid(@RequestParam("type")String type){
        List<String> list = ceCerebellumRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/cerebellumlncname")
    public Map<String, Object> cerebellumlncname(@RequestParam("type")String type){
        List<String> list = ceCerebellumRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/cerebellumpcgid")
    public Map<String, Object> cerebellumpcgid(@RequestParam("type")String type){
        List<String> list = ceCerebellumRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/cerebellumpcgname")
    public Map<String, Object> cerebellumpcgname(@RequestParam("type")String type){
        List<String> list = ceCerebellumRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/heart")
    public Map heart(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHeart> result =ceHeartRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/heartbylncid")
    public Map heartbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "10") int size,
                                 String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCerebellum> result = ceCerebellumRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/heartbylncname")
    public Map heartbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "size",defaultValue = "10") int size,
                                   String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHeart> result = ceHeartRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/heartbypcgid")
    public Map heartbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "10") int size,
                                 String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHeart> result = ceHeartRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/heartbypcgname")
    public Map heartbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "size",defaultValue = "10") int size,
                                   String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHeart> result = ceHeartRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/heartfilter")
    public Map heartfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                                @RequestParam(value = "size",defaultValue = "10")int size,
                                @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                                @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                                @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                                @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                                @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                                @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHeart> result;
        result = ceHeartRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/heartdistance")
    public Map heartdistance(@RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "size",defaultValue = "10")int size,
                                  @RequestParam(value = "start",defaultValue = "0") float start,
                                  @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHeart> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceHeartRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceHeartRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceHeartRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/heartlncid")
    public Map<String, Object> heartlncid(@RequestParam("type")String type){
        List<String> list = ceCerebellumRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/heartlncname")
    public Map<String, Object> heartlncname(@RequestParam("type")String type){
        List<String> list = ceHeartRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/heartpcgid")
    public Map<String, Object> heartpcgid(@RequestParam("type")String type){
        List<String> list = ceHeartRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/heartpcgname")
    public Map<String, Object> heartpcgname(@RequestParam("type")String type){
        List<String> list = ceHeartRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/kidney")
    public Map kidney(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeKidney> result =ceKidneyRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/kidneybylncid")
    public Map kidneybylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeKidney> result = ceKidneyRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/kidneybylncname")
    public Map kidneybylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10") int size,
                              String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeKidney> result = ceKidneyRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/kidneybypcgid")
    public Map kidneybypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeKidney> result = ceKidneyRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/kidneybypcgname")
    public Map kidneybypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10") int size,
                              String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeKidney> result = ceKidneyRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/kidneyfilter")
    public Map kidneyfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "size",defaultValue = "10")int size,
                           @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                           @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                           @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                           @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                           @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                           @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeKidney> result;
        result = ceKidneyRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/kidneydistance")
    public Map kidneydistance(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10")int size,
                             @RequestParam(value = "start",defaultValue = "0") float start,
                             @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeKidney> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceKidneyRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceKidneyRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceKidneyRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/kidneylncid")
    public Map<String, Object> kidneylncid(@RequestParam("type")String type){
        List<String> list = ceKidneyRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/kidneylncname")
    public Map<String, Object> kidneylncname(@RequestParam("type")String type){
        List<String> list = ceKidneyRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/kidneypcgid")
    public Map<String, Object> kidneypcgid(@RequestParam("type")String type){
        List<String> list = ceKidneyRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/kidneypcgname")
    public Map<String, Object> kidneypcgname(@RequestParam("type")String type){
        List<String> list = ceKidneyRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/liver")
    public Map liver(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeLiver> result =ceLiverRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/liverbylncid")
    public Map liverbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeLiver> result = ceLiverRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/liverbylncname")
    public Map liverbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeLiver> result = ceLiverRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/liverbypcgid")
    public Map liverbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeLiver> result = ceLiverRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/liverbypcgname")
    public Map liverbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeLiver> result = ceLiverRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/liverfilter")
    public Map liverfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10")int size,
                            @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                            @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                            @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                            @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                            @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                            @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeLiver> result;
        result = ceLiverRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/liverdistance")
    public Map liverdistance(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10")int size,
                              @RequestParam(value = "start",defaultValue = "0") float start,
                              @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeLiver> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceLiverRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceLiverRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceLiverRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/liverlncid")
    public Map<String, Object> liverlncid(@RequestParam("type")String type){
        List<String> list = ceLiverRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/liverlncname")
    public Map<String, Object> liverlncname(@RequestParam("type")String type){
        List<String> list = ceLiverRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/liverpcgid")
    public Map<String, Object> liverpcgid(@RequestParam("type")String type){
        List<String> list = ceLiverRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/liverpcgname")
    public Map<String, Object> liverpcgname(@RequestParam("type")String type){
        List<String> list = ceLiverRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/ovary")
    public Map ovary(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeOvary> result =ceOvaryRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/ovarybylncid")
    public Map ovarybylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeOvary> result = ceOvaryRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/ovarybylncname")
    public Map ovarybylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10") int size,
                              String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeOvary> result = ceOvaryRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/ovarybypcgid")
    public Map ovarybypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeOvary> result = ceOvaryRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/ovarybypcgname")
    public Map ovarybypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10") int size,
                              String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeOvary> result = ceOvaryRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/ovaryfilter")
    public Map ovaryfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "size",defaultValue = "10")int size,
                           @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                           @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                           @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                           @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                           @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                           @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeOvary> result;
        result = ceOvaryRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/ovarydistance")
    public Map ovarydistance(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10")int size,
                             @RequestParam(value = "start",defaultValue = "0") float start,
                             @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeOvary> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceOvaryRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceOvaryRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceOvaryRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/ovarylncid")
    public Map<String, Object> ovarylncid(@RequestParam("type")String type){
        List<String> list = ceOvaryRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/ovarylncname")
    public Map<String, Object> ovarylncname(@RequestParam("type")String type){
        List<String> list = ceOvaryRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/ovarypcgid")
    public Map<String, Object> ovarypcgid(@RequestParam("type")String type){
        List<String> list = ceOvaryRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/ovarypcgname")
    public Map<String, Object> ovarypcgname(@RequestParam("type")String type){
        List<String> list = ceOvaryRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/testis")
    public Map testis(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeTestis> result =ceTestisRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/testisbylncid")
    public Map testisbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeTestis> result = ceTestisRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/testisbylncname")
    public Map testisbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10") int size,
                              String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeTestis> result = ceTestisRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/testisbypcgid")
    public Map testisbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeTestis> result = ceTestisRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/testisbypcgname")
    public Map testisbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10") int size,
                              String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeTestis> result = ceTestisRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/testisfilter")
    public Map testisfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "size",defaultValue = "10")int size,
                           @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                           @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                           @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                           @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                           @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                           @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeTestis> result;
        result = ceTestisRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/testisdistance")
    public Map testisdistance(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10")int size,
                             @RequestParam(value = "start",defaultValue = "0") float start,
                             @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeTestis> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceTestisRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceTestisRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceTestisRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/testislncid")
    public Map<String, Object> testislncid(@RequestParam("type")String type){
        List<String> list = ceTestisRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/testislncname")
    public Map<String, Object> testislncname(@RequestParam("type")String type){
        List<String> list = ceTestisRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/testispcgid")
    public Map<String, Object> testispcgid(@RequestParam("type")String type){
        List<String> list = ceTestisRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/testispcgname")
    public Map<String, Object> testispcgname(@RequestParam("type")String type){
        List<String> list = ceTestisRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/differentiation")
    public Map differentiation(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result =ceSrp168391Repository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/differentiationbylncid")
    public Map differentiationbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result = ceSrp168391Repository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/differentiationbylncname")
    public Map differentiationbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result = ceSrp168391Repository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/differentiationbypcgid")
    public Map differentiationbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result = ceSrp168391Repository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/differentiationbypcgname")
    public Map differentiationbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result = ceSrp168391Repository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/differentiationfilter")
    public Map differentiationfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10")int size,
                            @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                            @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                            @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                            @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                            @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                            @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result;
        result = ceSrp168391Repository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/differentiationdistance")
    public Map differentiationdistance(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10")int size,
                              @RequestParam(value = "start",defaultValue = "0") float start,
                              @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceSrp168391Repository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceSrp168391Repository.findByDistanceAfter(start,pageable);
        }else {
            result = ceSrp168391Repository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/differentiationlncid")
    public Map<String, Object> differentiationlncid(@RequestParam("type")String type){
        List<String> list = ceSrp168391Repository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/differentiationlncname")
    public Map<String, Object> differentiationlncname(@RequestParam("type")String type){
        List<String> list = ceSrp168391Repository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/differentiationpcgid")
    public Map<String, Object> differentiationpcgid(@RequestParam("type")String type){
        List<String> list = ceSrp168391Repository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/differentiationpcgname")
    public Map<String, Object> differentiationpcgname(@RequestParam("type")String type){
        List<String> list = ceSrp168391Repository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/preimplantation2")
    public Map preimplantation2(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp061636> result =ceSrp061636Repository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/preimplantation2bylncid")
    public Map preimplantation2bylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                                      @RequestParam(value = "size",defaultValue = "10") int size,
                                      String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp061636> result = ceSrp061636Repository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/preimplantation2bylncname")
    public Map preimplantation2bylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                                        @RequestParam(value = "size",defaultValue = "10") int size,
                                        String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp061636> result = ceSrp061636Repository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/preimplantation2bypcgid")
    public Map preimplantation2bypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                                      @RequestParam(value = "size",defaultValue = "10") int size,
                                      String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp061636> result = ceSrp061636Repository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/preimplantation2bypcgname")
    public Map preimplantation2bypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                                        @RequestParam(value = "size",defaultValue = "10") int size,
                                        String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp061636> result = ceSrp061636Repository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/preimplantation2filter")
    public Map preimplantation2filter(@RequestParam(value = "page",defaultValue = "1") int page,
                                     @RequestParam(value = "size",defaultValue = "10")int size,
                                     @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                                     @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                                     @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                                     @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                                     @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                                     @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp061636> result;
        result = ceSrp061636Repository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/preimplantation2distance")
    public Map preimplantation2distance(@RequestParam(value = "page",defaultValue = "1") int page,
                                       @RequestParam(value = "size",defaultValue = "10")int size,
                                       @RequestParam(value = "start",defaultValue = "0") float start,
                                       @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp061636> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceSrp061636Repository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceSrp061636Repository.findByDistanceAfter(start,pageable);
        }else {
            result = ceSrp061636Repository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/preimplantation2lncid")
    public Map<String, Object> preimplantation2lncid(@RequestParam("type")String type){
        List<String> list = ceSrp061636Repository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation2lncname")
    public Map<String, Object> preimplantation2lncname(@RequestParam("type")String type){
        List<String> list = ceSrp061636Repository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation2pcgid")
    public Map<String, Object> preimplantation2pcgid(@RequestParam("type")String type){
        List<String> list = ceSrp061636Repository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation2pcgname")
    public Map<String, Object> preimplantation2pcgname(@RequestParam("type")String type){
        List<String> list = ceSrp061636Repository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/preimplantation1")
    public Map preimplantation1(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp011546> result =ceSrp011546Repository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/preimplantation1bylncid")
    public Map preimplantation1bylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                                       @RequestParam(value = "size",defaultValue = "10") int size,
                                       String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp011546> result = ceSrp011546Repository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/preimplantation1bylncname")
    public Map preimplantation1bylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                                         @RequestParam(value = "size",defaultValue = "10") int size,
                                         String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp011546> result = ceSrp011546Repository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/preimplantation1bypcgid")
    public Map preimplantation1bypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                                       @RequestParam(value = "size",defaultValue = "10") int size,
                                       String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp011546> result = ceSrp011546Repository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/preimplantation1bypcgname")
    public Map preimplantation1bypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                                         @RequestParam(value = "size",defaultValue = "10") int size,
                                         String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp011546> result = ceSrp011546Repository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/preimplantation1filter")
    public Map preimplantation1filter(@RequestParam(value = "page",defaultValue = "1") int page,
                                      @RequestParam(value = "size",defaultValue = "10")int size,
                                      @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                                      @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                                      @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                                      @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                                      @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                                      @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp011546> result;
        result = ceSrp011546Repository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/preimplantation1distance")
    public Map preimplantation1distance(@RequestParam(value = "page",defaultValue = "1") int page,
                                        @RequestParam(value = "size",defaultValue = "10")int size,
                                        @RequestParam(value = "start",defaultValue = "0") float start,
                                        @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp011546> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceSrp011546Repository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceSrp011546Repository.findByDistanceAfter(start,pageable);
        }else {
            result = ceSrp011546Repository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/preimplantation1lncid")
    public Map<String, Object> preimplantation1lncid(@RequestParam("type")String type){
        List<String> list = ceSrp011546Repository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation1lncname")
    public Map<String, Object> preimplantation1lncname(@RequestParam("type")String type){
        List<String> list = ceSrp011546Repository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation1pcgid")
    public Map<String, Object> preimplantation1pcgid(@RequestParam("type")String type){
        List<String> list = ceSrp011546Repository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/preimplantation1pcgname")
    public Map<String, Object> preimplantation1pcgname(@RequestParam("type")String type){
        List<String> list = ceSrp011546Repository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/colorectal")
    public Map colorectal(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeColorectal> result =ceColorectalRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/colorectalbylncid")
    public Map colorectalbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "size",defaultValue = "10") int size,
                                  String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeColorectal> result = ceColorectalRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/colorectalbylncname")
    public Map colorectalbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                                    @RequestParam(value = "size",defaultValue = "10") int size,
                                    String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeColorectal> result = ceColorectalRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/colorectalbypcgid")
    public Map colorectalbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "size",defaultValue = "10") int size,
                                  String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeColorectal> result = ceColorectalRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/colorectalbypcgname")
    public Map colorectalbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                                    @RequestParam(value = "size",defaultValue = "10") int size,
                                    String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeColorectal> result = ceColorectalRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/colorectalfilter")
    public Map colorectalfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "10")int size,
                                 @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                                 @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                                 @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                                 @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                                 @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                                 @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeColorectal> result;
        result = ceColorectalRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/colorectaldistance")
    public Map colorectaldistance(@RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "size",defaultValue = "10")int size,
                                   @RequestParam(value = "start",defaultValue = "0") float start,
                                   @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeColorectal> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceColorectalRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceColorectalRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceColorectalRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/colorectallncid")
    public Map<String, Object> colorectallncid(@RequestParam("type")String type){
        List<String> list = ceColorectalRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/colorectallncname")
    public Map<String, Object> colorectallncname(@RequestParam("type")String type){
        List<String> list = ceColorectalRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/colorectalpcgid")
    public Map<String, Object> colorectalpcgid(@RequestParam("type")String type){
        List<String> list = ceColorectalRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/colorectalpcgname")
    public Map<String, Object> colorectalpcgname(@RequestParam("type")String type){
        List<String> list = ceColorectalRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/coronary")
    public Map coronary(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCoronary> result =ceCoronaryRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/coronarybylncid")
    public Map coronarybylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "10") int size,
                                 String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCoronary> result = ceCoronaryRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/coronarybylncname")
    public Map coronarybylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "size",defaultValue = "10") int size,
                                   String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCoronary> result = ceCoronaryRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/coronarybypcgid")
    public Map coronarybypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "10") int size,
                                 String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCoronary> result = ceCoronaryRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/coronarybypcgname")
    public Map coronarybypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "size",defaultValue = "10") int size,
                                   String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCoronary> result = ceCoronaryRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/coronaryfilter")
    public Map coronaryfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                                @RequestParam(value = "size",defaultValue = "10")int size,
                                @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                                @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                                @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                                @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                                @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                                @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCoronary> result;
        result = ceCoronaryRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/coronarydistance")
    public Map coronarydistance(@RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "size",defaultValue = "10")int size,
                                  @RequestParam(value = "start",defaultValue = "0") float start,
                                  @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCoronary> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceCoronaryRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceCoronaryRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceCoronaryRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/coronarylncid")
    public Map<String, Object> coronarylncid(@RequestParam("type")String type){
        List<String> list = ceCoronaryRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/coronarylncname")
    public Map<String, Object> coronarylncname(@RequestParam("type")String type){
        List<String> list = ceCoronaryRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/coronarypcgid")
    public Map<String, Object> coronarypcgid(@RequestParam("type")String type){
        List<String> list = ceCoronaryRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/coronarypcgname")
    public Map<String, Object> coronarypcgname(@RequestParam("type")String type){
        List<String> list = ceCoronaryRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/pancreatic")
    public Map pancreatic(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CePancreatic> result =cePancreaticRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/pancreaticbylncid")
    public Map pancreaticbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CePancreatic> result = cePancreaticRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/pancreaticbylncname")
    public Map pancreaticbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "10") int size,
                                 String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CePancreatic> result = cePancreaticRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/pancreaticbypcgid")
    public Map pancreaticbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CePancreatic> result = cePancreaticRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/pancreaticbypcgname")
    public Map pancreaticbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "10") int size,
                                 String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CePancreatic> result = cePancreaticRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/pancreaticfilter")
    public Map pancreaticfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10")int size,
                              @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                              @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                              @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                              @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                              @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                              @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CePancreatic> result;
        result = cePancreaticRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/pancreaticdistance")
    public Map pancreaticdistance(@RequestParam(value = "page",defaultValue = "1") int page,
                                @RequestParam(value = "size",defaultValue = "10")int size,
                                @RequestParam(value = "start",defaultValue = "0") float start,
                                @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CePancreatic> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = cePancreaticRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = cePancreaticRepository.findByDistanceAfter(start,pageable);
        }else {
            result = cePancreaticRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/pancreaticlncid")
    public Map<String, Object> pancreaticlncid(@RequestParam("type")String type){
        List<String> list = cePancreaticRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/pancreaticlncname")
    public Map<String, Object> pancreaticlncname(@RequestParam("type")String type){
        List<String> list = cePancreaticRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/pancreaticpcgid")
    public Map<String, Object> pancreaticpcgid(@RequestParam("type")String type){
        List<String> list = cePancreaticRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/pancreaticpcgname")
    public Map<String, Object> pancreaticpcgname(@RequestParam("type")String type){
        List<String> list = cePancreaticRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/escc")
    public Map escc(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEscc> result =ceEsccRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/esccbylncid")
    public Map esccbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "10") int size,
                                 String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEscc> result = ceEsccRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/esccbylncname")
    public Map esccbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "size",defaultValue = "10") int size,
                                   String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEscc> result = ceEsccRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/esccbypcgid")
    public Map esccbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "10") int size,
                                 String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEscc> result = ceEsccRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/esccbypcgname")
    public Map esccbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "size",defaultValue = "10") int size,
                                   String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEscc> result = ceEsccRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/esccfilter")
    public Map esccfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                                @RequestParam(value = "size",defaultValue = "10")int size,
                                @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                                @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                                @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                                @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                                @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                                @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEscc> result;
        result = ceEsccRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/esccdistance")
    public Map esccdistance(@RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "size",defaultValue = "10")int size,
                                  @RequestParam(value = "start",defaultValue = "0") float start,
                                  @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEscc> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceEsccRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceEsccRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceEsccRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/escclncid")
    public Map<String, Object> escclncid(@RequestParam("type")String type){
        List<String> list = ceEsccRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/escclncname")
    public Map<String, Object> escclncname(@RequestParam("type")String type){
        List<String> list = ceEsccRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/esccpcgid")
    public Map<String, Object> esccpcgid(@RequestParam("type")String type){
        List<String> list = ceEsccRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/esccpcgname")
    public Map<String, Object> esccpcgname(@RequestParam("type")String type){
        List<String> list = ceEsccRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/hepatocellular")
    public Map hepatocellular(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHepatocellular> result =ceHepatocellularRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/hepatocellularbylncid")
    public Map hepatocellularbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "size",defaultValue = "10") int size,
                           String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHepatocellular> result = ceHepatocellularRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hepatocellularbylncname")
    public Map hepatocellularbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHepatocellular> result = ceHepatocellularRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hepatocellularbypcgid")
    public Map hepatocellularbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "size",defaultValue = "10") int size,
                           String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHepatocellular> result = ceHepatocellularRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hepatocellularbypcgname")
    public Map hepatocellularbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHepatocellular> result = ceHepatocellularRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hepatocellularfilter")
    public Map hepatocellularfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                          @RequestParam(value = "size",defaultValue = "10")int size,
                          @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                          @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                          @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                          @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                          @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                          @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHepatocellular> result;
        result = ceHepatocellularRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/hepatocellulardistance")
    public Map hepatocellulardistance(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10")int size,
                            @RequestParam(value = "start",defaultValue = "0") float start,
                            @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHepatocellular> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceHepatocellularRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceHepatocellularRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceHepatocellularRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/hepatocellularlncid")
    public Map<String, Object> hepatocellularlncid(@RequestParam("type")String type){
        List<String> list = ceHepatocellularRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hepatocellularlncname")
    public Map<String, Object> hepatocellularlncname(@RequestParam("type")String type){
        List<String> list = ceHepatocellularRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hepatocellularpcgid")
    public Map<String, Object> hepatocellularpcgid(@RequestParam("type")String type){
        List<String> list = ceHepatocellularRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hepatocellularpcgname")
    public Map<String, Object> hepatocellularpcgname(@RequestParam("type")String type){
        List<String> list = ceHepatocellularRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/hbv")
    public Map hbv(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHbv> result =ceHbvRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/hbvbylncid")
    public Map hbvbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                                     @RequestParam(value = "size",defaultValue = "10") int size,
                                     String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHbv> result = ceHbvRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hbvbylncname")
    public Map hbvbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                                       @RequestParam(value = "size",defaultValue = "10") int size,
                                       String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHbv> result = ceHbvRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hbvbypcgid")
    public Map hbvbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                                     @RequestParam(value = "size",defaultValue = "10") int size,
                                     String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHbv> result = ceHbvRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hbvbypcgname")
    public Map hbvbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                                       @RequestParam(value = "size",defaultValue = "10") int size,
                                       String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHbv> result = ceHbvRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hbvfilter")
    public Map hbvfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                                    @RequestParam(value = "size",defaultValue = "10")int size,
                                    @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                                    @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                                    @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                                    @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                                    @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                                    @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHbv> result;
        result = ceHbvRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/hbvdistance")
    public Map hbvdistance(@RequestParam(value = "page",defaultValue = "1") int page,
                                      @RequestParam(value = "size",defaultValue = "10")int size,
                                      @RequestParam(value = "start",defaultValue = "0") float start,
                                      @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHbv> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceHbvRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceHbvRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceHbvRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/hbvlncid")
    public Map<String, Object> hbvlncid(@RequestParam("type")String type){
        List<String> list = ceHbvRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hbvlncname")
    public Map<String, Object> hbvlncname(@RequestParam("type")String type){
        List<String> list = ceHbvRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hbvpcgid")
    public Map<String, Object> hbvpcgid(@RequestParam("type")String type){
        List<String> list = ceHbvRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hbvpcgname")
    public Map<String, Object> hbvpcgname(@RequestParam("type")String type){
        List<String> list = ceHbvRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/sars2")
    public Map sars2(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSars2> result =ceSars2Repository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/sars2bylncid")
    public Map sars2bylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                          @RequestParam(value = "size",defaultValue = "10") int size,
                          String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSars2> result = ceSars2Repository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/sars2bylncname")
    public Map sars2bylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSars2> result = ceSars2Repository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/sars2bypcgid")
    public Map sars2bypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                          @RequestParam(value = "size",defaultValue = "10") int size,
                          String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSars2> result = ceSars2Repository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/sars2bypcgname")
    public Map sars2bypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSars2> result = ceSars2Repository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/sars2filter")
    public Map sars2filter(@RequestParam(value = "page",defaultValue = "1") int page,
                         @RequestParam(value = "size",defaultValue = "10")int size,
                         @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                         @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                         @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                         @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                         @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                         @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSars2> result;
        result = ceSars2Repository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/sars2distance")
    public Map sars2distance(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "size",defaultValue = "10")int size,
                           @RequestParam(value = "start",defaultValue = "0") float start,
                           @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSars2> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceSars2Repository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceSars2Repository.findByDistanceAfter(start,pageable);
        }else {
            result = ceSars2Repository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/sars2lncid")
    public Map<String, Object> sars2lncid(@RequestParam("type")String type){
        List<String> list = ceSars2Repository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/sars2lncname")
    public Map<String, Object> sars2lncname(@RequestParam("type")String type){
        List<String> list = ceSars2Repository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/sars2pcgid")
    public Map<String, Object> sars2pcgid(@RequestParam("type")String type){
        List<String> list = ceSars2Repository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/sars2pcgname")
    public Map<String, Object> sars2pcgname(@RequestParam("type")String type){
        List<String> list = ceSars2Repository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/ccle")
    public Map ccle(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCcle> result =ceCcleRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/cclebylncid")
    public Map cclebylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCcle> result = ceCcleRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/cclebylncname")
    public Map cclebylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCcle> result = ceCcleRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/cclebypcgid")
    public Map cclebypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCcle> result = ceCcleRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/cclebypcgname")
    public Map cclebypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCcle> result = ceCcleRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/cclefilter")
    public Map cclefilter(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10")int size,
                            @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                            @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                            @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                            @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                            @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                            @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCcle> result;
        result = ceCcleRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/ccledistance")
    public Map ccledistance(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size",defaultValue = "10")int size,
                              @RequestParam(value = "start",defaultValue = "0") float start,
                              @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeCcle> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceCcleRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceCcleRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceCcleRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/cclelncid")
    public Map<String, Object> cclelncid(@RequestParam("type")String type){
        List<String> list = ceCcleRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/cclelncname")
    public Map<String, Object> cclelncname(@RequestParam("type")String type){
        List<String> list = ceCcleRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/cclepcgid")
    public Map<String, Object> cclepcgid(@RequestParam("type")String type){
        List<String> list = ceCcleRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/cclepcgname")
    public Map<String, Object> cclepcgname(@RequestParam("type")String type){
        List<String> list = ceCcleRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/encode")
    public Map encode(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEncode> result =ceEncodeRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/encodebylncid")
    public Map encodebylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                        @RequestParam(value = "size",defaultValue = "10") int size,
                        String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEncode> result = ceEncodeRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/encodebylncname")
    public Map encodebylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEncode> result = ceEncodeRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/encodebypcgid")
    public Map encodebypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEncode> result = ceEncodeRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/encodebypcgname")
    public Map encodebypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEncode> result = ceEncodeRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/encodefilter")
    public Map encodefilter(@RequestParam(value = "page",defaultValue = "1") int page,
                         @RequestParam(value = "size",defaultValue = "10")int size,
                         @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                         @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                         @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                         @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                         @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                         @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEncode> result;
        result = ceEncodeRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/encodedistance")
    public Map encodedistance(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "size",defaultValue = "10")int size,
                           @RequestParam(value = "start",defaultValue = "0") float start,
                           @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeEncode> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceEncodeRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceEncodeRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceEncodeRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/encodelncid")
    public Map<String, Object> encodelncid(@RequestParam("type")String type){
        List<String> list = ceEncodeRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/encodelncname")
    public Map<String, Object> encodelncname(@RequestParam("type")String type){
        List<String> list = ceEncodeRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/encodepcgid")
    public Map<String, Object> encodepcgid(@RequestParam("type")String type){
        List<String> list = ceEncodeRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/encodepcgname")
    public Map<String, Object> encodepcgname(@RequestParam("type")String type){
        List<String> list = ceEncodeRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/hpa")
    public Map hpa(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHpa> result =ceHpaRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/hpabylncid")
    public Map hpabylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHpa> result = ceHpaRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hpabylncname")
    public Map hpabylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHpa> result = ceHpaRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hpabypcgid")
    public Map hpabypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size,
                             String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHpa> result = ceHpaRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hpabypcgname")
    public Map hpabypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "size",defaultValue = "10") int size,
                               String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHpa> result = ceHpaRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/hpafilter")
    public Map hpafilter(@RequestParam(value = "page",defaultValue = "1") int page,
                         @RequestParam(value = "size",defaultValue = "10")int size,
                         @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                         @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                         @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                         @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                         @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                         @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHpa> result;
        result = ceHpaRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/hpadistance")
    public Map hpadistance(@RequestParam(value = "page",defaultValue = "1") int page,
                      @RequestParam(value = "size",defaultValue = "10")int size,
                      @RequestParam(value = "start",defaultValue = "0") float start,
                      @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeHpa> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceHpaRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceHpaRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceHpaRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/hpalncid")
    public Map<String, Object> hpalncid(@RequestParam("type")String type){
        List<String> list = ceHpaRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hpalncname")
    public Map<String, Object> hpalncname(@RequestParam("type")String type){
        List<String> list = ceHpaRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hpapcgid")
    public Map<String, Object> hpapcgid(@RequestParam("type")String type){
        List<String> list = ceHpaRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/hpapcgname")
    public Map<String, Object> hpapcgname(@RequestParam("type")String type){
        List<String> list = ceHpaRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/circadian")
    public Map circadian(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result =ceSrp168391Repository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/circadianbylncid")
    public Map circadianbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                          @RequestParam(value = "size",defaultValue = "10") int size,
                          String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result = ceSrp168391Repository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/circadianbylncname")
    public Map circadianbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result = ceSrp168391Repository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/circadianbypcgid")
    public Map circadianbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                          @RequestParam(value = "size",defaultValue = "10") int size,
                          String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result = ceSrp168391Repository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/circadianbypcgname")
    public Map circadianbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size,
                            String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result = ceSrp168391Repository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/circadianfilter")
    public Map circadianfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                         @RequestParam(value = "size",defaultValue = "10")int size,
                         @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                         @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                         @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                         @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                         @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                         @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result;
        result = ceSrp168391Repository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/circadiandistance")
    public Map circadiandistance(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10")int size,
                            @RequestParam(value = "start",defaultValue = "0") float start,
                            @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSrp168391> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceSrp168391Repository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceSrp168391Repository.findByDistanceAfter(start,pageable);
        }else {
            result = ceSrp168391Repository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/circadianlncid")
    public Map<String, Object> circadianlncid(@RequestParam("type")String type){
        List<String> list = ceSrp168391Repository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/circadianlncname")
    public Map<String, Object> circadianlncname(@RequestParam("type")String type){
        List<String> list = ceSrp168391Repository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/circadianpcgid")
    public Map<String, Object> circadianpcgid(@RequestParam("type")String type){
        List<String> list = ceSrp168391Repository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/circadianpcgname")
    public Map<String, Object> circadianpcgname(@RequestParam("type")String type){
        List<String> list = ceSrp168391Repository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/subcellular")
    public Map subcellular(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSubcellular> result =ceSubcellularRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/subcellularbylncid")
    public Map subcellularbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "size",defaultValue = "10") int size,
                                  String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSubcellular> result = ceSubcellularRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/subcellularbylncname")
    public Map subcellularbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                                    @RequestParam(value = "size",defaultValue = "10") int size,
                                    String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSubcellular> result = ceSubcellularRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/subcellularbypcgid")
    public Map subcellularbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "size",defaultValue = "10") int size,
                                  String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSubcellular> result = ceSubcellularRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/subcellularbypcgname")
    public Map subcellularbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                                    @RequestParam(value = "size",defaultValue = "10") int size,
                                    String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSubcellular> result = ceSubcellularRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/subcellularfilter")
    public Map subcellularfilter(@RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "size",defaultValue = "10")int size,
                                 @RequestParam(value = "pcc_start",defaultValue = "0.5") float pcc_start,
                                 @RequestParam(value = "pcc_end",defaultValue = "1") float pcc_end,
                                 @RequestParam(value = "pvalue_start",defaultValue = "0") float pvalue_start,
                                 @RequestParam(value = "pvalue_end",defaultValue = "0.01") float pvalue_end,
                                 @RequestParam(value = "distance_start",defaultValue = "0") float distance_start,
                                 @RequestParam(value = "distance_end",defaultValue = "0.01") float distance_end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSubcellular> result;
        result = ceSubcellularRepository.findByPccBetweenAndPvalueBetweenAndDistanceBetween(pcc_start,pcc_end,pvalue_start,pvalue_end,distance_start,distance_end,pageable);
        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/subcellulardistance")
    public Map subcellulardistance(@RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "size",defaultValue = "10")int size,
                                   @RequestParam(value = "start",defaultValue = "0") float start,
                                   @RequestParam(value = "end",defaultValue = "10000000000000") float end) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CeSubcellular> result;
        if(!StringUtils.isEmpty(start)&&!StringUtils.isEmpty(end)){
            result = ceSubcellularRepository.findByDistanceBetween(start,end,pageable);
        }else if(!StringUtils.isEmpty(start)){
            result = ceSubcellularRepository.findByDistanceAfter(start,pageable);
        }else {
            result = ceSubcellularRepository.findByDistanceBefore(end,pageable);
        }

        Map map = new HashMap();
        map.put("total", result.getTotalElements());
        map.put("geneInfo", result.getContent());
        map.put("page", page);
        return map;
    }

    @RequestMapping("/subcellularlncid")
    public Map<String, Object> subcellularlncid(@RequestParam("type")String type){
        List<String> list = ceSubcellularRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/subcellularlncname")
    public Map<String, Object> subcellularlncname(@RequestParam("type")String type){
        List<String> list = ceSubcellularRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/subcellularpcgid")
    public Map<String, Object> subcellularpcgid(@RequestParam("type")String type){
        List<String> list = ceSubcellularRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/subcellularpcgname")
    public Map<String, Object> subcellularpcgname(@RequestParam("type")String type){
        List<String> list = ceSubcellularRepository.findPcgname(type);
        return List2Select.convert(list);
    }

    @RequestMapping(value = "/interaction")
    public Map interaction(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "size",defaultValue = "10")int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Interaction> result =interactionRepository.findAll(pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo", result.getContent());
        return map;
    }

    @RequestMapping("/interactionbylncid")
    public Map interactionbylncid(@RequestParam(value = "page",defaultValue = "1") int page,
                                @RequestParam(value = "size",defaultValue = "10") int size,
                                String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Interaction> result = interactionRepository.findByGeneid(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/interactionbylncname")
    public Map interactionbylncname(@RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "size",defaultValue = "10") int size,
                                  String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Interaction> result = interactionRepository.findByLncname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/interactionbypcgid")
    public Map interactionbypcgid(@RequestParam(value = "page",defaultValue = "1") int page,
                                @RequestParam(value = "size",defaultValue = "10") int size,
                                String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Interaction> result = interactionRepository.findByPcg(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/interactionbypcgname")
    public Map interactionbypcgname(@RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "size",defaultValue = "10") int size,
                                  String term) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Interaction> result = interactionRepository.findByPcgname(term, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("total",result.getTotalElements());
        map.put("geneInfo",result.getContent());
        return map;
    }

    @RequestMapping("/interactionlncid")
    public Map<String, Object> interactionlncid(@RequestParam("type")String type){
        List<String> list = interactionRepository.findLncid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/interactionlncname")
    public Map<String, Object> interactionlncname(@RequestParam("type")String type){
        List<String> list = interactionRepository.findLncname(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/interactionpcgid")
    public Map<String, Object> interactionpcgid(@RequestParam("type")String type){
        List<String> list = interactionRepository.findPcgid(type);
        return List2Select.convert(list);
    }

    @RequestMapping("/interactionpcgname")
    public Map<String, Object> interactionpcgname(@RequestParam("type")String type){
        List<String> list = interactionRepository.findPcgname(type);
        return List2Select.convert(list);
    }
}
