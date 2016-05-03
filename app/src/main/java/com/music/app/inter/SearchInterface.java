package com.music.app.inter;

import com.music.app.model.UISearchResultList;
import com.music.app.servicemanager.model.LyricsResult;

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

    @GET("/api.php?action=lyrics&fmt=json")
    void searchTracks(@Query("artist") String artist,@Query("song") String trackName,
                      Callback<LyricsResult> callback);
}
