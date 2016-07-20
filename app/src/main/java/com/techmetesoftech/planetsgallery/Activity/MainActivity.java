package com.techmetesoftech.planetsgallery.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.techmetesoftech.planetsgallery.Util;
import com.techmetesoftech.planetsgallery.adapter.PlanetsGridViewImageAdapter;
import com.techmetesoftech.planetsgallery.pojo.PlanetsImageContainer;
import com.techmetesoftech.plantsdetails.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Planets Gallery");

        // open json file
        String planetsImageList = Util.loadJson(this, "planets_images_list");
        Gson gson = new Gson();
        final PlanetsImageContainer pimageContainer = (PlanetsImageContainer) gson.fromJson(planetsImageList, PlanetsImageContainer.class);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new PlanetsGridViewImageAdapter(this, pimageContainer.getPlanetsImageList()));

        // Listening to GridView item click
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // Launch PlanetsViewImage.java on selecting GridView Item
                Intent i = new Intent(getApplicationContext(), PlanetsViewImage.class);

                // Show a simple toast message for the item position
        Toast.makeText(getApplicationContext(), "" + (position+1), Toast.LENGTH_SHORT).show();

                // Send the click position to PlanetsViewImage.java using intent
                i.putExtra("id", position);

                // Start PlanetsViewImage
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "settings", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
