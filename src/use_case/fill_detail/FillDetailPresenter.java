package use_case.fill_detail;

import data_access.Database;
import entity.FetchedData;
import view_model.MainFrameViewModel;
import view_model.ScrollResultsPanelModel;
import view_model.StarredViewModel;

import java.util.List;

public class FillDetailPresenter implements FillDetailOutputBoundary {
    @Override
    public void prepareSuccessView(FetchedData outputData) {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
