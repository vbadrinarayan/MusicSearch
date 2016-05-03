package com.music.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * UISearchResult.
 */
public class UISearchResult implements Parcelable {

    private String artistName;

    private String trackName;

    private String previewUrl;

    private String artworkUrl30;

    private String artworkUrl60;

    private String artworkUrl100;

    private Double collectionPrice;

    private Double trackPrice;

    private String releaseDate;

    private Integer trackTimeMillis;

    private String currency;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public Double getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(Double collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public Double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(Double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(Integer trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.artistName);
        dest.writeString(this.trackName);
        dest.writeString(this.previewUrl);
        dest.writeString(this.artworkUrl30);
        dest.writeString(this.artworkUrl60);
        dest.writeString(this.artworkUrl100);
        dest.writeValue(this.collectionPrice);
        dest.writeValue(this.trackPrice);
        dest.writeString(this.releaseDate);
        dest.writeValue(this.trackTimeMillis);
        dest.writeString(this.currency);
    }

    public UISearchResult() {
    }

    protected UISearchResult(Parcel in) {
        this.artistName = in.readString();
        this.trackName = in.readString();
        this.previewUrl = in.readString();
        this.artworkUrl30 = in.readString();
        this.artworkUrl60 = in.readString();
        this.artworkUrl100 = in.readString();
        this.collectionPrice = (Double) in.readValue(Double.class.getClassLoader());
        this.trackPrice = (Double) in.readValue(Double.class.getClassLoader());
        this.releaseDate = in.readString();
        this.trackTimeMillis = (Integer) in.readValue(Integer.class.getClassLoader());
        this.currency = in.readString();
    }

    public static final Creator<UISearchResult> CREATOR = new Creator<UISearchResult>() {
        @Override
        public UISearchResult createFromParcel(Parcel source) {
            return new UISearchResult(source);
        }

        @Override
        public UISearchResult[] newArray(int size) {
            return new UISearchResult[size];
        }
    };
}