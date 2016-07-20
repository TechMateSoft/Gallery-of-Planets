package com.techmetesoftech.planetsgallery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.app.Activity;

import com.techmetesoftech.planetsgallery.pojo.PlanetsImages;

import java.util.ArrayList;

/**
 * Created by techmatesofttech on 10/6/16.
 */
public class PlanetsGridViewImageAdapter extends BaseAdapter {

    private ArrayList<PlanetsImages> planets_image_list;
    private LayoutInflater layoutInflater;
    private final Activity context;

    public PlanetsGridViewImageAdapter(Activity context, ArrayList<PlanetsImages> list){
        this.context = context;
        this.planets_image_list = new ArrayList<PlanetsImages>();
        this.planets_image_list.addAll(list);
        layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // To know number of elements in list
    public int getCount() {
        return  planets_image_list.size();
    }

    // To know position of particular Item in list
    public Object getItem(int position) {
        return this.planets_image_list.get(position);
    }

    // TO know an Id of Particular Item
    public long getItemId(int position) {
        return 0;
    }

    // To know an Id of Image
    public Integer getImageId(int position) {
        PlanetsImages planetsImages = (PlanetsImages) this.planets_image_list.get(position);
        String image = planetsImages.getImg();
        Integer id = this.context.getResources().getIdentifier(image, "mipmap", this.context.getPackageName());
        return id;
    }

    // Create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        PlanetsImages planetsImages = (PlanetsImages) this.planets_image_list.get(position);
        String image = planetsImages.getImg();

        ImageView imageView;
        if (convertView == null) {
            // If it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(200,200);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        Integer id = this.context.getResources().getIdentifier(image, "mipmap", this.context.getPackageName());
        imageView.setImageResource(id);
        return imageView;
    }
}
