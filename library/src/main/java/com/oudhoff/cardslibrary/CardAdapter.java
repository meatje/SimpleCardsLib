package com.oudhoff.cardslibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Card> cards = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public CardAdapter(List<Card> cards, Context context) {
        this.cards = cards;
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    public void add(Card newItem) {
        cards.add(newItem);
        notifyDataSetChanged();
    }

    public void addAll(List<Card> newItems) {
        cards.addAll(newItems);
        notifyDataSetChanged();
    }

    public void clear() {
        cards.clear();
        notifyDataSetChanged();
    }

    public void remove(int position) {
        cards.remove(position);
        notifyDataSetChanged();
    }

    public void remove(Card card) {
        cards.remove(card);
        notifyDataSetChanged();
    }

    public Card getItem(int position) {
        return cards.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.view_base_card, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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
