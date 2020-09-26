package com.example.keyenterexample

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class ViewModel:ViewModel() {
    var enterKey: ObservableField<String>? = null
    var enteredValue: ObservableField<String>? = null

    init {
        enterKey= ObservableField("")
        enteredValue= ObservableField("")
    }

    val enterMethod: Function1<String, Unit> = this::enterMethod

    private fun enterMethod(key: String){
        enteredValue?.set(key)
        enterKey?.set("")
    }
}