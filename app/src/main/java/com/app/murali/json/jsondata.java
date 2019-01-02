package com.app.murali.json;

import android.os.AsyncTask;
import android.widget.ScrollView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class jsondata extends AsyncTask<Void, Void, Void> {

    String data = "";
    String dataparsed = "";
    String datasingleparsed = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/1702wk");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jo = (JSONObject) jsonArray.get(i);

                datasingleparsed = "Name : " + jo.get("name") + "\n" +
                        "Phone No : " + jo.get("phoneno") + "\n" +
                        "Address : " + jo.get("address") + "\n" +
                        "Email : " + jo.get("email") + "\n";

                dataparsed = dataparsed + datasingleparsed + "\n";
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.getjson1.setText(this.dataparsed);
    }
}
