package com.example.sdu_portal_mobile

import android.icu.text.SimpleDateFormat
import android.net.wifi.rtt.CivicLocationKeys.CITY
import android.os.AsyncTask
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.sdu_portal_mobile.databinding.ActivityMainBinding
import com.example.sdu_portal_mobile.databinding.ActivityWeatherBinding
import org.json.JSONObject
import java.net.URL
import java.util.*

class WeatherActivity : AppCompatActivity() {

    val CITY: String = "almaty,kz"
    val API: String = "06c921750b9a82d8f5d1294e1586276f" // Use API key
    private lateinit var binding: ActivityWeatherBinding

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        }

    }
