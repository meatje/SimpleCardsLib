package com.oudhoff.cardslibrary.callbacks;

import android.view.MenuItem;

import com.oudhoff.cardslibrary.Card;


public interface CardHeaderMenuClickListener {
    boolean onCardMenuItemClick(Card card, MenuItem item);
}
