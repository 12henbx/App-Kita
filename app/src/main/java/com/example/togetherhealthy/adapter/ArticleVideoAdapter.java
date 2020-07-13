package com.example.togetherhealthy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togetherhealthy.R;
import com.example.togetherhealthy.model.ArticleVideoPost;
import com.example.togetherhealthy.model.MultiTypePost;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class ArticleVideoAdapter extends RecyclerView.Adapter<ArticleVideoAdapter.ArticleVideoViewHolder> {
    private List<ArticleVideoPost> dataArticle;

    @NonNull
    @Override
    public ArticleVideoAdapter.ArticleVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_video, parent, false);
        return new ArticleVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleVideoAdapter.ArticleVideoViewHolder holder, final int position) {
        holder.textViewArticle.setText(dataArticle.get(position).getArticle());
        holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = dataArticle.get(position).getArticle();
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataArticle.size();
    }

    public static class ArticleVideoViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewArticle;
        public YouTubePlayerView youTubePlayerView;
        public ArticleVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewArticle = (TextView)itemView.findViewById(R.id.tv_article);
            youTubePlayerView = itemView.findViewById(R.id.youtube_player_view);
        }

        void setArticleVideo(final MultiTypePost multiTypePost) {
            textViewArticle.setText(multiTypePost.getArticle());
            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = multiTypePost.getUrl_video();
                    youTubePlayer.loadVideo(videoId, 0);
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ArticleVideoAdapter(List<ArticleVideoPost> myDataset) {
        dataArticle = myDataset;
    }
}
