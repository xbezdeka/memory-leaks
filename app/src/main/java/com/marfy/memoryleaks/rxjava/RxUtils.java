package com.marfy.memoryleaks.rxjava;

import com.marfy.memoryleaks.Utils;
import io.reactivex.Observable;
import java.util.concurrent.Callable;

public class RxUtils {

  public static Observable<String> getObservable() {
    return Observable.fromCallable(new Callable<String>() {
      @Override
      public String call() throws Exception {
        Utils.expensiveOperation();
        return "result";
      }
    });
  }
}
