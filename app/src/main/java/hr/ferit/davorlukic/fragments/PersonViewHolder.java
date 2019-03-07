package hr.ferit.davorlukic.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private TextView tvDescription;
    private TextView tvTitle;
    private ImageView ivPicture;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        tvDescription = itemView.findViewById(R.id.tvDescription);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        ivPicture = itemView.findViewById((R.id.ivPicture));
    }

    public void setDescription(String description){
        tvDescription.setText(description);
    }

    public void setTitle(String title){
        tvTitle.setText(title);
    }

    public void setPicture(Integer imageID) {
        ivPicture.setImageResource(imageID);
    }
}
