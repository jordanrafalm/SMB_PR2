package com.example.notification2

import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    private lateinit var myBroadcast: MyBroadcast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onResume() {
        super.onResume()
        myBroadcast = MyBroadcast()
        registerReceiver(myBroadcast, IntentFilter("com.example.myapp.MY_CUSTOM_INTENT"))
    }




  //  override fun onStop() {
    //    super.onStop()
      //  unregisterReceiver(myBroadcast)
    //}




    }

