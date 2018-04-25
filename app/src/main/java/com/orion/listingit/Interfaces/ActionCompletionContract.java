package com.orion.listingit.Interfaces;

public interface ActionCompletionContract {
    void onViewMoved(int oldPosition, int newPosition);

    void onViewSwiped(int position);
}
