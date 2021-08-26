package com.truefan.sample.app.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.truefan.sample.app.R.*
import com.truefan.sample.app.data.api.ApiHelper
import com.truefan.sample.app.data.api.RetrofitBuilder
import com.truefan.sample.app.databinding.ActivityMainBinding
import com.truefan.sample.app.ui.base.ViewModelFactory
import com.truefan.sample.app.ui.main.viewmodel.MainViewModel
import com.truefan.sample.app.utils.Status.ERROR
import com.truefan.sample.app.utils.Status.LOADING
import com.truefan.sample.app.utils.Status.SUCCESS

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewModel()
        setupObservers()
    }


    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))).get(
                MainViewModel::class.java
            )
    }

    private fun setupObservers() {
        viewModel.getData().observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    SUCCESS -> {
                        binding.apply {
                            progressBar.visibility = View.GONE
                            rank.text = getString(string.rank) + it.data?.rank.toString()
                            score.text = getString(string.score) + it.data?.score.toString()
                            msg.text = getString(string.msg) + it.data?.msg
                        }
                    }
                    ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}
