package com.c.kotlinconcept

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.c.kotlinconcept.retrofit.RetrofitClient
import com.c.kotlinconcept.retrofit.Users
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkServer()
    }


    data class Data(val name: String, val age: Int, val data: String = "")
    private fun sendData(): Data {
        return Data("Jack", 30)
    }
    private fun deStructure() {
//        val obj = sendData()
        val obj = sendData()
        // Using instance to access properties
        println("Name is ${obj.name}")
        println("Age is ${obj.age}")

        // Creating two variables using destructing declaration
        val (name, age) = sendData()
        println("Name is $name")
        println("Age is $age")

    }

    private fun checkServer() {
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
