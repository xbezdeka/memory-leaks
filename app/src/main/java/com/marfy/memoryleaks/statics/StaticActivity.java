package com.marfy.memoryleaks.statics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

/**
 * This class is full of memory leaks. Don't take it as correct example.
 */
public class StaticActivity extends AppCompatActivity {

  public static StaticActivity sInstance;

  public static void setInstance(StaticActivity instance) {
    sInstance = instance;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new FrameLayout(this));
    setInstance(this);
  }
}
