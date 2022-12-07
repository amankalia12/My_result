package com.example.my_result;

import com.example.my_result.Model.Example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myresut {


    @GET("read.php")
    Call<Example> getjobs();
}
