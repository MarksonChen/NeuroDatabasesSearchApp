package view_model;

import entity.FetchedData;

import java.util.LinkedHashMap;
import java.util.List;

public class SearchViewState {
    private String searchFieldText = ""; // Here are the default values
    private int page = 1;
    private String databaseOption = SearchViewModel.ALL_DATABASES;
    private int resultsPerPage = SearchViewModel.DEFAULT_RESULTS_PER_PAGE;
    private List<FetchedData> fetchedData;          // For single view
    private LinkedHashMap<String, Boolean>[] detailEntryDisplayed;
    private String errorMessage;

    public String getSearchFieldText() {
        return searchFieldText;
    }

    public void setSearchFieldText(String searchFieldText) {
        this.searchFieldText = searchFieldText;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getDatabaseOption() {
        return databaseOption;
    }

    public void setDatabaseOption(String databaseOption) {
        this.databaseOption = databaseOption;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    public List<FetchedData> getFetchedData() {
        return fetchedData;
    }

    public void setFetchedData(List<FetchedData> fetchedData) {
        this.fetchedData = fetchedData;
    }

    public LinkedHashMap<String, Boolean>[] getDetailEntryDisplayed() {
        return detailEntryDisplayed;
    }

    public void setDetailEntryDisplayed(LinkedHashMap<String, Boolean>[] detailEntryDisplayed) {
        this.detailEntryDisplayed = detailEntryDisplayed;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
