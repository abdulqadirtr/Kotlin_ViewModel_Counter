package com.example.kotlin_viewmodel_counter

import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_viewmodel_counter.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity(), LifecycleOwner {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var number = 0
        var viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


      //  viewModel.startTime()

        viewModel.getSecond().observe(this, Observer {
            binding.textView.text = it.toString()
        })

        viewModel.getFinish().observe(this, Observer {
            if(it== true){
                Toast.makeText(applicationContext, "Time finished", Toast.LENGTH_LONG).show()
            }
        })

        binding.btnStart.setOnClickListener(View.OnClickListener {

            viewModel.startTimer()
        })

        binding.btnStop.setOnClickListener(View.OnClickListener {


            viewModel.stopTimer()

        })


    /*    binding. textView.text = viewModel.number.toString()
        binding.apply {

            submit.setOnClickListener(View.OnClickListener {
                viewModel.addNumber()
                textView.text = viewModel.number.toString()

            })

        }
*/

    }
}