package com.oudhoff.simplecardslib;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;

public class SimpleCardView extends CardView implements OnClickListener, OnLongClickListener {

    private Card card;
    private LinearLayout container;

    public SimpleCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initUI();
    }

    private void initUI() {
        container = (LinearLayout) findViewById(R.id.simpleCardContainer);

        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    public void clearCard() {
        container.removeAllViews();
    }

    public void setCard(Card card) {
        clearCard();
        this.card = card;

        if (card.getCardHeader() != null) {
            container.addView(card.getCardHeader());
        }

        if (card.getInflatedLayout() != null) {
            container.addView(card.getInflatedLayout());
        }
    }

    @Override
    public void onClick(View v) {
        if (card.getCardClickListener() != null) {
            card.getCardClickListener().onCardClick(card);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (card.getCardLongClickListener() != null) {
            return card.getCardLongClickListener().onCardLongClick(card);
        }

        return false;
    }
}
