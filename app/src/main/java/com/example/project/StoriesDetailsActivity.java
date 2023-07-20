package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.project.adapters.ScenesAdapter;
import com.example.project.models.Scene;
import com.example.project.models.Story;

import java.util.List;

public class StoriesDetailsActivity extends AppCompatActivity {

    RecyclerView recyclerViewScenes;
    List<Scene> scenesList;
    ScenesAdapter scenesAdapter;
    Story story;
    int status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_details);

        // slectioner histoire a partir de intent
        story = (Story) getIntent().getSerializableExtra("story");
        setTitle(story.getTitle());

        // initialiser recyclerView
        recyclerViewScenes = findViewById(R.id.recycler_view_scenes);
        recyclerViewScenes.setLayoutManager(new LinearLayoutManager(this));

        scenesList = story.getScenesList();
        scenesAdapter = new ScenesAdapter(scenesList);
        recyclerViewScenes.setAdapter(scenesAdapter);
    }

    // le travail sur le menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.share){
            shareEvent();
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareEvent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        Intent chooser = Intent.createChooser(intent, "share");
        startActivity(chooser);
    }
}