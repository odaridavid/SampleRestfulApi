package com.github.odaridavid.samplerestfulapi

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenCreated {
            try {
                val users =
                    UserApiService
                        .createUserApiService()
                        .getUsers()
                val namesTextView = findViewById<TextView>(R.id.namesTextView)
                val sb = StringBuilder()
                for (user in users.data) {
                    sb.append(user.first_name)
                    sb.append("\n")
                }

                namesTextView.text = sb.toString()
            } catch (e: IOException) {
                Log.e("Users", "******IO Exception Occured*******")
            }
        }
    }

}
