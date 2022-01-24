package com.example.newcontactcreate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newcontactcreate.R;
import com.example.newcontactcreate.model.Member;

public class SecondFragment extends Fragment {
    private TextView contact_name,contact_phone;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_head,container,false);
      contact_name = view.findViewById(R.id.contact_name);
    contact_phone = view.findViewById(R.id.contact_phone);
      return view;

    }

    public void updateText(Member member){

        contact_name.setText(member.getName());
       contact_phone.setText(member.getNumber());
    }
}
