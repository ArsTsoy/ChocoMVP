package com.example.arslan.chocomvp2.service;



import com.example.arslan.chocomvp2.all_deal.Deal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONChocoAPI {
    String DEALS = "v3_3/deals";
    String DEAL_INFO = "v3/deal";
    String CATEGORY_BANNER = "v3_4/deals/banner";
    String TOWNS = "v3/towns";
    String COMMENTS = "v3/deal/comments";
    String REVIEWS = "v3/deal/reviews";
    String CATEGORIES = "v3_3/categories";


    String PARAMS_DEAL_ID = "deal_id";
    String PARAMS_SORT_BY = "sort";
    String PARAMS_PAGE = "page";
    String PARAMS_TOWN_ID = "town_id";
    String PARAMS_CATEGORY_ID = "category_id";

    @GET(DEALS)
    Call<JsonResult<List<Deal>>> getAllDeals(
            @Query(PARAMS_TOWN_ID) int town_id,
            @Query(PARAMS_CATEGORY_ID) int category_id,
            @Query(PARAMS_SORT_BY) String methodOfSort,
            @Query(PARAMS_PAGE) int page
    );




}
