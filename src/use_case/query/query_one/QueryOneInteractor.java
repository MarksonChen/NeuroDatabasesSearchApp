package use_case.query.query_one;

import entity.FetchedData;
import entity.Query;
import use_case.query.QueryDataAccessInterface;

import java.io.IOException;
import java.util.List;

public class QueryOneInteractor implements QueryOneInputBoundary{
    private final QueryDataAccessInterface queryDAO;
    private final QueryOneOutputBoundary queryPresent;

    public QueryOneInteractor(QueryOneOutputBoundary queryPresent, QueryDataAccessInterface queryDAO) {
        this.queryDAO = queryDAO;
        this.queryPresent = queryPresent;
    }

    /**
     * Send back result from one specific external database.
     *
     * @param inputData The info that needed to start a query, both API needed and program needed.
     */

    @Override
    public void execute(QueryOneInputData inputData) {
        Query query = new Query(inputData.getKeywords());
        if (query.getKeywords().trim().isEmpty()){
            queryPresent.prepareFailView("Error: Cannot search with empty query");
            return;
        }
        // Star & History may appear here
        List<Boolean> dataStarredStateList = null;
        List<Query> historyQueryList = null;

        try {
            List<FetchedData> fetchedData = queryDAO.queryOne(inputData.getDatabase(), query, inputData.getResultPerPage(), inputData.getPage());
            QueryOneOutputData Output = new QueryOneOutputData(inputData.getDatabase(), fetchedData, dataStarredStateList, historyQueryList, queryDAO.getQueryOneTotalResults(), inputData.getPage(), inputData.getKeywords());
            queryPresent.prepareSuccessView(Output);
        }
        catch (IOException e){
            queryPresent.prepareFailView("Error: Happened while fetching query on \""+ inputData.getKeywords() + "\"");
        }
    }
}
