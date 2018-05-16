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


public class FragmentBusiness extends Fragment {
    /** Attributs privés */
    // Liste qui va contenir les news à afficher
    private List<News> mNews = new ArrayList<>();

    /** Constructeurs */
    // Constructeur publique vide requi
    public FragmentBusiness() { }

    /** Methodes */
    // Cette méthode est réalise la création initiale du fragment
    // Elle est appelée avant onCreateView dans le cycle de vie du fragment
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNews.add(new News(
                "Lexpress.fr",
                "La croissance devrait atteindre 0,3% au 2e trimestre",
                "Un taux identique à celui du 1er trimestre, selon " +
                        "la première estimation de la Banque de France.",
                "https://lexpansion.lexpress.fr/actualite-economique/la-croissance-" +
                        "devrait-atteindre-0-3-au-2e-trimestre_2008249.html",
                "https://static.lexpress.fr/medias_10954/w_1820,h_1365,c_crop," +
                        "x_106,y_0/w_605,h_350,c_fill,g_north/v1470648616/la-croissance-ne-" +
                        "devrait-augmenter-que-de-facon-tres-lente-au-cours-des-trois-" +
                        "prochaines-annees-en-france-selon-les-previsions-pluriannuelles-" +
                        "de-la-banque-de-france_5608719.jpg",
                "2018-05-14T08:35:00Z"
        ));
        mNews.add(new News(
                "Les Echos",
                "Les grèves pèsent sur le trafic passagers du tunnel sous la Manche",
                "Getlink, ex-Groupe Eurotunnel, pâtit notamment d'un « contexte " +
                        "général en France ayant un impact fortement négatif sur " +
                        "l'attractivité touristique du pays ».",
                "https://www.lesechos.fr/industrie-services/tourisme-transport/" +
                        "0301673723889-les-greves-pesent-sur-le-trafic-passagers-du-tunnel-" +
                        "sous-la-manche-2175637.php\"",
                "https://www.lesechos.fr/medias/2018/05/14/2175637_les-greves-" +
                        "pesent-sur-le-trafic-passagers-du-tunnel-sous-la-manche-web-" +
                        "0301674000377.jpg",
                "2018-05-14T08:31:00Z"
        ));
        mNews.add(new News(
                "20minutes.fr",
                "Grève à la SNCF EN DIRECT : Une journée «très difficile» avec un " +
                        "train sur deux sur les lignes A et B du RER...",
                "Suivez en direct cette nouvelle journée de grève à la SNCF...",
                "https://www.20minutes.fr/societe/2270359-20180514-greve-sncf-" +
                        "direct-trafic-tres-perturbe-1-tgv-ter-transilien-3",
                "https://img.20mn.fr/F9vzyUb8Skm1cYBfCIJ16Q/648x360_gare-nord-" +
                        "quasi-vide-lors-journee-greve-24-avril-2018",
                "2018-05-14T08:30:03Z"
        ));
    }

    // Cette méthode retourne la vue relative au fragment business
    // Elle crée également un NewsAdapter qu'elle attache à la RecyclerView présente dans ce
    // même fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // On récupère une vue gonflée du layout relative au fragment_business
        View businessView =
                inflater.inflate(R.layout.fragment_business, container, false);

        // A partir de cette vue on peut également récupérer la RecyclerView
        RecyclerView recyclerView = businessView.findViewById(R.id.business_recyclerview);

        // Sur cette RecyclerView on y attache un LayoutManger. Le LayoutManager est responsable
        // du comptage et du positionnement des vues de chaque news dans le RecyclerView. Il
        // s'occupe également du recyclage des vues de news qui ne sont plus visible par
        // l'utilisateur
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // On créer ici un NewsAdapter en y passant notamment la liste de données de news mNews
        NewsAdapter newsAdapter = new NewsAdapter(getContext(), mNews);

        // On set un listener sur cet adapter et on définit l'action à réaliser lors d'un
        // click sur un item de news
        newsAdapter.setOnClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(
                        getContext(),
                        mNews.get(position).getmTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        // On attache l'adapter à la RecyclerView du fragment_business
        recyclerView.setAdapter(newsAdapter);

        // On retourne l'objet contenant la vue relative au fragment_business
        return businessView;
    }
}
