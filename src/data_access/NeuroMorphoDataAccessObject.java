package data_access;

import entity.FetchedData;
import entity.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.open_website.WebDataAccessInterface;

import java.io.IOException;
import java.util.*;

public class NeuroMorphoDataAccessObject implements DatabaseDataAcecssInterface{
    private final WebDataAccessInterface webDAO;
    private static final Set<String> brainRegions = new HashSet<>();
    private static final Set<String> cellTypes = new HashSet<>();
    private static final boolean loaded = false;
    private int totalResults;
    private final String[] entryKeys = {"species", "strain", "soma_surface", "volume", "reference doi"};

    public NeuroMorphoDataAccessObject(WebDataAccessInterface webDAO) {
        this.webDAO = webDAO;
    }

    @Override
    public List<FetchedData> query(Query query, int resultsPerPage, int page) throws IOException {
        return null;
    }

    @Override
    public int getTotalResults() {
        return totalResults;
    }

    @Override
    public String getURL(String id) {
        return "https://neuromorpho.org/neuron_info.jsp?neuron_name=" + id;
    }

    @Override
    public String[] getEntryKeys() {
        return entryKeys;
    }
    private void loadBrainFields() throws IOException {
        String response = webDAO.getResponse("https://neuromorpho.org/api/neuron/fields/brain_region");
        JSONObject responseJson = new JSONObject(response);
        JSONArray fieldArray = responseJson.getJSONArray("fields");
        for (int i = 0; i < fieldArray.length(); i++) {
            brainRegions.add(fieldArray.getString(i)); // why to lowercase? later?
        }
    }

    private void loadCellFields() throws IOException {
        String response = webDAO.getResponse("https://neuromorpho.org/api/neuron/fields/cell_type");
        JSONObject responseJson = new JSONObject(response);
        JSONArray fieldArray = responseJson.getJSONArray("fields");
        for (int i = 0; i < fieldArray.length(); i++) {
            cellTypes.add(fieldArray.getString(i));
        }
    }

    public void load() throws IOException {
        loadBrainFields();
        loadCellFields();
    }

    private JSONArray fetchResults(Query query, int resultsPerPage, int page) throws IOException {
        return null;
    }
}