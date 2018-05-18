package com.example.android.newsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {
    /** Attributs privés */
    // @SerializedName indique que cet attribut doit être (dé)sérialisé par JSON avec la String
    // spécifiée
    // @Expose indique que cet attribut doit être exposé pour la (dé)sérialisation JSON
    @SerializedName("id")
    @Expose
    private Object mId;

    @SerializedName("name")
    @Expose
    private String mName;

    /** Constructeurs */
    public Source() { }

    public Source(Object mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    /** Accesseurs et mutateurs */
    public Object getmId() {
        return mId;
    }

    public void setmId(Object mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
