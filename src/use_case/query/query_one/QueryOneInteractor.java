package use_case.query.query_one;

import entity.FetchedData;
import entity.Query;
import use_case.HistoryDataAccessInterface;
import use_case.query.QueryDataAccessInterface;
import use_case.star.StarDataAccessInterface;

import java.io.IOException;
import java.util.List;

public class QueryOneInteractor implements QueryOneInputBoundary{
    private final QueryDataAccessInterface queryDAO;
    private final QueryOneOutputBoundary queryPresent;
    private final StarDataAccessInterface starDAO;
    private final HistoryDataAccessInterface historyDAO;

    public QueryOneInteractor(QueryOneOutputBoundary queryPresent, QueryDataAccessInterface queryDAO, StarDataAccessInterface starDAO, HistoryDataAccessInterface historyDAO) {
        this.queryDAO = queryDAO;
        this.queryPresent = queryPresent;
        this.starDAO = starDAO;
        this.historyDAO = historyDAO;
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

        historyDAO.add(query);
        try {
            historyDAO.saveToFile();
        } catch (IOException e) {
            e.printStackTrace(); // No need to push an alert if this automatic process is not working
        }

        try {
            List<FetchedData> fetchedData = queryDAO.queryOne(inputData.getDatabase(), query, inputData.getResultPerPage(), inputData.getPage());
            List<Boolean> dataStarredStateList = starDAO.checkIfDataStarred(fetchedData);
            List<Query> historyQueryList = historyDAO.getHistoryQueryList();
            QueryOneOutputData outputData = new QueryOneOutputData(inputData.getDatabase(), fetchedData, dataStarredStateList, historyQueryList, queryDAO.getQueryOneTotalResults(), inputData.getPage(), inputData.getKeywords());
            queryPresent.prepareSuccessView(outputData);
        } catch (IOException e){
            queryPresent.prepareFailView("Error: Happened while fetching query on \""+ inputData.getKeywords() + "\"");
        }
    }
}
