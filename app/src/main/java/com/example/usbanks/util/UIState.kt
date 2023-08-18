package com.example.usbanks.util

sealed class UIState {
    object Loading: UIState()
    class Success<T> (val response: T): UIState()
    class Error (val exception: Exception) : UIState()
}
