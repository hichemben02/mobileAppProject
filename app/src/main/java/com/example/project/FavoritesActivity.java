package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.adapters.StoriesAdapter;
import com.example.project.models.Story;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FavoritesActivity extends AppCompatActivity{

    RecyclerView recyclerViewavorite;
    static StoriesAdapter storiesAdapter;
    static List<Story> favoritesList = new ArrayList<>();
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String FAVORITES_SET_KEY = "favorite_stories_set";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        getSupportActionBar().setTitle("Favorites");

        recyclerViewavorite = findViewById(R.id.recycler_view_favorites);
        prepareRecyclerview();

        TextView nofavorites = findViewById(R.id.textView);
        if (favoritesList.isEmpty()){
            nofavorites.setVisibility(View.VISIBLE);
            nofavorites.setText("No favorite story added !!");
        }
        else {
            nofavorites.setVisibility(View.GONE);
        }
    }

    private void prepareRecyclerview() {
        recyclerViewavorite.setLayoutManager(new LinearLayoutManager(this));
        storiesAdapter = new StoriesAdapter(favoritesList, new StoriesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(FavoritesActivity.this, StoriesDetailsActivity.class);
                intent.putExtra("story", favoritesList.get(position));
                startActivity(intent);
            }
        });
        recyclerViewavorite.setAdapter(storiesAdapter);
    }

    public static void addToFavorites(Context context, Story story){
        if (favoritesList.contains(story)) {
            Toast.makeText(context, "Story already in favorites list", Toast.LENGTH_SHORT).show();
            return;
        }
        story.setFavorite(true);
        favoritesList.add(story);
        if (storiesAdapter != null) {
            storiesAdapter.notifyDataSetChanged();
        }
    }

    public static void removeFromFavorites( Story story){
        story.setFavorite(false);
        favoritesList.remove(story);
        if (storiesAdapter != null) {
            storiesAdapter.notifyDataSetChanged();
        }
    }
}