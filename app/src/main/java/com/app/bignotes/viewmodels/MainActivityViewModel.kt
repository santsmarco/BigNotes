package com.app.bignotes.viewmodels

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.app.bignotes.views.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivityViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth

    fun performLogout(activity: Activity){
        Toast.makeText(activity, "Saindo...", Toast.LENGTH_SHORT).show()
        auth = Firebase.auth
        auth.signOut()
        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}