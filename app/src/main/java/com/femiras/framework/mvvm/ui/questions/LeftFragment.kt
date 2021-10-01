package com.femiras.framework.mvvm.ui.questions

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.utils.OnSwipeTouchListener
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrConfig
import com.r0adkll.slidr.model.SlidrInterface
import com.r0adkll.slidr.model.SlidrPosition
import kotlinx.android.synthetic.main.fragment_left.*

import kotlinx.android.synthetic.main.fragment_left.imageView6


class LeftFragment : Fragment() {




    private var mContext: Activity? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_left, container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mContext=activity
        // Get the status bar colors to interpolate between
        val primary = mContext!!.resources.getColor(R.color.black)
        val secondary = mContext!!.resources.getColor(R.color.black)

        // Build the slidr config


//
//        mConfig = SlidrConfig.Builder()
//            .primaryColor(primary)
//            .secondaryColor(secondary)
//            .position(SlidrPosition.LEFT)
//            .velocityThreshold(2400f) //                .distanceThreshold(.25f)
//            //                .edge(true)
//
//            .build()
//
//        // Attach the Slidr Mechanism to this activity
//
//        // Attach the Slidr Mechanism to this activity
//        Slidr.attach(mContext!!, mConfig!!)
        imageView6.setOnClickListener {
            findNavController().popBackStack()


        }
        constraintLayout3.setOnTouchListener(object : OnSwipeTouchListener(requireContext()) {
            override fun onSwipeLeft() {
                super.onSwipeLeft()

                datas()

            }

            override fun onSwipeRight() {
                super.onSwipeRight()

            }

            override fun onSwipeUp() {
                super.onSwipeUp()

            }

            override fun onSwipeDown() {
                super.onSwipeDown()

            }
        })

    }

    fun datas(){
        QuestionsActivity().data(mContext!! as QuestionsActivity)
    }
}