package com.example.android.newsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {
    /** Attributs privés */
    // @SerializedName indique que cet attribut doit être (dé)sérialisé par JSON avec la String
    // spécifiée
    // @Expose indique que cet attribut doit être exposé pour la (dé)sérialisation JSON
    @SerializedName("source")
    @Expose
    private Source mSource;

    @SerializedName("author")
    @Expose
    private String mAuthor;

    @SerializedName("title")
    @Expose
    private String mTitle;

    @SerializedName("description")
    @Expose
    private String mDescription;

    @SerializedName("url")
    @Expose
    private String mUrl;

    @SerializedName("urlToImage")
    @Expose
    private String mUrlToImage;

    @SerializedName("publishedAt")
    @Expose
    private String mPublishedAt;

    /** Constructeurs */
    public Article() { }

    public Article(Source mSource, String mAuthor, String mTitle, String mDescription, String mUrl, String mUrlToImage, String mPublishedAt) {
        this.mSource = mSource;
        this.mAuthor = mAuthor;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mUrl = mUrl;
        this.mUrlToImage = mUrlToImage;
        this.mPublishedAt = mPublishedAt;
    }

    /** Accesseurs et mutateurs */
    public Source getmSource() {
        return mSource;
    }

    public void setmSource(Source mSource) {
        this.mSource = mSource;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmUrlToImage() {
        return mUrlToImage;
    }

    public void setmUrlToImage(String mUrlToImage) {
        this.mUrlToImage = mUrlToImage;
    }

    public String getmPublishedAt() {
        return mPublishedAt;
    }

    public void setmPublishedAt(String mPublishedAt) {
        this.mPublishedAt = mPublishedAt;
    }
}
