package com.app.murali.json;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static android.content.ContentValues.TAG;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewAdapter> {

    private Context mcontext;
    private ArrayList<studentdata> mdataitem;
    String pasringdatalist = "";

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View v = LayoutInflater.from(mcontext).inflate(R.layout.card_view, parent, false);

        return new ViewAdapter(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
//        studentdata currentitem = studentdata(position);

        jsondata jsonfile =  new jsondata();
        jsonfile.doInBackground();


        for (int i = 0; i < datalist.size(); i++ ){

            pasringdatalist = datalist.get(i).name +"\n"+
                    datalist.get(i).phone_no +"\n"+
                    datalist.get(i).address +"\n"+
                    datalist.get(i).email;

            parsingfulldata = parsingfulldata +pasringdatalist;

            Log.i(TAG, "doInBackground: parsingfulldata" + parsingfulldata );

        }

    }

    @Override
    public int getItemCount() {
        return mdataitem.size();
    }

    public static class ViewAdapter extends RecyclerView.ViewHolder {
      public   TextView dispalyjsonvalue;


        public ViewAdapter(View itemView) {
            super(itemView);
            dispalyjsonvalue = itemView.findViewById(R.id.displayjson);

        }
    }
}
