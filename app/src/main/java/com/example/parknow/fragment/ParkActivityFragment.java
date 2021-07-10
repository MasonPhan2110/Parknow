package com.example.parknow.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.parknow.R;
import com.example.parknow.adapter.ParkActivityAdapter;

import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;


public class ParkActivityFragment extends Fragment {
    LinearLayout now_1, now_2, past;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_park_activity, container, false);
        now_1 = view.findViewById(R.id.linear_now_1);
        now_2 = view.findViewById(R.id.linear_now_2);
        past = view.findViewById(R.id.linear_past);
        setup_fragment();
        return view;
    }

    private void setup_fragment() {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<String>();
        list1.add("Minh");
        list1.add("Minh");
        list1.add("Minh");

        ParkActivityAdapter adapter = new ParkActivityAdapter(getContext(),now_1,"Đã sắp lịch", list);
        ParkActivityAdapter adapter1 = new ParkActivityAdapter(getContext(),now_2,"Xe đang gửi", list1);
        adapter.load();
        adapter1.load();
    }
}