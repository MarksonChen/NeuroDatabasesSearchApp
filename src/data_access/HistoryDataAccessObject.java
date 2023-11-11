package data_access;

import entity.Query;
import use_case.HistoryDataAccessInterface;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HistoryDataAccessObject implements HistoryDataAccessInterface {

    @Override
    public List<Query> getHistoryQueryList() {
        return null;
    }

    @Override
    public void add(Query query) {

    }

    @Override
    public void removeHistory() {

    }

    @Override
    public void saveToFile() throws IOException {

    }
}
