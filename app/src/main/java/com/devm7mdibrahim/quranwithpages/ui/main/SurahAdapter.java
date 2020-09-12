package com.devm7mdibrahim.quranwithpages.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devm7mdibrahim.quranwithpages.R;
import com.devm7mdibrahim.quranwithpages.model.Data;
import com.devm7mdibrahim.quranwithpages.ui.quran.QuranActivity;

import java.util.List;

import static com.devm7mdibrahim.quranwithpages.ui.main.MainActivity.SURAH_NUMBER;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahViewHolder> {

    private List<Data> surahList;

    @NonNull
    @Override
    public SurahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SurahViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.surah_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final SurahViewHolder holder, int position) {
        final Data surah = surahList.get(position);

        holder.surahName.setText(surah.getName());

        holder.itemView.setOnClickListener(view -> {
            Context context = holder.itemView.getContext();
            Intent intent = new Intent(context, QuranActivity.class);
            intent.putExtra(SURAH_NUMBER, surah.getPage());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return surahList != null ? surahList.size() : 0;
    }

    public void submitList(List<Data> surahList) {
        this.surahList = surahList;
        notifyDataSetChanged();
    }

    static class SurahViewHolder extends RecyclerView.ViewHolder {
        private TextView surahName;

        public SurahViewHolder(@NonNull View itemView) {
            super(itemView);
            surahName = itemView.findViewById(R.id.surah_name);
        }
    }
}
