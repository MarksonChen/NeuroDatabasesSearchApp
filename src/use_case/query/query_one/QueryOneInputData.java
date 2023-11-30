package use_case.query.query_one;

import data_access.Database;

public class QueryOneInputData {
    private final Database database;
    private final String keywords;
    private final int perPage;
    private final int page;

    public QueryOneInputData(Database database, String keywords, int perPage, int page) {
        this.database = database;
        this.keywords = keywords;
        this.perPage = perPage;
        this.page = page;
    }

    public Database getDatabase() {
        return database;
    }

    public String getKeywords() {
        return keywords;
    }

    public int getResultPerPage() {
        return perPage;
    }

    public int getPage() {
        return page;
    }
}
