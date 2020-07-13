package com.example.togetherhealthy.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.togetherhealthy.R;
import com.example.togetherhealthy.adapter.ArticlePostAdapter;
import com.example.togetherhealthy.adapter.ArticleVideoAdapter;
import com.example.togetherhealthy.adapter.MultiTypeAdapter;
import com.example.togetherhealthy.model.ArticlePost;
import com.example.togetherhealthy.model.ArticleVideoPost;
import com.example.togetherhealthy.model.MultiTypePost;
import com.example.togetherhealthy.model.StreamPost;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ChipGroup chipGroup;

    private String dummyArticle = "Code review is a very important part of the team ‘s life. It is impossible to downplay the significance of this process. This makes a team stronger, a code better and cleaner, and gives growth not only to beginners but also to those who are already experienced. A person who can do a good code review is worth his weight in gold. And always remember that it was a time when none of us reviewed a code or created a Pull Requests, so be patient with those who haven’t done it yet, and the world will get a little better. Peace!";
    private String dummyArticle1 = "It is impossible to downplay the significance of this process. This makes a team stronger, a code better and cleaner, and gives growth not only to beginners but also to those who are already experienced. A person who can do a good code review is worth his weight in gold. And always remember that it was a time when none of us reviewed a code or created a Pull Requests, so be patient with those who haven’t done it yet, and the world will get a little better. Peace!";

    private RecyclerView articleRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
//    List<ArticlePost> listOfArticle;
//    List<ArticleVideoPost> listOfVideo;
    List<MultiTypePost> listOfPosts;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        chipGroup = root.findViewById(R.id.chip_group);

        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup chipGroup, int i) {

                Chip chip = chipGroup.findViewById(i);
                if (chip != null)
                    Toast.makeText(getActivity().getApplicationContext(), "Chip is " + chip.getText().toString(), Toast.LENGTH_SHORT).show();

                Log.e("OnCheckedChangeListener", "Called");
            }
        });

//        chipGroup.setOnClickListener(new ChipGroup.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                Chip chip = chipGroup.findViewById(checkedId);
//                if (chip != null)
//                    Toast.makeText(getActivity().getApplicationContext(), "Chip is " + chip.getChipText(), Toast.LENGTH_SHORT).show();
//                System.out.println("test56");
//            }
//        });

//        listOfArticle = new ArrayList<ArticlePost>();
//        listOfVideo = new ArrayList<ArticleVideoPost>();
        listOfPosts = new ArrayList<>();

        for (int i =0 ; i < 10 ; i++){
            MultiTypePost article = new MultiTypePost();

            article.setUsername(String.valueOf(i));
            article.setArticle(dummyArticle + i);
            listOfPosts.add(article);
        }

        for (int i =0 ; i < 2 ; i++){
            MultiTypePost articleVideoPost = new MultiTypePost();
            articleVideoPost.setArticle(dummyArticle1);
            articleVideoPost.setUsername(String.valueOf(i));
            articleVideoPost.setUrl_video("l2mI4vL95kU");
            listOfPosts.add(articleVideoPost);
        }

        articleRecyclerView = (RecyclerView) root.findViewById(R.id.post_recyclerview);
        articleRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this.getContext());
        articleRecyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
//        mAdapter = new ArticlePostAdapter(listOfArticle);
        mAdapter = new MultiTypeAdapter(getContext(), (ArrayList<MultiTypePost>) listOfPosts);
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