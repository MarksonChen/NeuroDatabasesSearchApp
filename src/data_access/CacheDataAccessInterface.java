package data_access;

import entity.FetchedData;
import entity.Query;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public interface CacheDataAccessInterface {
    /**
     * @param database is the database currently looking
     * @param query
     * @param page
     * @return if there is cache data
     */
    boolean hasCache(Database database, Query query, int page);

    /**
     * @param database
     * @param query
     * this function cache the fetchedDataList
     */
    void cache(Database database, Query query, List<FetchedData> fetchedDataList);

    /**
     * this function updating cache data with fetchedData
     */
    void replaceData(FetchedData fetchedData);

    List<FetchedData> getDataOnPage(Database database, int page);


}
