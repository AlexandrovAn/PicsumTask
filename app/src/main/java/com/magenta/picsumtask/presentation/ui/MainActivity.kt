package com.magenta.picsumtask.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.magenta.picstask.R
import com.magenta.picstask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController
        get() = (supportFragmentManager.findFragmentById(binding.mainFc.id) as NavHostFragment)
            .navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.random_pictures_fragment -> {
                    binding.mainToolbar.apply {
                        navigationIcon = null
                        setTitle(R.string.toolbar_name)
                        inflateMenu(R.menu.main_toolbar_menu)
                        menu.findItem(R.id.action_favorite).setOnMenuItemClickListener {
                            navController.navigate(R.id.liked_pictures_fragment)
                            true
                        }
                    }
                }
                R.id.liked_pictures_fragment -> {
                    binding.mainToolbar.apply {
                        menu.clear()
                        setTitle(R.string.favorite_toolbar_name)
                        setNavigationIcon(R.drawable.back_icon)
                        setNavigationOnClickListener {
                            onBackPressed()
                        }
                    }
                }
            }
        }
    }
}
