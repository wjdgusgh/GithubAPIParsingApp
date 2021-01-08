package com.example.githubapiparsingapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
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
        binding.searchtext = this@MainActivity

    }

    fun searchBtnClick(view: View){
        var username: String = editText_User.text.toString()
        searchUsersUserRepos(username)
    }

    private fun searchUsersUserRepos(user: String? = ""){
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(RetrofitNetwork::class.java)

        val call: Call<List<UsersUserRepos>> = api.reposUser(user!!)

        call.enqueue(object : Callback<List<UsersUserRepos>> {
            override fun onResponse(call: Call<List<UsersUserRepos>>, response: Response<List<UsersUserRepos>>) {
                val userRepos: List<UsersUserRepos>? = response.body()
                var userRepo = ""

                for (i in 0..userRepos?.size!!.minus(1)) {
                    var reposId: String? = userRepos.get(i).id
                    var reposNodeId: String? = userRepos.get(i).node_id
                    userRepo += "ID:$reposId\nNodeID:$reposNodeId\n"

                    userRepos.get(i).owner?.let {
                        userRepo += "OwnerID:${it.id}\n" +
                                "OwnerNodeID:${it.node_id}\n" +
                                "OwnerLogin:${it.login}\n"
                    }

                    userRepos.get(i).license?.let {
                        userRepo += "LicenseKey:${it.key}\n" +
                                "LicenseNodeID:${it.node_id}\n" +
                                "LicenseLogin:${it.name}\n"
                    }
                    userRepo += "\n"
                }
                resultTextView.text = userRepo
            }

            override fun onFailure(call: Call<List<UsersUserRepos>>, t: Throwable) {
                Log.e("debugTest", "error:(${t.message})")
            }
        })

    }


}

