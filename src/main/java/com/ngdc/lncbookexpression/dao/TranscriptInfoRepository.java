package com.ngdc.lncbookexpression.dao;

import com.ngdc.lncbookexpression.model.TranscriptInfo1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscriptInfoRepository extends JpaRepository<TranscriptInfo1,String> {
    TranscriptInfo1 findByTranscriptid(String transcriptid);
}
