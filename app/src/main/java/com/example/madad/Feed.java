package com.example.madad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Feed extends AppCompatActivity {

    Button button1;
    RecyclerView recyclerView;

    private List<Model1> model1List;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        recyclerView =findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        model1List =new ArrayList<>();
        myadapter adapter= new myadapter(model1List,this);


        button1=findViewById(R.id.upload_btn);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String phonexyz= getIntent().getStringExtra("phonexyz");
                String namexyz= getIntent().getStringExtra("namexyz");
                Intent i = new Intent (Feed.this, Temporary.class);
                i.putExtra("phonexyz",phonexyz);
                i.putExtra("namexyz",namexyz);
                startActivity(i);
            }
        });


       /* recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Model1> options =
                new FirebaseRecyclerOptions.Builder<Model1>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Image"), Model1.class)
                        .build();


        adapter=new myadapter(options);   */

        FirebaseDatabase.getInstance().getReference().child("Image").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
                Model1 model = snapshot.getValue(Model1.class);
                model1List.add(model);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
        recyclerView.setAdapter(adapter);

    }
  /*  @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }  */


}