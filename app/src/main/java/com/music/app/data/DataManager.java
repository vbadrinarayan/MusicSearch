package com.music.app.data;

import android.app.Application;

import com.music.app.inter.ResponseListener;
import com.music.app.model.UISearchResultList;
import com.music.app.servicemanager.webrequest.Manager;

/**
 * DataManager.
 */
public class DataManager {

    public static void getMusicSearchResults(Application context
            , String searchText, ResponseListener<UISearchResultList> listener){
        Manager.getSearchResults(context, searchText, listener);
        System.out.println("DataManager::::coming here");
    }
}
