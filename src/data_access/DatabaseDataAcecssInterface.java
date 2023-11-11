package data_access;

import entity.FetchedData;
import entity.Query;

import java.io.IOException;
import java.util.*;

public interface DatabaseDataAcecssInterface {
    List<FetchedData> query(Query query, int resultsPerPage, int page) throws IOException;
//    List<FetchedData> getRelevantEntries(String keywords);
    int getTotalResults();
    // Precondition: query is called once before this method is called
    String getURL(String id);
    String[] getEntryKeys();
}
