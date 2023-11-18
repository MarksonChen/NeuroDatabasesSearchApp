package use_case.switch_view;

import org.junit.jupiter.api.Test;
import view.SearchView;
import view_model.SearchViewModel;

import static org.junit.jupiter.api.Assertions.*;

class SwitchViewInteractorTest {

    @Test
    void successTest(){
        // Note that this is a very basic version of the JUnit test
        // As there are no input/output data structure. no DAO usage,
        // and no "prepareFailView" & "prepareSuccessView" structure.

        String inputData = SearchViewModel.VIEW_NAME;

        SwitchViewOutputBoundary mockPresenter = new SwitchViewOutputBoundary() {
            @Override
            public void switchToView(String viewName) {
                assertEquals(viewName, inputData);
            }
        };
        SwitchViewInteractor interactor = new SwitchViewInteractor(mockPresenter);
        interactor.execute(inputData);
    }

}