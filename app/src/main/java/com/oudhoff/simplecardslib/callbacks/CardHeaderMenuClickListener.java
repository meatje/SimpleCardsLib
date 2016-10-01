package com.oudhoff.simplecardslib.callbacks;

import android.view.MenuItem;

import com.oudhoff.simplecardslib.Card;

public interface CardHeaderMenuClickListener {
    boolean onCardMenuItemClick(Card card, MenuItem item);
}
