package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val menuIcon = findViewById<ImageView>(R.id.menu_icon)
        val navView = findViewById<NavigationView>(R.id.nav_drawer)

        navView.itemIconTintList = null
        menuIcon.setOnClickListener{
            drawerLayout.openDrawer(GravityCompat.START)
        }
        val navController = Navigation.findNavController(this,R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(navView,navController)

        val textTitle = findViewById<TextView>(R.id.title)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            textTitle.text = destination.label
        }

    }
}