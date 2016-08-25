package com.example.query_train;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private android.app.FragmentManager fManager;
    private RadioButton one,two,three;
    private ImageView left;
    private TextView title;
    private RadioGroup tab_bar;
    MyFragment fg1,fg2,fg3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (RadioButton) findViewById(R.id.channel_one);
        two = (RadioButton) findViewById(R.id.channel_two);
        three = (RadioButton) findViewById(R.id.channel_three);
        left = (ImageView) findViewById(R.id.left);
        title = (TextView) findViewById(R.id.title);
        tab_bar = (RadioGroup) findViewById(R.id.tab_bar);
        fManager = getFragmentManager();
        tab_bar.setOnCheckedChangeListener(this);
        one.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (checkedId) {
            case R.id.channel_one:
                if (fg1==null) {
                    fg1 = MyFragment.newInstance(1);
                    fTransaction.add(R.id.frag_content,(Fragment)fg1);
                }else {
                    fTransaction.show(fg1);
                }
                title.setText("车票预定");
                break;
            case R.id.channel_two:
                if (fg2==null) {
                    fg2 = MyFragment.newInstance(2);
                    fTransaction.add(R.id.frag_content,(Fragment)fg2);
                }else {
                    fTransaction.show(fg2);
                }
                title.setText("订单查询");
                break;
            case R.id.channel_three:
                if (fg3==null) {
                    fg3 = MyFragment.newInstance(3);
                    fTransaction.add(R.id.frag_content,(Fragment)fg3);
                }else {
                    fTransaction.show(fg3);
                }
                title.setText("我的12306");
                break;
        }
        fTransaction.commit();
    }
    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
    }
}
