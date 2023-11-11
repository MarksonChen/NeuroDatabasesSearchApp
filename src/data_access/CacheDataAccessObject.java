package data_access;

import entity.FetchedData;
import entity.Query;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CacheDataAccessObject implements CacheDataAccessInterface {

    @Override
    public boolean hasCache(Database database, Query query, int page) {
        return false;
    }

    @Override
    public void cache(Database database, Query query, List<FetchedData> fetchedDataList) {

    }

    @Override
    public void replaceData(FetchedData fetchedData) {

    }

    @Override
    public List<FetchedData> getDataOnPage(Database database, int page) {
        return null;
    }

    @Override
    public List<FetchedData>[] getCachedData() {
        return new List[0];
    }

    @Override
    public void saveCache(String pathName) throws IOException {

    }
}
