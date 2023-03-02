package com.example.project;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;

public class AllSeeActivity extends AppCompatActivity {

    ArrayList<Word> mWordList=new ArrayList<>();
    WordAdapter mWordAdapter;
    FirebaseFirestore firestore=FirebaseFirestore.getInstance();
    RecyclerView wordListRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_see_activity);

        wordListRv=(RecyclerView)findViewById(R.id.word_list_rv);

        mWordAdapter=new WordAdapter(mWordList);
        wordListRv.setLayoutManager(new LinearLayoutManager(this));
        wordListRv.setAdapter(mWordAdapter);

        firestore.collection("Word").orderBy("jpWord", Query.Direction.DESCENDING).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot snapshot:list)
                        {
                            Word word=snapshot.toObject(Word.class);
                            mWordList.add(word);
                        }
                        mWordAdapter.notifyDataSetChanged();
                    }

                });
    }
}
