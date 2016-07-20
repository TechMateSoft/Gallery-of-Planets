package com.techmetesoftech.planetsgallery.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.app.Activity;
import com.google.gson.Gson;
import com.techmetesoftech.planetsgallery.Util;
import com.techmetesoftech.planetsgallery.adapter.PlanetsGridViewImageAdapter;
import com.techmetesoftech.planetsgallery.adapter.PlanetsImageViewAdapter;
import com.techmetesoftech.planetsgallery.pojo.PlanetsImageContainer;
import com.techmetesoftech.plantsdetails.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by techmatesofttech on 10/6/16.
 */
public class PlanetsViewImage extends Activity {
    // Declare Variable
    int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set title for the ViewPager
        setTitle("ViewPager");

        // Get the view from activity_view_img.xmlimg.xml
            setContentView(R.layout.activity_planets_view_img);

        // Retrieve data from MainActivity on item click event
        Intent p = getIntent();
        position = p.getExtras().getInt("id");

        String planetsImageList = Util.loadJson(this, "planets_images_list");
        Gson gson = new Gson();
        final PlanetsImageContainer timageContainer = (PlanetsImageContainer) gson.fromJson(planetsImageList, PlanetsImageContainer.class);

        PlanetsGridViewImageAdapter planetsGridViewImageAdapter = new PlanetsGridViewImageAdapter(this, timageContainer.getPlanetsImageList());
        List<ImageView> images = new ArrayList<ImageView>();

        // Retrieve all the images
        for (int i = 0; i < planetsGridViewImageAdapter.getCount(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(planetsGridViewImageAdapter.getImageId(i));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            images.add(imageView);
        }

        // Set the images into ViewPager
        PlanetsImageViewAdapter pageradapter = new PlanetsImageViewAdapter(images);
        ViewPager viewpager = (ViewPager) findViewById(R.id.pager);
        viewpager.setAdapter(pageradapter);
        // Show images following the position
        viewpager.setCurrentItem(position);
    }
}
