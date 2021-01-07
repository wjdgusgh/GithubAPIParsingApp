package com.example.githubapiparsingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.githubapiparsingapp.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(RetrofitNetwork::class.java)

        val call: Call<List<UsersUserRepos>> = api.reposUser("laravel")

        call.enqueue(object: Callback<List<UsersUserRepos>> {
            override fun onResponse(call: Call<List<UsersUserRepos>>, response: Response<List<UsersUserRepos>>) {
                val userRepos: List<UsersUserRepos>? = response.body()

                var userRepo = ""
                var resultText: String = ""
                userRepos?.forEach { it -> userRepo += "$it\n" }

                resultText = String.format(userRepo)

                resultTextView.text = resultText

            }

            override fun onFailure(call: Call<List<UsersUserRepos>>, t: Throwable) {
                Log.e("debugTest","error:(${t.message})")
            }
        })



    }

}

