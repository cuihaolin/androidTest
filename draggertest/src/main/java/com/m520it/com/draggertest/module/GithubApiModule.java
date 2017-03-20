package com.m520it.com.draggertest.module;

import android.app.Application;

import com.m520it.com.draggertest.GithubApiService;
import com.m520it.com.draggertest.R;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * @author Holly
 * @time 2017/3/15  10:51
 * @desc ${TODD}
 */
@Module
public class GithubApiModule {

    @Provides
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    @Provides
    public Retrofit provideRetrofit(Application application, OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(application.getString(R.string.api_github))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    protected GithubApiService provideGitHubService(Retrofit retrofit) {

        return retrofit.create(GithubApiService.class);
    }
}