package com.shamanth.paginglibrarytutorial.paging_implimentation.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.shamanth.paginglibrarytutorial.R;


public class TestActivity extends AppCompatActivity {

    String toolbarTitle;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateToolBarTitle(String title) {
        if (title != null)
            toolbarTitle = title;
    }
}
