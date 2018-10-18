package com.bolo.ktclient.httpapi

import com.bolo.ktclient.pojo.GitData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * Create by qinpc on 2018/3/27
 */
interface SimpleService {
    @GET("repos/{owner}/{repo}/contributors")
    fun listRepos(@Path("owner") owner: String, @Path("repo") repo: String):
            Call<MutableList<GitData>>

    @Headers(
        "User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, " +
                "like Gecko) Chrome/68.0.3440.106 Safari/537.36",
            "Cache-Control:no-cache",
            "Accept-Encoding:gzip, deflate",
            "Accept-Language:en-US,en;q=0.9",
            "Accept:*/*"
    )
    @GET("account/info")
    fun accountInfo(): Call<String>
}