package com.example.restapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.restapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listAdapter = ListAdapter(listOf())
        binding.recyclerView.adapter = listAdapter


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.apply{
            getAllItems()
            items.observe(this@MainActivity){items->
                listAdapter.list = items
                listAdapter.notifyDataSetChanged()
            }
        }
    }
}