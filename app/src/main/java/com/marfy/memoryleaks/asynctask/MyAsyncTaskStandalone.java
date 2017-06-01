package com.marfy.memoryleaks.asynctask;

import android.os.AsyncTask;
import com.marfy.memoryleaks.Utils;

class MyAsyncTaskStandalone extends AsyncTask<Void, Void, Void> {

  private final Callback callback;

  MyAsyncTaskStandalone(Callback callback) {
    this.callback = callback;
  }

  @Override
  protected Void doInBackground(Void... params) {
    Utils.expensiveOperation();
    return null;
  }

  @Override
  protected void onPostExecute(Void aVoid) {
    if (callback != null) {
      callback.onResult();
    }
  }

  interface Callback {

    void onResult();
  }
}