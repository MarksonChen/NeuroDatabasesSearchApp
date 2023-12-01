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

    private final OkHttpClient client;
    private final Desktop desktop;

    /**
     * construct an WebDAO object.
     */
    public WebDataAccessObject() {
        client = new OkHttpClient().newBuilder()
                .build();
        desktop = Desktop.getDesktop();
    }

    /**
     * @param path is the url
     * @return content of it
     * @throws IOException
     */
    @Override
    public String getResponse(String path) throws IOException {
        Request request = new Request.Builder()
                .url(path)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * It opens the web site in brower
     * @param path is the url
     * @throws URISyntaxException
     * @throws IOException
     */
    @Override
    public void openWebsite(String path) throws URISyntaxException, IOException {
        desktop.browse(new URI(path));
    }
}
