package com.example.android.newsapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newsapp.models.Article;
import com.example.android.newsapp.R;
import com.example.android.newsapp.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.RowViewHolder> {
    /** Attributs privés */
    // Attribut qui contient le contexte du fragment où se créer l'ArticleAdapter
    private Context mContext;
    // Attribut qui contient la liste des articles à afficher
    private List<Article> mArticles;
    // Attribut qui contient le listener attaché à ce ArticleAdapter
    private OnItemClickListener mOnItemClickListener;

    /** Constructeurs */
    public ArticleAdapter() { }

    public ArticleAdapter(Context mContext, List<Article> mArticles) {
        this.mContext = mContext;
        this.mArticles = mArticles;
    }

    /** Mutateurs */
    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public void setmArticles(List<Article> mArticles) {
        this.mArticles = mArticles;
    }

    /** Classe interne définissant le RowViewHolder */
    // Chaque ViewHolder se charge d'un seul item d'Article
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
    // Interface permettant la création d'un custom listener sur chaque item d'Article.
    // Lors de sa création dans chaque fragment la méthode onClick devra être redéfinie
    // pour spécifier l'action à réaliser sur un item du RecyclerView
    public interface OnItemClickListener {
        void onClick(View v, int position);
    }

    /** Methodes */
    // Appelée lorsque que la RecyclerView à besoin d'un ViewHolder représentant un item d'Article
    // Ce nouveau ViewHolder sera utilisé pour afficher les items de l'adapter en utilisant
    // onBindViewHolder
    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(
                R.layout.article_list,
                parent,
                false);

        return new RowViewHolder(v);
    }

    // Cette méthode permet de binder les datas avec l'affichage.
    // L'objet retourné par onCreateViewHolder contient les différentes vues d'un item Article
    // (titre, nom de la source etc.) et il est question ici de leur affecter une valeur avec la
    // position passée en paramètre
    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        Article currentArticle = mArticles.get(position);

        holder.mSourceName.setText(currentArticle.getmSource().getmName());
        holder.mTitle.setText(currentArticle.getmTitle());
        holder.mDescription.setText(currentArticle.getmDescription());
        holder.mPublishedAt.setText(Utils.getDate(currentArticle.getmPublishedAt()));
        Picasso.get().load(currentArticle.getmUrlToImage())
                .placeholder(R.drawable.ic_no_image)
                .fit()
                .centerCrop()
                .into(holder.mImage);
    }

    // Retourne le nombre de d'item (Article) contenu dans la liste mArticles
    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    // Cette méthode, appelée par chaque fragment, permet de setter un listener de type
    // ArticleAdapter.onItemClickListener (interface interne définie dans cette classe) sur cet
    // adapter
    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void clear() {
        mArticles.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Article> articles) {
        mArticles.clear();
        mArticles.addAll(articles);
        notifyDataSetChanged();
    }
}
