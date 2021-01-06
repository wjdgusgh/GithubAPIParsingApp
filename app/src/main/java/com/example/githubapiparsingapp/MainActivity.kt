package com.example.githubapiparsingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.githubapiparsingapp.GithubResponseModel
import com.example.githubapiparsingapp.GithubAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(GithubAPI.getRepoList("test")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({ response: GithubResponseModel ->
                for (item in response.items) {
                    Log.d("MainActivity", item.name)
                }
            }, { error: Throwable ->
                Log.d("MainActivity", error.localizedMessage)
                Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
            }))

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}