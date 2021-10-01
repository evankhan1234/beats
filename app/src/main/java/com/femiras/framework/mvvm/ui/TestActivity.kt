package com.femiras.framework.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.ui.questions.QuestionsOneFragmentDirections

import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        setupNavController()

    }
    private fun setupNavController() {
        Log.e("NAV", "SetupNavController")

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.landing) as NavHostFragment
        navController = navHostFragment.navController



        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            supportFragmentManager.popBackStack(R.id.content_viewer,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )


        }

//        binding.sideNavigation.setNavigationItemSelectedListener {
//            binding.drawerLayout.closeDrawers()
//            return@setNavigationItemSelectedListener false
//        }
    }
}