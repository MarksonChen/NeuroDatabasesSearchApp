package data_access;

import entity.FetchedData;
import entity.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.open_website.WebDataAccessInterface;

import java.io.IOException;
import java.util.*;

public class NeuroMorphoDataAccessObject implements DatabaseDataAcecssInterface{
    @Override
    public List<FetchedData> query(Query query, int resultsPerPage, int page) throws IOException {
        return null;
    }

    @Override
    public int getTotalResults() {
        return 0;
    }

    @Override
    public String getURL(String id) {
        return null;
    }

    @Override
    public String[] getEntryKeys() {
        return new String[0];
    }
}
