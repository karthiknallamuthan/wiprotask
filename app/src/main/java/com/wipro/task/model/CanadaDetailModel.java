package com.wipro.task.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;
import com.wipro.task.R;
import com.wipro.task.application.MyApplication;

public class CanadaDetailModel {
    private static final String TAG = "CanadaDetailModel";
    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("imageHref")
    private String imageRef;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageRef() {
        return imageRef;
    }

    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }

    @BindingAdapter({ "profileImage" })
    public static void loadImage(ImageView imageView, String imageURL) {
        Glide.with(MyApplication.getContext())
                .load(imageURL)
                .placeholder(R.drawable.loading) //placeholder
                .error(R.drawable.loading) //error
                .into(imageView);

    }

}
