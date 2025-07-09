package com.example.caffeine.ui.screens.done_snack

import androidx.lifecycle.ViewModel
import com.example.caffeine.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SnackDoneViewModel: ViewModel() {
    private val _snackPhoto = MutableStateFlow(R.drawable.im_oreo)
    val snackPhoto = _snackPhoto.asStateFlow()

    fun loadSnackPhoto(photo: Int) {
        _snackPhoto.value = photo
    }
}