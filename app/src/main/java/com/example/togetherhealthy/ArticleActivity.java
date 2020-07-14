package com.example.togetherhealthy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togetherhealthy.adapter.ArticleCommentAdapter;
import com.example.togetherhealthy.model.CommentModel;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity {

    private List<CommentModel> listComments;
    private RecyclerView recyclerView;
    private ArticleCommentAdapter adapter;

    public ArticleActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_article);

        listComments = new ArrayList<>();
        createDummyComments();
        setUpRecyclerView();

    }

    public void createDummyComments(){

        for(int i = 1; i<5; i++){
            CommentModel comment = new CommentModel();
            comment.setUserComment(i + " comment");
            comment.setUsername("user"+i);
            comment.setTimestamp(i * 1000);
            Log.v("COMMENT DUMMY", comment.toString());
            listComments.add(comment);
        }
    }

    public void setUpRecyclerView(){
        recyclerView = findViewById(R.id.recycler_view_comment);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        adapter = new ArticleCommentAdapter(listComments);
        recyclerView.setAdapter(adapter);
    }
}
