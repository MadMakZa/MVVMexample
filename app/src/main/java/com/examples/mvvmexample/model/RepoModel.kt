package com.examples.mvvmexample.model

import android.os.Handler

/**
 * Model
 */
class RepoModel {

    //получение данных из базы с заедржкой (Для имитации ожидания использую Handler)
    fun refreshData(onDataReadyCallback: OnDataReadyCallback){
        Handler().postDelayed({onDataReadyCallback.onDataReady("new data")},2000)
    }
}


interface OnDataReadyCallback{
    fun onDataReady(data: String)
}