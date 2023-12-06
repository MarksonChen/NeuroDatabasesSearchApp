package data_access;

import entity.FetchedData;
import entity.Query;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static data_access.Database.NeuroMorpho;
import static org.junit.jupiter.api.Assertions.*;

public class InMemoryQueryDataAccessObjectTest {
    private WebDataAccessObject webDAO;
    private InMemoryQueryDataAccessObject DAO;
    private Query query;

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        webDAO = new WebDataAccessObject();
        DAO = new InMemoryQueryDataAccessObject(new CacheDataAccessObject(), "resources/serializables/fetchedDataListArr.ser");
        query = new Query("Hippocampus");
    }

    @Test
    public void testQueryAll() throws IOException {
        List<FetchedData> result = DAO.queryOne(NeuroMorpho, query, 1, 1);
        assert result != null;
        assert DAO.fillDetails(result.get(0)) != null;
        assert DAO.getQueryOneTotalResults() != 0;
        assert DAO.queryAll(query, 1, 1) != null;
        assert DAO.getQueryAllTotalResults() != null;
        assert DAO.getEntryKeys() != null;
    }

    @Test
    public void testFillDetails(){

    }

}