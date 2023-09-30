package app;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Code for Week 3 Activity: Exploring APIs
        // Call an API using okhttp3, and output the response
        String query = "hippocampus";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://modeldb.science/api/v1/celltypes/name")
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONArray responseBody = new JSONArray(response.body().string());
            String[] names = new String[responseBody.length()];
            for (int i = 0; i < responseBody.length(); i++) {
                names[i] = responseBody.getString(i);
            }
            for (String name: names) {
                System.out.println(name);
            }

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}