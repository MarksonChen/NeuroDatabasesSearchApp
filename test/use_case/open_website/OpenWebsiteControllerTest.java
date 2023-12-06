package use_case.open_website;

import data_access.WebDataAccessObject;
import org.junit.jupiter.api.Test;

public class OpenWebsiteControllerTest {

    @Test
    void execute() {
        OpenWebsiteOutputBoundary mockPresenter = new OpenWebsiteOutputBoundary() {
            @Override
            public void prepareFailView(String errorMessage) {}
        };
        WebDataAccessObject webDAO = new WebDataAccessObject();
        OpenWebsiteInputBoundary openWebsiteInteractor = new OpenWebsiteInteractor(webDAO, mockPresenter);
        OpenWebsiteController openWebsiteController = new OpenWebsiteController(openWebsiteInteractor);
        openWebsiteController.execute("https://github.com/MarksonChen/NeuroDatabasesSearchApp");


    }
}
