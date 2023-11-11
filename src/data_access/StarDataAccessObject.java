package data_access;

import entity.FetchedData;
import use_case.star.StarDataAccessInterface;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class StarDataAccessObject implements StarDataAccessInterface {

    @Override
    public void toggleStar(FetchedData data) {

    }

    @Override
    public List<Boolean> checkIfDataStarred(List<FetchedData> fetchedData) {
        return null;
    }

    @Override
    public List<Boolean>[] checkIfDataStarred(List<FetchedData>[] fetchedData) {
        return new List[0];
    }

    @Override
    public Boolean dataIsStarred(FetchedData data) {
        return null;
    }

    @Override
    public List<FetchedData> getStarredDataList() {
        return null;
    }

    @Override
    public void saveStarredData() throws IOException {

    }
}
