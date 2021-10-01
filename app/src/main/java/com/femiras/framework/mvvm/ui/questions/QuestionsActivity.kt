package com.femiras.framework.mvvm.ui.questions

import android.app.Activity
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.TransitionManager
import android.util.Log
import android.view.GestureDetector
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.femiras.framework.mvvm.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_questions.*
import kotlinx.android.synthetic.main.activity_questions.img_plus
import kotlinx.android.synthetic.main.activity_questions.textView3
import kotlinx.android.synthetic.main.activity_questions.textView4

import androidx.fragment.app.FragmentActivity


@AndroidEntryPoint
class QuestionsActivity : FragmentActivity() {
    private lateinit var navController: NavController
    private var constraintSet1: ConstraintSet? = null
    private var constraintSet2: ConstraintSet? = null
    private var zoom = false
    private var move = true
    lateinit var gestureDetector: GestureDetector
    private val swipeThreshold = 100
    private val swipeVelocityThreshold = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        setupNavController()
        constraintSet1 = ConstraintSet()
        constraintSet2 = ConstraintSet()
      //  Slidr.attach(this);
        imgNen.settings.setJavaScriptEnabled(true)
        imgNen  .clearCache(true)
        constraintSet2!!.clone(this, R.layout.layout_button)
        constraintSet1!!.clone(constraintLayout)

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

        textView3.setOnClickListener(View.OnClickListener {
            if (zoom) {
                TransitionManager.beginDelayedTransition(constraintLayout)
                constraintSet1!!.applyTo(constraintLayout)
                zoom = false
               
                navController.popBackStack()

            } else {
                navController.navigate(QuestionsOneFragmentDirections.actionQuestionsOneFragmentToMainFragment())
                
                TransitionManager.beginDelayedTransition(constraintLayout)
                constraintSet2!!.applyTo(constraintLayout)
                zoom = true
                move=true
            }
        })
        textView4.setOnClickListener(View.OnClickListener {
            if (zoom) {
                TransitionManager.beginDelayedTransition(constraintLayout)
                constraintSet1!!.applyTo(constraintLayout)


                zoom = false
               
                navController.popBackStack()

            } else {
                move=true
                navController.navigate(QuestionsOneFragmentDirections.actionQuestionsOneFragmentToRightSideFragment())
                
                TransitionManager.beginDelayedTransition(constraintLayout)
                constraintSet2!!.applyTo(constraintLayout)

                zoom = true
            }
        })
        img_plus.setOnClickListener{
            navController.navigate(R.id.bottomSheetUploadFragment)
        }
        imgNen.setInitialScale(1);
        imgNen.getSettings().setLoadWithOverviewMode(true);
        imgNen.getSettings().setUseWideViewPort(true);

        imgNen.loadUrl("https://bd50.ocdev.me/beats/")


    }



    override fun onBackPressed() {
        super.onBackPressed()
        if (zoom) {


            TransitionManager.beginDelayedTransition(constraintLayout)
            constraintSet1!!.applyTo(constraintLayout)

            zoom = false
           

        }
        else{
            TransitionManager.beginDelayedTransition(constraintLayout)
            constraintSet2!!.applyTo(constraintLayout)
            
            zoom = true
        }
    }
    fun data(activity: QuestionsActivity){


        val navHostFragment = activity.supportFragmentManager.findFragmentById(R.id.landing) as NavHostFragment
        navController = navHostFragment.navController



        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            activity. supportFragmentManager.popBackStack(R.id.content_viewer,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )


        }

        Handler().postDelayed(Runnable {  TransitionManager.beginDelayedTransition(activity.constraintLayout)
            activity.constraintSet1!!.applyTo(activity.constraintLayout)}, 10)



        activity.zoom = false
        navController.popBackStack()


    }
    fun datas(activity: QuestionsActivity){


        val navHostFragment = activity.supportFragmentManager.findFragmentById(R.id.landing) as NavHostFragment
        navController = navHostFragment.navController



        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            activity. supportFragmentManager.popBackStack(R.id.content_viewer,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )


        }

        Handler().postDelayed(Runnable {  TransitionManager.beginDelayedTransition(activity.constraintLayout)
            activity.constraintSet1!!.applyTo(activity.constraintLayout)}, 10)



        activity.zoom = false
        navController.popBackStack()


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