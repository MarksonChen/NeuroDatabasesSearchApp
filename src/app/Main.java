package app;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Code for Week 3 Activity: Exploring APIs
        // Call an API using okhttp3, and output the response
        String query = "hippocampus";
        getresponse(query);



    }

    public static void getresponse(String query) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://neuroml-db.org/api/search?q=%s", query))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONArray responseBody = new JSONArray(response.body().string());
            for (int num = 0; num < responseBody.length(); num++) {
                System.out.println(responseBody.getJSONObject(num).getString("Name"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
