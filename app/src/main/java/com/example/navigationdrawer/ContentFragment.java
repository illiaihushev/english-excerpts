package com.example.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ContentFragment extends Fragment {
    private LayoutInflater mInflater;
    private ViewGroup mContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mInflater = inflater;
        mContainer = container;


        View v =inflater.inflate(R.layout.home,container,false);
        return v;
    }

    public void changeView(@LayoutRes int resource){
        View newView = mInflater.inflate(resource, mContainer, false);
        mContainer.removeAllViews();
        mContainer.addView(newView);
//        getFragmentManager().beginTransaction().remove(this).commit();
//        getFragmentManager().beginTransaction().replace(resource,this).commit();
    }
}
