package use_case.query;

import data_access.Database;
import entity.FetchedData;
import entity.Query;

import java.io.IOException;
import java.util.List;

public interface QueryDataAccessInterface {
    /**
     * @param database is the database user want to draw
     * @param query is input by user
     * @param resultsPerPage
     * @param page
     * @return a list of FetchedData that is result of the query
     * @throws IOException
     */
    List<FetchedData> queryOne(Database database, Query query, int resultsPerPage, int page) throws IOException;

    /**
     * @param query to all database at once
     * @param resultsPerPage
     * @param page
     * @return a list of FetchedData from all database
     * @throws IOException
     */
    List<FetchedData>[] queryAll(Query query, int resultsPerPage, int page) throws IOException;

    /**
     * @param data
     * @return the same FetchedData but with the detail filed (just for NeuroMorpho and ModelDB)
     * @throws IOException
     */
    FetchedData fillDetails(FetchedData data) throws IOException;

    /**
     * @return number of result of QueryOne
     */
    int getQueryOneTotalResults();

    /**
     * @return number of result of QueryAll
     */
    int[] getQueryAllTotalResults();

    /**
     * @return entryKeys for databases
     */
    String[][] getEntryKeys();
}
