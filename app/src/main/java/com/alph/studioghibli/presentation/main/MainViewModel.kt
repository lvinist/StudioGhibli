package com.alph.studioghibli.presentation.main

import androidx.lifecycle.ViewModel
import com.alph.studioghibli.provider.ThemeProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val themeProvider: ThemeProvider) : ViewModel() {

    fun themeProvider() = themeProvider
}