package use_case.query.query_all;

import data_access.Database;
import entity.FetchedData;
import view_model.HistoryViewModel;
import view_model.ScrollResultsPanelModel;
import view_model.ScrollResultsPanelState;
import view_model.SearchViewModel;

import java.util.List;

public class QueryAllPresenter implements QueryAllOutputBoundary {
    private final SearchViewModel searchViewModel;
    private final ScrollResultsPanelModel[] resultsPanelModels;

    public QueryAllPresenter(SearchViewModel searchViewModel, ScrollResultsPanelModel[] resultsPanelModels) {
        this.searchViewModel = searchViewModel;
        this.resultsPanelModels = resultsPanelModels;
    }

    @Override
    public void prepareSuccessView(QueryAllOutputData outputData) {
        List<FetchedData>[] fetchedDataListArr = outputData.getFetchedData();
        List<Boolean>[] starredStateListArr = outputData.getStarredStateListArr();
        int[] totalResultsList = outputData.getQueryAllTotalResults();
        for (int i = 0; i < Database.length; i++) {
            ScrollResultsPanelState state = resultsPanelModels[i].getState();
            state.setFetchedDataList(fetchedDataListArr[i]);
            state.setTotalResults(totalResultsList[i]);
            state.setCurrentPage(1);
            state.setLastQuery(outputData.getQueryKeywords());
            state.setDataIsStarredList(starredStateListArr[i]);
            resultsPanelModels[i].firePropertyChanged(ScrollResultsPanelModel.REFRESH_ALL);
        }
    }

    @Override
    public void prepareFailView(String errorMessage) {
        searchViewModel.getState().setErrorMessage(errorMessage);
        searchViewModel.firePropertyChanged(SearchViewModel.ERROR);
    }
}
