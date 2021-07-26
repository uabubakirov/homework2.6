package com.example.homework26;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    List<TaskModel> list;
    Context context;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_task_fragment,parent,false);
        return new RecyclerViewHolder(view);

    }
    public void addTask(TaskModel taskModel){
        this.list.add(taskModel);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder( RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.txtTitle.setText(list.get(position).getTitle());
        holder.txtDescription.setText(list.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle,txtDescription;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            itemView = txtTitle.findViewById(R.id.txt_title);
            itemView = txtDescription.findViewById(R.id.txt_description);
        }
    }
}
