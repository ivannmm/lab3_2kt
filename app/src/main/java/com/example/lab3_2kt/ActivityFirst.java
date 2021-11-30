package com.example.lab3_2kt;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityFirst extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        Button button = (Button) findViewById(R.id.bnToSecond);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityFirst.this, ActivitySecond.class);
            startActivity(intent);
        });
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(ActivityFirst.this, ActivityAbout.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
