package app;

import use_case.clear_history.ClearHistoryController;
import use_case.fill_detail.FillDetailController;
import use_case.load_from_DAO.LoadFromDAOController;
import use_case.open_frame.OpenFrameController;
import use_case.open_frame.OpenFramePresenter;
import use_case.open_website.*;
import use_case.query.query_all.QueryAllController;
import use_case.query.query_one.QueryOneController;
import use_case.reuse_history_query.ReuseHistoryQueryController;
import use_case.star.StarController;
import use_case.switch_results_panel.SwitchResultsPanelController;
import use_case.switch_results_panel.SwitchResultsPanelPresenter;
import use_case.switch_view.SwitchViewController;
import use_case.switch_view.SwitchViewPresenter;
import use_case.toggle_display_option.ToggleDisplayOptionController;
import use_case.HistoryDataAccessInterface;
import use_case.open_frame.OpenFrameInputBoundary;
import use_case.open_frame.OpenFrameInteractor;
import use_case.open_frame.OpenFrameOutputBoundary;
import use_case.query.QueryDataAccessInterface;
import use_case.star.StarDataAccessInterface;
import use_case.switch_results_panel.SwitchResultsPanelInputBoundary;
import use_case.switch_results_panel.SwitchResultsPanelInteractor;
import use_case.switch_results_panel.SwitchResultsPanelOutputBoundary;
import use_case.switch_view.SwitchViewInputBoundary;
import use_case.switch_view.SwitchViewInteractor;
import use_case.switch_view.SwitchViewOutputBoundary;
import view_model.*;

public class ControllerFactory {
    private final SearchViewModel searchViewModel;
    private final FrontPageViewModel frontPageViewModel;
    private final StarredViewModel starredViewModel;
    private final HistoryViewModel historyViewModel;
    private final MainFrameViewModel mainFrameViewModel;
    private final ViewManagerModel viewManagerModel;
    private final FrameManagerModel frameManagerModel;
    private final ScrollResultsPanelModel[] resultsPanelModels;
    private final WebDataAccessInterface webDAO;
    private final QueryDataAccessInterface queryDAO;
    private final StarDataAccessInterface starDAO;
    private final HistoryDataAccessInterface historyDAO;

    public ControllerFactory(SearchViewModel searchViewModel, FrontPageViewModel frontPageViewModel, StarredViewModel starredViewModel, HistoryViewModel historyViewModel, MainFrameViewModel mainFrameViewModel, ViewManagerModel viewManagerModel, FrameManagerModel frameManagerModel, ScrollResultsPanelModel[] resultsPanelModels, WebDataAccessInterface webDAO, QueryDataAccessInterface queryDAO, StarDataAccessInterface starDAO, HistoryDataAccessInterface historyDAO) {
        this.searchViewModel = searchViewModel;
        this.frontPageViewModel = frontPageViewModel;
        this.starredViewModel = starredViewModel;
        this.historyViewModel = historyViewModel;
        this.mainFrameViewModel = mainFrameViewModel;
        this.viewManagerModel = viewManagerModel;
        this.frameManagerModel = frameManagerModel;
        this.resultsPanelModels = resultsPanelModels;
        this.webDAO = webDAO;
        this.queryDAO = queryDAO;
        this.starDAO = starDAO;
        this.historyDAO = historyDAO;
    }

    // The methods have default visibility, aka "package private"

    SwitchViewController createSwitchViewController() {
        // Presenter depends on ViewModel
        SwitchViewOutputBoundary switchViewPresenter = new SwitchViewPresenter(viewManagerModel);
        // Interactor depends on Presenter (and optionally, DAO)
        SwitchViewInputBoundary switchViewInteractor = new SwitchViewInteractor(switchViewPresenter);
        // Controller depends on Interactor
        return new SwitchViewController(switchViewInteractor);
        // View depends on Controller
    }

    SwitchResultsPanelController createSwitchResultsPanelController() {
        SwitchResultsPanelOutputBoundary switchResultsPanelPresenter = new SwitchResultsPanelPresenter(searchViewModel);
        SwitchResultsPanelInputBoundary switchResultsPanelInteractor = new SwitchResultsPanelInteractor(switchResultsPanelPresenter);
        return new SwitchResultsPanelController(switchResultsPanelInteractor);
    }

    OpenFrameController createOpenFrameController() {
        OpenFrameOutputBoundary openFramePresenter = new OpenFramePresenter(frameManagerModel, starredViewModel, historyViewModel);
        OpenFrameInputBoundary openFrameInteractor = new OpenFrameInteractor(openFramePresenter);
        return new OpenFrameController(openFrameInteractor);
    }

    QueryAllController createQueryAllController() {
        return null;
    }

    QueryOneController createQueryOneController() {
        return null;
    }

    FillDetailController createFillDetailController() {
        return null;
    }

    StarController createStarController() {
        StarOutputBoundary starPresenter = new StarPresenter(resultsPanelModels, starredViewModel);
        StarInputBoundary starInteractor = new StarInteractor(starPresenter, starDAO);
        return new StarController(starInteractor);
    }

    ClearHistoryController createClearHistoryController() {
        ClearHistoryOutputBoundary clearHistoryPresenter = new ClearHistoryPresenter(historyViewModel);
        ClearHistoryInputBoundary clearHistoryInteractor = new ClearHistoryInteractor(clearHistoryPresenter, historyDAO);
        return new ClearHistoryController(clearHistoryInteractor);
    }

    ReuseHistoryQueryController createReuseHistoryQueryController() {
        return null;
    }

    LoadFromDAOController createLoadFromDAOController() {
        return null;
    }

    ToggleDisplayOptionController createToggleDisplayOptionController() {
        return null;
    }

    OpenWebsiteController createOpenWebsiteController() {
        OpenWebsiteOutputBoundary openWebsitePresenter = new OpenWebsitePresenter(mainFrameViewModel);
        OpenWebsiteInputBoundary openWebsiteInteractor = new OpenWebsiteInteractor(webDAO, openWebsitePresenter);
        return new OpenWebsiteController(openWebsiteInteractor);
    }
}
