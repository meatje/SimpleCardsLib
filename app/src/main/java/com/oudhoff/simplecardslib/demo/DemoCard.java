package com.oudhoff.simplecardslib.demo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.TextView;

import com.oudhoff.simplecardslib.Card;
import com.oudhoff.simplecardslib.R;

public class DemoCard extends Card<String> {

    public DemoCard(Context context, String data, @LayoutRes int layoutRes) {
        super(context, data, layoutRes);
    }

    @Override
    public void setupLayout(View inflatedLayout) {
        TextView text =  (TextView) inflatedLayout.findViewById(R.id.text);
        text.setText("HELLO " + getData());
    }
}
