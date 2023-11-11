package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import use_case.open_website.WebDataAccessInterface;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebDataAccessObject implements WebDataAccessInterface {

    @Override
    public String getResponse(String path) throws IOException {
        return null;
    }

    @Override
    public void openWebsite(String path) throws URISyntaxException, IOException {

    }
}
