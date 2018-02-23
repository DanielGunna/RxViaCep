package br.gunna.rxviacep;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ViaCepService {

    private static final String BASE_URL = "https://viacep.com.br/ws/";
    private static ViaCepService sInstance;
    private ViaCepAPI mService;


    private ViaCepService() {
        createService();
    }

    public static ViaCepService getInstance() {
        if (sInstance == null)
            sInstance = new ViaCepService();
        return sInstance;
    }

    private void createService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .build();

        mService = retrofit.create(ViaCepAPI.class);
    }

    public ViaCepAPI getService() {
        return mService;
    }


}
