package com.examples.mvvmexample.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.examples.mvvmexample.model.OnDataReadyCallback
import com.examples.mvvmexample.model.RepoModel
import java.util.*

/**
 * ViewModel - logic
 */
class MainViewModel : ViewModel() {
    var repoModel: RepoModel = RepoModel()  //экземпляр класса model
    val text = ObservableField<String>()    //оборачиваем объекты для наблюдения за ними (dataBinding)
    val textBtn1 = ObservableField("loading")    //оборачиваем объекты для наблюдения за ними (dataBinding)
    val textBtn2 = ObservableField("refresh")    //оборачиваем объекты для наблюдения за ними (dataBinding)
    val isLoading = ObservableField<Boolean>()

    //метод отвечающий за обновление данных
    val onDataReadyCallback = object : OnDataReadyCallback{
        override fun onDataReady(data: String) {
            isLoading.set(false)
            text.set(data)
        }
    }

    //вызывает refreshData у RepoModel, который в аргументах берёт реализацию OnDataReadyCallback
    fun refresh(){
        isLoading.set(true)
        repoModel.refreshData(object : OnDataReadyCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
            }
        })
    }
}
