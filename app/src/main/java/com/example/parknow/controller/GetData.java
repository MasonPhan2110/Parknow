package com.example.parknow.controller;

import androidx.annotation.NonNull;

import com.example.parknow.model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class GetData {
    public Users getdataUser(DatabaseReference reference){
        final Users[] user = {null};
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user[0] = snapshot.getValue(Users.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return user[0];
    }
}
