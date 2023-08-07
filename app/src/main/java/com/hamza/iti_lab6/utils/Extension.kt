package com.hamza.iti_lab6.utils

import android.content.Context
import android.widget.Toast
import com.hamza.iti_lab6.R
import io.github.muddz.styleabletoast.StyleableToast


fun Context.showToast(message: Any, duration: Int = Toast.LENGTH_LONG) {
    StyleableToast.makeText(this, message.toString(), duration, R.style.toastStyle).show();
}