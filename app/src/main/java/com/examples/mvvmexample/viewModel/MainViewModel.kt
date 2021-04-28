package com.examples.mvvmexample.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.examples.mvvmexample.model.OnDataReadyCallback
import com.examples.mvvmexample.model.OnRepositoryReadyCallback
import com.examples.mvvmexample.model.RepoModel
import com.examples.mvvmexample.model.Repository
import java.util.*
import kotlin.collections.ArrayList

/**
 * ViewModel - logic
 */
class MainViewModel : ViewModel() {
    var repoModel: RepoModel = RepoModel()  //экземпляр класса model
    val text = ObservableField<String>()    //оборачиваем объекты для наблюдения за ними (dataBinding)
    val textBtn1 = ObservableField("loading")    //оборачиваем объекты для наблюдения за ними (dataBinding)
    val textBtn2 = ObservableField("refresh")    //оборачиваем объекты для наблюдения за ними (dataBinding)
    val isLoading = ObservableField<Boolean>()
    var repositories = MutableLiveData<ArrayList<Repository>>()

    //метод отвечающий за обновление данных
    val onDataReadyCallback = object : OnDataReadyCallback{
        override fun onDataReady(data: String) {
            isLoading.set(false)
            text.set(data)
        }
    }


    //получить репозитории
    fun loadRepositories(){
        isLoading.set(true)
        repoModel.getRepositories(object : OnRepositoryReadyCallback{
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }
}
