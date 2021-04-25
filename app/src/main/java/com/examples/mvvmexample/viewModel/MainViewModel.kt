package com.examples.mvvmexample.viewModel

import com.examples.mvvmexample.model.RepoModel

/**
 * ViewModel - logic
 */
class MainViewModel {
    var repoModel: RepoModel = RepoModel() //экземпляр класса model
    var text: String = ""
    var isLoading: Boolean = false
}