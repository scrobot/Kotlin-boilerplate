package ru.five_dots.kotlin_boilerplate.util.network;

import com.github.scrobot.kotlin_boilerplate.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.five_dots.kotlin_boilerplate.util.Constants;

/**
 * Created by scrobot91 on 29.06.2016.
 */
public class RetrofitService {

    private final String TAG = RetrofitService.class.getSimpleName();
    private OkHttpClient.Builder okHttpClient;
    private Gson gson;
    private String url;

    public RetrofitService(String url) {
        this.url = url;
        this.setDefaultGson();
        this.setDefaultOkHttp();
    }

    public RetrofitService() {
        this.url = Constants.API.URL;
        this.setDefaultGson();
        this.setDefaultOkHttp();
    }

    private void setDefaultOkHttp() {
        okHttpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.HEADERS
                : HttpLoggingInterceptor.Level.NONE);
        okHttpClient.interceptors().add(logging);
    }

    private void setDefaultGson() {
        gson = new GsonBuilder()
//                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .setDateFormat("dd MMMM, HH:mm")
                .setLenient()
                .create();
    }

    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient.build())
//                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
