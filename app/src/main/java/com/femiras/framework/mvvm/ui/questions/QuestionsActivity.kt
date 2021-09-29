package com.femiras.framework.mvvm.ui.questions

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.ViewCompat
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.femiras.framework.mvvm.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_questions.*
import kotlinx.android.synthetic.main.layout_appbar.view.*
@AndroidEntryPoint
class QuestionsActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        setupNavController()
        imgNen.settings.setJavaScriptEnabled(true)
        imgNen  .clearCache(true)


        // Set web view client
        imgNen.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                // Page loading started
                // Do something
                Log.e("f","Sd")

            }

            override fun onPageFinished(view: WebView, url: String) {
                // Page loading finished
                // Enable disable back forward button
//                if (findNavController().currentDestination?.id != R.id.questionsTwoFragment && findNavController().currentDestination?.id == R.id.questionsOneFragment) {
//                    findNavController().navigate(
//                        QuestionsOneFragmentDirections.actionQuestionsOneFragmentToSquestionsTwoFragment(
//
//                        )
//                    )
//
//                }

            }
        }

        imgNen.setInitialScale(1);
        imgNen.getSettings().setLoadWithOverviewMode(true);
        imgNen.getSettings().setUseWideViewPort(true);

        imgNen.loadUrl("https://bd50.ocdev.me/beats/")

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
//    override fun onBackPressed() {
//        val navController = findNavController(R.id.questionsTwoFragment)
//        navController.navigate(R.id.questionsOneFragment)
//    }
}