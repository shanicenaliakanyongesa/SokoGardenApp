package com.modcom.yoghurts
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    //        fetch signup and signin button and intent them
        val signup = findViewById<Button>(R.id.signup)
        signup.setOnClickListener {
            val intent = Intent(applicationContext, About::class.java)
            startActivity(intent)
        }

//        SIGN IN
        val signin = findViewById<Button>(R.id.signin)
        signin.setOnClickListener {
            val intent = Intent(applicationContext, About::class.java)
            startActivity(intent)
        }

        //        fetch signup and signin button and intent them
        val about = findViewById<Button>(R.id.about)
        about.setOnClickListener {
            val intent = Intent(applicationContext, About::class.java)
            startActivity(intent)
        }


        //        fetch signup and signin button and intent them
        val speechtotext = findViewById<Button>(R.id.speechtotext)
        speechtotext.setOnClickListener {
            val intent = Intent(applicationContext, SpeechToTextActivity::class.java)
            startActivity(intent)
        }

//        fetch recylerview and progressbar
        val progressBar = findViewById<ProgressBar>(R.id.progressbar)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

//        define your url
        val url = "https://modcom2.pythonanywhere.com/api/get_product_details"

//        get the object of class APiHelper
        val helper = ApiHelper(applicationContext)

//        we have a function called loadProducts, its inside APIHELPER
//        pass the 3 arguments which are url, recyclerview and progressbar

        helper.loadProducts(url, recyclerView, progressBar )

    }
}
