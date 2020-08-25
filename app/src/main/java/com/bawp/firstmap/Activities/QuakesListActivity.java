package com.bawp.firstmap.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bawp.firstmap.Adapter.RecyclerViewAdapter;
import com.bawp.firstmap.R;
import com.bawp.firstmap.model.Earthquake;
import com.bawp.firstmap.util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuakesListActivity extends AppCompatActivity {
    private List<Earthquake> arrayList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RequestQueue queue;
    //private ArrayAdapter arrayAdapter;

   // private List<Earthquake> quakeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

       // quakeList = new ArrayList<>();

        recyclerView =findViewById(R.id.recyclerView);

        queue = Volley.newRequestQueue(this);
        arrayList = new ArrayList<>();
        getAllQuakes();


    }

    void getAllQuakes() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                Constants.URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("features");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject properties = jsonArray.getJSONObject(i).getJSONObject("properties");

                        //let's get coordinates

                        JSONObject geometry = jsonArray.getJSONObject(i).getJSONObject("geometry");

                        //get coordinates array
                        JSONArray coordinates = geometry.getJSONArray("coordinates");

                        double lon = coordinates.getDouble(0);
                        double lat = coordinates.getDouble(1);
                        Log.d("Quake: ", lon + ", " + lat);

                        Log.d("Lao", properties.getString("place"));

                        Earthquake earthQuake = new Earthquake();
                        //Setup EarthQuake Object
                        earthQuake.setPlace(properties.getString("place"));
                        earthQuake.setMagnitude(properties.getDouble("mag"));
                        earthQuake.setLon(lon);
                        earthQuake.setLat(lat);


                        arrayList.add(earthQuake);
                        Log.d("check", String.valueOf(arrayList.get(i)));

                       // recyclerView.setHasFixedSize(true);

                        //recyclerViewAdapter=new RecyclerViewAdapter(QuakesListActivity.this,arrayList);
                        //recyclerView.setAdapter(recyclerViewAdapter);


                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
                recyclerViewAdapter=new RecyclerViewAdapter(QuakesListActivity.this,arrayList);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(QuakesListActivity.this));
                recyclerView.setAdapter(recyclerViewAdapter);
                recyclerViewAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(jsonObjectRequest);

    }

}
