package com.example.togetherhealthy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togetherhealthy.R;
import com.example.togetherhealthy.model.CommentModel;

import org.w3c.dom.Text;

import java.util.List;

public class ArticleCommentAdapter extends RecyclerView.Adapter<ArticleCommentAdapter.ArticleCommentViewHolder> {

    private List<CommentModel> commentModelList;

    public ArticleCommentAdapter(List<CommentModel> commentModelList) {
        this.commentModelList = commentModelList;
    }

    @NonNull
    @Override
    public ArticleCommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_comment, parent, false);
        return new ArticleCommentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleCommentViewHolder holder, int position) {
        holder.tvComment.setText(commentModelList.get(position).getUserComment());
        holder.tvUsername.setText(commentModelList.get(position).getUsername());
        //holder.tvTimestamp.setText(commentModelList.get(position).getTimestamp());
    }

    @Override
    public int getItemCount() {
        return commentModelList.size();
    }

    public class ArticleCommentViewHolder extends RecyclerView.ViewHolder {

        public TextView tvUsername, tvComment, tvTimestamp;
        public ArticleCommentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvComment = itemView.findViewById(R.id.tvComment);
            //tvTimestamp = itemView.findViewById(R.id.tvTimestamp);
        }
    }
}
