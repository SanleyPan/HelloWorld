package com.thoughtworks.andoridtrain;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.thoughtworks.andoridtrain.utils.FragmentUtil;

public class MyFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_fragment_layout);
        initUI();
    }

    private void initUI() {
        Button android= findViewById(R.id.Android);
        FragmentUtil.replaceFragment(getSupportFragmentManager(),new Fragment1(),R.id.content,null);
        Button java= findViewById(R.id.Java);

        java.setOnClickListener(view -> {
            FragmentUtil.replaceFragment(getSupportFragmentManager(),new Fragment2(),R.id.content,null);
        });
        android.setOnClickListener(view -> {
            FragmentUtil.replaceFragment(getSupportFragmentManager(),new Fragment1(),R.id.content,null);
        });

    }
}
