package com.ngdc.lncbookexpression.dao;

import com.ngdc.lncbookexpression.model.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchRepository extends JpaRepository<Search,String> {
    List<Search> findByGeneid(String geneid);
    List<Search> findBySymbol(String symbol);
    List<Search> findBySourceid(String sourceid);
    List<Search> findByTranscriptid(String transcriptid);

    @Query(value ="select distinct u.symbol from search u where u.symbol like %?1% limit 0,5 ", nativeQuery = true)
    List<String> findSymbol(String symbol);

    @Query(value ="select distinct u.geneid from search u where u.geneid like %?1% limit 0,5 ", nativeQuery = true)
    List<String> findGeneid(String geneid);

    @Query(value ="select distinct u.sourceid from search u where u.sourceid like %?1% limit 0,5 ", nativeQuery = true)
    List<String> findSourceid(String sourceid);

    @Query(value ="select distinct u.transcriptid from search u where u.transcriptid like %?1% limit 0,5 ", nativeQuery = true)
    List<String> findTranscriptid(String geneid);
}
