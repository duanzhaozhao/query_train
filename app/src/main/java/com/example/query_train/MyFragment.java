package com.example.query_train;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 小钊 on 2016/8/25.
 */
public class MyFragment extends Fragment {
    int num;
    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    public static MyFragment newInstance(int num){
        MyFragment myFragment = new MyFragment();
        Log.i("aaa","ccc4");
        Bundle args = new Bundle();
        args.putInt("num",num);
        myFragment.setArguments(args);
        Log.i("aaa", String.valueOf(num));
        return myFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("aaa","ccc");
        num = getArguments() != null?getArguments().getInt("num"):1;
        Log.i("aaa1", String.valueOf(num));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        switch (num) {
            case 1:
                view = inflater.inflate(R.layout.view1,null);
                break;
            case 2:
                view = inflater.inflate(R.layout.view2,null);
                break;
            case 3:
                view = inflater.inflate(R.layout.view3,null);
                break;
        }
        return view;
    }
}
