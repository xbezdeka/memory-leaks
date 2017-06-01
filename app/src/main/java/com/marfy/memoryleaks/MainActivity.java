package com.marfy.memoryleaks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.marfy.memoryleaks.animation.AnimationActivity;
import com.marfy.memoryleaks.asynctask.AsyncTaskActivity;
import com.marfy.memoryleaks.fragment.FragmentActivity;
import com.marfy.memoryleaks.handler.HandlerActivity;
import com.marfy.memoryleaks.mvp.MvpActivity;
import com.marfy.memoryleaks.retrofit.RetrofitActivity;
import com.marfy.memoryleaks.rxjava.RxJavaActivity;
import com.marfy.memoryleaks.statics.StaticActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.caseStaticVariable)
  public void onStaticVariableClicked() {
    startActivity(new Intent(this, StaticActivity.class));
  }

  @OnClick(R.id.caseAsyncTask)
  public void onAsyncTaskClicked() {
    startActivity(new Intent(this, AsyncTaskActivity.class));
  }

  @OnClick(R.id.caseRetrofit)
  public void onRetrofitClicked() {
    startActivity(new Intent(this, RetrofitActivity.class));
  }

  @OnClick(R.id.caseRxJava)
  public void onRxJavaClicked() {
    startActivity(new Intent(this, RxJavaActivity.class));
  }

  @OnClick(R.id.caseHandlers)
  public void onHandlersClicked() {
    startActivity(new Intent(this, HandlerActivity.class));
  }

  @OnClick(R.id.caseAnimation)
  public void onAnimationClicked() {
    startActivity(new Intent(this, AnimationActivity.class));
  }

  @OnClick(R.id.caseMVP)
  public void onMvpClicked() {
    startActivity(new Intent(this, MvpActivity.class));
  }

  @OnClick(R.id.caseRetainedFragment)
  public void onRetainedFragmentClicked() {
    startActivity(new Intent(this, FragmentActivity.class));
  }
}
