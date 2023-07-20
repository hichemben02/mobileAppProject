package com.example.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.FavoritesActivity;
import com.example.project.R;
import com.example.project.models.Story;

import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.StoryViewHolder>{

    private List<Story> storiesList;
    private OnItemClickListener onItemClickListener;

    private int status = 0;

    public StoriesAdapter(List<Story> storiesList, OnItemClickListener onItemClickListener) {
        this.storiesList = storiesList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public StoriesAdapter.StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesAdapter.StoryViewHolder holder, int position) {
        Story story = storiesList.get(position);
        boolean isFavorite = story.isFavorite();

        holder.titleTextView.setText(story.getTitle());
        holder.imageView.setImageResource(story.getImage());
        holder.descriptionTextView.setText(story.getDescription());

        if (isFavorite){
            holder.addbutton.setVisibility(View.GONE);
            holder.removebutton.setVisibility(View.VISIBLE);
        } else {
            holder.addbutton.setVisibility(View.VISIBLE);
            holder.removebutton.setVisibility(View.GONE);
        }

        holder.addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = holder.addbutton.getContext();
                FavoritesActivity.addToFavorites(context, story);
                story.setFavorite(true);

                holder.addbutton.setVisibility(View.GONE);
                holder.removebutton.setVisibility(View.VISIBLE);

                Toast.makeText(holder.itemView.getContext(), "Added to favorites", Toast.LENGTH_SHORT).show();
            }
        });

        holder.removebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoritesActivity.removeFromFavorites(story);
                story.setFavorite(false);

                holder.addbutton.setVisibility(View.VISIBLE);
                holder.removebutton.setVisibility(View.GONE);

                Toast.makeText(holder.itemView.getContext(), "Removed from favorites", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return storiesList.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder{
        public TextView titleTextView;
        public TextView descriptionTextView;
        public ImageView imageView;
        public Button addbutton, removebutton;
        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_story);
            descriptionTextView = itemView.findViewById(R.id.description_story);
            imageView = itemView.findViewById(R.id.img_story);
            addbutton = itemView.findViewById(R.id.btn_add_fav);
            removebutton = itemView.findViewById(R.id.btn_remove_fav);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
