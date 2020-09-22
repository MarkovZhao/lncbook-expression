package com.ngdc.lncbookexpression.service.imp;

import com.ngdc.lncbookexpression.dao.*;
import com.ngdc.lncbookexpression.dao.CCLE.*;
import com.ngdc.lncbookexpression.dao.CCLE.GeSrp182096Repository;
import com.ngdc.lncbookexpression.dao.SpatialExpression.*;
import com.ngdc.lncbookexpression.model.*;
import com.ngdc.lncbookexpression.model.CCLE.*;
import com.ngdc.lncbookexpression.model.CCLE.GeSrp182096;
import com.ngdc.lncbookexpression.model.SpatialExpression.*;
import com.ngdc.lncbookexpression.service.GenePageService;
import com.ngdc.lncbookexpression.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GenePageServiceImpl implements GenePageService {
    @Autowired
    private GeneInfoRepository geneInfoRepository;
    @Autowired
    private GeneAlternativeRepository geneAlternativeRepository;
    @Autowired
    private TranscriptInfoRepository transcriptInfoRepository;
    @Autowired
    private GeSrp150867Repository geSrp150867Repository;
    @Autowired
    private GeHpaRepository geHpaRepository;
    @Autowired
    private GeEncodeRepository geEncodeRepository;
    @Autowired
    private GeBrainRepository geBrainRepository;
    @Autowired
    private GeCerebellumRepositoty geCerebellumRepositoty;
    @Autowired
    private GeHeartRepository geHeartRepository;
    @Autowired
    private GeKidneyRepository geKidneyRepository;
    @Autowired
    private GeLiverRepository geLiverRepository;
    @Autowired
    private GeOvaryRepository geOvaryRepository;
    @Autowired
    private GeTestisRepository geTestisRepository;
    @Autowired
    private GeCcleAllRepository geCcleAllRepository;
    @Autowired
    private GeCcleBileDuctRepository geCcleBileDuctRepository;
    @Autowired
    private GeCcleBlcaRepository geCcleBlcaRepository;
    @Autowired
    private GeCcleBrcaRepository geCcleBrcaRepository;
    @Autowired
    private GeCcleBreastRepository geCcleBreastRepository;
    @Autowired
    private GeCcleCescRepository geCcleCescRepository;
    @Autowired
    private GeCcleCllRepository geCcleCllRepository;
    @Autowired
    private GeCcleCoadRepository geCcleCoadRepository;
    @Autowired
    private GeCcleColorectalRepository geCcleColorectalRepository;
    @Autowired
    private GeCcleDlbcRepository geCcleDlbcRepository;
    @Autowired
    private GeCcleEscaRepository geCcleEscaRepository;
    @Autowired
    private GeCcleEwingsSarcomaRepository geCcleEwingsSarcomaRepository;
    @Autowired
    private GeCcleGbmRepository geCcleGbmRepository;
    @Autowired
    private GeCcleGiantCellRepository geCcleGiantCellRepository;
    @Autowired
    private GeCcleGliomaRepository geCcleGliomaRepository;
    @Autowired
    private GeCcleHnscRepository geCcleHnscRepository;
    @Autowired
    private GeCcleKircRepository geCcleKircRepository;
    @Autowired
    private GeCcleLamlRepository geCcleLamlRepository;
    @Autowired
    private GeCcleLeukemiaotherRepository geCcleLeukemiaotherRepository;
    @Autowired
    private GeCcleLcmlRepository geCcleLcmlRepository;
    @Autowired
    private GeCcleLggRepository geCcleLggRepository;
    @Autowired
    private GeCcleLihcRepository geCcleLihcRepository;
    @Autowired
    private GeCcleLuadRepository geCcleLuadRepository;
    @Autowired
    private GeCcleLungNscRepository geCcleLungNscRepository;
    @Autowired
    private GeCcleLuscRepository geCcleLuscRepository;
    @Autowired
    private GeCcleLymphomaOtherRepository geCcleLymphomaOtherRepository;
    @Autowired
    private GeCcleLymphomaHodgkinRepository geCcleLymphomaHodgkinRepository;
    @Autowired
    private GeCcleMbRepository geCcleMbRepository;
    @Autowired
    private GeCcleMelanomaRepository geCcleMelanomaRepository;
    @Autowired
    private GeCcleMeningiomaRepository geCcleMeningiomaRepository;
    @Autowired
    private GeCcleMesoRepository geCcleMesoRepository;
    @Autowired
    private GeCcleMesotheliomaRepository geCcleMesotheliomaRepository;
    @Autowired
    private GeCcleMmRepository geCcleMmRepository;
    @Autowired
    private GeCcleNanRepository geCcleNanRepository;
    @Autowired
    private GeCcleNbRepository geCcleNbRepository;
    @Autowired
    private GeCcleOsteosarcomaRepository geCcleOsteosarcomaRepository;
    @Autowired
    private GeCcleOtherRepository geCcleOtherRepository;
    @Autowired
    private GeCcleOvRepository geCcleOvRepository;
    @Autowired
    private GeCcleOvaryRepository geCcleOvaryRepository;
    @Autowired
    private GeCclePaadRepository geCclePaadRepository;
    @Autowired
    private GeCclePancreasRepository geCclePancreasRepository;
    @Autowired
    private GeCclePradRepository geCclePradRepository;
    @Autowired
    private GeCcleSarcRepository geCcleSarcRepository;
    @Autowired
    private GeCcleScleRepository geCcleScleRepository;
    @Autowired
    private GeCcleSkcmRepository geCcleSkcmRepository;
    @Autowired
    private GeCcleSofttissueRepository geCcleSofttissueRepository;
    @Autowired
    private GeCcleStadRepository geCcleStadRepository;
    @Autowired
    private GeCcleThcaRepository geCcleThcaRepository;
    @Autowired
    private GeCcleUcecRepository geCcleUcecRepository;
    @Autowired
    private GeCcleUrinaryTractRepository geCcleUrinaryTractRepository;
    @Autowired
    private GeCcleUpperaerodigestiveRepository geCcleUpperaerodigestiveRepository;

    @Autowired
    private GeSrp061636Repository geSrp061636Repository;
    @Autowired
    private GeSrp011546Repository geSrp011546Repository;
    @Autowired
    private GeExorbaseRepository geExorbaseRepository;
    @Autowired
    private GeSrp119895Repository geSrp119895Repository;
    @Autowired
    private GeSrp168391Repository geSrp168391Repository;
    @Autowired
    private GeSrp182096Repository geSrp182096Repository;
    @Autowired
    private GeCircadianRepository geCircadianRepository;
    @Autowired
    private GeSrp253951Repository geSrp253951Repository;
    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private ExperimentProfileRepository experimentProfileRepository;

    @Override
    public GeneInfoVO findGeneInfo(String geneid) {

        GeneInfoVO geneInfoVO = new GeneInfoVO();
        List <GeneInfo> geneInfo = geneInfoRepository.findByGeneid(geneid);
        geneInfoVO.setGeneInfo(geneInfo);
        return geneInfoVO;
    }

    @Override
    public GeneAlternativeVO findGeneAlternative(String geneid) {
        GeneAlternativeVO geneAlternativeVO = new GeneAlternativeVO();
        List<GeneAlternative> geneAlternatives = geneAlternativeRepository.findByGeneid(geneid);
        GeneAlternative geneAlternative = geneAlternatives.get(0);
        String transids = geneAlternative.getTranscriptid();
        String[] transidList = transids.split(",");

        List<TranscriptInfo1> transcriptInfos = new ArrayList<>();
        for(String x : transidList){
            TranscriptInfo1 transcriptInfo = transcriptInfoRepository.findByTranscriptid(x);
            transcriptInfos.add(transcriptInfo);
        }
        geneAlternativeVO.setGeneAlternative(geneAlternatives);
        geneAlternativeVO.setTransinfo(transcriptInfos);
        return geneAlternativeVO;
    }
    @Override
    public GESubcellularVO findGESubcellular(String geneid) {

        GESubcellularVO geneExpressionSubcellularVO = new GESubcellularVO();
        List <GeSrp150867> geSrp150867 = geSrp150867Repository.findByGeneid(geneid);
        geneExpressionSubcellularVO.setSrp150867(geSrp150867);
        return geneExpressionSubcellularVO;
    }

    @Override
    public GEHpaVO findGEHpa(String geneid) {

        GEHpaVO geHpaVO = new GEHpaVO();
        List <GeHpa> geHpa = geHpaRepository.findByGeneid(geneid);
        geHpaVO.setHpa(geHpa);
        return geHpaVO;
    }

    @Override
    public GEEncodeVO findGEEncode(String geneid) {

        GEEncodeVO geEncodeVO = new GEEncodeVO();
        List <GeEncode> geEncode = geEncodeRepository.findByGeneid(geneid);
        geEncodeVO.setEncode(geEncode);
        return geEncodeVO;
    }

    @Override
    public TissueDeveVO findGeTissueDEVO(String geneid) {
        TissueDeveVO tissueDeveVO = new TissueDeveVO();
        List <GeBrain> geBrain = geBrainRepository.findByGeneid(geneid);
        List <GeCerebellum> geCerebellum = geCerebellumRepositoty.findByGeneid(geneid);
        List <GeHeart> geHeart = geHeartRepository.findByGeneid(geneid);
        List <GeKidney> geKidney = geKidneyRepository.findByGeneid(geneid);
        List <GeLiver> geLiver = geLiverRepository.findByGeneid(geneid);
        List <GeOvary> geOvary = geOvaryRepository.findByGeneid(geneid);
        List <GeTestis> geTestis = geTestisRepository.findByGeneid(geneid);
        tissueDeveVO.setBrain(geBrain);
        tissueDeveVO.setCerebellum(geCerebellum);
        tissueDeveVO.setHeart(geHeart);
        tissueDeveVO.setKidney(geKidney);
        tissueDeveVO.setLiver(geLiver);
        tissueDeveVO.setOvary(geOvary);
        tissueDeveVO.setTestis(geTestis);
        return tissueDeveVO;
    }

    @Override
    public GePreimplantationVO findGePreimplantationVO(String geneid) {
        GePreimplantationVO gePreimplantationVO = new GePreimplantationVO();
        List <GeSrp061636> geSrp061636 = geSrp061636Repository.findByGeneid(geneid);
        gePreimplantationVO.setSrp061636(geSrp061636);
        List <GeSrp011546> geSrp011546 = geSrp011546Repository.findByGeneid(geneid);
        gePreimplantationVO.setSrp011546(geSrp011546);
        return gePreimplantationVO;
    }
    @Override
    public GeExosomeVO findGeExosomeVO(String geneid) {
        GeExosomeVO geExosomeVO = new GeExosomeVO();
        List <GeExorbase> geExorbase = geExorbaseRepository.findByGeneid(geneid);
        geExosomeVO.setExorbase(geExorbase);
        List <GeSrp119895> geSrp119895 = geSrp119895Repository.findByGeneid(geneid);
        geExosomeVO.setSrp119895(geSrp119895);
        return geExosomeVO;
    }
    @Override
    public GEDifferentiationVO findGEDifferentiationVO(String geneid) {
        GEDifferentiationVO geDifferentiationVO = new GEDifferentiationVO();
        List <GeSrp168391> geSrp168391 = geSrp168391Repository.findByGeneid(geneid);
        geDifferentiationVO.setSrp168391(geSrp168391);
        return geDifferentiationVO;
    }

    @Override
    public GECellVO findGECellVO(String geneid) {
        GECellVO geCellVO = new GECellVO();
        List<GeCcleAll> geCcleAll = geCcleAllRepository.findByGeneid(geneid);
        geCellVO.setAll(geCcleAll);
        List<GeCcleBileDuct> geCcleBileDuct = geCcleBileDuctRepository.findByGeneid(geneid);
        geCellVO.setBile(geCcleBileDuct);
        List<GeCcleBlca> geCcleBlca = geCcleBlcaRepository.findByGeneid(geneid);
        geCellVO.setBlca(geCcleBlca);
        List<GeCcleBrca> geCcleBrca = geCcleBrcaRepository.findByGeneid(geneid);
        geCellVO.setBrca(geCcleBrca);
        List<GeCcleBreast> geCcleBreast = geCcleBreastRepository.findByGeneid(geneid);
        geCellVO.setBreast(geCcleBreast);
        List<GeCcleCesc> geCcleCesc = geCcleCescRepository.findByGeneid(geneid);
        geCellVO.setCesc(geCcleCesc);
        List<GeCcleCll> geCcleCll = geCcleCllRepository.findByGeneid(geneid);
        geCellVO.setCll(geCcleCll);
        List<GeCcleCoad> geCcleCoad = geCcleCoadRepository.findByGeneid(geneid);
        geCellVO.setCoad(geCcleCoad);
        List<GeCcleColorectal> geCcleColorectal = geCcleColorectalRepository.findByGeneid(geneid);
        geCellVO.setColorectal(geCcleColorectal);
        List<GeCcleDlbc> geCcleDlbc = geCcleDlbcRepository.findByGeneid(geneid);
        geCellVO.setDlbc(geCcleDlbc);
        List<GeCcleEsca> geCcleEsca = geCcleEscaRepository.findByGeneid(geneid);
        geCellVO.setEsca(geCcleEsca);
        List<GeCcleEwingsSarcoma> geCcleEwingsSarcoma = geCcleEwingsSarcomaRepository.findByGeneid(geneid);
        geCellVO.setEwings_sarcoma(geCcleEwingsSarcoma);
        List<GeCcleGbm> geCcleGbm = geCcleGbmRepository.findByGeneid(geneid);
        geCellVO.setGbm(geCcleGbm);
        List<GeCcleGiantcell> geCcleGiantcell = geCcleGiantCellRepository.findByGeneid(geneid);
        geCellVO.setGiantcell(geCcleGiantcell);
        List<GeCcleGlioma> geCcleGlioma = geCcleGliomaRepository.findByGeneid(geneid);
        geCellVO.setGlioma(geCcleGlioma);
        List<GeCcleHnsc> geCcleHnsc = geCcleHnscRepository.findByGeneid(geneid);
        geCellVO.setHnsc(geCcleHnsc);
        List<GeCcleKirc> geCcleKirc = geCcleKircRepository.findByGeneid(geneid);
        geCellVO.setKirc(geCcleKirc);
        List<GeCcleLaml> geCcleLaml = geCcleLamlRepository.findByGeneid(geneid);
        geCellVO.setLaml(geCcleLaml);
        List<GeCcleLeukemiaother> geCcleLeukemiaother = geCcleLeukemiaotherRepository.findByGeneid(geneid);
        geCellVO.setLeukemia_other(geCcleLeukemiaother);
        List<GeCcleLcml> geCcleLcml = geCcleLcmlRepository.findByGeneid(geneid);
        geCellVO.setLcml(geCcleLcml);
        List<GeCcleLgg> geCcleLgg = geCcleLggRepository.findByGeneid(geneid);
        geCellVO.setLgg(geCcleLgg);
        List<GeCcleLihc> geCcleLihc = geCcleLihcRepository.findByGeneid(geneid);
        geCellVO.setLihc(geCcleLihc);
        List<GeCcleLuad> geCcleLuad = geCcleLuadRepository.findByGeneid(geneid);
        geCellVO.setLuad(geCcleLuad);
        List<GeCcleLungNsc> geCcleLungNsc = geCcleLungNscRepository.findByGeneid(geneid);
        geCellVO.setLungnsc(geCcleLungNsc);
        List<GeCcleLusc> geCcleLusc = geCcleLuscRepository.findByGeneid(geneid);
        geCellVO.setLusc(geCcleLusc);
        List<GeCcleLymphomaOther> geCcleLymphomaOther = geCcleLymphomaOtherRepository.findByGeneid(geneid);
        geCellVO.setLymphoma_other(geCcleLymphomaOther);
        List<GeCcleLymphomaHodgkin> geCcleLymphomaHodgkin = geCcleLymphomaHodgkinRepository.findByGeneid(geneid);
        geCellVO.setLymphoma_hodgkin(geCcleLymphomaHodgkin);
        List<GeCcleMb> geCcleMb = geCcleMbRepository.findByGeneid(geneid);
        geCellVO.setMb(geCcleMb);
        List<GeCcleMelanoma> geCcleMelanoma = geCcleMelanomaRepository.findByGeneid(geneid);
        geCellVO.setMelanoma(geCcleMelanoma);
        List<GeCcleMeningioma> geCcleMeningioma = geCcleMeningiomaRepository.findByGeneid(geneid);
        geCellVO.setMeningioma(geCcleMeningioma);
        List<GeCcleMeso> geCcleMeso = geCcleMesoRepository.findByGeneid(geneid);
        geCellVO.setMeso(geCcleMeso);
        List<GeCcleMesothelioma> geCcleMesothelioma = geCcleMesotheliomaRepository.findByGeneid(geneid);
        geCellVO.setMesothelioma(geCcleMesothelioma);
        List<GeCcleMm> geCcleMm = geCcleMmRepository.findByGeneid(geneid);
        geCellVO.setMm(geCcleMm);
        List<GeCcleNan> geCcleNan = geCcleNanRepository.findByGeneid(geneid);
        geCellVO.setNan(geCcleNan);
        List<GeCcleNb> geCcleNb = geCcleNbRepository.findByGeneid(geneid);
        geCellVO.setNb(geCcleNb);
        List<GeCcleOsteosarcoma> geCcleOsteosarcoma = geCcleOsteosarcomaRepository.findByGeneid(geneid);
        geCellVO.setOsteosarcoma(geCcleOsteosarcoma);
        List<GeCcleOther> geCcleOther = geCcleOtherRepository.findByGeneid(geneid);
        geCellVO.setOther(geCcleOther);
        List<GeCcleOv> geCcleOv = geCcleOvRepository.findByGeneid(geneid);
        geCellVO.setOv(geCcleOv);
        List<GeCcleOvary> geCcleOvary = geCcleOvaryRepository.findByGeneid(geneid);
        geCellVO.setOvary(geCcleOvary);
        List<GeCclePaad> geCclePaad = geCclePaadRepository.findByGeneid(geneid);
        geCellVO.setPaad(geCclePaad);
        List<GeCclePancreas> geCclePancreas = geCclePancreasRepository.findByGeneid(geneid);
        geCellVO.setPancreas(geCclePancreas);
        List<GeCclePrad> geCclePrad = geCclePradRepository.findByGeneid(geneid);
        geCellVO.setPrad(geCclePrad);
        List<GeCcleSarc> geCcleSarc = geCcleSarcRepository.findByGeneid(geneid);
        geCellVO.setSarc(geCcleSarc);
        List<GeCcleSclc> geCcleSclc = geCcleScleRepository.findByGeneid(geneid);
        geCellVO.setScle(geCcleSclc);
        List<GeCcleSkcm> geCcleSkcm = geCcleSkcmRepository.findByGeneid(geneid);
        geCellVO.setSkcm(geCcleSkcm);
        List<GeCcleSofttissue> geCcleSofttissue = geCcleSofttissueRepository.findByGeneid(geneid);
        geCellVO.setSofttissue(geCcleSofttissue);
        List<GeCcleStad> geCcleStad = geCcleStadRepository.findByGeneid(geneid);
        geCellVO.setStad(geCcleStad);
        List<GeCcleThca> geCcleThca = geCcleThcaRepository.findByGeneid(geneid);
        geCellVO.setThca(geCcleThca);
        List<GeCcleUcec> geCcleUcec = geCcleUcecRepository.findByGeneid(geneid);
        geCellVO.setUcec(geCcleUcec);
        List<GeCcleUrinaryTract> geCcleUrinaryTract = geCcleUrinaryTractRepository.findByGeneid(geneid);
        geCellVO.setUrinary_tract(geCcleUrinaryTract);
        List<GeCcleUpperaerodigestive> geCcleUpperaerodigestive = geCcleUpperaerodigestiveRepository.findByGeneid(geneid);
        geCellVO.setUpper_aerodigestive(geCcleUpperaerodigestive);
        return geCellVO;
    }

    @Override
    public GECircadianVO findGECircadianVO(String geneid) {
        GECircadianVO geCircadianVO = new GECircadianVO();
        List<GeCircadian> geCircadian = geCircadianRepository.findByGeneid(geneid);
        geCircadianVO.setCircadian(geCircadian);
        return geCircadianVO;
    }

    @Override
    public GEVirusVO findGEVirusVO(String geneid) {
        GEVirusVO geVirusVO = new GEVirusVO();
        List<GeSrp253951> geSrp253951 = geSrp253951Repository.findByGeneid(geneid);
        geVirusVO.setSrp253951(geSrp253951);
        List<GeSrp182096> geSrp182096 = geSrp182096Repository.findByGeneid(geneid);
        geVirusVO.setSrp182096(geSrp182096);
        return geVirusVO;
    }

    @Override
    public SearchVO findGeneVO(String geneid) {
        SearchVO searchVO = new SearchVO();
        List<Search> search = searchRepository.findBySourceid(geneid);
        searchVO.setSearch(search);
        return searchVO;
    }

    @Override
    public SearchSymbolVO findSymbolVO(String symbol) {
        SearchSymbolVO searchSymbolVO = new SearchSymbolVO();
        List<Search> searchsymbol = searchRepository.findBySymbol(symbol);
        searchSymbolVO.setSearch(searchsymbol);
        return searchSymbolVO;
    }

    @Override
    public SearchTranscriptVO findTranscriptVO(String transcriptid) {
        SearchTranscriptVO searchTranscriptVO = new SearchTranscriptVO();
        List<Search> searchtranscript = searchRepository.findByTranscriptid(transcriptid);
        searchTranscriptVO.setSearch(searchtranscript);
        return searchTranscriptVO;
    }

    @Override
    public ExpressionLevelVO findExpressionLevelVO(String geneid) {
        ExpressionLevelVO expressionLevelVO = new ExpressionLevelVO();
        List<ExperimentProfile> experimentProfile = experimentProfileRepository.findByGeneid(geneid);
        expressionLevelVO.setLevel(experimentProfile);
        return expressionLevelVO;
    }
}
