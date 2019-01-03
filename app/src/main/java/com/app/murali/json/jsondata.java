package com.app.murali.json;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;
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
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class jsondata extends AsyncTask<Void, Void, Void> {


    String data = "";


    List<studentdata> datalist = new ArrayList<>() ;


    String parsingfulldata = "";

    CustomerAdapter customerAdapter;
    MainActivity mainActivity;

    RecyclerView mrecyclerView;
    RecyclerView.Adapter madapter;
    RecyclerView.LayoutManager mlayoutManager;



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
                studentdata studentdata = new studentdata();
                studentdata.name =  jo.getString("name");
                studentdata.phone_no =  jo.getString("phoneno");
                studentdata.address =  jo.getString("address");
                studentdata.email =  jo.getString("email");

//                studentdata.setName(jo.getString("name"));
//                studentdata.setPhone_no(jo.getString("phoneno"));
//                studentdata.setAddress(jo.getString("address"));
//                studentdata.setEmail(jo.getString("email"));

               datalist.add(studentdata);
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
        Log.i(TAG, "onPostExecute: " + parsingfulldata);
        CustomerAdapter customerAdapter = new CustomerAdapter() ;
  //      MainActivity.getjson1.setText(this.parsingfulldata);
//        customerAdapter = new CustomerAdapter(this,datalist);
   //     mrecyclerView.setAdapter(customerAdapter);

    }
}
