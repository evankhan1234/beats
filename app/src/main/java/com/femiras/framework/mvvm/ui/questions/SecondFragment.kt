package com.femiras.framework.mvvm.ui.questions

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.femiras.framework.mvvm.R


class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_second2, container, false)


        return v;
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            // load data here
            //Q
        } else {
            // fragment is no longer visible
         //   QuestionsActivity().datas(mContext!! as QuestionsActivity)
        }
    }

}