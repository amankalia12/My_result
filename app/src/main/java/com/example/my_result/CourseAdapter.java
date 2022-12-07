package com.example.my_result;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_result.Model.Result;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private List<Result> number;


  public CourseAdapter(){

  }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.designe_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
       Result  result= number.get(i);
        holder.courseNameTV.setText(result.getName());
        holder.courseRatingTV.setText(result.getNumber());
        holder.courseIV.setText(result.getDate());
    }

    @Override
    public int getItemCount() {
        return number.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseIV;
        private final TextView courseNameTV;
        private final TextView courseRatingTV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseIV = itemView.findViewById(R.id.time);
            courseNameTV = itemView.findViewById(R.id.name);
            courseRatingTV = itemView.findViewById(R.id.number);
        }
    }

    public void setjoblist(List<Result> numbers){
        this.number=numbers;
        notifyDataSetChanged();
    }

}
