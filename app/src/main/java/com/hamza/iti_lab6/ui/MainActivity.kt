package com.hamza.iti_lab6.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamza.iti_lab6.R
import com.hamza.iti_lab6.adapters.PostAdapter
import com.hamza.iti_lab6.databinding.ActivityMainBinding
import com.hamza.iti_lab6.models.PostModel
import com.hamza.iti_lab6.utils.Const

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val adapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)


        showingData()
    }

    private fun showingData() {
        val users =
            arrayListOf<PostModel>(
                PostModel("Ahmed hamza", "11-10-2011", Const.POST, "https://img.icons8.com/?size=512&id=21441&format=png"),
                PostModel("MOH hamza", "11-11-2011", Const.POST, "https://img.icons8.com/?size=512&id=13042&format=png"),
                PostModel("Waleed hamza", "11-8-2011", Const.POST, "https://img.icons8.com/?size=512&id=81139&format=png")
            )
        adapter.list = users
        binding.rv.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}