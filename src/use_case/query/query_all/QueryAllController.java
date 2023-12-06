package use_case.query.query_all;

public class QueryAllController {
    private final QueryAllInputBoundary queryAllInteractor;

    public QueryAllController(QueryAllInputBoundary queryAllInteractor) {this.queryAllInteractor = queryAllInteractor;}

    public void execute(String keywords, int resultsPerPage) {
        QueryAllInputData queryAllInputData = new QueryAllInputData(keywords, resultsPerPage);
        queryAllInteractor.execute(queryAllInputData);
    }
}
