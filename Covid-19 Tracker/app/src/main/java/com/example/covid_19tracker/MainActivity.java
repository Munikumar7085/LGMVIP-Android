package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19tracker.activities.DisplayActivity;
import com.example.covid_19tracker.activities.DistrictActivity;
import com.example.covid_19tracker.adapters.StateAdapter;
import com.example.covid_19tracker.databinding.ActivityMainBinding;
import com.example.covid_19tracker.models.Delta;
import com.example.covid_19tracker.models.DistrictsData;
import com.example.covid_19tracker.models.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements StateAdapter.OnCardClickListener {
    String url="https://data.covid19india.org/state_district_wise.json";
    ActivityMainBinding binding;
    ArrayList<String> stateList;
    StateAdapter adapter;
    ArrayList<Model> model= new ArrayList<>();
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View root= binding.getRoot();
        setContentView(root);
        //List of states to show in recycler view
        stateList=new ArrayList<>(
                Arrays.asList(
                "Andaman and Nicobar Islands",
                "Andhra Pradesh",
                "Arunachal Pradesh",
                "Assam",
                "Bihar",
                "Chandigarh",
                "Chhattisgarh",
                "Dadra and Nagar Haveli and Daman and Diu",
                "Delhi",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jammu and Kashmir",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Ladakh",
                "Lakshadweep",
                "Madhya Pradesh",
                "Maharashtra",
                "Manipur",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "Odisha",
                "Puducherry",
                "Punjab",
                "Rajasthan",
                "Sikkim",
                "Tamil Nadu",
                "Telangana",
                "Tripura",
                "Uttar Pradesh",
                "Uttarakhand",
                "West Bengal")
        );
        // Adapter for recycler View
        getJsonData();

    }
    private void setDataAdapter()
    {
        adapter=new StateAdapter(this,model,this);
        binding.stateRecyclerview.setHasFixedSize(true);
        binding.stateRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.stateRecyclerview.setAdapter(adapter);
    }
    private void getJsonData() {
        //creating a new Volly request
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //creating a new JsonObjectRequest
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null,
                // if got response to request
                response -> {
                    try {
                        for(int i=0;i<stateList.size();i++)
                        {

                            JSONObject stateObject= response.getJSONObject(stateList.get(i));
                            JSONObject districtDataObject= stateObject.getJSONObject("districtData");
                            ArrayList<String > districts= DistrictsData.getStates(stateList.get(i));
                            int active=0;
                            int confirmed=0;
                            int deceased=0;
                            int recovered=0;
                            for(int j=0;j<districts.size();j++)
                            {
                                JSONObject districtObject=districtDataObject.getJSONObject(districts.get(j));
                                active+=districtObject.getInt("active");
                                confirmed+=districtObject.getInt("confirmed");
                                deceased+=districtObject.getInt("deceased");
                                recovered+=districtObject.getInt("recovered");
                            }
                            Model m= new Model(active,confirmed,deceased,recovered,stateList.get(i));
                            model.add(m);



                        }
                        setDataAdapter();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                },
                //if got error response from the api
                error -> Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show());
        //adding the jsonObjectRequest into the Request Queue
        requestQueue.add(jsonObjectRequest);

    }
    @Override
    //To handle clicks on items in Recycler View
    public void onCardClick(int position) {
        Intent intent = new Intent(this, DistrictActivity.class);
        intent.putExtra("state", stateList.get(position));
        startActivity(intent);
      }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}