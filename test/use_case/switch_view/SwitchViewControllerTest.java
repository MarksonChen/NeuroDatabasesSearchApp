package use_case.switch_view;

import org.junit.jupiter.api.Test;
import view_model.SearchViewModel;

import static org.junit.jupiter.api.Assertions.*;

class SwitchViewControllerTest {

    @Test
    void execute() {
        String inputData = SearchViewModel.VIEW_NAME;
        SwitchViewOutputBoundary mockPresenter = new SwitchViewOutputBoundary() {
            @Override
            public void switchToView(String viewName) {
                assertEquals(viewName, inputData);
            }
        };
        SwitchViewInputBoundary switchViewInteractor = new SwitchViewInteractor(mockPresenter);
        SwitchViewController switchViewController = new SwitchViewController(switchViewInteractor);
        switchViewController.execute(inputData);
    }
}