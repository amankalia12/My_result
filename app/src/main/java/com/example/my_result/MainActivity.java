package com.example.my_result;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;


import com.example.my_result.Model.Example;
import com.example.my_result.Model.Result;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView,madview1;
SwipeRefreshLayout swipeRefreshLayout;

    CourseAdapter courseAdapter;
    private ArrayList<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         swipeRefreshLayout=findViewById(R.id.swipeup);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        madview1=findViewById(R.id.adView1);



        AdRequest adRequest = new AdRequest.Builder().build();
        madview1.loadAd(adRequest);
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }
        });
       getdata();

       swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
               getdata();
           }
       });
    }


    public void getdata(){

        results=new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.idRVCourse);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        courseAdapter=new CourseAdapter();


        myresut myresuts=ApiClient.getClient().create(myresut.class);
        Call<Example> call=myresuts.getjobs();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response.body()!=null){
                    results= (ArrayList<Result>) response.body().getResult();
                    courseAdapter.setjoblist(results);
                    recyclerView.setAdapter(courseAdapter);
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable throwable) {

                Log.e("error","this is not working");


            }
        });

    }
}