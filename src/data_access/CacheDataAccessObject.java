package data_access;

import entity.FetchedData;
import entity.Query;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CacheDataAccessObject implements CacheDataAccessInterface {
    private Query currentQuery;
    private final List<List<FetchedData>>[] cachedData;

    public CacheDataAccessObject() {
        cachedData = new List[Database.length];
        reset();
    }

    private void reset() {  // result cache data every time user do another search
        for (int i = 0; i < Database.length; i++) {
            cachedData[i] = new ArrayList<>();
        }
    }

    @Override
    public boolean hasCache(Database database, Query query, int page) {
        return currentQuery != null && currentQuery.equals(query)
                && page <= cachedData[Database.indexOf(database)].size();
    }

    @Override
    public void cache(Database database, Query query, List<FetchedData> fetchedDataList) {
        if (currentQuery == null || !currentQuery.equals(query)) {
            currentQuery = query;
            reset();
        }
        cachedData[Database.indexOf(database)].add(fetchedDataList);
    }

    @Override
    public void replaceData(FetchedData fetchedData) {  // updating cache data
        List<List<FetchedData>> cachedDataListList = cachedData[Database.indexOf(fetchedData.getDatabase())];
        for (List<FetchedData> cachedDataList: cachedDataListList) {
            for (FetchedData cachedData : cachedDataList) {
                if (cachedData.equals(fetchedData)) {
                    // two fetchedData are equal regardless if they have Map filled
                    // here, "equal" refers to "having the same id in the same database"
                    cachedData.setDetails(fetchedData.getDetails());
                }
            }
        }
    }

    @Override
    public List<FetchedData> getDataOnPage(Database database, int page) {
        return cachedData[Database.indexOf(database)].get(page - 1);
    }


}
