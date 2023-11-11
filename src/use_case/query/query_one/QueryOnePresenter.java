package use_case.query.query_one;

import data_access.Database;
import view_model.HistoryViewModel;
import view_model.ScrollResultsPanelModel;
import view_model.ScrollResultsPanelState;
import view_model.SearchViewModel;

import java.util.HashMap;
import java.util.Map;

public class QueryOnePresenter implements QueryOneOutputBoundary {

    @Override
    public void prepareSuccessView(QueryOneOutputData outputData) {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
