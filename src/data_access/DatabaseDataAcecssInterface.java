package data_access;

import entity.FetchedData;
import entity.Query;

import java.io.IOException;
import java.util.*;

public interface DatabaseDataAcecssInterface {
    /**
     * @param query is the query input by "user"
     * @param resultsPerPage is results per page that need to display
     * @param page is current page number
     * @return a list of fetch data
     * @throws IOException
     */
    List<FetchedData> query(Query query, int resultsPerPage, int page) throws IOException;

    int getTotalResults();
    // Precondition: query is called once before this method is called
    String getURL(String id);
    String[] getEntryKeys();
}
