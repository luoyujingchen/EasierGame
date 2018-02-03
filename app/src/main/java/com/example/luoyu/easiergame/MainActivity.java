package com.example.luoyu.easiergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Switch goBtn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goBtn = findViewById(R.id.go_btn);
        goBtn.setChecked(false);
        intent = new Intent(this, MyService.class);


        goBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    intent.putExtra(MyService.ACTION, MyService.SHOW);
                    startService(intent);
                }else {
                    intent.putExtra(MyService.ACTION, MyService.HIDE);
                    startService(intent);
                }
            }
        });
    }
}
