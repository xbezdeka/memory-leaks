package com.marfy.memoryleaks.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * This class is full of memory leaks. Don't take it as correct example.
 */
public class RxJavaActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new FrameLayout(this));
    doRxJavaCall();
  }

  private void doRxJavaCall() {
    RxUtils.getObservable()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<String>() {
          @Override
          public void accept(@NonNull String s) throws Exception {
            // Here is the result
          }
        });
  }
}
