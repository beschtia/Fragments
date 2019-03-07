package hr.ferit.davorlukic.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class ModularFragment extends Fragment {

    private static final String BUNDLE_IMAGE = "showImage";

    private ImageView mImageView;
    private RecyclerView recycler;
    private RecyclerAdapter adapter;

    public static ModularFragment newInstance(boolean showImage) {
        ModularFragment fragment = new ModularFragment();
        Bundle args = new Bundle();
        args.putBoolean(BUNDLE_IMAGE, showImage);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_modular,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recyclerView);
        mImageView = view.findViewById(R.id.ivModImage);
        setUp();

    }

    private void setUp() {
        if(getArguments().getBoolean(BUNDLE_IMAGE)){
            setUpImageView();
        } else  {
            setUpRecyclerView();
        }
    }

    private void setUpImageView() {
        this.mImageView.setVisibility(View.VISIBLE);
        this.recycler.setVisibility(View.GONE);
    }

    private void setUpRecyclerView() {
        this.mImageView.setVisibility(View.GONE);
        this.recycler.setVisibility(View.VISIBLE);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter();
        recycler.setAdapter(adapter);
        setupRecyclerData();
        setupRecyclerTitle();
        setupRecyclerPicture();
    }

    private void setupRecyclerPicture() {
        List<Integer> data = new ArrayList<>();
        data.add(R.drawable.nietzsche);
        data.add(R.drawable.bruce);
        data.add(R.drawable.tesla);
        data.add(R.drawable.einstein);
        data.add(R.drawable.mao);
        adapter.addPicture(data);
    }

    private void setupRecyclerTitle() {
        List<String> data = new ArrayList<>();
        data.add(getText(R.string.tv_nameNietzsche).toString());
        data.add(getText(R.string.tv_nameBruce).toString());
        data.add(getText(R.string.tv_nameTesla).toString());
        data.add(getText(R.string.tv_nameEinstein).toString());
        data.add(getText(R.string.tv_nameMao).toString());
        adapter.addTitle(data);
    }

    private void setupRecyclerData() {
        List<String> data = new ArrayList<>();
        data.add(getText(R.string.tv_descriptionNietzsche).toString());
        data.add(getText(R.string.tv_descriptionBruce).toString());
        data.add(getText(R.string.tv_descriptionTesla).toString());
        data.add(getText(R.string.tv_descriptionEinstein).toString());
        data.add(getText(R.string.tv_descriptionMao).toString());
        adapter.addData(data);
    }

}
