package com.example.newcontactcreate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.newcontactcreate.fragment.FirstFragment;
import com.example.newcontactcreate.fragment.SecondFragment;
import com.example.newcontactcreate.model.Member;

public class MainActivity extends AppCompatActivity implements FirstFragment.FragmentFirstListener {
FirstFragment firstFragment;
SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
     private void initView(){
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFirst,firstFragment).replace(R.id.fragmentSecond,secondFragment).commit();

     }

    @Override
    public void sendToSecondFragment(Member member) {
        secondFragment.updateText(member);
    }
}