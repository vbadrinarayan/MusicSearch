package com.music.app.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.music.app.servicemanager.model.SearchMusicResult;

import java.util.ArrayList;
import java.util.List;

/**
 * UISearchResultList.
 */
@Generated("org.jsonschema2pojo")
public class UISearchResultList {

    @SerializedName("resultCount")
    @Expose
    private Integer resultCount;

    @SerializedName("results")
    @Expose
    private List<SearchMusicResult> results = new ArrayList<SearchMusicResult>();

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<SearchMusicResult> getResults() {
        return results;
    }

    public void setResults(List<SearchMusicResult> results) {
        this.results = results;
    }

}
