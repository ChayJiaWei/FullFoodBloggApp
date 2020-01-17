package com.example.foodbloggapp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*


class MainActivity : AppCompatActivity() {
    
    lateinit var handler:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        handler=DatabaseHelper(this)
        
        showHome()
        
        var isFragmentReviewLoaded = true
        
        
        save.setOnClickListener { 
            handler.insertingUserData(name.text.toString(),email.text.toString(),password.text.toString())
                showHome()
        }
        
        login_button.setOnClickListener { 
            if (handler.userPresent(login_email.text.toString(),login_password.text.toString()))
                Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Username or password is incorrect",Toast.LENGTH_SHORT).show()
        }
        
        buttonRegister.setOnClickListener { 
            showRegistration()
        }
        
        buttonLogin.setOnClickListener{
            showLogin()
        }
        
        

        val review = findViewById<Button>(R.id.buttonReview)
        val event = findViewById<Button>(R.id.buttonEvent)
        val directory = findViewById<Button>(R.id.buttonDirectory)


        val trans = supportFragmentManager.beginTransaction()

        buttonReview.setOnClickListener(){
        trans.add(R.id.fragment_review,Fragment())
        trans.addToBackStack(null)
            trans.commit()
    }
        buttonEvent.setOnClickListener(){
            trans.add(R.id.fragment_event,Fragment())
            trans.addToBackStack(null)
            trans.commit()
        }

       

        

    }
    private  fun showRegistration() {
        registration_layout.visibility = View.VISIBLE
        login_layout.visibility = View.VISIBLE
        homepage.visibility = View.GONE
    }
    private  fun showLogin(){
        registration_layout.visibility = View.GONE
        login_layout.visibility = View.VISIBLE
        homepage.visibility = View.GONE
    }
    private  fun showHome(){
        registration_layout.visibility = View.GONE
        login_layout.visibility = View.GONE
        homepage.visibility = View.VISIBLE
    }
}
