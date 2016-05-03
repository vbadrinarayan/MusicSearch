package com.music.app.inter;

import com.music.app.model.UISearchResultList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Badri on 03/05/16.
 */
public interface SearchInterface {

    @GET("/search")
    void searchTracks(@Query("term") String term,
                      Callback<UISearchResultList> callback);
}
