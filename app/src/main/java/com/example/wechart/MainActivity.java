package com.example.wechart;

import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentManager;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment weixinFragment=new weixinFragment();
    private Fragment tongxunluFragment=new tongxunluFragment();
    private Fragment faxianFragment=new faxianFragment();
    private Fragment shezhiFragment=new shezhiFragment();
    private FragmentManager fragmentManager;

    private View LinearLayout1,LinearLayout2,LinearLayout3,LinearLayout4;
    private ImageView imageWeixin,imagetongxunlu,imagefaxian,imageshezhi;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView2);

        LinearLayout1=findViewById(R.id.tab_weixin);
        LinearLayout2=findViewById(R.id.tab_tongxunlu);
        LinearLayout3=findViewById(R.id.tab_faxian);
        LinearLayout4=findViewById(R.id.tab_shezhi);

        imageWeixin=findViewById(R.id.imageView);
        imagetongxunlu=findViewById(R.id.imageView1);
        imagefaxian=findViewById(R.id.imageView2);
        imageshezhi=findViewById(R.id.imageView3);

        LinearLayout1.setOnClickListener(this);
        LinearLayout2.setOnClickListener(this);
        LinearLayout3.setOnClickListener(this);
        LinearLayout4.setOnClickListener(this);

        initFragment();
        showfragment(0);

    }
    private void initFragment(){
        fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.content,weixinFragment);
        transaction.add(R.id.content,tongxunluFragment);
        transaction.add(R.id.content,faxianFragment);
        transaction.add(R.id.content,shezhiFragment);
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(weixinFragment);
        transaction.hide(tongxunluFragment);
        transaction.hide(faxianFragment);
        transaction.hide(shezhiFragment);
    }


    @Override
    public void onClick(View v) {
        resetImage();
        switch (v.getId()){
            case R.id.tab_weixin:
                showfragment(0);
                break;
            case R.id.tab_tongxunlu:
                showfragment(1);
                break;
            case R.id.tab_faxian:
                showfragment(2);
                break;
            case R.id.tab_shezhi:
                showfragment(3);
                break;
            default:
                break;
        }

    }

    private void showfragment(int i){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                textView.setText("微信");
                transaction.show(weixinFragment);
                imageWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;

            case 1:
                textView.setText("通讯录");
                transaction.show(tongxunluFragment);
                imagetongxunlu.setImageResource(R.drawable.tab_address_pressed);
                break;

            case 2:
                textView.setText("发现");
                transaction.show(faxianFragment);
                imagefaxian.setImageResource(R.drawable.tab_find_frd_pressed);
                break;

            case 3:
                textView.setText("设置");
                transaction.show(shezhiFragment);
                imageshezhi.setImageResource(R.drawable.tab_settings_pressed);
                break;

            default:
                break;
        }
        transaction.commit();
    }

    public void resetImage(){
        imageWeixin.setImageResource(R.drawable.tab_weixin_normal);
        imagetongxunlu.setImageResource(R.drawable.tab_address_normal);
        imagefaxian.setImageResource(R.drawable.tab_find_frd_normal);
        imageshezhi.setImageResource(R.drawable.tab_settings_normal);

    }

}