package com.example.arslan.chocomvp2.all_deal;

import java.util.List;

public interface DealContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface Presenter{

        void onDestroy();

        void onRefresh(int town_id, int category_id, String sort_by);

        void requestDataFromServer(int town_id, int category_id, String sort_by, int page);

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Deal> allDeals);



        void onResponseFailure(Throwable throwable);

    }


    interface GetDealIntractor {
        interface OnFinishedListener {
            void onFinished(List<Deal> allDeals);
            void onFailure(Throwable t);
        }

        void getDealsList(OnFinishedListener onFinishedListener, int town_id, int category_id, String sort_by, int page);
    }
}
