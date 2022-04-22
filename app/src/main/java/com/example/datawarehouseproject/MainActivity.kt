package com.example.datawarehouseproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.datawarehouseproject.databinding.ActivityMainBinding
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding()
        sendGet()
        whenPushNextButton()

    }

    private fun whenPushNextButton()
    {
        binding.button1.setOnClickListener()
        {
            val intent = Intent(this, SelectionScreenActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.anim_in, R.anim.anim_out);

        }
    }
    private fun ActivityMainBinding()
    {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun sendGet() {
        val client = OkHttpClient()
        val url = "http://dwapi22.herokuapp.com/predict/"

        val jSON = MediaType.parse("application/json; charset=utf-8")
        val jsonObject = JSONObject()
        try {
            jsonObject.put("school", "GP")
            jsonObject.put("sex", "M")
            jsonObject.put("age", 17)
            jsonObject.put("address", "R")
            jsonObject.put("famsize", "GT3")
            jsonObject.put("Pstatus", "T")
            jsonObject.put("Medu", 2)
            jsonObject.put("Fedu", 2)
            jsonObject.put("Mjob", "other")
            jsonObject.put("Fjob", "other")
            jsonObject.put("reason", "course")
            jsonObject.put("guardian", "father")
            jsonObject.put("traveltime", 2)
            jsonObject.put("studytime", 2)
            jsonObject.put("failures", 0)
            jsonObject.put("schoolsup", "no")
            jsonObject.put("famsup", "yes")
            jsonObject.put("paid", "yes")
            jsonObject.put("activities", "yes")
            jsonObject.put("nursery", "yes")
            jsonObject.put("higher", "yes")
            jsonObject.put("internet", "no")
            jsonObject.put("romantic", "yes")
            jsonObject.put("famrel", 4)
            jsonObject.put("freetime", 5)
            jsonObject.put("goout", 2)
            jsonObject.put("Dalc", 1)
            jsonObject.put("Walc", 1)
            jsonObject.put("health", 1)
            jsonObject.put("absences", 4)
            jsonObject.put("G1", 11)
            jsonObject.put("G2", 11)
            jsonObject.put("G3", 11)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Log.d("gg", jsonObject.toString())

        val body:RequestBody = RequestBody.create(jSON, jsonObject.toString())
        Log.d("gg", jSON.toString())
        val request = Request.Builder().url(url).method("POST", body).build()


        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val tm = response.body()?.string()
                Log.d("gg", tm!!)
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("Failed", "FAILED")
                e.printStackTrace()
            }
        })

    }

}