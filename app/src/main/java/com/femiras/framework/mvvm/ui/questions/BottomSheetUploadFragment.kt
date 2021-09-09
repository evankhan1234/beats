package com.femiras.framework.mvvm.ui.questions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.femiras.framework.mvvm.R




import android.app.Dialog

import android.util.DisplayMetrics
import android.util.Log
import com.femiras.framework.mvvm.utils.Utils


import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.annotation.NonNull

import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import kotlinx.android.synthetic.main.fragment_bottom_sheet_upload.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet_upload.view.*


@AndroidEntryPoint
class BottomSheetUploadFragment : BottomSheetDialogFragment() {


    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    companion object {
        const val TAG = "BottomSheetDialog"
    }




    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val view = View.inflate(context, R.layout.fragment_bottom_sheet_upload, null)
        view.channel_logo_iv.minimumHeight=300
        dialog.setContentView(view)
        val parent = view.parent as View
        bottomSheetBehavior = BottomSheetBehavior.from(parent)
        val displayMetrics = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        Log.e("height","height"+height)

        view.textView28.setOnClickListener {
            dismiss()
        }
        var peek:Int?=0
        when {
            height>=2301 -> {
                peek=1180
            }
            height in 2001..2300 -> {
                peek=950
            }
            height in 1901..2000 -> {
                peek=930
            }
            height in 1801..1900 -> {
                peek=930
            }
            height in 1701..1800 -> {
                peek=900
            }
            height in 1301..1499 -> {
                peek=750
            }
            height in 1151..1298 -> {
                peek=700
            }
            else -> {
                peek=600
            }
        }
        bottomSheetBehavior.peekHeight = peek
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == 3) {

                    view.channel_logo_iv.minimumHeight=750
                    view.edit_text_second.visibility=View.VISIBLE
                }
                else  if (newState == 4) {

                    view.channel_logo_iv.minimumHeight=300
                    view.edit_text_second.visibility=View.GONE
                }
                Log.e("height","height"+newState)

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // React to dragging events
            }
        })

        return dialog
    }







    override fun getTheme(): Int = R.style.SheetDialog


}

            