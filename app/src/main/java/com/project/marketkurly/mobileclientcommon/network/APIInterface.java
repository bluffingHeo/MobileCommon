package com.project.marketkurly.mobileclientcommon.network;

import com.google.gson.JsonObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {
    @POST("/external/manufacture/inspection")
    Call<JsonObject> sampleCheckDataUpload(@Body RequestBody param);
}
