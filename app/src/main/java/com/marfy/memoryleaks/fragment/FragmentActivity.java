package com.marfy.memoryleaks.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

/**
 * This class is full of memory leaks. Don't take it as correct example.
 */
public class FragmentActivity extends AppCompatActivity {

  @SuppressWarnings("ResourceType")
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    FrameLayout view = new FrameLayout(this);
    view.setId(42);
    setContentView(view);

    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .replace(42, new RetainedFragment())
          .commit();
    }
  }
}
