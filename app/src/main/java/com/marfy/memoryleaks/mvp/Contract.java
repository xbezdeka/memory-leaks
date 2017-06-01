package com.marfy.memoryleaks.mvp;


class Contract {

  interface View {

    void showData(String data);
  }

  interface Presenter {

    void loadData();

    void detachView();
  }
}
