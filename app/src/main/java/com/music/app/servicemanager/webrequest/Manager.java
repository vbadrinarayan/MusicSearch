package com.music.app.servicemanager.webrequest;

import android.app.Application;
import android.util.Log;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

import com.music.app.inter.ResponseListener;
import com.music.app.inter.SearchInterface;
import com.music.app.model.UISearchResultList;
import com.music.app.utility.Constants;

/**
 * Manager.
 */
public class Manager {

    private static final String TAG = Manager.class.getSimpleName();

    public static void getSearchResults(final Application context, final String searchText
            , final ResponseListener<UISearchResultList> listener) {

        /*
         * Here the conversion from teh service model to UI model has to happen and UI model
         * has to be returned. Due to tiome constraints the service model is being returned.
         */

        final String targetUrl = Constants.URL_MUSIC_SEARCH;
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(targetUrl).build();
        SearchInterface inter = restAdapter.create(SearchInterface.class);

        inter.searchTracks(searchText, new Callback<UISearchResultList>() {
            @Override
            public void success(UISearchResultList searchResp, retrofit.client.Response response) {
                if (searchResp != null) {
                    Log.i(TAG, "Count is:::"+searchResp.getResults().size());
                    listener.onSuccess(searchResp);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                String msg = error.getMessage();
                listener.onFailure(new Throwable(), msg);
            }
        });


    }

}
