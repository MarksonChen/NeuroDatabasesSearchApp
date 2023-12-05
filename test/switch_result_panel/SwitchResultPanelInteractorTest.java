package switch_result_panel;

import org.junit.jupiter.api.Test;
import use_case.switch_results_panel.SwitchResultsPanelController;
import use_case.switch_results_panel.SwitchResultsPanelInputBoundary;
import use_case.switch_results_panel.SwitchResultsPanelInteractor;
import use_case.switch_results_panel.SwitchResultsPanelOutputBoundary;
import view_model.SearchViewModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwitchResultPanelInteractorTest {
    @Test
    void execute(){
        String inputData = SearchViewModel.ALL_DATABASES;
        SwitchResultsPanelOutputBoundary mockPresenter = new SwitchResultsPanelOutputBoundary() {
            @Override
            public void switchResultsPanel(String databaseOption) {
                assertEquals(databaseOption, inputData);
            }
        };
        SwitchResultsPanelInputBoundary switchResultsPanelInteractor = new SwitchResultsPanelInteractor(mockPresenter);
        SwitchResultsPanelController switchResultsPanelController = new SwitchResultsPanelController(switchResultsPanelInteractor);
        switchResultsPanelController.execute(inputData);
    }
}
