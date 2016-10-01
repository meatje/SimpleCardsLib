package com.oudhoff.cardslibrary;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.view.LayoutInflater;
import android.view.View;

import com.oudhoff.cardslibrary.callbacks.CardClickListener;
import com.oudhoff.cardslibrary.callbacks.CardHeaderMenuClickListener;
import com.oudhoff.cardslibrary.callbacks.CardLongClickListener;


public abstract class Card<T> {
    private Context context;
    private CardHeader cardHeader;

    private View inflatedLayout;
    private LayoutInflater inflater;

    private CardClickListener cardClickListener;
    private CardLongClickListener cardLongClickListener;


    private T data;

    public abstract void setupLayout(View inflatedLayout);

    public Card(Context context, T data, @LayoutRes int layoutRes) {
        this.context = context;
        this.data = data;

        inflater = LayoutInflater.from(getContext());
        inflatedLayout = inflater.inflate(layoutRes, null, false);
        setupLayout(inflatedLayout);
    }

    public Context getContext() {
        return context;
    }

    public CardHeader getCardHeader() {
        return cardHeader;
    }

    public void setCardHeader(String title, @MenuRes int menuRes, CardHeaderMenuClickListener cardHeaderMenuClickListener) {
        CardHeader cardHeader = (CardHeader) inflater.inflate(R.layout.view_base_card_header, null, false);
        cardHeader.setTitle(title);
        cardHeader.setCard(this);
        cardHeader.setPopupMenu(menuRes, cardHeaderMenuClickListener);

        this.cardHeader = cardHeader;
    }

    public T getData() {
        return data;
    }

    public View getInflatedLayout() {
        return inflatedLayout;
    }


    public CardClickListener getCardClickListener() {
        return cardClickListener;
    }

    public void setCardClickListener(CardClickListener cardClickListener) {
        this.cardClickListener = cardClickListener;
    }

    public CardLongClickListener getCardLongClickListener() {
        return cardLongClickListener;
    }

    public void setCardLongClickListener(CardLongClickListener cardLongClickListener) {
        this.cardLongClickListener = cardLongClickListener;
    }
}
