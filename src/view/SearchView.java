package view;

import data_access.Database;
import use_case.query.query_all.QueryAllController;
import use_case.query.query_one.QueryOneController;
import use_case.switch_results_panel.SwitchResultsPanelController;
import use_case.switch_view.SwitchViewController;
import use_case.toggle_display_option.ToggleDisplayOptionController;
import view_model.SearchViewModel;
import view_model.SearchViewState;
import view.search_view_components.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedHashMap;

public class SearchView extends JPanel {

    public SearchView(SearchViewModel searchViewModel, SwitchViewController switchViewController, SwitchResultsPanelController switchResultsPanelController, QueryAllController queryAllController, QueryOneController queryOneController, ToggleDisplayOptionController toggleDisplayOptionController) {

    }
}
