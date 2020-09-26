package com.example.keyenterexample

import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @BindingAdapter("onEditorEnterAction")
    @JvmStatic
    fun EditText.onEditorEnterAction(f: Function1<String, Unit>?) {

        if (f == null) setOnEditorActionListener(null)
        else setOnEditorActionListener { v, actionId, event ->

            val imeAction = when (actionId) {
                EditorInfo.IME_ACTION_NEXT,
                EditorInfo.IME_ACTION_DONE,
                EditorInfo.IME_ACTION_SEND,
                EditorInfo.IME_ACTION_GO -> true
                else -> false
            }

            val keydownEvent = event?.keyCode == KeyEvent.KEYCODE_ENTER
                    && event.action == KeyEvent.ACTION_DOWN

            if (imeAction or keydownEvent)
                true.also { f(v.editableText.toString()) }
            else false
        }
    }
}
