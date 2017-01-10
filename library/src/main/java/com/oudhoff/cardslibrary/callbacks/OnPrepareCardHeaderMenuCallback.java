package com.oudhoff.cardslibrary.callbacks;

import android.view.Menu;

import com.oudhoff.cardslibrary.Card;

public interface OnPrepareCardHeaderMenuCallback {
    boolean onPrepareCardHeaderMenu(Card card, Menu menu);
}
