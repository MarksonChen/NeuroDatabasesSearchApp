package app;
import okhttp3.*;
import org.json.*;

import java.io.IOException;
import java.util.*;

public class Main_Zijie_Ma {
    public static void main(String[] args) {
        // Code for Week 3 Activity: Exploring APIs
        // Call an API using okhttp3, and output the response
        Scanner scan = new Scanner(System.in);

        System.out.println("What you information that you wants to search?");
        String info = scan.nextLine();

        System.out.println(GetTest(info));
    }


    public static Object GetTest(String search) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://neuroml-db.org/api/search?q=%s", search))
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONArray responseArray = new JSONArray(response.body().string());
            if (response.code() == 200) {
                ArrayList<String> result = new ArrayList<String>();
                for (int i=0; i< responseArray.length(); i++){
                    result.add(responseArray.getJSONObject(i).getString("Name"));
                }
                return result;
            } else {
                throw new RuntimeException(response.message());
            }
        } catch (JSONException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
