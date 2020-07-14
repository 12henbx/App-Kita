package com.example.togetherhealthy.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.togetherhealthy.R;
import com.example.togetherhealthy.model.api.Response;
import com.example.togetherhealthy.network.RetrofitClientInstance;
import com.example.togetherhealthy.notifications.NotificationsViewModel;

import java.security.GeneralSecurityException;

import retrofit2.Call;
import retrofit2.Callback;

public class ProfileFragment extends Fragment {

    public String userClass;
    private String consumerId = "1000";
    private String password = "7789";
    private long timestamp = System.currentTimeMillis() / 1000L;
    private String sTimestamp = Long.toString(timestamp);
    private String signature = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        RetrofitClientInstance.GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(RetrofitClientInstance.GetDataService.class);

        try {
            signature = RetrofitClientInstance.generateHmacSHA256Signature(consumerId, password, sTimestamp);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        Call<Response> call = service.getUser(consumerId, sTimestamp, signature, "0001842246369", "2019-08-12");
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                userClass = response.body().getResponse().getPeserta().getHakKelas().getKeterangan();
                Toast.makeText(getContext(), "Kelas User "+userClass, Toast.LENGTH_SHORT).show();
                //Log.d("TAG RESPONSE", response.body().getResponse().getPeserta().getHakKelas().getKeterangan());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(getContext(), "Can't load user data", Toast.LENGTH_SHORT).show();
                Log.d("THROWABLE", t.toString());

            }
        });
        return root;
    }
}
