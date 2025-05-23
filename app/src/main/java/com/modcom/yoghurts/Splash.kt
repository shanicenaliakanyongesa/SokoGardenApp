package com.modcom.yoghurts
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //     FETCH IMAGE VIEWS
        val leftimage = findViewById<ImageView>(R.id.leftimg)
        val rightimage = findViewById<ImageView>(R.id.rightimg)

        val leftanim = AnimationUtils.loadAnimation(applicationContext, R.anim.leftanimation)
        val rightanim = AnimationUtils.loadAnimation(applicationContext, R.anim.rightanimation)

        leftimage.animation = leftanim
        rightimage.animation = rightanim

        Handler().postDelayed({
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }, 5000)
    }
}