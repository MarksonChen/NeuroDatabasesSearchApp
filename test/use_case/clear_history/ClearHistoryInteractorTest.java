package use_case.clear_history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClearHistoryInteractorTest {

    private ClearHistoryInteractor clearHistoryInteractor;
    private FakeHistoryDataAccessInterface historyDAO;

    @BeforeEach
    void setUp() {
        // Initialize the fake DAO
        historyDAO = new FakeHistoryDataAccessInterface();

        // Initialize the interactor with the fake DAO
        clearHistoryInteractor = new ClearHistoryInteractor(historyDAO);
    }

    @Test
    void executeShouldClearHistory() {
        // Execute the method under test
        clearHistoryInteractor.execute();

        // Verify that the clearHistory method was called on the DAO
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
