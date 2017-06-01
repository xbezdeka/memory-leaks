package com.marfy.memoryleaks.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.marfy.memoryleaks.R;

/**
 * This class is full of memory leaks. Don't take it as correct example.
 */
public class AnimationActivity extends AppCompatActivity {

  @BindView(R.id.image)
  ImageView imageView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_animation);
    ButterKnife.bind(this);
    startAnimation();
  }

  private void startAnimation() {
    ValueAnimator animator = ValueAnimator.ofFloat(1f, 0f);
    animator.setInterpolator(new AccelerateDecelerateInterpolator());
    animator.setRepeatCount(ValueAnimator.INFINITE);
    animator.setRepeatMode(ValueAnimator.REVERSE);
    animator.setDuration(3000);
    animator.addUpdateListener(new AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        imageView.setAlpha((float) animation.getAnimatedValue());
      }
    });

    animator.start();
  }
}
