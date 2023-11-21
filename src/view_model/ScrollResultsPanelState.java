package view_model;

import entity.FetchedData;

import java.util.ArrayList;
import java.util.List;

public class ScrollResultsPanelState {

    private List<FetchedData> fetchedDataList = new ArrayList<>();
    private List<Boolean> dataIsStarredList = new ArrayList<>();


    public List<FetchedData> getFetchedDataList() {
        return fetchedDataList;
    }

    public void toggleStarOfData(FetchedData data) {
        int index = fetchedDataList.indexOf(data);
        dataIsStarredList.set(index, !dataIsStarredList.get(index));
    }

}
