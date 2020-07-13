package com.example.togetherhealthy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togetherhealthy.R;
import com.example.togetherhealthy.model.ArticlePhotoPost;
import com.example.togetherhealthy.model.MultiTypePost;

import java.util.List;

public class ArticlePhotoAdapter extends RecyclerView.Adapter<ArticlePhotoAdapter.ArticlePhotoViewHolder> {
    private List<ArticlePhotoPost> dataArticle;

    @NonNull
    @Override
    public ArticlePhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_photo, parent, false);
        return new ArticlePhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlePhotoViewHolder holder, int position) {
        holder.textViewArticle.setText(dataArticle.get(position).getArticle());
    }

    @Override
    public int getItemCount() {
        return dataArticle.size();
    }

    public static class ArticlePhotoViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewArticle;
        public ImageView imageView;
        public ArticlePhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewArticle = (TextView)itemView.findViewById(R.id.tv_article);
            imageView = itemView.findViewById(R.id.image_post);
        }

        void setArticlePhoto(MultiTypePost multiTypePost) {
            textViewArticle.setText(multiTypePost.getArticle());
            imageView.setImageResource(multiTypePost.getUrl_photo());
        }
    }
}
