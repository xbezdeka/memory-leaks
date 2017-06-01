package com.marfy.memoryleaks.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import com.marfy.memoryleaks.mvp.Contract.View;

/**
 * This class is full of memory leaks. Don't take it as correct example.
 */
public class MvpActivity extends AppCompatActivity implements View {

  private Presenter presenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new FrameLayout(this));
    presenter = new Presenter(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.loadData();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.detachView();
  }

  @Override
  public void showData(String data) {
    // Show data here
  }
}
