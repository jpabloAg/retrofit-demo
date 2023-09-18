package com.example.consumeapijetpackcompose

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostsViewModel: ViewModel() {
    var _listaPosts: ArrayList<PostsResponse> by mutableStateOf(arrayListOf())

    fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getPosts()
            withContext(Dispatchers.Main) {
                if (response.body()!!.isNotEmpty()){
                    _listaPosts = response.body()!!
                }
            }
        }
    }
}