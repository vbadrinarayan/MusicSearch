package com.music.app.servicemanager.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * SearchMusicResultList.
 */
public class SearchMusicResultList {

    @SerializedName("resultCount")
    private int resultCount;

    @SerializedName("results")
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
