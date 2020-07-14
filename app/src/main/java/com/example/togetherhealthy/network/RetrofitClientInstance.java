package com.example.togetherhealthy.network;

import android.util.Base64;

import com.example.togetherhealthy.model.api.HakKelas;
import com.example.togetherhealthy.model.api.Response;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.time.Instant;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://dvlp.bpjs-kesehatan.go.id/hackaton/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public static String generateHmacSHA256Signature(String consumerId, String key, String timestamp) throws GeneralSecurityException {
        byte[] hmacData = null;
        String data = consumerId+"&"+timestamp;

        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKey);
            hmacData = mac.doFinal(data.getBytes("UTF-8"));
            return Base64.encodeToString(hmacData, Base64.DEFAULT).replace("\n", "").replace("\r", "");
        } catch (UnsupportedEncodingException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public interface GetDataService {

        @GET("Peserta/nokartu/{no_kartu}/tglSEP/{tgl_SEP}")
        Call<Response> getUser(@Header("X-cons-id") String consumerId, @Header("X-timestamp") String timestamp,
                                        @Header("X-signature") String signature, @Path("no_kartu") String no_kartu,
                                        @Path("tgl_SEP") String tgl_SEP);

    }
}




