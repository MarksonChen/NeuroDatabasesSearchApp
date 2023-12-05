package data_access;

import entity.FetchedData;
import entity.Query;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static data_access.Database.ModelDB;
import static data_access.Database.NeuroMorpho;
import static org.junit.jupiter.api.Assertions.*;

public class QueryDataAccessObjectTest {
    private WebDataAccessObject webDAO;
    private QueryDataAccessObject DAO;
    private Query query;
    private CacheDataAccessInterface cache;
    private ModelDBDataAccessObject modelDBDAO;

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        webDAO = new WebDataAccessObject();
        cache = new CacheDataAccessObject();
        DAO = new QueryDataAccessObject(cache, webDAO);
        query = new Query("Hippocampus");
        modelDBDAO = new ModelDBDataAccessObject(webDAO);
    }

    @Test
    public void testQueryAll() throws IOException {
        List<FetchedData> result = DAO.queryOne(NeuroMorpho, query, 1, 1);
        assert result != null;
        assert DAO.getQueryOneTotalResults() != 0;
        assert DAO.queryAll(query, 1, 1) != null;
        assert DAO.getQueryAllTotalResults() != null;
        assert DAO.getEntryKeys() != null;
    }

    @Test
    public void testFillDetail() throws IOException {
        List<FetchedData> result;
        result = modelDBDAO.query(query, 2, 1);
        assert DAO.fillDetails(result.get(0)) != null;
    }

    @Test
    public void testReplaceData() throws IOException {
        List<FetchedData> result;
        result = modelDBDAO.query(query, 2, 1);
        cache.cache(ModelDB, query, result);
        assert DAO.fillDetails(result.get(0)) != null;
    }
}