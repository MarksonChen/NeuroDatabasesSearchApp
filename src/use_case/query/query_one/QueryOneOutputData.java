package use_case.query.query_one;

import data_access.Database;
import entity.FetchedData;
import entity.Query;

import java.util.List;

public class QueryOneOutputData {
    private final Database database;
    private final List<FetchedData> fetchedData;
    private final List<Boolean> dataStarredStateList;
    private final List<Query> historyQueryList;
    private final int queryOneTotalResults;
    private final int page;
    private final String queryKeyword;

    public QueryOneOutputData(Database database, List<FetchedData> fetchedData, List<Boolean> dataStarredStateList, List<Query> historyQueryList, int queryOneTotalResults, int page, String queryKeyword) {
        this.database = database;
        this.fetchedData = fetchedData;
        this.dataStarredStateList = dataStarredStateList;
        this.historyQueryList = historyQueryList;
        this.queryOneTotalResults = queryOneTotalResults;
        this.page = page;
        this.queryKeyword = queryKeyword;
    }

    public int getPage() {
        return page;
    }

    public int getQueryOneTotalResults() {
        return queryOneTotalResults;
    }

    public Database getDatabase() {
        return database;
    }

    public List<FetchedData> getFetchedData() {
        return fetchedData;
    }

    public List<Query> getHistoryQueryList() {
        return historyQueryList;
    }

    public String getQueryKeyword() {
        return queryKeyword;
    }

    public List<Boolean> getDataStarredStateList() {
        return dataStarredStateList;
    }
}
