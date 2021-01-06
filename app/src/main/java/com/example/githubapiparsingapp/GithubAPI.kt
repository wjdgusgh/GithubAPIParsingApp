package com.example.githubapiparsingapp

import com.example.githubapiparsingapp.GithubResponseModel
import retrofit2.http.GET
import retrofit2.http.Query
import io.reactivex.Observable

class GithubAPI {
    interface GithubApiImpl {
        @GET("/search/repositories")
        fun getRepoList(@Query("q") query: String):Observable<GithubResponseModel>
    }

    companion object{
        fun getRepoList(query: String):Observable<GithubResponseModel>{
            return RetrofitCreator.create(GithubApiImpl::class.java).getRepoList(query)
        }
    }
}