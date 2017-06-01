package com.marfy.memoryleaks;

public class Utils {

  public static void expensiveOperation() {
    try {
      Thread.sleep(8000);
    } catch (InterruptedException e) {
      // this is ok
    }
  }
}
