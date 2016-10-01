package com.oudhoff.simplecardslib.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oudhoff.simplecardslib.Card;
import com.oudhoff.simplecardslib.R;
import com.oudhoff.simplecardslib.SimpleCardView;

import java.util.ArrayList;
import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Card> cards = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public DemoAdapter(List<Card> cards, Context context) {
        this.cards = cards;
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.view_base_card, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Holder viewHolder = (Holder) holder;

        SimpleCardView cardView = (SimpleCardView) holder.itemView;

        cardView.setCard(cards.get(position));
    }


    @Override
    public int getItemCount() {
        return cards.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        public Holder(View itemView) {
            super(itemView);
        }


    }
}
