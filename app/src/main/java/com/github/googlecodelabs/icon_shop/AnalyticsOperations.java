package com.github.googlecodelabs.icon_shop;

public interface AnalyticsOperations {
    void logEcommercePurchase(long balance);
    void logAddToCart(App.ItemData item);
    void setProfession(String profession);

}
