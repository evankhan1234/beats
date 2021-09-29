package com.femiras.framework.mvvm.ui.questions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.ui.home.today.SecondAdapter
import kotlinx.android.synthetic.main.fragment_right.*

class RightFragment : Fragment() {
    var secondAdapter: RightAdapter?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_right, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondAdapter = RightAdapter(requireContext())
        channel_logo_iv?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = secondAdapter
        }


    }

}