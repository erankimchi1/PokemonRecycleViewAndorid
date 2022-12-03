package com.example.pokemon_project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    private ArrayList<DataModel> dataSet;
    View publicView;

    public CustomAdapter(ArrayList<DataModel> dataSet) {

        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
       CardView cardView;
       TextView textViewName;
       TextView textViewVersion;
       TextView textViewID;
        ImageView imageViewIcon;

       public MyViewHolder (View itemView )
       {
           super(itemView);

           cardView = (CardView) itemView.findViewById(R.id.card_view);
           textViewName = ( TextView) itemView.findViewById(R.id.textViewName);
           textViewVersion = ( TextView) itemView.findViewById(R.id.textViewVersion);
           textViewID = (TextView) itemView.findViewById(R.id.textViewID);
           imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
       }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.cards_layout , parent ,false);
        publicView = view;
        CardView cardView = view.findViewById(R.id.card_view);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                TextView name = view.findViewById(R.id.textViewName);
                TextView description = view.findViewById(R.id.textViewVersion);
                TextView ID = view.findViewById(R.id.textViewID);
                String imgName = name.getText().toString().toLowerCase().split(" ")[0];
                System.out.println(name.getText().toString());
                System.out.println(description.getText().toString());
                bundle.putString("name",name.getText().toString());
                bundle.putString("fullDescription", dataSet.get(Integer.parseInt(ID.getText().toString())).getFullDescription());
                System.out.println(dataSet.get(Integer.parseInt(ID.getText().toString())).getId());
                bundle.putString("image", imgName);
                Navigation.findNavController(view).navigate(R.id.action_main_characters_to_character_details, bundle);
            }
        });

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, @SuppressLint("RecyclerView") int listPosition) {
        TextView textViewName = viewHolder.textViewName;
        TextView textViewVersion = viewHolder.textViewVersion;
        TextView ID = viewHolder.textViewID;
        ImageView imageView = viewHolder.imageViewIcon;
        CardView cardView = viewHolder.cardView;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
        //System.out.println(dataSet.get(listPosition).getId());
        int currentID = dataSet.get(listPosition).getId();
        ID.setText((currentID)+"");

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}


