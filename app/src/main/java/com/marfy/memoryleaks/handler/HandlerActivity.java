package com.marfy.memoryleaks.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

/**
 * This class is full of memory leaks. Don't take it as correct example.
 */
public class HandlerActivity extends AppCompatActivity {

  private final Handler handler = new Handler();

  private final Handler handler2 = new Handler(new Callback() {
    @Override
    public boolean handleMessage(Message msg) {
      Log.i("test", "Message received");
      return false;
    }
  });

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new FrameLayout(this));
    executeDelayed();
    //executeThread();
  }

  private void executeDelayed() {
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        // Execute delayed code
      }
    }, 8000 /* After 8s*/);
  }

  private void executeThread() {
    new BackgroundThread(handler2).start();
  }
}
