package com.example.usbanks.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usbanks.apiService.NewsRepository
import com.example.usbanks.model.Article
import com.example.usbanks.util.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
): ViewModel() {

    private val _newsLiveData = MutableLiveData<List<Article>>()
    val newsLiveData: MutableLiveData<List<Article>> = _newsLiveData

    fun fetchNews() {
        viewModelScope.launch {
            val response = repository.getNews()

            if (response.isSuccessful) {
                newsLiveData.postValue(response.body()?.articles)
            } else {
                // display error
            }
        }
    }
}
}