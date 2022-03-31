package com.sr.myappjan.material;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.sr.myappjan.R;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class CustomAdapterRecycler extends RecyclerView.Adapter<CustomAdapterRecycler.MyViewHolder>
{

    ArrayList<String> personName;
    ArrayList<Integer> personImage;
    Context context;

    public CustomAdapterRecycler(Context context, ArrayList<String> personName, ArrayList<Integer> personImage)
    {
        this.context = context;
        this.personName = personName;
        this.personImage = personImage;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayoutrecycler, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position)
    {
        holder.name.setText(personName.get(position));
        holder.image.setImageResource(personImage.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(context, SecondActivityRecycler.class);
                intent.putExtra("Image",personImage.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return personName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        ImageView image;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
