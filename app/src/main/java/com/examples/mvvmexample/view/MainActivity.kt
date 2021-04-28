package com.examples.mvvmexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.examples.mvvmexample.R
import com.examples.mvvmexample.databinding.ActivityMainBinding
import com.examples.mvvmexample.model.Repository
import com.examples.mvvmexample.viewModel.MainViewModel
import com.examples.mvvmexample.viewModel.RepositoryRecyclerViewAdapter

/**
 * View - представление
 */
class MainActivity : AppCompatActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding

    private val repositoryRecyclerViewAdapter = RepositoryRecyclerViewAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
        binding.repositoryRv.adapter = repositoryRecyclerViewAdapter
        viewModel.repositories.observe(this,
                { it?.let{ repositoryRecyclerViewAdapter.replaceData(it)} })

    }

    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}