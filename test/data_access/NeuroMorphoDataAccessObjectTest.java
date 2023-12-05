package data_access;

import entity.FetchedData;
import entity.Query;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NeuroMorphoDataAccessObjectTest {
    private WebDataAccessObject webDAO;
    private NeuroMorphoDataAccessObject NMDAO;
    private Query query;

    @Before
    public void setUp() {
        webDAO = new WebDataAccessObject();
        NMDAO = new NeuroMorphoDataAccessObject(webDAO);
        query = new Query("Hippocampus");
    }

    @Test
    public void testQuery() throws IOException {
        List<FetchedData>  result = NMDAO.query(query, 1, 1);
        assert NMDAO.getTotalResults() != 0;
        assert NMDAO.getEntryKeys() != null;
        assert result != null;
    }

}