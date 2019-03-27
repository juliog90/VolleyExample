package com.juliodev.volley;

import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Image {
    //getI Image from URL
    public static Drawable fromUrl(String url) {
        //Define Object
        Drawable d = null;
        //
        try {
            InputStream data = (InputStream) new URL(url).getContent();
            d = Drawable.createFromStream(data, "");
        } catch (MalformedURLException e) {
            Log.e("Error", e.getMessage());
        } catch (IOException e) {
            Log.e("Error", e.getMessage());
        }
        //return Drawable object
        return d;
    }
}
