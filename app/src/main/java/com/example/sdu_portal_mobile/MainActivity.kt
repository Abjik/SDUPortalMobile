package com.example.sdu_portal_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sdu_portal_mobile.databinding.ActivityMainBinding
import com.example.sdu_portal_mobile.model.RVAdapter
import com.example.sdu_portal_mobile.model.TodoModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.activity_main_nav_host_fragment)
        setupWithNavController(binding.bottomNavigationView, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val bottomNavVisible = when (destination.id) {
                R.id.loginFragment -> false
                else -> true
            }
            binding.bottomNavigationView.isVisible = bottomNavVisible
        }
//    var user = findViewById<EditText>(R.id.login)
//    var password = findViewById<EditText>(R.id.password)
//
//    fun login(){
//        if(user.text.toString().equals("admin") && password.text.toString().equals("admin")){
//
//        }
//        else{
//
//        }
//    }
    }
}