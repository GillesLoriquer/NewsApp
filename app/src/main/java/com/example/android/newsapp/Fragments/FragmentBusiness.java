package com.example.android.newsapp.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.newsapp.Models.Article;
import com.example.android.newsapp.Models.News;
import com.example.android.newsapp.R;
import com.example.android.newsapp.adapters.ArticleAdapter;
import com.example.android.newsapp.interfaces.NewsApiService;
import com.example.android.newsapp.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;


public class FragmentBusiness extends Fragment {
    /** Attributs privés */
    // Attribut contenant une liste d'article
    private List<Article> mArticles = new ArrayList<>();

    // Attribut contenant un objet de type ArticleAdapter
    private ArticleAdapter mArticleAdapter = new ArticleAdapter();

    /** Constructeurs */
    // Constructeur publique vide requi
    public FragmentBusiness() { }

    /** Methodes */
    // Cette méthode est réalise la création initiale du fragment
    // Elle est appelée avant onCreateView dans le cycle de vie du fragment
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On fournit un contexte à notre adapter...
        mArticleAdapter.setmContext(getContext());

        // ... ainsi qu'une List<Article> (ici ArrayList vide, elle sera mise à jour et l'adapter
        // sera notifié par le Callback de l'appel à NewsApiService)
        mArticleAdapter.setmArticles(mArticles);

        // Création d'une instance retrofit de type RetrofitClientInstance
        NewsApiService newsApiService =
                RetrofitClientInstance.getRetrofitInstance().create(NewsApiService.class);

        // Création de l'appel à la méthode newsForCategory de l'interface NewsApiService
        // Un objet de type News sera retourné
        retrofit2.Call<News> call = newsApiService.newsForCategory(
                "fr",
                "health",
                "ee166bfd9a324909a2d584246d54b70e");

        // Réalisation de l'appel asynchrone (via Callback)
        call.enqueue(new Callback<News>() {
            @Override
            // En cas de réponse on fournit à l'adapter une nouveau set de data (List<Article>)
            public void onResponse(retrofit2.Call<News> call, Response<News> response) {
                mArticleAdapter.addAll(response.body().getmArticles());
            }

            // En cas d'échec, on affiche un TextView informant qu'une erreur s'est produite
            @Override
            public void onFailure(retrofit2.Call<News> call, Throwable t) {
                Toast.makeText(
                        getContext(),
                        "Something went wrong...Please try later!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Cette méthode retourne la vue relative au fragment business
    // Elle crée également un ArticleAdapter qu'elle attache à la RecyclerView présente dans ce
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
        // du comptage et du positionnement des vues de chaque article dans le RecyclerView. Il
        // s'occupe également du recyclage des vues d'article qui ne sont plus visible par
        // l'utilisateur
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // On set un listener sur cet adapter et on définit l'action à réaliser lors d'un
        // click sur un item de news
        mArticleAdapter.setOnClickListener(new ArticleAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(
                        getContext(),
                        mArticles.get(position).getmTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        // On attache l'adapter à la RecyclerView du fragment_business
        recyclerView.setAdapter(mArticleAdapter);

        // On retourne l'objet contenant la vue relative au fragment_business
        return businessView;
    }
}
