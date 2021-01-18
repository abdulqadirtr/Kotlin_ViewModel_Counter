package com.example.kotlin_viewmodel_counter

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private lateinit var timer: CountDownTimer
    private val _seconds = MutableLiveData<Int>()

    private val _finish = MutableLiveData<Boolean>()

    fun getSecond(): LiveData<Int> {

        return _seconds
    }

    fun getFinish(): LiveData<Boolean>{

        return _finish
    }


    /** Start Timer. This function is triggered from MainActivity. */
    fun startTimer(){
        timer = object : CountDownTimer(10000, 1000){
            override fun onFinish() {
                _finish.value = true
            }

            override fun onTick(p0: Long) {
                val timeLeft = p0/1000
                _seconds.value = timeLeft.toInt()
            }
        }.start()
    }

    /** Stop Timer. This function is triggered from MainActivity. */
    fun stopTimer(){
        timer.cancel()
    }


    var number = 0
    fun addNumber() {
        number++
    }

    override fun onCleared() {
        super.onCleared()
    }

}