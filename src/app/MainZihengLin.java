package app;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

public class MainZihengLin {
    public static void main(String[] args) {
        // Code for Week 3 Activity: Exploring APIs
        // Call an API using okhttp3, and output the response
        String query = "hippocampus";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://neuroml-db.org/api/search?q=%s", query ))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONArray responseBody = new JSONArray(response.body().string());
            for (int i = 0; i < responseBody.length(); i++) {
                System.out.println(responseBody.getJSONObject(i).getString("Name"));;
            }

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}


