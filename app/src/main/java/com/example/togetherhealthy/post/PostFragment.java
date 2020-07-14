package com.example.togetherhealthy.post;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.togetherhealthy.R;
import com.example.togetherhealthy.home.HomeFragment;
import com.example.togetherhealthy.model.MultiTypePost;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static androidx.constraintlayout.widget.Constraints.TAG;
import static androidx.media.MediaBrowserServiceCompat.RESULT_OK;

public class PostFragment extends Fragment implements
        AdapterView.OnItemSelectedListener{

    private PostViewModel postViewModel;
    String categoryName = "";
    String  uriVideo="";
    Uri uriImage;
//    private List<String> categoryList;
    String[] country = { "Pilih Kategori Pos", "Administrasi", "Penyakit jantung", "Penyakit ginjal", "Penyakit diabetes", "Penyakit asma"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        postViewModel =
                ViewModelProviders.of(this).get(PostViewModel.class);
        View root = inflater.inflate(R.layout.fragment_post, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        postViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        final Button closeButton = root.findViewById(R.id.btn_post_close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert getFragmentManager() != null;
                getFragmentManager().popBackStackImmediate();
            }
        });

        final Spinner categorySpinner = root.findViewById(R.id.category_spinner);
        categorySpinner.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(aa);

        final EditText titleText = root.findViewById(R.id.edit_insert_title);
        final EditText posText = root.findViewById(R.id.edit_insert_post);

        final Button imageButton = root.findViewById(R.id.btn_upload_photo);
        final Button videoButton = root.findViewById(R.id.btn_upload_video);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
//                uriVideo = String.valueOf(uri);
            }
        });

        final Button postButton = root.findViewById(R.id.btn_post);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiTypePost multiTypePost = new MultiTypePost();

                multiTypePost.setTitle(titleText.getText().toString());
                multiTypePost.setArticle(posText.getText().toString());
                multiTypePost.setUrl_photo(uriImage);
                multiTypePost.setUrl_video(uriVideo);
                multiTypePost.setCategory(categoryName);
                multiTypePost.setVoteCount(0);
                HomeFragment.listOfPosts.add(multiTypePost);
                Toast.makeText(getActivity(),"Tulisan anda berhasil dipos." , Toast.LENGTH_LONG).show();
                moveToHomeFragment();
            }
        });

        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        categoryName = country[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("blabla");
            Uri targetUri = data.getData();

            if (requestCode == 0){
                uriImage = targetUri;
            }

            System.out.println(targetUri);
        Log.d(TAG, "onActivityResult: " + targetUri);
//            textTargetUri.setText(targetUri.toString());
//            Bitmap bitmap;
//            try {
//                bitmap = BitmapFactory.decodeStream(Objects.requireNonNull(this.getActivity()).getApplicationContext().getContentResolver().openInputStream(targetUri));
//                targetImage.setImageBitmap(bitmap);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
    }

    private void moveToHomeFragment(){
        Fragment fragment = new HomeFragment();

        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
    }
}