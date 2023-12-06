package use_case.ToggleDisplayOption;

import org.junit.jupiter.api.Test;
import use_case.toggle_display_option.ToggleDisplayOptionInputData;
import use_case.toggle_display_option.ToggleDisplayOptionInteractor;
import use_case.toggle_display_option.ToggleDisplayOptionOutputBoundary;
import use_case.toggle_display_option.ToggleDisplayOptionOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToggleDisplayOptionInteractorTest {

    @Test
    void execute(){
        int databaseIndex = 1;
        String entryKey = "b";
        ToggleDisplayOptionInputData inputData = new ToggleDisplayOptionInputData(databaseIndex,entryKey);
        ToggleDisplayOptionOutputBoundary mockPresenter = new ToggleDisplayOptionOutputBoundary() {
            @Override
            public void prepareSuccessView(ToggleDisplayOptionOutputData toggleDisplayOptionOutputData) {
                assertEquals(toggleDisplayOptionOutputData.getDatabaseIndex(), databaseIndex);
                assertEquals(toggleDisplayOptionOutputData.getEntryKey(), entryKey);
            }
        };
        ToggleDisplayOptionInteractor toggleDisplayOptionInteractor = new ToggleDisplayOptionInteractor(mockPresenter);
        toggleDisplayOptionInteractor.execute(inputData);
    }

}
