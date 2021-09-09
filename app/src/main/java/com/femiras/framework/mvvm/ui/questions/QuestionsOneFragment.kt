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
import android.graphics.Bitmap





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

        imgNen.loadUrl("https://bd50.ocdev.me/fox/")

        img_plus.setOnClickListener{
            if (findNavController().currentDestination?.id != R.id.bottomSheetUploadFragment && findNavController().currentDestination?.id == R.id.questionsOneFragment) {
                    findNavController().navigate(R.id.bottomSheetUploadFragment
                    )

                }
        }
    }
}


