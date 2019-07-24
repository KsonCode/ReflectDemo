package com.bwie.reflectdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bwie.reflectdemo.butterknife.BindView;
import com.bwie.reflectdemo.butterknife.ButterKnife;
import com.bwie.reflectdemo.butterknife.ContentView;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv)
    TextView textView;
    @BindView(R.id.tv2)
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        textView.setText("kson");
        textView2.setText("kson2");
    }
}
