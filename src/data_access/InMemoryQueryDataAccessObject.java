package data_access;

import entity.FetchedData;
import entity.Query;
import use_case.query.QueryDataAccessInterface;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class InMemoryQueryDataAccessObject implements QueryDataAccessInterface {
    private final CacheDataAccessInterface dataCacheDAO;
    private final List<FetchedData>[] fetchedDataListArr;
    private final List<FetchedData>[] DataListArr;
    private final List<String>[] dataIDArr;
    private Database lastQueryDatabase;

    public InMemoryQueryDataAccessObject(CacheDataAccessInterface dataCacheDAO, String serializableFilePath) throws IOException, ClassNotFoundException {
        this.dataCacheDAO = dataCacheDAO;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializableFilePath));
        fetchedDataListArr = (List<FetchedData>[]) ois.readObject();


        // load dataID, diff
        dataIDArr = new List[Database.length];
        for (int i = 0; i < Database.length; i++) {
            List<String> ids = new ArrayList<>();
            for (FetchedData fetchedData : fetchedDataListArr[i]) {
                ids.add(fetchedData.getId());
            }
            dataIDArr[i] = ids;
        }

        DataListArr = new List[Database.length];
        DataListArr[0] = fetchedDataListArr[0];  // load neuroMorpho
        for (int i = 1; i < Database.length; i++) {  // load modelDB and neuroElectro
            DataListArr[i] = new ArrayList<>();
            for (int j = 0; j < fetchedDataListArr[i].size(); j++) {
                FetchedData data = fetchedDataListArr[i].get(j);
                DataListArr[i].add(new FetchedData(data.getTitle(), data.getId(), data.getURL(), data.getDatabase()));
            }
        }


    }

    private List<FetchedData> getPageData(int resultsPerPage, int page, List<FetchedData> dataList) {
        return dataList.subList((page-1) * resultsPerPage, Math.min(dataList.size(),(page) * resultsPerPage));
    }

    @Override
    public FetchedData fillDetails(FetchedData data) {
        int arrIndex = Database.indexOf(data.getDatabase());  // get the index of the data in database
        int listIndex = dataIDArr[arrIndex].indexOf(data.getId());  // get the index of the data id in dataIDArr
        FetchedData detail = fetchedDataListArr[arrIndex].get(listIndex);
        data.setDetails(detail.getDetails());
        return data;
    }

    @Override
    public List<FetchedData> queryOne(Database database, Query query, int resultsPerPage, int page) throws IOException {
        lastQueryDatabase = database;
        if(dataCacheDAO.hasCache(database, query, page)) {
            return dataCacheDAO.getDataOnPage(database, page);
        }
        List<FetchedData> fetchedDataList = DataListArr[Database.indexOf(database)];  // get data of that database
        return getPageData(resultsPerPage, page, fetchedDataList);
    }

    @Override
    public List<FetchedData>[] queryAll(Query query, int resultsPerPage, int page) throws IOException {
        List<FetchedData>[] queryResult = new List[Database.length];
        for (int i = 0; i < Database.length; i++) {
            queryResult[i] = getPageData(resultsPerPage, page, DataListArr[i]);
        }
        return queryResult;
    }

    @Override
    public int getQueryOneTotalResults() {
        return DataListArr[Database.indexOf(lastQueryDatabase)].size();
    }

    @Override
    public List<Integer> getQueryAllTotalResults() {
        List<Integer> result = new ArrayList<>();;
        for (int i = 0; i < DataListArr.length; i++) {
            result.add(DataListArr[i].size());
        }
        return result;
    }

    @Override
    public String[][] getEntryKeys() {
        return new String[][]{
                new NeuroMorphoDataAccessObject(null).getEntryKeys(),
                new NeuroElectroDataAccessObject(null).getEntryKeys(),
                new ModelDBDataAccessObject(null).getEntryKeys()};
    }
}
