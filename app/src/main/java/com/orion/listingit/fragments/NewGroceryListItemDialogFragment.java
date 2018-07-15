package com.orion.listingit.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.orion.listingit.R;
import com.orion.listingit.interfaces.NewListItemDialogFragmentListener;

public class NewGroceryListItemDialogFragment extends DialogFragment implements TextView.OnEditorActionListener {

    private AutoCompleteTextView mTextView;

    private NewListItemDialogFragmentListener mListener;

    public NewGroceryListItemDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof NewListItemDialogFragmentListener) {
            mListener = (NewListItemDialogFragmentListener) context;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.grocery_list_new_item_title);

        View viewInflated = LayoutInflater.from(getActivity()).inflate(R.layout.create_new_simple_list_item, null, false);
        mTextView = viewInflated.findViewById(R.id.input);
        mTextView.setOnEditorActionListener(this);
        builder.setView(viewInflated);

        // Set up the buttons
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.DismissNewListItemDialogFragmentWithResult(mTextView.getText().toString());
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }


    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (EditorInfo.IME_ACTION_DONE == i) {
            mListener.DismissNewListItemDialogFragmentWithResult(textView.getText().toString());
            this.dismiss();
            return true;
        }
        return false;
    }
}
