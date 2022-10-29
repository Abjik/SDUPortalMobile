package com.example.sdu_portal_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sdu_portal_mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
    }
}