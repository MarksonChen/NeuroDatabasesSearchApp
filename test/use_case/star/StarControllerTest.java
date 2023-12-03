package use_case.star;

import data_access.StarDataAccessObject;
import entity.FetchedData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import static org.junit.jupiter.api.Assertions.*;

class StarControllerTest {

    private StarController starController;
    private StarInteractor starInteractor;
    private StarDataAccessInterface starDAO; // This should be a real or test implementation

    @BeforeEach
    void setUp() {
        // Initialize the data access object (DAO)
        starDAO = new StarDataAccessObject("resources/serializables/starredData.ser");

        // Initialize the interactor with the DAO
        starInteractor = new StarInteractor(starDAO);

        // InitiaClize the controller with the interactor
        starController = new StarController(starInteractor);
    }

    @Test
    void executeShouldInvokeInteractor() {
        // Create a test instance of FetchedData
        FetchedData testData = new FetchedData("Sample Title", "Sample ID", "http://sampleurl.com", null, new LinkedHashMap<>());

        // Execute the method under test
        starController.execute(testData);

    }
}


