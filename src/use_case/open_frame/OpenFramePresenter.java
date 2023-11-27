package use_case.open_frame;

import view_model.FrameManagerModel;
import view_model.HistoryViewModel;
import view_model.StarredViewModel;

import java.util.Objects;

public class OpenFramePresenter implements OpenFrameOutputBoundary {

    private final FrameManagerModel frameManagerModel;
    private final StarredViewModel starredViewModel;
    private final HistoryViewModel historyViewModel;

    public OpenFramePresenter(FrameManagerModel frameManagerModel, StarredViewModel starredViewModel, HistoryViewModel historyViewModel) {
        this.frameManagerModel = frameManagerModel;
        this.starredViewModel = starredViewModel;
        this.historyViewModel = historyViewModel;
    }

    @Override
    public void openFrame(String viewName) {
        frameManagerModel.setActiveView(viewName);
        frameManagerModel.firePropertyChanged(FrameManagerModel.Open);
        if(Objects.equals(viewName, StarredViewModel.VIEW_NAME))
            starredViewModel.firePropertyChanged(StarredViewModel.REFRESH);
        else if (Objects.equals(viewName, HistoryViewModel.VIEW_NAME)) {
            historyViewModel.firePropertyChanged(HistoryViewModel.REFRESH);
        }

    }
}
