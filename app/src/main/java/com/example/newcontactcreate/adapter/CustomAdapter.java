package com.example.newcontactcreate.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newcontactcreate.R;
import com.example.newcontactcreate.fragment.FirstFragment;
import com.example.newcontactcreate.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    FirstFragment firstFragment;
    List<Member> members;

    public CustomAdapter(FirstFragment firstFragment, List<Member> members) {
        this.firstFragment = firstFragment;
        this.members = members;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomViewHolder) {
            LinearLayout lay_click = ((CustomViewHolder) holder).linearLayout;
            TextView name = ((CustomViewHolder) holder).name;
            TextView phone = ((CustomViewHolder) holder).phone;

            name.setText(member.getName());
            phone.setText(member.getNumber());

            lay_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    firstFragment.clickContactItem(member);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView name, phone;
        LinearLayout linearLayout;
        View view;

        public CustomViewHolder(View v) {
            super(v);
            view = v;
            linearLayout = view.findViewById(R.id.click_name_phone);
            name = view.findViewById(R.id.tv_name);
            phone = view.findViewById(R.id.tv_phone_number);

        }
    }
}