package com.example.datawarehouseproject

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittest.model.Post
import com.example.retrofitdemo.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    var myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()

    fun pushPost(post: Post) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }


}