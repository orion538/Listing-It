package com.orion.listingit.interfaces;

public interface ActionCompletionContract {
    void onViewMoved(int oldPosition, int newPosition);

    void onViewSwiped(int position);
}
