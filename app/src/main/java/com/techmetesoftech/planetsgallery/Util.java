package com.techmetesoftech.planetsgallery;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by techmatesofttech on 10/6/16.
 */
public class Util {

    //This function use to open any file
    public static String loadJson(Context self, String name) {
        String json = null;
        try {
            //.json is a extension of file
            InputStream is = self.getAssets().open(name + ".json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}
