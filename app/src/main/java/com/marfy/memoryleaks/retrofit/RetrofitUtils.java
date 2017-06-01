package com.marfy.memoryleaks.retrofit;

import com.marfy.memoryleaks.Utils;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;

class RetrofitUtils {

  static Api getApi() {
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .addNetworkInterceptor(new Interceptor() {
          @Override
          public okhttp3.Response intercept(Chain chain) throws IOException {
            Utils.expensiveOperation();
            return chain.proceed(chain.request());
          }
        })
        .build();

    Retrofit retrofit = new Builder()
        //.client(okHttpClient)
        .baseUrl("http://www.bbc.co.uk/")
        .build();

    return retrofit.create(Api.class);
  }
}
