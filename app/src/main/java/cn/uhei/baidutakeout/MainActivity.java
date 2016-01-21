package cn.uhei.baidutakeout;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HomeFragment hf;

    private ImageView ivHome,ivList,ivMy;
    private TextView tvHome,tvList,tvMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivHome = (ImageView) findViewById(R.id.ivHome);
        ivList = (ImageView) findViewById(R.id.ivList);
        ivMy = (ImageView) findViewById(R.id.ivMy);
        tvHome = (TextView) findViewById(R.id.tvHome);
        tvList = (TextView) findViewById(R.id.tvList);
        tvMy = (TextView) findViewById(R.id.tvMy);

        ivHome.setOnClickListener(this);
        ivList.setOnClickListener(this);
        ivMy.setOnClickListener(this);
        tvHome.setOnClickListener(this);
        tvList.setOnClickListener(this);
        tvMy.setOnClickListener(this);

        homeFragment();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ivHome:
                homeFragment();
                showToast("首页");
                break;
            case R.id.tvHome:
                homeFragment();
                showToast("首页");
                break;
            case R.id.ivList:
                listFragment();
                showToast("订单");
                break;
            case R.id.tvList:
                listFragment();
                showToast("订单");
                break;
            case R.id.ivMy:
                showToast("我的");
                myFragment();
                break;
            case R.id.tvMy:
                showToast("我的");
                myFragment();
                break;
        }
    }
    //我的帧
    private void myFragment(){
        UserFragment uf = new UserFragment();
        FragmentManager userfm = getFragmentManager();
        FragmentTransaction userft = userfm.beginTransaction();
        userft.replace(R.id.fl, uf);
        userft.commit();

        ivHome.setImageResource(R.drawable.tab_icon_home);
        ivList.setImageResource(R.drawable.tab_icon_dingdan);
        ivMy.setImageResource(R.drawable.tab_icon_me_selected);

        tvHome.setTextColor(Color.parseColor("#585858"));
        tvList.setTextColor(Color.parseColor("#585858"));
        tvMy.setTextColor(Color.parseColor("#FF2D48"));
    }

    //订单帧
    private void listFragment(){
        ListFragment listf = new ListFragment();
        FragmentManager listfm = getFragmentManager();
        FragmentTransaction listft = listfm.beginTransaction();
        listft.replace(R.id.fl, listf);
        listft.commit();

        ivHome.setImageResource(R.drawable.tab_icon_home);
        ivList.setImageResource(R.drawable.tab_icon_dingdan_selected);
        ivMy.setImageResource(R.drawable.tab_icon_me);

        tvHome.setTextColor(Color.parseColor("#585858"));
        tvList.setTextColor(Color.parseColor("#FF2D48"));
        tvMy.setTextColor(Color.parseColor("#585858"));


    }

    //首页帧
    private void homeFragment(){
        HomeFragment homef = new HomeFragment();
        FragmentManager homefm = getFragmentManager();
        FragmentTransaction homeft = homefm.beginTransaction();
        homeft.replace(R.id.fl,homef);
        homeft.commit();

        ivHome.setImageResource(R.drawable.tab_icon_home_selected);
        ivList.setImageResource(R.drawable.tab_icon_dingdan);
        ivMy.setImageResource(R.drawable.tab_icon_me);

        tvHome.setTextColor(Color.parseColor("#FF2D48"));
        tvList.setTextColor(Color.parseColor("#585858"));
        tvMy.setTextColor(Color.parseColor("#585858"));
    }

    //测试
    private void showToast(String str){
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
    }
}
