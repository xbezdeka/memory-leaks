package com.marfy.memoryleaks;

import android.app.Application;
import android.os.StrictMode;

public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    initStrictMode();
  }

  private void initStrictMode() {
    StrictMode.setVmPolicy(
        new StrictMode.VmPolicy.Builder()
            .detectActivityLeaks()
            .detectLeakedClosableObjects() // Any closable object
            .detectLeakedSqlLiteObjects() // SqLiteCursor
            .detectLeakedRegistrationObjects() // BroadcastReceiver, ServiceConnection
            .penaltyLog()
            .build());
  }
}
