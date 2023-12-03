package use_case.star;

import entity.FetchedData;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class StarInteractorTest {

    @Test
    void executeWithBasicTest() {
        // Create a simple instance of FetchedData
        FetchedData testData = new FetchedData("Sample Title", "Sample ID", "http://sampleurl.com", null, new LinkedHashMap<>());

        // Create the StarInteractor with null dependencies
        StarInteractor starInteractor = new StarInteractor(null, null);

        // Execute the method under test
        try {
            starInteractor.execute(testData);
            assertTrue(true); // If no exception is thrown, the test passes
        } catch (Exception e) {
            fail("Execution of StarInteractor.execute should not throw an exception.");
        }
    }
}




