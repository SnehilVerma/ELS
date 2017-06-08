package com.elsapp.els;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.daprlabs.aaron.swipedeck.SwipeDeck;

import java.util.ArrayList;
import java.util.List;

import Adapter.SwipeAdapter;


public class MainActivity extends AppCompatActivity {

    List testData;
    SwipeAdapter adapter;
    SwipeDeck cardStack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);


        testData = new ArrayList<>();
        testData.add("0");
        testData.add("1");
        testData.add("2");
        testData.add("3");
        testData.add("4");

        adapter = new SwipeAdapter(testData, this);
        if(cardStack != null){
            cardStack.setAdapter(adapter);
        }

        cardStack.setCallback(new SwipeDeck.SwipeDeckCallback() {
            @Override
            public void cardSwipedLeft(long positionInAdapter) {
                Log.i("MainActivity", "card was swiped left, position in adapter: " + positionInAdapter);
            }

            @Override
            public void cardSwipedRight(long positoinInAdapter) {
                Log.i("MainActivity", "card was swiped right, position in adapter: " + positoinInAdapter);

            }
        });

        cardStack.setLeftImage(R.id.left_image);
        cardStack.setRightImage(R.id.right_image);

    }
}
