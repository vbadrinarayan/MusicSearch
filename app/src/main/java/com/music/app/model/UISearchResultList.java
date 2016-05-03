package com.music.app.model;

import com.google.gson.annotations.SerializedName;
import com.music.app.servicemanager.model.SearchMusicResult;

import java.util.List;

/**
 * UISearchResultList.
 */
public class UISearchResultList {

    private int resultCount;

    private List<SearchMusicResult> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<SearchMusicResult> getResults() {
        return results;
    }

    public void setResults(List<SearchMusicResult> results) {
        this.results = results;
    }

}
