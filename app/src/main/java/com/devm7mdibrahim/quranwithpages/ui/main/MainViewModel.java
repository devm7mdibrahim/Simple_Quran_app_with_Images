package com.devm7mdibrahim.quranwithpages.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devm7mdibrahim.quranwithpages.api.ApiClient;
import com.devm7mdibrahim.quranwithpages.model.Data;
import com.devm7mdibrahim.quranwithpages.model.SurahResponse;
import com.devm7mdibrahim.quranwithpages.utils.Resource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    public LiveData<Resource<List<Data>>> getSurahList() {
        final MutableLiveData<Resource<List<Data>>> surahResponse = new MutableLiveData<>();

        surahResponse.setValue(Resource.<List<Data>>loading());
        ApiClient.getRetrofitInstance().getSurahList()
                .enqueue(new Callback<SurahResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<SurahResponse> call, @NonNull Response<SurahResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            surahResponse.postValue(Resource.success(response.body().getData()));
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<SurahResponse> call, @NonNull Throwable t) {
                        surahResponse.setValue(Resource.<List<Data>>error(t.getMessage() != null ? t.getMessage() : "Unknown Error"));
                    }
                });

        return surahResponse;
    }
}
