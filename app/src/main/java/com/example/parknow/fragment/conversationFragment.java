package com.example.parknow.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parknow.R;
import com.example.parknow.model.Chatlist;
import com.example.parknow.model.Parks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class conversationFragment extends Fragment {
    private RecyclerView recyclerView;
    //private UserAdapter userAdapter;
    private List<Parks> mParks;
    FirebaseUser firebaseUser;
    DatabaseReference reference;
    private List<Chatlist> chatList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conversation, container, false);
        recyclerView = view.findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        chatList = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("Chatlist").child(firebaseUser.getUid());
        return view;
    }
}