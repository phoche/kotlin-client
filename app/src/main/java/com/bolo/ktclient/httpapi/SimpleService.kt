package com.bolo.ktclient.httpapi

import com.bolo.ktclient.pojo.GitData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Create by qinpc on 2018/3/27
 */
interface SimpleService {
    @GET("repos/{owner}/{repo}/contributors")
    fun listRepos(@Path("owner") owner: String, @Path("repo") repo: String) :
            Call<MutableList<GitData>>
}