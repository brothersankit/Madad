package com.example.madad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    private List<Model1> model1List;

   private Context context;

    public myadapter(List<Model1> model1List, Context context) {
        this.model1List = model1List;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder( @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.eachpost,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myadapter.myviewholder holder, int position) {
        Model1 modelxy= model1List.get(position);
        holder.textView.setText(modelxy.getName());

        Glide.with(context).load(modelxy.url).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return model1List.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView textView;

        public myviewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.picture);
            textView=(TextView)itemView.findViewById(R.id.username);

        }
    }
}
