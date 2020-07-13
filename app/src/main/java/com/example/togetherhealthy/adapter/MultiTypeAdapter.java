package com.example.togetherhealthy.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togetherhealthy.R;
import com.example.togetherhealthy.model.MultiTypePost;

import java.util.ArrayList;

public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int TYPE_ARTICLE = 1;
    private static int TYPE_ARTICLE_PHOTO = 2;
    private static int TYPE_ARTICLE_VIDEO = 3;
    private static int TYPE_STREAM = 4;

    private Context context;
    private ArrayList<MultiTypePost> multiTypePostArrayList;

    public MultiTypeAdapter(Context context, ArrayList<MultiTypePost> multiTypePostArrayList){
        this.context = context;
        this.multiTypePostArrayList = multiTypePostArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_ARTICLE) { // for call layout
            view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
            return new ArticlePostAdapter.ArticlePostViewHolder(view);

        } else if (viewType == TYPE_ARTICLE_PHOTO){ // for email layout
            view = LayoutInflater.from(context).inflate(R.layout.item_article_photo, parent, false);
            return new ArticlePhotoAdapter.ArticlePhotoViewHolder(view);
        } else if (viewType == TYPE_ARTICLE_VIDEO){
            view = LayoutInflater.from(context).inflate(R.layout.item_article_video, parent, false);
            return new ArticleVideoAdapter.ArticleVideoViewHolder(view);
        } else if (viewType == TYPE_STREAM) {
            view = LayoutInflater.from(context).inflate(R.layout.item_stream, parent, false);
            return new StreamAdapter.StreamViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (multiTypePostArrayList.get(position).getUrl_photo() == 0 && TextUtils.isEmpty(multiTypePostArrayList.get(position).getUrl_video())) {
            return TYPE_ARTICLE;
        } else if (TextUtils.isEmpty(multiTypePostArrayList.get(position).getUrl_video())){
            return TYPE_ARTICLE_PHOTO;
        } else if (multiTypePostArrayList.get(position).getUrl_photo() == 0) {
            return TYPE_ARTICLE_VIDEO;
        } else if (multiTypePostArrayList.get(position).getUrl_photo() == 0 && multiTypePostArrayList.get(position).getArticle().isEmpty()) {
            return TYPE_STREAM;
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_ARTICLE) {
            ((ArticlePostAdapter.ArticlePostViewHolder) holder).setArticle(multiTypePostArrayList.get(position));
        } else if (getItemViewType(position) == TYPE_ARTICLE_PHOTO){
            ((ArticlePhotoAdapter.ArticlePhotoViewHolder) holder).setArticlePhoto(multiTypePostArrayList.get(position));
        } else if (getItemViewType(position) == TYPE_ARTICLE_VIDEO) {
            ((ArticleVideoAdapter.ArticleVideoViewHolder) holder).setArticleVideo(multiTypePostArrayList.get(position));
        } else {
            ((StreamAdapter.StreamViewHolder) holder).setStream(multiTypePostArrayList.get(position));
        }


    }

    @Override
    public int getItemCount() {
        return multiTypePostArrayList.size();
    }

}
