package app;

import use_case.clear_history.ClearHistoryController;
import use_case.clear_history.ClearHistoryPresenter;
import use_case.fill_detail.FillDetailController;
import use_case.fill_detail.FillDetailPresenter;
import use_case.load_from_DAO.LoadFromDAOController;
import use_case.load_from_DAO.LoadFromDAOPresenter;
import use_case.open_frame.OpenFrameController;
import use_case.open_frame.OpenFramePresenter;
import use_case.open_website.OpenWebsiteController;
import use_case.open_website.OpenWebsitePresenter;
import use_case.query.query_all.QueryAllController;
import use_case.query.query_all.QueryAllPresenter;
import use_case.query.query_one.QueryOneController;
import use_case.query.query_one.QueryOnePresenter;
import use_case.reuse_history_query.ReuseHistoryQueryController;
import use_case.reuse_history_query.ReuseHistoryQueryPresenter;
import use_case.star.StarController;
import use_case.star.StarPresenter;
import use_case.switch_results_panel.SwitchResultsPanelController;
import use_case.switch_results_panel.SwitchResultsPanelPresenter;
import use_case.switch_view.SwitchViewController;
import use_case.switch_view.SwitchViewPresenter;
import use_case.toggle_display_option.ToggleDisplayOptionController;
import use_case.toggle_display_option.ToggleDisplayOptionPresenter;
import use_case.HistoryDataAccessInterface;
import use_case.clear_history.ClearHistoryInputBoundary;
import use_case.clear_history.ClearHistoryInteractor;
import use_case.clear_history.ClearHistoryOutputBoundary;
import use_case.fill_detail.FillDetailInputBoundary;
import use_case.fill_detail.FillDetailInteractor;
import use_case.fill_detail.FillDetailOutputBoundary;
import use_case.load_from_DAO.LoadFromDAOInputBoundary;
import use_case.load_from_DAO.LoadFromDAOInteractor;
import use_case.load_from_DAO.LoadFromDAOOutputBoundary;
import use_case.open_frame.OpenFrameInputBoundary;
import use_case.open_frame.OpenFrameInteractor;
import use_case.open_frame.OpenFrameOutputBoundary;
import use_case.open_website.OpenWebsiteInputBoundary;
import use_case.open_website.OpenWebsiteInteractor;
import use_case.open_website.OpenWebsiteOutputBoundary;
import use_case.open_website.WebDataAccessInterface;
import use_case.query.QueryDataAccessInterface;
import use_case.query.query_all.QueryAllInputBoundary;
import use_case.query.query_all.QueryAllInteractor;
import use_case.query.query_all.QueryAllOutputBoundary;
import use_case.query.query_one.QueryOneInputBoundary;
import use_case.query.query_one.QueryOneInteractor;
import use_case.query.query_one.QueryOneOutputBoundary;
import use_case.reuse_history_query.ReuseHistoryQueryInputBoundary;
import use_case.reuse_history_query.ReuseHistoryQueryInteractor;
import use_case.reuse_history_query.ReuseHistoryQueryOutputBoundary;
import use_case.star.StarDataAccessInterface;
import use_case.star.StarInputBoundary;
import use_case.star.StarInteractor;
import use_case.star.StarOutputBoundary;
import use_case.switch_results_panel.SwitchResultsPanelInputBoundary;
import use_case.switch_results_panel.SwitchResultsPanelInteractor;
import use_case.switch_results_panel.SwitchResultsPanelOutputBoundary;
import use_case.switch_view.SwitchViewInputBoundary;
import use_case.switch_view.SwitchViewInteractor;
import use_case.switch_view.SwitchViewOutputBoundary;
import use_case.toggle_display_option.ToggleDisplayOptionInputBoundary;
import use_case.toggle_display_option.ToggleDisplayOptionInteractor;
import use_case.toggle_display_option.ToggleDisplayOptionOutputBoundary;
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
        return null;
    }

    OpenFrameController createOpenFrameController() {
        return null;
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
        return null;
    }

    ClearHistoryController createClearHistoryController() {
        return null;
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
        return null;
    }
}
