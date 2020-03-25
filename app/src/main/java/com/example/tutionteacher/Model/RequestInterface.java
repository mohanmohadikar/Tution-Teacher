package com.example.tutionteacher.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("mohanmohadikar/Tution-Teacher/master/db.json")
    Call<JSONResponse> getJSON();
}
