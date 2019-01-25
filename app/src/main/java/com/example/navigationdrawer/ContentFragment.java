package com.example.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ContentFragment extends Fragment {
    private LayoutInflater mInflater;
    private ViewGroup mContainer;
    private ViewGroup placeholder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mInflater = inflater;
        mContainer = container;


        View v =inflater.inflate(R.layout.home,container,false);
        placeholder = (ViewGroup) v;

        return placeholder;
    }

    public void changeView(@LayoutRes int resource){
        View newView = mInflater.inflate(resource, mContainer, false);
        placeholder.removeAllViews();
        placeholder.addView(newView);
    }
}
