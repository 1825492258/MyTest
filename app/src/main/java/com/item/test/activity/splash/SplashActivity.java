package com.item.test.activity.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.item.test.MainActivity;
import com.item.test.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.splash_image)
    ImageView mSplashImage; // 图片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        //  mSplashImage.setImageResource(getBackgroundImageResID());
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSplashImage.startAnimation(animation);
    }

    public int getBackgroundImageResID() {
        int resId;
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour <= 12) {
            resId = R.drawable.morning;
        } else if (hour > 12 && hour <= 18) {
            resId = R.drawable.afternoon;
        } else {
            resId = R.drawable.night;
        }
        return resId;
    }
}
