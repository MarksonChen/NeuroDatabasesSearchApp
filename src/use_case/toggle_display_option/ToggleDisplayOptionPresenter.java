package use_case.toggle_display_option;

import view_model.ScrollResultsPanelModel;
import view_model.SearchViewModel;
import view_model.StarredViewModel;

import java.util.LinkedHashMap;

public class ToggleDisplayOptionPresenter implements ToggleDisplayOptionOutputBoundary {
    private final SearchViewModel searchViewModel;
    private final StarredViewModel starredViewModel;
    private final ScrollResultsPanelModel[] resultsPanelModels;

    public ToggleDisplayOptionPresenter(SearchViewModel searchViewModel, StarredViewModel starredViewModel, ScrollResultsPanelModel[] resultsPanelModels) {
        this.searchViewModel = searchViewModel;
        this.starredViewModel = starredViewModel;
        this.resultsPanelModels = resultsPanelModels;
    }

    @Override
    public void prepareSuccessView(ToggleDisplayOptionOutputData outputData) {
        int databaseIndex = outputData.getDatabaseIndex();
        String entryKey = outputData.getEntryKey();

        LinkedHashMap<String, Boolean>[] detailEntryDisplayed = searchViewModel.getState().getDetailEntryDisplayed();
        boolean displayed = detailEntryDisplayed[databaseIndex].get(entryKey);
        detailEntryDisplayed[databaseIndex].put(entryKey, !displayed);
        searchViewModel.firePropertyChanged(SearchViewModel.REFRESH_OPTION_BAR);

        ScrollResultsPanelModel resultsPanelModel = resultsPanelModels[databaseIndex];
        resultsPanelModel.firePropertyChanged(ScrollResultsPanelModel.REFRESH_DATA_INFO_PANEL);

        starredViewModel.firePropertyChanged(StarredViewModel.REFRESH);

    }
}
