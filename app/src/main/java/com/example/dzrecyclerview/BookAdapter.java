package com.example.dzrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {

    List<BookModel> list = new ArrayList<>();

    public BookAdapter(List<BookModel> list) {
        this.list = list;
    }
    public void addTask(BookModel model){
        list.add(model);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public BookAdapter.BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_holder,parent,false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BookHolder holder, int position) {
        holder.txtTitle.setText(list.get(position).getTitle());
        holder.txtDescription.setText(list.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class BookHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDescription;
        public BookHolder(@NonNull View itemView){
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDescription = itemView.findViewById(R.id.txt_description);
        }
    }
}
