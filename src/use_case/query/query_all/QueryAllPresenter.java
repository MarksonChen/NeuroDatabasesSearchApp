package use_case.query.query_all;

import data_access.Database;
import entity.FetchedData;
import view_model.HistoryViewModel;
import view_model.ScrollResultsPanelModel;
import view_model.ScrollResultsPanelState;
import view_model.SearchViewModel;

import java.util.List;

public class QueryAllPresenter implements QueryAllOutputBoundary {

    @Override
    public void prepareSuccessView(QueryAllOutputData outputData) {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
