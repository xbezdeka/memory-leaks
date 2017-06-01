package com.marfy.memoryleaks.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import com.marfy.memoryleaks.Utils;
import com.marfy.memoryleaks.asynctask.MyAsyncTaskStandalone.Callback;

/**
 * This class is full of memory leaks. Don't take it as correct example.
 */
public class AsyncTaskActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new FrameLayout(this));

    doLongOperation();
    //doLongOperation2();
    //doLongOperation3();
  }

  private void doLongOperation() {
    // Anonymous class
    new AsyncTask<Void, Void, Void>() {

      @Override
      protected Void doInBackground(Void... params) {
        Utils.expensiveOperation();
        return null;
      }

      @Override
      protected void onPostExecute(Void aVoid) {
        // Here is my result
      }
    }.execute();
  }

  private void doLongOperation2() {
    new MyAsyncTask().execute();
  }

  private void doLongOperation3() {
    new MyAsyncTaskStandalone(new Callback() {
      @Override
      public void onResult() {
        // Here is my result
      }
    }).execute();
  }

  /**
   * Inner class
   */
  private class MyAsyncTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {
      Utils.expensiveOperation();
      return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
      // Here is my result
    }
  }
}
