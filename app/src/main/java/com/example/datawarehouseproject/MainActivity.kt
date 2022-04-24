package com.example.datawarehouseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.datawarehouseproject.databinding.ActivityMainBinding
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import com.example.retrofittest.model.Post
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding()
        whenPushNextButton()

    }

    private fun whenPushNextButton()
    {
        binding.button1.setOnClickListener()
        {
            val intent = Intent(this, SelectionScreenActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
        }
    }
    private fun ActivityMainBinding()
    {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
