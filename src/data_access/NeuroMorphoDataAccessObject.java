package data_access;

import entity.FetchedData;
import entity.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.open_website.WebDataAccessInterface;

import java.io.IOException;
import java.util.*;

import static data_access.PreloadedDatabaseDataAccessObject.splitWords;

public class NeuroMorphoDataAccessObject implements DatabaseDataAcecssInterface{
    private final WebDataAccessInterface webDAO;
    private static final Set<String> brainRegions = new HashSet<>();
    private static final Set<String> cellTypes = new HashSet<>();
    private static boolean loaded = false;
    private int totalResults;
    private final String[] entryKeys = {"species", "strain", "soma_surface", "volume", "reference doi"};

    public NeuroMorphoDataAccessObject(WebDataAccessInterface webDAO) {
        this.webDAO = webDAO;
    }

    /**
     * @param query is the query input by "user"
     * @param resultsPerPage is results per page that need to display
     * @param page is current page number
     * @return a list of fetch data
     * @throws IOException
     */
    @Override
    public List<FetchedData> query(Query query, int resultsPerPage, int page) throws IOException {
        if (!loaded) {
            load();
            loaded = true;
        }
        JSONArray queryResults = fetchResults(query, resultsPerPage, page);
        if (queryResults == null) {
            return new ArrayList<>();
        }
        List<FetchedData> entries = new ArrayList<>();
        for (int i = 0; i < queryResults.length(); i++) {
            entries.add(parseEntry(queryResults.getJSONObject(i)));
        }
        return entries;

    }

    private FetchedData parseEntry(JSONObject entry) {
        String title = entry.getJSONArray("brain_region").getString(0) + ", "
                + joinJSONArray(entry.getJSONArray("cell_type"));
        String id = entry.getString("neuron_name");
        LinkedHashMap<String, String> details = new LinkedHashMap<>();
        details.put(entryKeys[0], entry.getString("species"));
        details.put(entryKeys[1], entry.getString("strain"));
        details.put(entryKeys[2], entry.getString("soma_surface"));
        details.put(entryKeys[3], entry.getString("volume"));
        details.put(entryKeys[4], entry.getJSONArray("reference_doi").getString(0));
        return new FetchedData(title, id, getURL(id), Database.NeuroMorpho, details);
    }

    private String joinJSONArray(JSONArray jsonArr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArr.length(); i++) {
            list.add(jsonArr.getString(i));
        }
        return String.join(", ", list);
    }

    /**
     * @return number of total result
     */
    @Override
    public int getTotalResults() {
        return totalResults;
    }

    /**
     * @param id is the id of the neuron name
     * @return the url for that neuron
     */
    @Override
    public String getURL(String id) {
        return "https://neuromorpho.org/neuron_info.jsp?neuron_name=" + id;
    }

    /**
     * @return All the entry keys of this api we need.
     */
    @Override
    public String[] getEntryKeys() {
        return entryKeys;
    }
    private void loadBrainFields() throws IOException {
        String response = webDAO.getResponse("https://neuromorpho.org/api/neuron/fields/brain_region");
        JSONObject responseJson = new JSONObject(response);
        if (responseJson.has("fields")) {
            JSONArray fieldArray = responseJson.getJSONArray("fields");
            for (int i = 0; i < fieldArray.length(); i++) {
                brainRegions.add(fieldArray.getString(i).toLowerCase());
            }
        }
    }

    private void loadCellFields() throws IOException {
        String response = webDAO.getResponse("https://neuromorpho.org/api/neuron/fields/cell_type");
        JSONObject responseJson = new JSONObject(response);
        if (responseJson.has("fields")) {
            JSONArray fieldArray = responseJson.getJSONArray("fields");
            for (int i = 0; i < fieldArray.length(); i++) {
                cellTypes.add(fieldArray.getString(i).toLowerCase());
            }
        }
    }

    /**
     * It load all the fetch results into brainRegions and cellTypes
     * @throws IOException
     */
    public void load() throws IOException {
        loadBrainFields();
        loadCellFields();
    }

    private JSONArray fetchResults(Query query, int resultsPerPage, int page) throws IOException {
        String[] keywords = splitWords(query.getKeywords());
        String cellType = null, brainRegion = null;
        for (String keyword: keywords){
            if (cellTypes.contains(keyword)){
                cellType = keyword;
                break;
            }
        }
        for (String keyword: keywords){
            if (brainRegions.contains(keyword) && (cellType == null || !cellType.equals(keyword))){
                brainRegion = keyword;
                break;
            }
        }
        if (cellType == null && brainRegion == null){
            totalResults = 0;
            return null;  // No brain region / cell types matched, so no results were fetched
        }

        String path = buildPath(resultsPerPage, page, cellType, brainRegion);
        String response = webDAO.getResponse(path);
        JSONObject responseJSON = new JSONObject(response);
        totalResults = responseJSON.getJSONObject("page").getInt("totalElements");
        return responseJSON.getJSONObject("_embedded").getJSONArray("neuronResources");

    }

    private String buildPath(int resultsPerPage, int page, String cellType, String brainRegion) {
        StringBuilder path = new StringBuilder("https://neuromorpho.org/api/neuron/select?q=");
        if (cellType != null && brainRegion != null){
            path.append("cell_type:").append(cellType)
                    .append(",brain_region:").append(brainRegion);
        } else if (cellType != null){
            path.append("cell_type:").append(cellType);
        } else if (brainRegion != null){
            path.append("brain_region:").append(brainRegion);
        }
        path.append("&size=").append(resultsPerPage).append("&page=").append(page);
        return path.toString();
    }
}