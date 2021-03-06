package ru.orme.studyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView splashName, splashAuthor;
    Animation sideAnimation;

    private static int SPLASH_TIME = 5000;

    SharedPreferences onBoardingPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        splashName = findViewById(R.id.tv_splash_name);
        splashAuthor = findViewById(R.id.tv_splash_author);

        sideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_anim);

        splashName.setAnimation(sideAnimation);
        splashAuthor.setAnimation(sideAnimation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingPreferences = getSharedPreferences("onBoarding", MODE_PRIVATE);
                boolean isFirstTime = onBoardingPreferences.getBoolean("firstTime", true);

                if (isFirstTime){
                    SharedPreferences.Editor editor = onBoardingPreferences.edit();
                    editor.putBoolean("firstTime", false);
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, OnBoarding.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(MainActivity.this, ClickActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_TIME);

    }
}
