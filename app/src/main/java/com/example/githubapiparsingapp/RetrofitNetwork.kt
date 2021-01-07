package com.example.githubapiparsingapp

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface RetrofitNetwork {
    @GET("/users/{user}/repos")
    fun reposUser(@Path("user") user: String): Call<List<UsersUserRepos>>

}