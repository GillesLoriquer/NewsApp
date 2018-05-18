package com.example.android.newsapp.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.newsapp.fragments.FragmentBusiness;
import com.example.android.newsapp.R;
import com.example.android.newsapp.adapters.ViewPagerAdapter;
import com.example.android.newsapp.fragments.FragmentEntertainment;
import com.example.android.newsapp.fragments.FragmentSports;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // On récupère le widget ViewPager
        // Un ViewPager assure une navigation horizontale en permettant à l'utilisateur de faire
        // défiler (swipe) les différents portions du contenu d'une application (ici des fragments)
        // sur un seul et même écran
        ViewPager viewPager = findViewById(R.id.viewpager);

        // On créer un viewPagerAdapter qui se charge de garder en mémoire les différents fragments
        // qui lui sont ajoutés
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Ajout manuel des différents fragments
        viewPagerAdapter.addFragment(new FragmentBusiness(), "Business");
        viewPagerAdapter.addFragment(new FragmentEntertainment(), "Entertainment");
        viewPagerAdapter.addFragment(new FragmentSports(), "Sports");

        // On attache le viewPagerAdapter au widget ViewPager
        viewPager.setAdapter(viewPagerAdapter);

        // On récupère le widget TabLayout
        TabLayout tabLayout = findViewById(R.id.tablayout);

        // On attache le TabLayout au ViewPager
        // Ceci permet un affichage du tab correspondant avec le fragment affiché avec le fragment
        tabLayout.setupWithViewPager(viewPager);

        // On définit ici le texte correspondant au fragment affiché. Ce texte correspond au
        // second paramètre passé lors de la création du fragment
        tabLayout.getTabAt(0).setText(viewPagerAdapter.getTitle(0));
        tabLayout.getTabAt(1).setText(viewPagerAdapter.getTitle(1));
        tabLayout.getTabAt(2).setText(viewPagerAdapter.getTitle(2));

        // On supprimer ici l'ombre générée par l'action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}
