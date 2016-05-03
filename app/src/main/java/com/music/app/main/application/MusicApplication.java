package com.music.app.main.application;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Badri on 03/05/16.
 */
public class MusicApplication extends Application {

    // The request queue.
    private RequestQueue mRequestQueue;

    private static final String TAG = MusicApplication.class.getSimpleName();

    /**
     * Gets the request queue.
     *
     * @return Returns the RequestQueue object.
     */
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request, String tag) {
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(request);
    }
}
