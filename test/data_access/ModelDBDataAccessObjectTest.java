package data_access;

import entity.FetchedData;
import entity.Query;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;


public class ModelDBDataAccessObjectTest {  //also cover preloaded
    private WebDataAccessObject webDAO;
    private ModelDBDataAccessObject modelDBDAO;
    private Query query;

    @Before
    public void setUp() {
        webDAO = new WebDataAccessObject();
        modelDBDAO = new ModelDBDataAccessObject(webDAO);
        query = new Query("Hippocampus");
    }

    @Test
    public void testGetEntryDetail() throws IOException {
        LinkedHashMap<String, String> details = modelDBDAO.getEntryDetail("87284");
        assert modelDBDAO.getEntryKeys() != null;
        assert details != null;
        assert details.containsKey("description");
        assert details.containsKey("neurons");
        assert details.containsKey("keywords");
        assert details.containsKey("model paper");

    }

    @Test
    public void query() throws IOException {
        List<FetchedData> result = modelDBDAO.query(query, 1, 1);
        assert modelDBDAO.getTotalResults() != 0;
        assert result != null;
        assert Database.getDatabaseNames() != null;
    }

}
