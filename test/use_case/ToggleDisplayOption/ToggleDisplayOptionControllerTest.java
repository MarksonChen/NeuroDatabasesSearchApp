package use_case.ToggleDisplayOption;

import org.junit.jupiter.api.Test;
import use_case.toggle_display_option.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToggleDisplayOptionControllerTest {
    @Test
    void execute(){
        int databaseIndex = 0;
        String entryKey = "a";
        ToggleDisplayOptionInputData inputData = new ToggleDisplayOptionInputData(databaseIndex,entryKey);
        ToggleDisplayOptionOutputBoundary mockPresenter = new ToggleDisplayOptionOutputBoundary() {
            @Override
            public void prepareSuccessView(ToggleDisplayOptionOutputData toggleDisplayOptionOutputData) {
                assertEquals(toggleDisplayOptionOutputData.getDatabaseIndex(), inputData.getDataBaseIndex());
                assertEquals(toggleDisplayOptionOutputData.getEntryKey(), inputData.getEntryKey());
            }
        };
        ToggleDisplayOptionInputBoundary toggleDisplayOptionInteractor = new ToggleDisplayOptionInteractor(mockPresenter);
        ToggleDisplayOptionController toggleDisplayOptionController = new ToggleDisplayOptionController(toggleDisplayOptionInteractor);
        toggleDisplayOptionController.execute(databaseIndex,entryKey);
    }
}
