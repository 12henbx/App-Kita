package com.example.togetherhealthy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togetherhealthy.R;
import com.example.togetherhealthy.model.ArticlePost;
import com.example.togetherhealthy.model.MultiTypePost;

import java.util.List;

public class ArticlePostAdapter extends RecyclerView.Adapter<ArticlePostAdapter.ArticlePostViewHolder> {
    private List<ArticlePost> dataArticle;


    public static class ArticlePostViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewArticle;
        public ArticlePostViewHolder(View itemView) {
            super(itemView);
            textViewArticle = (TextView)itemView.findViewById(R.id.tv_article);
        }

        void setArticle(MultiTypePost multiTypePost) {
            textViewArticle.setText(multiTypePost.getArticle());
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ArticlePostAdapter(List<ArticlePost> myDataset) {
        dataArticle = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ArticlePostAdapter.ArticlePostViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ArticlePostViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ArticlePostViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textViewArticle.setText(dataArticle.get(position).getArticle());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataArticle.size();
    }

}
