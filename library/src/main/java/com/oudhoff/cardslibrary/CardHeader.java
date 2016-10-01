package com.oudhoff.cardslibrary;

import android.content.Context;
import android.support.annotation.MenuRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.oudhoff.cardslibrary.callbacks.CardHeaderMenuClickListener;


public class CardHeader extends RelativeLayout implements OnClickListener {

    private TextView titleTextView;
    private ImageButton overflowButton;

    private Card card;
    private String title;
    private CardHeaderMenuClickListener cardHeaderMenuClickListener;

    private PopupMenu overflowMenu;

    public CardHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        titleTextView = (TextView) findViewById(R.id.simpleCardHeaderTitle);
        overflowButton = (ImageButton) findViewById(R.id.simpleCardHeaderOverflowButton);
        overflowButton.setVisibility(View.GONE);
        overflowButton.setOnClickListener(this);
    }

    public void setTitle(String title) {
        titleTextView.setText(title);
        this.title = title;
    }

    public void setTitle(@StringRes int title) {
        this.title = getContext().getString(title);
        titleTextView.setText(this.title);
    }

    public String getTitle() {
        return title;
    }

    public void setPopupMenu(@MenuRes int menuRes, final CardHeaderMenuClickListener cardHeaderMenuClickListener) {
        this.cardHeaderMenuClickListener = cardHeaderMenuClickListener;

        //Create the pop up menu;
        overflowMenu = new PopupMenu(getContext(), overflowButton);
        overflowMenu.inflate(menuRes);
        overflowMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return cardHeaderMenuClickListener.onCardMenuItemClick(card, item);
            }
        });

        overflowButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        overflowMenu.show();
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
