package com.example.basicapiusage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myText: TextView=findViewById<TextView>(R.id.textView2)
        val myButton:Button=findViewById(R.id.button)
        myText.setOnClickListener{
            val intent = myIntent(this, SignUpPage::class.java)
            startActivity(intent)
        }
       myButton.setOnClickListener {
           val myintent=myIntent2(this,Dashboard::class.java)
           startActivity(myintent)
       }

    }
    private fun myIntent(mainActivity: MainActivity, clazz: Class<SignUpPage>): Intent {
        return Intent(mainActivity, clazz)
    }
    private fun myIntent2(mainActivity: MainActivity, clazz: Class<Dashboard>): Intent {
        return Intent(mainActivity, clazz)
    }


}


