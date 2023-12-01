package use_case.fill_detail;

import data_access.Database;
import entity.FetchedData;
import view_model.MainFrameViewModel;
import view_model.ScrollResultsPanelModel;
import view_model.StarredViewModel;

import java.util.List;

public class FillDetailPresenter implements FillDetailOutputBoundary {
    private final ScrollResultsPanelModel[] resultsPanelModels;
    private final MainFrameViewModel mainFrameViewModel;

    public FillDetailPresenter(ScrollResultsPanelModel[] resultsPanelModels, StarredViewModel starredViewModel, MainFrameViewModel mainFrameViewModel) {
        this.resultsPanelModels = resultsPanelModels;
        this.mainFrameViewModel = mainFrameViewModel;
    }

    @Override
    public void prepareSuccessView(FetchedData outputData) {
        ScrollResultsPanelModel model = resultsPanelModels[Database.indexOf(outputData.getDatabase())];
        List<FetchedData> stateDataList = model.getState().getFetchedDataList();
        if (stateDataList.contains(outputData)){
            model.firePropertyChanged(ScrollResultsPanelModel.REFRESH_DATA_INFO_PANEL);
        }
    }

    @Override
    public void prepareFailView(String errorMessage) {
        mainFrameViewModel.getState().setErrorMessage(errorMessage);
        mainFrameViewModel.firePropertyChanged(MainFrameViewModel.ERROR);
    }
}
