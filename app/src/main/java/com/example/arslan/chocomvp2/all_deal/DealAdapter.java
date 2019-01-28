package com.example.arslan.chocomvp2.all_deal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arslan.chocomvp2.R;
import com.example.arslan.chocomvp2.all_deal.Listeners.OnDealClickListener;
import com.example.arslan.chocomvp2.all_deal.Listeners.OnReachEndListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DealAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private final int DEAL_ITEM_LAYOUT = R.layout.deal_item;
    private final int SPECIAL_DEAL_ITEM_LAYOUT = R.layout.special_deal_item;


    private OnReachEndListener onReachEndListener;
    private OnDealClickListener onDealClickListener;

    public void setOnDealClickListener(OnDealClickListener onDealClickListener) {
        this.onDealClickListener = onDealClickListener;
    }

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }


    private static String IMAGE_KIND_GENERAL = "general";
    private static String IMAGE_KIND_WIDE_PLATE = "wide_plate";

    private static int ITEM_TYPE_GENERAL = 1;
    private static int ITEM_TYPE_WIDE_PLATE = 2;

    private List<Deal> deals;

    public Deal getDeal(int position){
        return deals.get(position);
    }

    public DealAdapter() {
        this.deals = new ArrayList<>();
    }


    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals.clear();
        this.deals.addAll(deals);
        this.notifyDataSetChanged();
    }

    public void addDeals(List<Deal> deals) {
        this.deals.addAll(deals);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = null;
        if(i == ITEM_TYPE_GENERAL){
            view = layoutInflater.inflate(DEAL_ITEM_LAYOUT, viewGroup, false);
            return new GeneralDealViewHolder(view);
        }else{
            view = layoutInflater.inflate(SPECIAL_DEAL_ITEM_LAYOUT, viewGroup, false);
            return new SpecialDealViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(deals.size() >= 20 && i>deals.size()-2 && onReachEndListener != null){
            onReachEndListener.onReachEnd();
        }
        Deal deal = deals.get(i);
        if(viewHolder instanceof GeneralDealViewHolder){
            ((GeneralDealViewHolder) viewHolder).bind(deal);
        }else {
            ((SpecialDealViewHolder)viewHolder).bind(deal);
        }
    }

    @Override
    public int getItemCount() {
        return deals.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(deals.get(position).getImageKind().equals(IMAGE_KIND_GENERAL)){
            return ITEM_TYPE_GENERAL;
        }else {
            return ITEM_TYPE_WIDE_PLATE;
        }
    }





    private class GeneralDealViewHolder extends RecyclerView.ViewHolder{
        private ImageView IVDeal;
        private TextView TVShortTitle;
        private TextView TVTitle;
        private TextView TVBought;
        private TextView TVPrice;
        private TextView TVRating;

        private String price;

        public GeneralDealViewHolder(@NonNull View itemView) {
            super(itemView);

            IVDeal = itemView.findViewById(R.id.deal_item_IVDeal);
            TVShortTitle = itemView.findViewById(R.id.deal_item_TVShortTitle);
            TVTitle = itemView.findViewById(R.id.deal_item_TVTitle);
            TVBought = itemView.findViewById(R.id.deal_item_TVBoughtCount);
            TVPrice = itemView.findViewById(R.id.deal_item_TVPrice);
            TVRating = itemView.findViewById(R.id.deal_item_TVRating);

            price = itemView.getResources().getString(R.string.deal_item_priceFrom);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onDealClickListener != null){
                        onDealClickListener.onDealClick(deals.get(getAdapterPosition()));
                    }
                }
            });
        }

        public void bind(Deal deal){
            Picasso.get().load(deal.getImageUrlWide()).into(IVDeal);
            TVShortTitle.setText(deal.getTitle_short());
            TVTitle.setText(deal.getTitle());
            TVBought.setText(Integer.toString(deal.getBought()));
            TVPrice.setText(String.format(price, deal.getPrice()));
            TVRating.setText(Double.toString(deal.getReviews_rate()));
        }
    }


    private class SpecialDealViewHolder extends RecyclerView.ViewHolder{
        private ImageView sIVDeal;

        public SpecialDealViewHolder(@NonNull View itemView) {
            super(itemView);
            sIVDeal = itemView.findViewById(R.id.special_deal_item_IVDeal);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onDealClickListener != null){
                        onDealClickListener.onDealClick(deals.get(getAdapterPosition()));
                    }
                }
            });


        }

        public void bind(Deal deal){
            Picasso.get().load(deal.getImageUrl()).into(sIVDeal);
        }
    }



}
