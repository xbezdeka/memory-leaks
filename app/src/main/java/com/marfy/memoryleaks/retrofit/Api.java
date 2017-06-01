package com.marfy.memoryleaks.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

interface Api {

  @GET("radio1/playlist.json")
  Call<ResponseBody> apiCall();
}
