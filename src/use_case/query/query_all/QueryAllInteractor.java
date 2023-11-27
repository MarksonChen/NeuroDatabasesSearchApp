package use_case.query.query_all;

import entity.FetchedData;
import entity.Query;
import use_case.HistoryDataAccessInterface;
import use_case.query.QueryDataAccessInterface;
import use_case.star.StarDataAccessInterface;

import java.io.IOException;
import java.util.List;

public class QueryAllInteractor implements QueryAllInputBoundary {

    private final QueryAllOutputBoundary queryAllPresenter;
    private final QueryDataAccessInterface queryDAO;

    public QueryAllInteractor(QueryAllOutputBoundary queryAllOutputBoundary, QueryDataAccessInterface queryDAO) {
        this.queryAllPresenter = queryAllOutputBoundary;
        this.queryDAO = queryDAO;
    }

    @Override
    public void execute(QueryAllInputData inputData) {
        String keywords = inputData.getKeywords();
        Query query = new Query(keywords);
        if (query.getKeywords().trim().isEmpty()){
            queryAllPresenter.prepareFailView("Cannot search with empty query, please try again");
            return;
        }
        // Star & History may appear here
        List<Boolean>[] starredStateList = null;
        List<Query> historyQueryList = null;
        try {
            List<FetchedData>[] fetchedData = queryDAO.queryAll(query, inputData.getResultPerPage(), 1);
            int[] queryAllTotalResults = queryDAO.getQueryAllTotalResults();

            QueryAllOutputData outputData = new QueryAllOutputData(keywords, fetchedData, starredStateList, historyQueryList, queryAllTotalResults);
            queryAllPresenter.prepareSuccessView(outputData);
        } catch (IOException e) {
            queryAllPresenter.prepareFailView("An error occured while fetching query for \"" + keywords + "\"");
        }
    }
}
