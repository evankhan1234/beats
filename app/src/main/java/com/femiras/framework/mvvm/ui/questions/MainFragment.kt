package com.femiras.framework.mvvm.ui.questions

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.femiras.framework.mvvm.R
import com.google.android.material.tabs.TabLayout


class MainFragment : Fragment() {

    private var mContext: Activity? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_main, container, false)
        val viewPager = v.findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = PageAdapter(childFragmentManager)

        mContext=activity
        val tabLayout = v.findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                Log.e("Sds","s"+position)
                if (position==1){
                    QuestionsActivity().datas(mContext!! as QuestionsActivity)
                }
            }
        })

        return v
    }

}