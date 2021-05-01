package com.example.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    private val _count = MutableLiveData(0);
    val count: LiveData<Int> = _count

    fun countChange(count: Int) {
        _count.value = count;

    }
}