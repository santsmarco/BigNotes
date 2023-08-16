package com.app.bignotes.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.app.bignotes.R
import com.app.bignotes.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginButton.setOnClickListener {
            viewModel.performLogin(this,binding)
        }

        viewModel.loginSuccess.observe(this) { success ->
            when (success) {
                true -> {
                    Toast.makeText(this, "Sucesso Login", Toast.LENGTH_SHORT).show()
                    viewModel.initMain(this)
                }
                false -> {
                    Toast.makeText(this, "Erro Login", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}