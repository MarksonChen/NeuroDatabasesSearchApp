package use_case.clear_history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClearHistoryControllerTest {

    private ClearHistoryController clearHistoryController;
    private ClearHistoryInteractor clearHistoryInteractor;
    private FakeHistoryDataAccessInterface historyDAO;

    @BeforeEach
    void setUp() {
        // Initialize the fake DAO or the real DAO
        historyDAO = new FakeHistoryDataAccessInterface();

        // Initialize the real interactor with the DAO
        clearHistoryInteractor = new ClearHistoryInteractor(historyDAO);

        // Initialize the controller with the real interactor
        clearHistoryController = new ClearHistoryController(clearHistoryInteractor);
    }

    @Test
    void executeShouldInvokeInteractor() {
        // Execute the method under test
        clearHistoryController.execute();

        // Assertions to verify the expected behavior
        assertTrue(historyDAO.isClearHistoryCalled);
    }

    // Fake DAO for testing purposes
    private class FakeHistoryDataAccessInterface implements HistoryDataAccessInterface {
        boolean isClearHistoryCalled = false;

        @Override
        public void clearHistory() {
            isClearHistoryCalled = true;
        }

    }
}

