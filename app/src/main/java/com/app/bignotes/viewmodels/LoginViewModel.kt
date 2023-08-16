package com.app.bignotes.views

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.bignotes.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess
    private lateinit var auth: FirebaseAuth


    fun performLogin(activity: Activity, binding: ActivityLoginBinding) {
        auth = Firebase.auth
        val username = binding.usernameEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        if(username.isNotEmpty() && password.isNotEmpty()){
           auth(username, password, activity)
        }else{
            Toast.makeText(activity, "Email ou senha vazio", Toast.LENGTH_SHORT).show()
        }

    }

    fun initMain(activity: Activity){
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    fun auth(username:String, password:String, activity: Activity){
        auth.signInWithEmailAndPassword(username,password)
            .addOnCompleteListener(activity) {task ->
                if (task.isSuccessful) {
                    _loginSuccess.value = task.isSuccessful
                } else {
                    _loginSuccess.value = false
                }
            }
    }
}