package com.example.instagram_clone.main.view

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.instagram_clone.R
import com.example.instagram_clone.camera.view.CameraFragment
import com.example.instagram_clone.databinding.ActivityMainBinding
import com.example.instagram_clone.home.view.HomeFragment
import com.example.instagram_clone.profile.view.ProfileFragment
import com.example.instagram_clone.search.view.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    private lateinit var homeFragment: Fragment
    private lateinit var searchFragment: Fragment
    private lateinit var cameraFragment: Fragment
    private lateinit var profileFragment: Fragment
    private var currentFragment: Fragment? = null

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.insetsController?.setSystemBarsAppearance(
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
        window.statusBarColor = ContextCompat.getColor(this, R.color.gray)

        setSupportActionBar(binding.mainToolbar)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_insta_camera)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        homeFragment = HomeFragment()
        searchFragment = SearchFragment()
        cameraFragment = CameraFragment()
        profileFragment = ProfileFragment()

        binding.mainBottomNav.selectedItemId = R.id.menu_bottom_home
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_bottom_home -> currentFragment = homeFragment
            R.id.menu_bottom_search -> currentFragment = searchFragment
            R.id.menu_bottom_add -> currentFragment = cameraFragment
            R.id.menu_bottom_profile -> currentFragment = profileFragment
        }

        currentFragment?.let {
            if (supportFragmentManager.findFragmentById(R.id.main_fragment) == null) {
                supportFragmentManager.beginTransaction().apply {
                    add(R.id.main_fragment, it)
                    commit()
                }
            } else {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.main_fragment, it)
                    addToBackStack(null)
                    commit()
                }
            }
        }
        return false
    }
}
