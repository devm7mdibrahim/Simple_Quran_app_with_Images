package com.devm7mdibrahim.quranwithpages.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devm7mdibrahim.quranwithpages.R;

public class MainActivity extends AppCompatActivity {

    public static final String SURAH_NUMBER = "surah_number";
    private MainViewModel mainViewModel;
    private ProgressBar progressBar;
    private SurahAdapter surahAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewModel();
        getSurahList();
    }

    private void initViews() {
        progressBar = findViewById(R.id.mainProgressBar);
        RecyclerView recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        surahAdapter = new SurahAdapter();
        recyclerView.setAdapter(surahAdapter);
    }

    private void getSurahList() {
        mainViewModel.getSurahList().observe(this, response -> {
            switch (response.status){
                case ERROR:{
                    Toast.makeText(MainActivity.this, response.message, Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    break;
                }
                case LOADING:{
                    progressBar.setVisibility(View.VISIBLE);
                    break;
                }
                case SUCCESS:{
                    progressBar.setVisibility(View.GONE);
                    surahAdapter.submitList(response.data);
                    break;
                }
            }
        });
    }

    private void initViewModel() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }
}