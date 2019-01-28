package com.example.arslan.chocomvp2.all_deal;

import android.util.Log;

import com.example.arslan.chocomvp2.service.JSONChocoAPI;
import com.example.arslan.chocomvp2.service.JsonResult;
import com.example.arslan.chocomvp2.service.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealModel implements DealContract.GetDealIntractor{


    @Override
    public void getDealsList(final DealContract.GetDealIntractor.OnFinishedListener onFinishedListener, int town_id, int category_id, String sort_by, int page) {
        JSONChocoAPI api = NetworkService.getInstance().getJSONApi();

        Call<JsonResult<List<Deal>>> call = api.getAllDeals(town_id,category_id,sort_by,page);
        Log.i("mURL ", call.request().url().toString());


        call.enqueue(new Callback<JsonResult<List<Deal>>>() {
            @Override
            public void onResponse(Call<JsonResult<List<Deal>>> call, Response<JsonResult<List<Deal>>> response) {
                if(response.body() != null && response.isSuccessful()){
                    onFinishedListener.onFinished(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<JsonResult<List<Deal>>> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }


}
