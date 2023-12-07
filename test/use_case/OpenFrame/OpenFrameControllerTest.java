package use_case.OpenFrame;

import org.junit.jupiter.api.Test;
import use_case.open_frame.OpenFrameController;
import use_case.open_frame.OpenFrameInputBoundary;
import use_case.open_frame.OpenFrameInteractor;
import use_case.open_frame.OpenFrameOutputBoundary;
import view_model.FrameManagerModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenFrameControllerTest {
    @Test
    void execute(){
        String inputData = FrameManagerModel.OPEN;
        OpenFrameOutputBoundary mockPresenter = new OpenFrameOutputBoundary() {
            @Override
            public void openFrame(String viewName) {assertEquals(viewName, inputData);}
        };
        OpenFrameInputBoundary openFrameInteractor = new OpenFrameInteractor(mockPresenter);
        OpenFrameController openFrameController = new OpenFrameController(openFrameInteractor);
        openFrameController.execute(inputData);
    }
}
