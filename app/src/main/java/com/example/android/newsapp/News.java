package com.example.android.newsapp;

public class News {
    /** Attributs privés */
    private String mSourceName;
    private String mTitle;
    private String mDescription;
    private String mURL;
    private String mURLToImage;
    private String mPublishedAt;

    /** Constructeurs */
    public News() {
    }

    public News(
            String mSourceName,
            String mTitle,
            String mDescription,
            String mURL,
            String mURLToImage,
            String mPublishedAt) {
        this.mSourceName = mSourceName;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mURL = mURL;
        this.mURLToImage = mURLToImage;
        this.mPublishedAt = mPublishedAt;
    }

    /** Accesseurs */
    public String getmSourceName() {
        return mSourceName;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmURL() {
        return mURL;
    }

    public String getmURLToImage() {
        return mURLToImage;
    }

    public String getmPublishedAt() {
        return mPublishedAt;
    }
}
