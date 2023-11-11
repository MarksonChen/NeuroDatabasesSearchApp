package data_access;

import entity.FetchedData;
import entity.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.open_website.WebDataAccessInterface;

import java.io.IOException;
import java.util.*;

public class NeuroElectroDataAccessObject extends PreloadedDatabaseDataAccessObject{

    @Override
    public List<FetchedData> query(Query query, int resultsPerPage, int page) throws IOException {
        return null;
    }

    @Override
    public String getURL(String id) {
        return null;
    }

    @Override
    public String[] getEntryKeys() {
        return new String[0];
    }

    @Override
    public LinkedHashMap<String, String> getEntryDetail(String id) throws IOException {
        return null;
    }
}
