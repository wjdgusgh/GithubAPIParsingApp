package com.example.githubapiparsingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}

