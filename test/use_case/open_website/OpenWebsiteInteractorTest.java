package use_case.open_website;

import data_access.WebDataAccessObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class OpenWebsiteInteractorTest {
    private WebDataAccessObject webDAO;
    private OpenWebsiteOutputBoundary mockPresenter;
    private String testData;

    @BeforeEach
    void setup(){
        webDAO = new WebDataAccessObject();
        mockPresenter = new OpenWebsiteOutputBoundary() {
            @Override
            public void prepareFailView(String s) {
            }
        };
        testData = "https://github.com/MarksonChen/NeuroDatabasesSearchApp";
    }

    @Test
    void testOpenWebsite(){
        OpenWebsiteInputBoundary openWebsiteInteractor = new OpenWebsiteInteractor(webDAO, mockPresenter);
        openWebsiteInteractor.execute(testData);
    }
    @Test
    void testThrowsException(){
        WebDataAccessInterface mockDAO;
        mockDAO = new WebDataAccessObject(){

            @Override
            public void openWebsite(String url) throws IOException {
                throw new IOException();
            }
        };
        OpenWebsiteInputBoundary openWebsiteInteractor = new OpenWebsiteInteractor(mockDAO, mockPresenter);
        openWebsiteInteractor.execute(testData);
    }
}
