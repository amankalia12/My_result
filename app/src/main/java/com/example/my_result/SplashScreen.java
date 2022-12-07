package com.example.my_result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        imageView=findViewById(R.id.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            Intent i=new Intent(SplashScreen.this,MainActivity.class);
            startActivity(i);
            finish();
            }
        },3000);



    }
}