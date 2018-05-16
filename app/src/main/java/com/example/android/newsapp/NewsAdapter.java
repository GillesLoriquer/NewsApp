package com.example.android.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.RowViewHolder> {
    /** Attributs privés */
    // Attribut qui contient le contexte du fragment où se créer le NewsAdapter
    private Context mContext;
    // Attribut qui contient la liste des news à afficher
    private List<News> mNews;
    // Attribut qui contient le listener attaché à ce NewsAdapter
    private OnItemClickListener mOnItemClickListener;

    /** Constructeurs */
    public NewsAdapter() { }

    public NewsAdapter(Context mContext, List<News> mNews) {
        this.mContext = mContext;
        this.mNews = mNews;
    }

    /** Classe interne définissant le RowViewHolder */
    // Chaque ViewHolder se charge d'un seul item de news
    public class RowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /** Attributs privés */
        private TextView mSourceName;
        private TextView mTitle;
        private TextView mDescription;
        private TextView mPublishedAt;
        private ImageView mImage;

        /** Constructeurs */
        public RowViewHolder(View itemView) {
            super(itemView);
            mSourceName = itemView.findViewById(R.id.cardview_source_name);
            mTitle = itemView.findViewById(R.id.cardview_title);
            mDescription = itemView.findViewById(R.id.cardview_description);
            mPublishedAt = itemView.findViewById(R.id.cardview_publishedat);
            mImage = itemView.findViewById(R.id.cardview_image);
            itemView.setOnClickListener(this);
        }

        /** Méthodes */
        // Lors d'un click sur un item, la méthode onClick redéfinie dans le fragment à partir
        // de l'interface OnItemClickListener est appelée (callback ?)
        @Override
        public void onClick(View v) {
            mOnItemClickListener.onClick(v, getAdapterPosition());
        }
    }

    /** Interface interne */
    // Interface permettant la création d'un custom listener sur chaque item de news.
    // Lors de sa création dans chaque fragment la méthode onClick devra être redéfinie
    // pour spécifier l'action à réaliser sur un item du RecyclerView
    public interface OnItemClickListener {
        void onClick(View v, int position);
    }

    /** Methodes */
    // Appelée lorsque que la RecyclerView à besoin d'un ViewHolder représentant un item de news
    // Ce nouveau ViewHolder sera utilisé pour afficher les items de l'adapter en utilisant
    // onBindViewHolder
    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(
                R.layout.news_list,
                parent,
                false);

        return new RowViewHolder(v);
    }

    // Cette méthode permet de binder les datas avec l'affichage.
    // L'objet retourné par onCreateViewHolder contient les différentes vues d'un item news
    // (titre, nom de la source etc.) et il est question ici de leur affecter une valeur avec la
    // position passée en paramètre
    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        News currentNews = mNews.get(position);

        holder.mSourceName.setText(currentNews.getmSourceName());
        holder.mTitle.setText(currentNews.getmTitle());
        holder.mDescription.setText(currentNews.getmDescription());
        holder.mPublishedAt.setText(currentNews.getmPublishedAt());
        //holder.mImage.setText(currentNews.getmURLToImage());
    }

    // Retourne le nombre de d'item (news) contenu dans la liste mNews
    @Override
    public int getItemCount() {
        return mNews.size();
    }

    // Cette méthode, appelée par chaque fragment, permet de setter un listener de type
    // NewsAdapter.onItemClickListener (interface interne définie dans cette classe) sur cet
    // adapter
    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
