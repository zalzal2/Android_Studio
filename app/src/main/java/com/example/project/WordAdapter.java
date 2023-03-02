package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
     ArrayList<Word> mWordList;

    public WordAdapter(ArrayList<Word> mWordList) {
        this.mWordList=mWordList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.wordTv.setText(mWordList.get(position).getJpWord());
        holder.huriganaTv.setText(mWordList.get(position).getHurigana());
        holder.meanTv.setText(mWordList.get(position).getMean());

            holder.wordTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(holder.wordTv.getContext(),OneSeeActivity.class);
                    intent.putExtra("jpWord", mWordList.get(position).getJpWord());
                    intent.putExtra("hurigana", mWordList.get(position).getHurigana());
                    intent.putExtra("mean", mWordList.get(position).getMean());

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    holder.wordTv.getContext().startActivity(intent);
                }
            });

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView wordTv;
        TextView huriganaTv;
        TextView meanTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wordTv = itemView.findViewById(R.id.word_tv);
            huriganaTv = itemView.findViewById(R.id.hurigana_tv);
            meanTv = itemView.findViewById(R.id.mean_tv);
        }
    }
}