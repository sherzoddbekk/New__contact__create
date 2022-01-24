package com.example.newcontactcreate.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newcontactcreate.R;
import com.example.newcontactcreate.adapter.CustomAdapter;
import com.example.newcontactcreate.model.Member;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private RecyclerView recyclerView;
    FragmentFirstListener fragmentAListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_first, container,false);
        recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 1));

        List<Member> members = prepareMemberList();

        CustomAdapter adapter = new CustomAdapter(this, members);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<Member> prepareMemberList() {
        List<Member> members= new ArrayList<>();
        for(int i = 0; i<20; i++){
            members.add(new Member("A"+i,"91506475"+i));
        }
        return members;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentFirstListener){
            fragmentAListener = (FragmentFirstListener) context;
        }
    }
    public  void clickContactItem(Member member){
        fragmentAListener.sendToSecondFragment(member);
    }



    @Override
    public void onDetach() {
        super.onDetach();
        fragmentAListener = null;
    }

    public interface FragmentFirstListener{
        void sendToSecondFragment(Member member);
    }

}
