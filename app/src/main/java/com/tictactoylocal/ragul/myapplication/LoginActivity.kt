package com.tictactoylocal.ragul.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()
    }

    fun btnLoginEvent(view: View) {
        loginToFireBase(etEmail.text.toString(), etPassword.text.toString())
    }

    fun loginToFireBase(email: String, password: String) {
        mAuth!!.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {task->
                    if(task.isSuccessful){
                        Toast.makeText(applicationContext,"Successful login",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(applicationContext,"Fail login",Toast.LENGTH_SHORT).show()
                    }
                }
    }
}
