package com.hamza.iti_lab6.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamza.iti_lab6.databinding.ActivityDetailsBinding
import com.hamza.iti_lab6.utils.Const

class DetailsActivity : AppCompatActivity() {
    private var _binding: ActivityDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

       receivingDetails()
    }

    private fun receivingDetails() {
        val userName=intent.getStringExtra(Const.USER_NAME_KEY)
        val post=intent.getStringExtra(Const.POST_KEY)
        binding.txtUsername.text="Username: $userName"
        binding.txtPost.text="post: $post"

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}