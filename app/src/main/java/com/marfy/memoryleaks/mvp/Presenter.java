package com.marfy.memoryleaks.mvp;

import com.marfy.memoryleaks.mvp.Contract.View;
import com.marfy.memoryleaks.rxjava.RxUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

class Presenter implements Contract.Presenter {

  private View view;

  Presenter(View view) {
    this.view = view;
  }

  @Override
  public void loadData() {
    RxUtils.getObservable()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<String>() {
          @Override
          public void accept(@NonNull String s) throws Exception {
            if (view != null) {
              view.showData(s);
            }
          }
        });
  }

  @Override
  public void detachView() {
    view = null;
  }
}
