package data_access;

import entity.FetchedData;
import entity.Query;
import use_case.query.QueryDataAccessInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryQueryDataAccessObject implements QueryDataAccessInterface {

    @Override
    public List<FetchedData> queryOne(Database database, Query query, int resultsPerPage, int page) throws IOException {
        return null;
    }

    @Override
    public List<FetchedData>[] queryAll(Query query, int resultsPerPage, int page) throws IOException {
        return new List[0];
    }

    @Override
    public FetchedData fillDetails(FetchedData data) throws IOException {
        return null;
    }

    @Override
    public int getQueryOneTotalResults() {
        return 0;
    }

    @Override
    public int[] getQueryAllTotalResults() {
        return new int[0];
    }

    @Override
    public String[][] getEntryKeys() {
        return new String[0][];
    }
}
