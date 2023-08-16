package com.app.bignotes.viewmodels

import android.app.Activity
import android.content.Intent
import android.os.Handler
import androidx.lifecycle.ViewModel
import com.app.bignotes.views.LoginActivity
import com.app.bignotes.views.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth

    fun performSplash(activity: Activity) {
        Handler().postDelayed({
            auth = Firebase.auth

            val currentUser = auth.currentUser
            if (currentUser != null) {
                val intent = Intent(activity, MainActivity::class.java)
                activity.startActivity(intent)
                activity.finish()
            }else{
                val intent = Intent(activity,LoginActivity::class.java)
                activity.startActivity(intent)
                activity.finish()
            }
        }, 4000)
    }

}