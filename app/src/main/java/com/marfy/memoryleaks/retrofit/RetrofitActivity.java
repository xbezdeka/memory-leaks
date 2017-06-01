package com.marfy.memoryleaks.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class is full of memory leaks. Don't take it as correct example.
 */
public class RetrofitActivity extends AppCompatActivity {

  private Call<ResponseBody> apiCall;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new FrameLayout(this));
    doApiCall();
  }

  private void doApiCall() {
    apiCall = RetrofitUtils.getApi().apiCall();
    apiCall.enqueue(new Callback<ResponseBody>() {
      @Override
      public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        // get result here
      }

      @Override
      public void onFailure(Call<ResponseBody> call, Throwable t) {
        // get error here
      }
    });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    apiCall.cancel();
  }
}
