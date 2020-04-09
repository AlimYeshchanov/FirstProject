package com.example.learnwordseasily;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }


        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Button buttonOne = (Button)findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                readApp();
            }
        });

        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        Button buttonTwo = (Button)findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.startAnimation(animRotate);
                ListOfWords();
            }
        });

        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.scale);
        Button buttonThree = (Button)findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                writeWord();
            }
        });

        final Animation animTranslate = AnimationUtils.loadAnimation(this,R.anim.anim_translate);
        Button buttonFour = (Button)findViewById(R.id.buttonFour);
        buttonFour.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.startAnimation(animTranslate);
                //load new page
            }
        });

        final Animation animSlide = AnimationUtils.loadAnimation(this, R.anim.slide_left);
        Button buttonFive = (Button)findViewById(R.id.buttonFive);
        buttonFive.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.startAnimation(animSlide);
                //load new page
            }
        });
    }

    public void readApp() {
        final Intent intent = new Intent(this, aboutApp.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 300);
    }


    public void ListOfWords() {
        final Intent intent = new Intent(this, ListOfWordsActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 800);
    }

    public void writeWord(){
        final Intent intent = new Intent(this, WriteWordActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 800);
    }

}
