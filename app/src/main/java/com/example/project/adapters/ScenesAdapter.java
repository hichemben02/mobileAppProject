package com.example.project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.models.Scene;

import java.util.ArrayList;
import java.util.List;

public class ScenesAdapter extends RecyclerView.Adapter<ScenesAdapter.SceneViewHolder> {

    public List<Scene> scenesList = new ArrayList<>();

    public ScenesAdapter(List<Scene> scenesList) {
        this.scenesList = scenesList;
    }

    @NonNull
    @Override
    public ScenesAdapter.SceneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scene, parent, false);
        return new SceneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScenesAdapter.SceneViewHolder holder, int position) {
        Scene scene = scenesList.get(position);
        holder.textView.setText(scene.getText());
        holder.imageView.setImageResource(scene.getImage());
        //holder.titleTextView.setText(scene.getTitle());
    }

    @Override
    public int getItemCount() {
        return scenesList.size();
    }

    public class SceneViewHolder extends RecyclerView.ViewHolder{
        //public TextView titleTextView;
        public ImageView imageView;
        public TextView textView;

        public SceneViewHolder(@NonNull View itemView) {
            super(itemView);
            //titleTextView = itemView.findViewById(R.id.title_scene);
            imageView = itemView.findViewById(R.id.img_scene);
            textView = itemView.findViewById(R.id.text_scene);
        }
    }
}
