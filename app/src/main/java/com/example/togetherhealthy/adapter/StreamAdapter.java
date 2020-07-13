package com.example.togetherhealthy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togetherhealthy.R;
import com.example.togetherhealthy.model.MultiTypePost;
import com.example.togetherhealthy.model.StreamPost;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class StreamAdapter extends RecyclerView.Adapter<StreamAdapter.StreamViewHolder> {
    private List<StreamPost> dataArticle;

    @NonNull
    @Override
    public StreamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stream, parent, false);
        return new StreamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StreamViewHolder holder, int position) {
//        holder.textViewArticle.setText(dataArticle.get(position).getArticle());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class StreamViewHolder extends RecyclerView.ViewHolder {
        public YouTubePlayerView youTubePlayerView;
        public StreamViewHolder(@NonNull View itemView) {
            super(itemView);
            youTubePlayerView = itemView.findViewById(R.id.youtube_player_view);
        }

        void setStream(final MultiTypePost multiTypePost) {
            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = multiTypePost.getUrl_video();
                    youTubePlayer.loadVideo(videoId, 0);
                }
            });
        }
    }
}
