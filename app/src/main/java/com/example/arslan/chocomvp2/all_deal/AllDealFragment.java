package com.example.arslan.chocomvp2.all_deal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.arslan.chocomvp2.R;
import com.example.arslan.chocomvp2.all_deal.Listeners.OnDealClickListener;
import com.example.arslan.chocomvp2.all_deal.Listeners.OnReachEndListener;

import java.util.ArrayList;
import java.util.List;

public class AllDealFragment extends Fragment implements DealContract.MainView {
    private static final int LAYOUT = R.layout.fragment_all_deal;

    private RecyclerView recyclerView;
    private DealContract.Presenter presenter;
    private View view;
    private DealAdapter dealAdapter;

    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        initRecyclerView();

        presenter = new DealPresenter(this,new DealModel());
        presenter.requestDataFromServer(1,1, "popular", page);
        return view;
    }

    private void initRecyclerView() {
        recyclerView = view.findViewById(R.id.fragment_all_deal_recyclerViewAllDeal);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    private void initListener(){}

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToRecyclerView(List<Deal> allDeals) {
        if(dealAdapter == null){
            dealAdapter = new DealAdapter();
            recyclerView.setAdapter(dealAdapter);
            dealAdapter.setOnReachEndListener(new OnReachEndListener() {
                @Override
                public void onReachEnd() {
                    presenter.requestDataFromServer(1,1,"popular",++page);
                    Toast.makeText(getActivity(), "page " + page, Toast.LENGTH_SHORT).show();
                }
            });
            dealAdapter.setOnDealClickListener(new OnDealClickListener() {
                @Override
                public void onDealClick(Deal deal) {
                    Intent deal_info_intent = new Intent();

                }
            });
        }
        dealAdapter.addDeals(allDeals);



    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getActivity(),
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
    }
}
