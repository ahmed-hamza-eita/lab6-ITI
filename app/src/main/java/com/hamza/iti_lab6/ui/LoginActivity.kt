package com.hamza.iti_lab6.ui

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hamza.iti_lab6.R
import com.hamza.iti_lab6.databinding.ActivityLoginBinding
import com.hamza.iti_lab6.utils.Const
import com.hamza.iti_lab6.utils.MySharedPreferences

class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        actions()

    }

    private fun login() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()
        if (email.isEmpty()) {
            binding.edtEmail.error = getString(R.string.required)
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.edtEmail.error = "invalid Email Address"
        } else if (password.isEmpty()) {
            binding.edtPassword.error = getString(R.string.required)
        } else {
            MySharedPreferences.setUserEmail(email)
            MySharedPreferences.putBoolean(Const.LOGIN_KEY, true)
            intent()
            finishAffinity()


        }
    }

    private fun actions() {
        binding.btnLogin.setOnClickListener {

            login()
        }
    }

    private fun intent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}