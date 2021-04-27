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

    //получить фейковый список репозитоиев
    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback){
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First", "Owner 1", 100 , false))
        arrayList.add(Repository("Second", "Owner 2", 30 , true))
        arrayList.add(Repository("Third", "Owner 3", 430 , false))

        Handler().postDelayed({onRepositoryReadyCallback.onDataReady(arrayList)},2000)
    }
}

interface OnDataReadyCallback{
    fun onDataReady(data: String)
}

interface OnRepositoryReadyCallback{
    fun onDataReady(data: ArrayList<Repository>)
}