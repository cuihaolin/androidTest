package com.m520it.com.draggertest.api;

import com.m520it.com.draggertest.bean.Repo;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * @author Holly
 * @time 2017/3/15  10:52
 * @desc ${TODD}
 */
public interface GithubApiService {
    //rxjava和retrofit配合使用
    @GET("/users/{user}/repos")
    Observable<ArrayList<Repo>> getRepoData(@Path("user") String user);
}