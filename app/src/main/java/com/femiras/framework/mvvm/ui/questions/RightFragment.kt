package com.femiras.framework.mvvm.ui.questions

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.ui.home.today.SecondAdapter
import com.femiras.framework.mvvm.utils.OnSwipeTouchListener
import kotlinx.android.synthetic.main.fragment_left.*
import kotlinx.android.synthetic.main.fragment_right.*

class RightFragment : Fragment() {
    var secondAdapter: RightAdapter?=null
    var channel_logo_iv: RecyclerView?=null
    var constraintLayout3: NestedScrollView?=null
    private var mContext: Activity? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_right, container, false)
        channel_logo_iv=v.findViewById(R.id.channel_logo_iv)
        constraintLayout3=v.findViewById(R.id.constraintLayout3)
        activity?.runOnUiThread { secondAdapter = RightAdapter(requireContext())
        channel_logo_iv?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = secondAdapter
        }

        }
        mContext=activity

        constraintLayout3?.setOnTouchListener(object : OnSwipeTouchListener(requireContext()) {
            @SuppressLint("ClickableViewAccessibility")
            override fun onSwipeLeft() {
                super.onSwipeLeft()
                Toast.makeText(
                    context, "Swipe Left gesture detected",
                    Toast.LENGTH_SHORT
                )

                    .show()


            }

            override fun onSwipeRight() {
                super.onSwipeRight()

                datas()
            }

            override fun onSwipeUp() {
                super.onSwipeUp()

            }

            override fun onSwipeDown() {
                super.onSwipeDown()

            }
        })
        return v
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    fun datas(){
        QuestionsActivity().data(mContext!! as QuestionsActivity)
    }

}