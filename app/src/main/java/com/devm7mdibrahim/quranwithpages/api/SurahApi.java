package com.devm7mdibrahim.quranwithpages.api;

import com.devm7mdibrahim.quranwithpages.model.SurahResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SurahApi {
    @GET("mihrabi//json/quran/surah.json")
    Call<SurahResponse> getSurahList();
}
