package com.example.sportzinteractivedemo.presentation.matches.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sportzinteractivedemo.domain.usecase.GetNzIndMatchDataUseCase
import com.example.sportzinteractivedemo.domain.usecase.GetSaPakMatchDetailsUseCase

class SeriesViewModelFactory(
private val getNzIndMatchDataUseCase: GetNzIndMatchDataUseCase,
private val getSaPakMatchDetailsUseCase: GetSaPakMatchDetailsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SeriesViewModel(getNzIndMatchDataUseCase,getSaPakMatchDetailsUseCase) as T
    }
}