package com.ransoft.androidreactive.coadingwithmitch.ui.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ransoft.androidreactive.R
import com.ransoft.androidreactive.coadingwithmitch.data.modal.Post
import com.ransoft.androidreactive.coadingwithmitch.data.network.MyApi
import com.ransoft.androidreactive.databinding.ActivityPostBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private val postAdapter by lazy { PostAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        binding.recyclerView.setLayoutManager(LinearLayoutManager(this));
        binding.recyclerView.adapter = postAdapter
        getPosts()
    }

    private fun getPosts() {
        MyApi().getPosts().enqueue(object: Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                postAdapter.posts = response.body()
            }
        })
    }
}