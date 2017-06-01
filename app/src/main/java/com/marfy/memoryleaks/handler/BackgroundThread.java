package com.marfy.memoryleaks.handler;

import android.os.Handler;
import com.marfy.memoryleaks.Utils;

class BackgroundThread extends Thread {

  private final Handler handler;

  BackgroundThread(Handler handler) {
    this.handler = handler;
  }

  @Override
  public void run() {
    Utils.expensiveOperation();
    handler.sendEmptyMessage(0);
  }
}
