package com.femiras.framework.mvvm.ui.questions

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import com.femiras.framework.mvvm.R

import kotlinx.android.synthetic.main.fragment_questions_one.*



class QuestionsOneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions_one, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        img_plus.setOnClickListener{
            if (findNavController().currentDestination?.id != R.id.bottomSheetUploadFragment && findNavController().currentDestination?.id == R.id.questionsOneFragment) {
                findNavController().navigate(R.id.bottomSheetUploadFragment
                )

            }
        }
        textView4.setOnClickListener{
            if (findNavController().currentDestination?.id != R.id.bottomSheetUploadFragment && findNavController().currentDestination?.id == R.id.questionsOneFragment) {
                    findNavController().navigate(QuestionsOneFragmentDirections.actionQuestionsOneFragmentToRightFragment()
                    )

                }
        }
        textView3.setOnClickListener{
//            if (findNavController().currentDestination?.id != R.id.bottomSheetUploadFragment && findNavController().currentDestination?.id == R.id.questionsOneFragment) {
//               // findNavController().navigate(QuestionsOneFragmentDirections.actionQuestionsOneFragmentToLeftFragment()
//                )
//
//            }
        }
    }
}


