package com.devm7mdibrahim.quranwithpages.ui.quran;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.devm7mdibrahim.quranwithpages.R;

import java.util.ArrayList;
import java.util.List;

import static com.devm7mdibrahim.quranwithpages.ui.main.MainActivity.SURAH_NUMBER;

public class QuranActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
        initViewPager();
        getSurahPageNumber();
    }


    private void initViewPager() {
        viewPager = findViewById(R.id.view_pager);
        QuranPagesAdapter pagesAdapter = new QuranPagesAdapter(this, getPagesList());
        viewPager.setAdapter(pagesAdapter);
    }

    private List<Integer> getPagesList() {
        List<Integer> pagesList = new ArrayList<>();
        for (int i = 1; i <= 604; i++) {
            int image = getResources().getIdentifier("a" + i, "drawable", getPackageName());
            pagesList.add(image);
        }
        return pagesList;
    }

    private void getSurahPageNumber() {
        int surahNumber = getIntent().getIntExtra(SURAH_NUMBER, 1);
        viewPager.setCurrentItem(surahNumber - 1);
    }
}