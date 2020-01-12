package com.example.foodbloggapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_event.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var isFragmentReviewLoaded = true


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val review = findViewById<Button>(R.id.buttonReview)
        val event = findViewById<Button>(R.id.buttonEvent)
        val trans = supportFragmentManager.beginTransaction()
        review.setOnClickListener(){
        trans.add(R.id.fragment_review,Fragment())
        trans.addToBackStack(null)
            trans.commit()
    }
        event.setOnClickListener(){
            trans.add(R.id.fragment_event,Fragment())
            trans.addToBackStack(null)
            trans.commit()
        }
    }


    fun ShowFragment_Event(){
        val trans = supportFragmentManager.beginTransaction()
        trans.add(R.id.fragment_event,Fragment())
        trans.addToBackStack(null)
        trans.commit()
    }

}
