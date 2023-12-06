package use_case.query.query_one;

import data_access.*;
import entity.FetchedData;
import entity.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.HistoryDataAccessInterface;
import use_case.query.QueryDataAccessInterface;
import use_case.query.query_all.*;
import use_case.star.StarDataAccessInterface;
import view_model.SearchViewModel;

import java.io.IOException;
import java.util.List;

public class QueryOneTest {

    // This test file is a combination of QueryOneInteractorTest and QueryOneControllerTest
    // Using Unit Test and integration Test.

    QueryDataAccessInterface queryDAO;
    StarDataAccessInterface starDAO;
    HistoryDataAccessInterface historyDAO;
    @BeforeEach
    void setUp() {
        try {
            queryDAO = new InMemoryQueryDataAccessObject(new CacheDataAccessObject(), "resources/serializables/fetchedDataListArr.ser");
            starDAO = new StarDataAccessObject("resources/serializables/starredData.ser");
            starDAO.clear();
            historyDAO = new HistoryDataAccessObject("resources/serializables/historyQueries.ser");
            historyDAO.clear();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void controllerTest() {
        for (int i=0;i<Database.length;i++){
            QueryOneOutputBoundary mockPresenter = new QueryOneOutputBoundary(){
                @Override
                public void prepareSuccessView(QueryOneOutputData outputData) {
                    Assertions.assertFalse(Database.indexOf(outputData.getDatabase())==-1);
                    Assertions.assertFalse(outputData.getFetchedData().isEmpty());
                    Assertions.assertFalse(outputData.getQueryOneTotalResults()<0);
                    Assertions.assertFalse(outputData.getPage()!=1);
                    Assertions.assertEquals("hippocampus", outputData.getQueryKeyword());
                    Assertions.assertFalse(outputData.getDataStarredStateList().isEmpty());
                    Assertions.assertFalse(outputData.getHistoryQueryList().isEmpty());
                }

                @Override
                public void prepareFailView(String s) {Assertions.fail("Failure unexpected");
                };
            };

            QueryOneInputBoundary queryInteractor = new QueryOneInteractor(mockPresenter, queryDAO, starDAO, historyDAO);
            QueryOneController queryOneController = new QueryOneController(queryInteractor);

            queryOneController.execute(Database.get(i), "hippocampus", SearchViewModel.DEFAULT_RESULTS_PER_PAGE, 1);
        }
    }

    @Test
    void successTestBasic() {
        QueryOneInputData inputData = new QueryOneInputData(Database.get(0),"hippocampus", SearchViewModel.DEFAULT_RESULTS_PER_PAGE,1);

        QueryOneOutputBoundary mockPresenter = new QueryOneOutputBoundary() {
            @Override
            public void prepareSuccessView(QueryOneOutputData outputData) {
                Assertions.assertFalse(Database.indexOf(outputData.getDatabase())==-1);
                Assertions.assertFalse(outputData.getFetchedData().isEmpty());
                Assertions.assertFalse(outputData.getQueryOneTotalResults()<0);
                Assertions.assertFalse(outputData.getPage()!=1);
                Assertions.assertFalse(outputData.getDataStarredStateList().isEmpty());
                Assertions.assertFalse(outputData.getHistoryQueryList().isEmpty());
                Assertions.assertEquals(outputData.getQueryKeyword(), inputData.getKeywords());
            }

            @Override
            public void prepareFailView(String s) {
                Assertions.fail("Failure unexpected");
            }
        };

        QueryOneInputBoundary queryInteractor = new QueryOneInteractor(mockPresenter, queryDAO, starDAO, historyDAO);
        queryInteractor.execute(inputData);
    }


    @Test
    void failTestEmptyQuery(){
        QueryOneInputData inputData = new QueryOneInputData(Database.get(0),"", SearchViewModel.DEFAULT_RESULTS_PER_PAGE,1);

        QueryOneOutputBoundary mockPresenter = new QueryOneOutputBoundary() {
            @Override
            public void prepareSuccessView(QueryOneOutputData outputData) {
                Assertions.fail("Success unexpected");
            }

            @Override
            public void prepareFailView(String s) {
                //Test passed
            }
        };

        QueryOneInputBoundary queryInteractor = new QueryOneInteractor(mockPresenter, queryDAO, starDAO, historyDAO);
        queryInteractor.execute(inputData);
    }

    @Test
    void exceptionTest() {
        HistoryDataAccessInterface HDAO;
        try {
            HDAO = new HistoryDataAccessObject("resources/serializables/historyQueries.ser") {
                @Override
                public void saveToFile() throws IOException {
                    throw new IOException();
                }
            };
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        QueryOneOutputBoundary mockPresenter = new QueryOneOutputBoundary(){
            @Override
            public void prepareFailView(String s){
                // pass
            };

            @Override
            public void prepareSuccessView(QueryOneOutputData outputData) {
                Assertions.fail("Unexpected success");
            }
        };

        QueryOneInputBoundary queryInteractor = new QueryOneInteractor(mockPresenter, queryDAO, starDAO, HDAO);
        QueryOneInputData inputData = new QueryOneInputData(Database.get(1), "hippocampus", SearchViewModel.DEFAULT_RESULTS_PER_PAGE, 1);
        QueryOneController queryOneController = new QueryOneController(queryInteractor);
        queryInteractor.execute(inputData);
    }

    @Test
    void interactorTest(){
        QueryDataAccessInterface QDAO;
        try {
            QDAO = new InMemoryQueryDataAccessObject(new CacheDataAccessObject(), "resources/serializables/fetchedDataListArr.ser"){
                @Override
                public List<FetchedData> queryOne(Database database, Query query, int resultsPerPage, int page) throws IOException {
                    throw new IOException();
                }
            };
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        QueryOneOutputBoundary mockPresenter = new QueryOneOutputBoundary() {
            @Override
            public void prepareSuccessView(QueryOneOutputData outputData) {
                Assertions.fail("Unexpected success");
            }

            @Override
            public void prepareFailView(String s){
                // pass
            }
        };

        QueryOneInputBoundary queryInteractor = new QueryOneInteractor(mockPresenter, QDAO, starDAO, historyDAO);
        QueryOneInputData inputData = new QueryOneInputData(Database.get(1), "hippocampus", SearchViewModel.DEFAULT_RESULTS_PER_PAGE, 1);
        queryInteractor.execute(inputData);
    }

}
