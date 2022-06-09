package com.example.notification2

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val activityName = "com.example.rafal.activites.ShowListActivity"
        val packageName = "com.example.rafal"
        val intent = Intent().setClassName(packageName, activityName)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)


    }
}