package com.example.android.newsapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/** Voir FragmentBusiness pour commentaire des actions réalisées */

public class FragmentSport extends Fragment {
    private List<News> mNews = new ArrayList<>();

    public FragmentSport() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNews.add(new News(
                "Footmercato.net",
                "Equipe de France : Didier Deschamps explique comment il a choisi " +
                        "ses 23 pour le Mondial 2018",
                "Jeudi soir, Didier Deschamps fera 23 heureux mais aussi beaucoup de " +
                        "déçus au moment d’annoncer la liste des joueurs qui l’accompagneront " +
                        "au Mondial en Russie. Sur le site de la FFF, le sélectionneur national" +
                        " a expliqué comment il avait tranché au (...)",
                "\"http://www.footmercato.net/coupe-du-monde/russie-2018/equipe-de-" +
                        "france-didier-deschamps-explique-comment-il-a-choisi-ses-23-" +
                        "pour-le-mondial-2018_226890",
                "\"http://www.footmercato.net/images/a/deschamps-livre-les-" +
                        "secrets-de-la-preparation-de-la-liste-des-23_226890.jpg",
                "2018-05-15T14:08:27Z"
        ));
        mNews.add(new News(
                "Foot01.com",
                "OM : Mitroglou finalement présent contre l'Atlético ?",
                "Très incertain il y a encore quelques jours, Kostas Mitroglou " +
                        "pourrait finalement être opérationnel pour la finale de l’Europa " +
                        "League entre l’Olympique de Marseille et l’Atlético Madrid. Selon " +
                        "les informations...",
                "\"https://www.foot01.com/equipe/marseille/om-mitroglou-finalement-" +
                        "present-contre-l-atletico,284947",
                "https://www.foot01.com/img/images/650x600/2018/May/15/" +
                        "om-mitroglou-finalement-present-contre-l-atletico-icon_dim_" +
                        "260418_10_51,218955.jpg",
                "2018-05-15T13:40:00Z"
        ));
        mNews.add(new News(
                "Ouest-france.fr",
                "Polémique en Allemagne après les photos d'Özil et Gündogan avec Erdogan",
                "Deux joueurs de football de la Mannschaft, Mesut Ösil et " +
                        "Ilkay Gündogan, ont posé avec le président turc pour le soutenir" +
                        " dans le cadre de la campagne électorale. La fédération allemande" +
                        " de football a réagi en estimant que des joueurs de l’équipe " +
                        "nationale ne…",
                "https://www.ouest-france.fr/sport/football/polemique-en-" +
                        "allemagne-apres-les-photos-d-ozil-et-gundogan-avec-erdogan-5760173",
                "https://media.ouest-france.fr/v1/pictures/320138fe91575993e" +
                        "9ac732a51696671-polemique-en-allemagne-apres-les-photos-d-ozil-e" +
                        "t-gundogan-avec-erdogan.jpg?focuspoint=43,42&height=630&width=" +
                        "1200&cropresize=1&fill=0",
                "2018-05-15T13:07:50Z"
        ));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View sportView =
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

        return sportView;
    }
}
