package use_case.OpenFrame;

import org.junit.jupiter.api.Test;
import use_case.open_frame.OpenFrameInputBoundary;
import use_case.open_frame.OpenFrameInteractor;
import use_case.open_frame.OpenFrameOutputBoundary;
import view_model.FrameManagerModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenFrameInteractorTest {
    @Test
    void execute(){
        String inputdata = FrameManagerModel.Open;
        OpenFrameOutputBoundary mockpresenter = new OpenFrameOutputBoundary() {
            @Override
            public void openFrame(String viewName) {assertEquals(viewName, inputdata);}
        };
        OpenFrameInputBoundary openFrameInteractor = new OpenFrameInteractor(mockpresenter);
        openFrameInteractor.execute(inputdata);
    }
}
