package com.c.kotlinconcept.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.c.kotlinconcept.R
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postData()
    }


    private fun postData() {
        val client = RetrofitClient()
        client.initOTPHost()
        client.routeApi.signUp(
            Users(
                "svchs",
                "abc@cb.co",
                "9876543210",
                "1234567890",
                "user"
            )
        )
            .enqueue(object : Callback<JsonObject> {
                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                }


            })


    }


}
