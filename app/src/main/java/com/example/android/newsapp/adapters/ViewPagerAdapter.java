package com.example.android.newsapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    // ArrayList qui contient les différents fragments ajoutés
    private final ArrayList<Fragment> listFragment = new ArrayList<>();
    // ArrayList qui contient les titres de chaque fragment (sport, business, health etc.)
    private final ArrayList<String> listTitles = new ArrayList<>();

    // Constructeur par défaut
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // Cette methode retourne un fragment spécifique en fonction d'une position passée en
    // paramètre
    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    // Cette methode retourne la taille (ou le nombre de fragment) de l'ArrayList qui contient
    // les fragments
    @Override
    public int getCount() {
        return listFragment.size();
    }

    // Cette méthode permet l'ajout de fragment à l'ArrayList listFragment
    public void addFragment(Fragment fragment, String title) {
        listFragment.add(fragment);
        listTitles.add(title);
    }

    // Cette méthode retourne le titre du fragment à la position passée en paramètre
    public String getTitle(int position) {
        return listTitles.get(position);
    }
}
