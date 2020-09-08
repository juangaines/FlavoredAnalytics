package com.github.googlecodelabs.icon_shop;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;

import static com.huawei.hms.analytics.type.HAEventType.ADDPRODUCT2CART;
import static com.huawei.hms.analytics.type.HAEventType.COMPLETEPURCHASE;
import static com.huawei.hms.analytics.type.HAParamType.CATEGORY;
import static com.huawei.hms.analytics.type.HAParamType.PRICE;
import static com.huawei.hms.analytics.type.HAParamType.PRODUCTID;
import static com.huawei.hms.analytics.type.HAParamType.PRODUCTNAME;
import static com.huawei.hms.analytics.type.HAParamType.QUANTITY;

public abstract class BaseActivity extends AppCompatActivity implements AnalyticsOperations{

    private HiAnalyticsInstance mHiAnalytics;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HiAnalyticsTools.enableLog();
        mHiAnalytics= HiAnalytics.getInstance(this);
    }

    @Override
    public void logEcommercePurchase(long balance) {

        Bundle params = new Bundle();
        //params.putLong( VALUE, balance);
        // to be added
        mHiAnalytics.onEvent( COMPLETEPURCHASE, params );
    }

    @Override
    public void logAddToCart(App.ItemData item) {
            Bundle params = new Bundle();
            params.putString( PRODUCTID, item.mName );
            params.putString( PRODUCTNAME, item.mName );
            params.putString( CATEGORY, "icon" );
            params.putLong( QUANTITY, 1 );
            params.putDouble( PRICE, item.mPrice );
            mHiAnalytics.onEvent(ADDPRODUCT2CART, params );
    }

    @Override
    public void setProfession(String profession) {
        mHiAnalytics.setUserProfile( "profession", profession );
    }
}
