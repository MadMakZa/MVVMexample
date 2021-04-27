package com.examples.mvvmexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.examples.mvvmexample.R
import com.examples.mvvmexample.databinding.ActivityMainBinding
import com.examples.mvvmexample.viewModel.MainViewModel

/**
 * View - представление
 */
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

//    var mainViewModel = MainViewModel() //View должна иметь экземпляр ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.executePendingBindings()
    }
}