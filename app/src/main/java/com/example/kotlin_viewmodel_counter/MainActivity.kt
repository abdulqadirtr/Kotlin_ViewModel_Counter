package com.example.kotlin_viewmodel_counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_viewmodel_counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LifecycleOwner {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var number = 0
        var viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding. textView.text = viewModel.number.toString()
        binding.apply {

            submit.setOnClickListener(View.OnClickListener {
                viewModel.addNumber()
                textView.text = viewModel.number.toString()
            })

        }


    }
}