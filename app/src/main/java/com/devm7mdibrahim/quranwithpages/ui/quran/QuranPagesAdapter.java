package com.devm7mdibrahim.quranwithpages.ui.quran;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class QuranPagesAdapter extends PagerAdapter {

    private List<Integer> mQuranPagesList;
    private Context mContext;

    public QuranPagesAdapter(Context context, List<Integer> quranPagesList){
        mContext = context;
        mQuranPagesList = quranPagesList;
    }
    @Override
    public int getCount() {
        return mQuranPagesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Integer image = mQuranPagesList.get(position);

        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(image);
        container.addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
