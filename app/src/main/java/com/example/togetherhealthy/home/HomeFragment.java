package com.example.togetherhealthy.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togetherhealthy.R;
import com.example.togetherhealthy.adapter.ArticlePostAdapter;
import com.example.togetherhealthy.model.ArticlePost;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ChipGroup chipGroup;

    private RecyclerView articleRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<ArticlePost> listOfArticle;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        chipGroup = root.findViewById(R.id.chipGroupMenu);
        listOfArticle = new ArrayList<ArticlePost>();

        for (int i =0 ; i < 10 ; i++){
            ArticlePost article = new ArticlePost();
            article.setUsername(String.valueOf(i));
            article.setArticle("Eyehunt " + i);
            listOfArticle.add(article);
        }

        articleRecyclerView = (RecyclerView) root.findViewById(R.id.post_recyclerview);
        articleRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this.getContext());
        articleRecyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ArticlePostAdapter(listOfArticle);
        articleRecyclerView.setAdapter(mAdapter);



//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}