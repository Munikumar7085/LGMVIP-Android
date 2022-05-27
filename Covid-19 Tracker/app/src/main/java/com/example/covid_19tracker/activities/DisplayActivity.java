package com.example.covid_19tracker.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19tracker.MainActivity;
import com.example.covid_19tracker.databinding.ActivityDisplayBinding;
import com.example.covid_19tracker.models.Delta;
import com.example.covid_19tracker.models.Model;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class DisplayActivity extends AppCompatActivity {
    String state;
    String district;
    //base url to fetch data
    String url="https://data.covid19india.org/state_district_wise.json";
    ActivityDisplayBinding binding;
    ArrayList<Float> covidCasePercent=new ArrayList<>();
    ArrayList<String> covidStages=new ArrayList<>();
    ArrayList<Float> deltaCasePercent=new ArrayList<>();
    ArrayList<String> deltaStages=new ArrayList<>();
    PieChart covidPie;
    PieChart deltaPie;
    Model model;
    Delta delta;
    float total_covid_cases=1;
    float total_delta_cases=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDisplayBinding.inflate(getLayoutInflater());
        View root= binding.getRoot();
        setContentView(root);
        covidPie=binding.covidPieChart;
        deltaPie=binding.deltaPieChart;
        state=getIntent().getStringExtra("state");
        district=getIntent().getStringExtra("district");
        getJsonData();
        binding.homeButton.setOnClickListener(view -> {
            Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
            startActivity(intent);

            finish();

             });


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

                        JSONObject districtObject=districtDataObject.getJSONObject(district);
                        int active=(districtObject.getInt("active"));
                       int confirmed=(districtObject.getInt("confirmed"));
                       int deceased=(districtObject.getInt("deceased"));
                       int recovered=(districtObject.getInt("recovered"));
                       model=new Model(active,confirmed,deceased,recovered,district);
                        JSONObject deltaObject=districtObject.getJSONObject("delta");
                        delta = new Delta(deltaObject.getInt("confirmed"),deltaObject.getInt("deceased"),deltaObject.getInt("recovered"));
                        setLayout();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                },
                //if got error response from the api
                error -> Toast.makeText(DisplayActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show());
        //adding the jsonObjectRequest into the Request Queue
        requestQueue.add(jsonObjectRequest);

    }
//Binds the data to the xml Views
    private void setLayout() {
        binding.active.setText(String.valueOf(model.active));
        binding.confirmed.setText(String.valueOf(model.confirmed));
        binding.deceased.setText(String.valueOf(model.deceased));
        binding.recovered.setText(String.valueOf(model.recovered));

        total_covid_cases=model.active+model.confirmed+model.deceased+model.recovered;
       covidCasePercent.add((model.active/total_covid_cases)*100);
        covidCasePercent.add((model.confirmed/total_covid_cases)*100);
        covidCasePercent.add((model.deceased/total_covid_cases)*100);
        covidCasePercent.add((model.recovered/total_covid_cases)*100);
        covidStages.add("Active");
        covidStages.add("Confirmed");
        covidStages.add("Deceased");
        covidStages.add("Recovered");
        setPieChart(covidCasePercent, covidPie,"Covid Percentage","Covid Cases Percentage");
        if (delta!=null)
        {
            try {
                binding.deltaActive.setText(String.valueOf(delta.getActive()));
                binding.deltaDeceased.setText(String.valueOf(delta.getDeceased()));
                binding.deltaRecovered.setText(String.valueOf(delta.getRecovered()));
                total_delta_cases=delta.getActive()+delta.getDeceased()+delta.getRecovered();
                deltaCasePercent.add((delta.getActive()/total_delta_cases)*100);
                deltaCasePercent.add((delta.getDeceased()/total_delta_cases)*100);
                deltaCasePercent.add((delta.getRecovered()/total_delta_cases)*100);
                deltaStages.add("Active");
                deltaStages.add("Deceased");
                deltaStages.add("Recovered");
                setPieChart(deltaCasePercent, deltaPie,"Delta Percentage","Delta Cases Percentage");
            }
            catch (Exception e)
            {
                Log.i("state",e.getMessage());
            }
        }
    }

    //Creates the piechart
    private void setPieChart(ArrayList<Float> percent, PieChart pieChart, String desc, String label) {
        Description description=new Description();
        description.setText(desc);
        description.setTextColor(Color.rgb(255,0,255));
        pieChart.setDescription(description);
        pieChart.setHoleRadius(5f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("");
        pieChart.setCenterTextSize(12);
        feedDataToChart(percent, pieChart,label);
    }

    //Sets the data in the pieChart
    private void feedDataToChart(ArrayList<Float> percent, PieChart pieChart, String label) {
        ArrayList<PieEntry> yEntry=new ArrayList<>();
        for(int i=0;i<percent.size();i++)
        {
            yEntry.add(new PieEntry(percent.get(i),i));
        }
        PieDataSet pieDataSet=new PieDataSet(yEntry,label);
        pieDataSet.setSliceSpace(1);
        pieDataSet.setValueTextSize(14);
        ArrayList<Integer> colors=getColors(yEntry.size());
        pieDataSet.setColors(colors);
        Legend legend =pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }

    //Returns the colors Arraylist for the pieChart
    private ArrayList<Integer> getColors(int size) {
        ArrayList<Integer> colors=new ArrayList<>();
        colors.add(Color.rgb(57,255,20));

        if(size>3)
        {
            colors.add(Color.rgb(255,36,0));

        }
        colors.add(Color.rgb(255,0,255));

        colors.add(Color.rgb(0,255,255));
        return colors;

    }
}