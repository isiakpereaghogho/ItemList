package com.example.restapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){
val items: MutableLiveData<List<Item>> = MutableLiveData()

    fun getAllItems(){
        try{
        CoroutineScope(Dispatchers.IO).launch {
            val itemList: List<Item> = RetrofitProvider.service.getAllItems()
            items.postValue(itemList)
        }
        }catch (e: Exception)
    {
        Log.e("ViewModel", e.message.toString())
    }
        }
}