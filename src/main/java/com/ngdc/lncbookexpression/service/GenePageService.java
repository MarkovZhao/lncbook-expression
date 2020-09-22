package com.ngdc.lncbookexpression.service;

import com.ngdc.lncbookexpression.model.Search;
import com.ngdc.lncbookexpression.view.*;

public interface GenePageService {
    GeneInfoVO findGeneInfo(String geneid);

    GeneAlternativeVO findGeneAlternative(String geneid);

    GESubcellularVO findGESubcellular(String geneid);

    GEHpaVO findGEHpa(String geneid);

    GEEncodeVO findGEEncode(String geneid);

    TissueDeveVO findGeTissueDEVO(String geneid);

    GePreimplantationVO findGePreimplantationVO(String geneid);

    GeExosomeVO findGeExosomeVO(String geneid);

    GEDifferentiationVO findGEDifferentiationVO(String geneid);

    GECellVO findGECellVO(String geneid);

    GECircadianVO findGECircadianVO(String geneid);

    GEVirusVO findGEVirusVO(String geneid);

    SearchVO findGeneVO(String geneid);

    SearchSymbolVO findSymbolVO(String symbol);

    SearchTranscriptVO findTranscriptVO(String transcriptid);

    ExpressionLevelVO findExpressionLevelVO(String geneid);
}
