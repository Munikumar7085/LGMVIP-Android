package com.example.covid_19tracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19tracker.adapters.StateAdapter;
import com.example.covid_19tracker.databinding.ActivityDistrictBinding;
import com.example.covid_19tracker.models.Delta;
import com.example.covid_19tracker.models.DistrictsData;
import com.example.covid_19tracker.models.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class DistrictActivity extends AppCompatActivity implements StateAdapter.OnCardClickListener {
    String url="https://data.covid19india.org/state_district_wise.json";
    ActivityDistrictBinding binding;
    ArrayList<String> districtsList;
    String state;
    StateAdapter adapter;
    ArrayList<Model> model =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDistrictBinding.inflate(getLayoutInflater());
        View root= binding.getRoot();
        setContentView(root);

        state=getIntent().getStringExtra("state");
        //Getting the ArrayList of Districts by passing State name
         getJsonData();

    }

    private void setDataAdapter()
    {
        adapter= new StateAdapter(this,model,this);
        binding.districtRecyclerview.setHasFixedSize(true);
        binding.districtRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.districtRecyclerview.setAdapter(adapter);
    }
    @Override
    //To handle the clicks on the items in District Recycler View
    public void onCardClick(int position) {
        Intent intent = new Intent(this,DisplayActivity.class);
        intent.putExtra("state",state);
        intent.putExtra("district",districtsList.get(position));
        startActivity(intent);
        finish();


    }
    private void getJsonData() {
        //creating a new Volly request
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //creating a new JsonObjectRequest
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null,
                // if got response to request
                response -> {
                    try {
                        JSONObject stateObject= response.getJSONObject(state);

                        JSONObject districtDataObject= stateObject.getJSONObject("districtData");
                        districtsList= DistrictsData.getStates(state);
                        for(int j=0;j<districtsList.size();j++)
                        {
                            JSONObject districtObject=districtDataObject.getJSONObject(districtsList.get(j));
                            int active=districtObject.getInt("active");
                            int confirmed=districtObject.getInt("confirmed");
                            int deceased=districtObject.getInt("deceased");
                            int recovered=districtObject.getInt("recovered");
                            Model m =new Model(active,confirmed,deceased,recovered,districtsList.get(j));
                            model.add(m);
                        }
                        setDataAdapter();

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                },
                //if got error response from the api
                error -> Toast.makeText(DistrictActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show());
        //adding the jsonObjectRequest into the Request Queue
        requestQueue.add(jsonObjectRequest);

    }
}