package com.example.hongxu.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        System.out.println("SecActivity运行到onCreat方法");
    }
    protected void onStart() {
        super.onStart();
        System.out.println("SecActivity运行到onStart方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("SecActivity运行到onRestart方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("SecActivity运行到onResume方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("SecActivity运行到 onPause方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("SecActivity运行到onStop方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("SecActivity运行到onDestroy方法");
    }
}
