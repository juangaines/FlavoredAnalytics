package com.github.googlecodelabs.icon_shop;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;

public abstract class BaseActivity extends AppCompatActivity implements AnalyticsOperations{

    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics= FirebaseAnalytics.getInstance(this);
    }

    @Override
    public void logEcommercePurchase(long balance) {

        Bundle params = new Bundle();
        params.putLong( FirebaseAnalytics.Param.VALUE, balance);
        mFirebaseAnalytics.logEvent( FirebaseAnalytics.Event.ECOMMERCE_PURCHASE, params );
    }

    @Override
    public void logAddToCart(App.ItemData item) {
            Bundle params = new Bundle();
            params.putString( FirebaseAnalytics.Param.ITEM_ID, item.mName );
            params.putString( FirebaseAnalytics.Param.ITEM_CATEGORY, "icon" );
            params.putLong( FirebaseAnalytics.Param.VALUE, item.mPrice );
            mFirebaseAnalytics.logEvent( FirebaseAnalytics.Event.ADD_TO_CART, params );
    }

    @Override
    public void setProfession(String profession) {
        mFirebaseAnalytics.setUserProperty( "profession", profession );
    }
}
