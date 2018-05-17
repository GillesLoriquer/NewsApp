package com.example.android.newsapp.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.newsapp.Models.News;

import java.util.ArrayList;
import java.util.List;

/** Voir FragmentBusiness pour commentaire des actions réalisées */

public class FragmentSport extends Fragment {
    private List<News> mNews = new ArrayList<>();

    public FragmentSport() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*View sportView =
                inflater.inflate(R.layout.fragment_sport, container, false);

        RecyclerView recyclerView = sportView.findViewById(R.id.sport_recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        NewsAdapter newsAdapter = new NewsAdapter(getContext(), mNews);

        newsAdapter.setOnClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(
                        getContext(),
                        mNews.get(position).getmTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(newsAdapter);

        return sportView;*/
        return null;
    }
}
