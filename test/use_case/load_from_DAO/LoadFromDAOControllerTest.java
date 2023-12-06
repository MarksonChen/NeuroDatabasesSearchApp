package use_case.load_from_DAO;

import data_access.CacheDataAccessObject;
import data_access.HistoryDataAccessObject;
import data_access.InMemoryQueryDataAccessObject;
import data_access.StarDataAccessObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.HistoryDataAccessInterface;
import use_case.query.QueryDataAccessInterface;
import use_case.star.StarDataAccessInterface;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoadFromDAOControllerTest {

    private QueryDataAccessInterface queryDAO;
    private StarDataAccessInterface starDAO;
    private HistoryDataAccessInterface historyDAO;

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
    void execute() {
        LoadFromDAOOutputBoundary mockPresenter = new LoadFromDAOOutputBoundary() {
            @Override
            public void updateStatesWithData(LoadFromDAOOutputData outputData) {
                // Test passed
            }
        };
        LoadFromDAOInputBoundary interactor = new LoadFromDAOInteractor(mockPresenter, queryDAO, starDAO, historyDAO);
        LoadFromDAOController controller = new LoadFromDAOController(interactor);
        controller.execute();
    }
}