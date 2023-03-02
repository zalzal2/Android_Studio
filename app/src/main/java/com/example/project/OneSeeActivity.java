package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OneSeeActivity extends AppCompatActivity {

    TextView wordTv, huriganaTv, meanTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_see_activity);

        wordTv=(TextView)findViewById(R.id.word_tv);
        huriganaTv=(TextView)findViewById(R.id.hurigana_tv);
        meanTv=(TextView)findViewById(R.id.mean_tv);

        wordTv.setText(getIntent().getStringExtra("jpWord").toString());
        huriganaTv.setText(getIntent().getStringExtra("hurigana").toString());
        meanTv.setText(getIntent().getStringExtra("mean").toString());

    }
}
