package data_access;

import entity.FetchedData;
import entity.Query;

import java.io.IOException;
import java.util.*;

abstract public class PreloadedDatabaseDataAccessObject implements DatabaseDataAcecssInterface{
    private static boolean loaded = false;
    // This is marked "protected" because ideally, it should be accessible
    // only by the subclass, but there isn't a "subclass only" access
    // modifier in Java.
    private int totalResults;
    private Query lastQuery;
    private List<String> queryResults;

    abstract void load() throws IOException;

    static String[] splitWords(String keywords){
        return keywords.toLowerCase().split("\\s+");
    }

    /**
     * @return relevant elements from a set of Strings from keywords.
     */
    private List<String> getRelevantItems(Set<String> entries, String keywords) {
        Map<String, Integer> keywordsCount = new HashMap<>();
        for (String entry: entries){
            String lowerCaseEntry = entry.toLowerCase();
            int count = 0;
            for (String keyword: splitWords(keywords)){
                if (lowerCaseEntry.contains(keyword)){
                    count++;
                }
            }
            if (count > 0){
                keywordsCount.put(entry, count);
            }
        }
        List<String> results = new ArrayList<>(keywordsCount.keySet());
        results.sort(Comparator.comparingInt(String::length));
        results.sort(Comparator.comparing(keywordsCount::get).reversed());

        return results;
    }

    public List<FetchedData> query(Database database, Map<String, String> preloadedEntries, Query query, int resultsPerPage, int page) throws IOException {
        if (!loaded) load();
        if (!query.equals(lastQuery)){
            queryResults = getRelevantItems(preloadedEntries.keySet(), query.getKeywords());
            totalResults = queryResults.size();
            lastQuery = query;
        }
        List<FetchedData> fetchedDataList = new ArrayList<>();
        for (int i = resultsPerPage * (page-1); i < resultsPerPage * page && i < totalResults; i++){
            String entry = queryResults.get(i);
            String id = preloadedEntries.get(entry);
            fetchedDataList.add(new FetchedData(entry, id, getURL(id), database));
        }

        return fetchedDataList;
    }

    @Override
    public int getTotalResults() {
        return totalResults;
    }

    abstract public LinkedHashMap<String, String> getEntryDetail(String id) throws IOException;
}
