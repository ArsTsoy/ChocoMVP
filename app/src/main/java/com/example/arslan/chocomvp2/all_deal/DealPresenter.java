package com.example.arslan.chocomvp2.all_deal;

import java.util.List;

public class DealPresenter implements DealContract.Presenter, DealContract.GetDealIntractor.OnFinishedListener {

    private DealContract.MainView mainView;
    private DealContract.GetDealIntractor getDealIntractor;


    public DealPresenter(DealContract.MainView mainView, DealContract.GetDealIntractor getDealIntractor) {
        this.mainView = mainView;
        this.getDealIntractor = getDealIntractor;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onRefresh(int town_id, int category_id, String sort_by) {
        if(mainView != null){
            mainView.showProgress();
        }
        getDealIntractor.getDealsList(this, town_id, category_id, sort_by, 1);
    }

    @Override
    public void requestDataFromServer(int town_id, int category_id, String sort_by, int page) {
        getDealIntractor.getDealsList(this, town_id, category_id, sort_by, page);
    }

    @Override
    public void onFinished(List<Deal> allDeals) {
        if(mainView != null){
            mainView.setDataToRecyclerView(allDeals);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }

    }
}
