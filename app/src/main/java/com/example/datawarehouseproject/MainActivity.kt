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
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding()
        whenPushNextButton()
        Service()
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
    private fun Service()
    {

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        val myPost = Post(1,2, "other", 11,11,11,2,"other","T",1,4,"yes","R",17,0,4,"GT3","yes",5,2,"father",1,"yes","yes","yes","yes","course","no","GP","no","M",2,2)
        viewModel.pushPost(myPost)

        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())

            }else {
                Log.d("Main", response.toString())
            }
        })
    }
}
