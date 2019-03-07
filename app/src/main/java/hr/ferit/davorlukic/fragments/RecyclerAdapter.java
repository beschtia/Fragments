package hr.ferit.davorlukic.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private List<String> dataList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private List<Integer> pictureList = new ArrayList<>();

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View cellView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_person, viewGroup, false);
        return new PersonViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int position) {
        personViewHolder.setDescription(dataList.get(position));
        personViewHolder.setTitle(titleList.get(position));
        personViewHolder.setPicture(pictureList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(List<String> data){
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }

    public void addTitle(List<String> data){
        this.titleList.clear();
        this.titleList.addAll(data);
        notifyDataSetChanged();
    }

    public void addPicture(List<Integer> data) {
        this.pictureList.clear();
        this.pictureList.addAll(data);
        notifyDataSetChanged();
    }
}
