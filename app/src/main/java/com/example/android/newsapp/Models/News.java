package com.example.android.newsapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    /** Attributs privés */
    // @SerializedName indique que cet attribut doit être (dé)sérialisé par JSON avec la String
    // spécifiée
    // @Expose indique que cet attribut doit être exposé pour la (dé)sérialisation JSON
    @SerializedName("status")
    @Expose
    private String mStatus;

    @SerializedName("totalResults")
    @Expose
    private Integer mTotalResults;

    @SerializedName("articles")
    @Expose
    private List<Article> mArticles = null;

    /** Constructeurs */
    public News() { }

    public News(String mStatus, Integer mTotalResults, List<Article> mArticles) {
        this.mStatus = mStatus;
        this.mTotalResults = mTotalResults;
        this.mArticles = mArticles;
    }

    /** Accesseurs et mutateurs */
    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public Integer getmTotalResults() {
        return mTotalResults;
    }

    public void setmTotalResults(Integer mTotalResults) {
        this.mTotalResults = mTotalResults;
    }

    public List<Article> getmArticles() {
        return mArticles;
    }

    public void setmArticles(List<Article> mArticles) {
        this.mArticles = mArticles;
    }
}
