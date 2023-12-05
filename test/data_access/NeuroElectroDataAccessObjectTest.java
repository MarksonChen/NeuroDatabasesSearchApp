package data_access;

import entity.FetchedData;
import entity.Query;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NeuroElectroDataAccessObjectTest {
    private WebDataAccessObject webDAO;
    private NeuroElectroDataAccessObject NEDAO;
    private Query query;

    @Before
    public void setUp() {
        webDAO = new WebDataAccessObject();
        NEDAO = new NeuroElectroDataAccessObject(webDAO);
        query = new Query("Hippocampus");
    }

    @Test
    public void testGetEntryDetail() throws IOException {
        LinkedHashMap<String, String> details = NEDAO.getEntryDetail("72");
        assert NEDAO.getEntryKeys() != null;
        assert details != null;
        assert details.containsKey("input resistance");
        assert details.containsKey("resting membrane potential");
        assert details.containsKey("spike threshold");
        assert details.containsKey("spike half-width");
        assert details.containsKey("spike amplitude");
    }

    @Test
    public void query() throws IOException {
        List<FetchedData> result = NEDAO.query(query, 1, 1);
        assert result != null;
    }

}