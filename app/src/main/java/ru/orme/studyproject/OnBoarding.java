package ru.orme.studyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.orme.studyproject.adapters.SliderAdapter;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letsGetStarted;
    Animation letsGetStartedAnim;
    int viewPagerPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //hooks
        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.letsGetStarted);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip(View view){
        startActivity(new Intent(getApplicationContext(), ClickActivity.class));
        finish();
    }

    public void next(View view){
        viewPager.setCurrentItem(viewPagerPosition + 1);
    }

    private void addDots(int position){
        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i=0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.buttonColor));
        }
    }


    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            viewPagerPosition = position;

            if (position == 0 || position == 1 || position == 2){
                letsGetStarted.setVisibility(View.INVISIBLE);
            } else {
                letsGetStarted.setVisibility(View.VISIBLE);
                letsGetStartedAnim = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.alpha_anim);
                letsGetStarted.setAnimation(letsGetStartedAnim);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void getStartedClick(View view) {
        Intent intent = new Intent(OnBoarding.this, ClickActivity.class);
        startActivity(intent);
        finish();
    }
}
