package com.oudhoff.simplecardslib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.oudhoff.cardslibrary.Card;
import com.oudhoff.cardslibrary.CardAdapter;
import com.oudhoff.cardslibrary.callbacks.CardClickListener;
import com.oudhoff.cardslibrary.callbacks.CardHeaderMenuClickListener;
import com.oudhoff.cardslibrary.callbacks.OnPrepareCardHeaderMenuCallback;

import java.util.ArrayList;
import java.util.List;

public class DemoActivity extends AppCompatActivity implements CardClickListener, CardHeaderMenuClickListener, OnPrepareCardHeaderMenuCallback {

    private CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Card> cards = new ArrayList<>();

        for (int i = 1; i <= 25; i++) {
            DemoCard card = new DemoCard(this, "Test " + i, R.layout.demo_card);
            card.setCardHeader("Title " + i, R.menu.demo_card_menu, this, this);
            card.setCardClickListener(this);
            cards.add(card);
        }

        cardAdapter = new CardAdapter(cards, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(cardAdapter);
    }

    @Override
    public boolean onPrepareCardHeaderMenu(Card card, Menu menu) {
        MenuItem item = menu.findItem(R.id.testMenuItem);
//        item.setEnabled(false);
        return true;
    }

    @Override
    public boolean onCardMenuItemClick(Card card, MenuItem item) {
        Toast.makeText(this, item.getTitle() + " " + card.getCardHeader().getTitle(), Toast.LENGTH_SHORT).show();

        return true;
    }

    @Override
    public void onCardClick(Card card) {
        Toast.makeText(this, "CLICKED:  " + card.getCardHeader().getTitle(), Toast.LENGTH_SHORT).show();
    }


}
