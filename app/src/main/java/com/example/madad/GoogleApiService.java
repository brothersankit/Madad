package com.example.madad;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GoogleApiService {
    @GET
    Call<MyPlaces> getNearByPlaces(@Url String url);
}
