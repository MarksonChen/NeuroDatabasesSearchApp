package data_access;

import entity.FetchedData;
import entity.Query;

import java.io.IOException;
import java.util.*;

abstract public class PreloadedDatabaseDataAccessObject implements DatabaseDataAcecssInterface{


    public List<FetchedData> query(Database database, Map<String, String> preloadedEntries, Query query, int resultsPerPage, int page) throws IOException {
        return null; // Implement this from the common structure of the two databases
    }

    @Override
    public int getTotalResults() {
        return 0;
    }

    abstract public LinkedHashMap<String, String> getEntryDetail(String id) throws IOException;
}
