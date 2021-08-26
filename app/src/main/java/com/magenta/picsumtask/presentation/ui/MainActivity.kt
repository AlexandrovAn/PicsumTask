package com.magenta.picsumtask.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import com.magenta.picstask.R
import com.magenta.picstask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val navController
        get() = (supportFragmentManager.findFragmentById(binding.mainFc.id) as NavHostFragment)
            .navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.random_pictures_fragment -> binding.mainToolbar.applyRandomPictures()
                R.id.liked_pictures_fragment -> binding.mainToolbar.applyFavouritePictures()
            }
        }
    }

    private fun Toolbar.applyRandomPictures() {
        navigationIcon = null
        setTitle(R.string.toolbar_name)
        inflateMenu(R.menu.main_toolbar_menu)
        menu.findItem(R.id.action_favorite).setOnMenuItemClickListener {
            navController.navigate(R.id.liked_pictures_fragment)
            true
        }
    }

    private fun Toolbar.applyFavouritePictures() {
        menu.clear()
        setTitle(R.string.favorite_toolbar_name)
        setNavigationIcon(R.drawable.back_icon)
        setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
