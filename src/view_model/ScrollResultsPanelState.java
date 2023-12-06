package view_model;

import entity.FetchedData;

import java.util.ArrayList;
import java.util.List;

public class ScrollResultsPanelState {
    private List<FetchedData> fetchedDataList = new ArrayList<>();
    private List<Boolean> dataIsStarredList = new ArrayList<>();
    private int totalResults;
    private int resultsPerPage = SearchViewModel.DEFAULT_RESULTS_PER_PAGE;
    private String lastQuery;
    private int currentPage;

    public int getCurrentPage() {
        return currentPage;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Boolean> getDataIsStarredList() {
        return dataIsStarredList;
    }

    public List<FetchedData> getFetchedDataList() {
        return fetchedDataList;
    }

    public String getLastQuery() {
        return lastQuery;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setDataIsStarredList(List<Boolean> dataIsStarredList) {
        this.dataIsStarredList = dataIsStarredList;
    }

    public void setFetchedDataList(List<FetchedData> fetchedDataList) {
        this.fetchedDataList = fetchedDataList;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public void setLastQuery(String lastQuery) {
        this.lastQuery = lastQuery;
    }

    public void toggleStarOfData(FetchedData data) {
        int index = fetchedDataList.indexOf(data);
        dataIsStarredList.set(index, !dataIsStarredList.get(index));
    }
}
