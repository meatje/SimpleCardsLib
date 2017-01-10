package com.oudhoff.cardslibrary;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.view.LayoutInflater;
import android.view.View;

import com.oudhoff.cardslibrary.callbacks.CardClickListener;
import com.oudhoff.cardslibrary.callbacks.CardHeaderMenuClickListener;
import com.oudhoff.cardslibrary.callbacks.CardLongClickListener;
import com.oudhoff.cardslibrary.callbacks.OnPrepareCardHeaderMenuCallback;


public abstract class Card<T> {
    private Context context;
    private CardHeader cardHeader;

    private View inflatedLayout;
    private View headerLayout;
    private LayoutInflater inflater;

    private CardClickListener cardClickListener;
    private CardLongClickListener cardLongClickListener;

    private T data;

    public abstract void setupLayout(View inflatedLayout);

    public Card(Activity activity, T data, @LayoutRes final int layoutRes) {
        this.context = activity;
        this.data = data;
        this.inflater = LayoutInflater.from(getContext());

        inflatedLayout = inflater.inflate(layoutRes, null, false);
        setupLayout(inflatedLayout);
    }

    public Context getContext() {
        return context;
    }

    public CardHeader getCardHeader() {
        return cardHeader;
    }

    public void setCardHeader(final String title, @MenuRes final int menuRes, final CardHeaderMenuClickListener cardHeaderMenuClickListener) {
        setCardHeader(title, menuRes, cardHeaderMenuClickListener, null);
    }

    public void setCardHeader(final String title, @MenuRes final int menuRes, final CardHeaderMenuClickListener cardHeaderMenuClickListener, final OnPrepareCardHeaderMenuCallback onPrepareCardHeaderMenuCallback) {
        CardHeader cardHeader = (CardHeader) inflater.inflate(R.layout.view_base_card_header, null, false);
        cardHeader.setTitle(title);
        cardHeader.setCard(Card.this);
        cardHeader.setPopupMenu(menuRes, cardHeaderMenuClickListener, onPrepareCardHeaderMenuCallback);

        Card.this.cardHeader = cardHeader;
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
