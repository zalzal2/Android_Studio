package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class WordActivity extends AppCompatActivity {

    FirebaseFirestore fireStore= FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        EditText WordEt=findViewById(R.id.word_et);
        EditText HuriganaEt=findViewById(R.id.hurigana_et);
        EditText MeanEt=findViewById(R.id.mean_et);

        Button WordAddBtn=findViewById(R.id.word_add_btn);

        WordAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String JpWord = WordEt.getText().toString();
                String Hurigana = HuriganaEt.getText().toString();
                String Mean = MeanEt.getText().toString();

                Word word = new Word();
                word.setJpWord(JpWord);
                word.setHurigana(Hurigana);
                word.setMean(Mean);

                fireStore.collection("Word").add(word)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(WordActivity.this, "저장 성공.", Toast.LENGTH_SHORT).show();
                                setResult(RESULT_OK);
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(WordActivity.this, "저장 실패.", Toast.LENGTH_SHORT).show();
                            }
                        });

            }

        });
    }
}
