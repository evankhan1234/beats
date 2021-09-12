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
import android.view.MotionEvent
import android.widget.LinearLayout
import com.femiras.framework.mvvm.utils.Utils


import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout

import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import kotlinx.android.synthetic.main.fragment_bottom_sheet_upload.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet_upload.view.*
import android.content.Intent
import android.os.Handler
import android.view.View.OnTouchListener
import androidx.core.view.MotionEventCompat
import com.femiras.framework.mvvm.utils.LockableBottomSheetBehavior
import kotlinx.android.synthetic.main.layout_text.view.*


@AndroidEntryPoint
class BottomSheetUploadFragment : BottomSheetDialogFragment() {


    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    companion object {
        const val TAG = "BottomSheetDialog"
    }



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val view = View.inflate(context, R.layout.layout_text, null)
        dialog.setContentView(view)
        val parent = view.parent as View
        bottomSheetBehavior = BottomSheetBehavior.from(parent)
        val displayMetrics = DisplayMetrics()
        val params: ConstraintLayout.LayoutParams = view.channel_logo_iv.layoutParams as ConstraintLayout.LayoutParams
        params.height = 300
        params.width = LinearLayout.LayoutParams.MATCH_PARENT
        view.channel_logo_iv.layoutParams = params

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

                activity?.runOnUiThread {
                    if (newState == 3) {

                        Handler().postDelayed(Runnable {
                            view.textView310.visibility=View.VISIBLE
                            val params: ConstraintLayout.LayoutParams = view.channel_logo_iv.layoutParams as ConstraintLayout.LayoutParams
                            params.height = 600
                            params.width = LinearLayout.LayoutParams.MATCH_PARENT
                            view.channel_logo_iv.layoutParams = params
                            view.textView310.visibility = View.VISIBLE

                        }, 250)


                    }

                    else  if (newState == 4) {
                        val params: ConstraintLayout.LayoutParams = view.channel_logo_iv.layoutParams as ConstraintLayout.LayoutParams
                        params.height = 300
                        params.width = LinearLayout.LayoutParams.MATCH_PARENT
                        view.channel_logo_iv.layoutParams = params
                        view.textView310.visibility = View.GONE
                    }
                    else if(newState == 5){
                        dismiss()
                    }
                }
//                bottomSheet.post { //workaround for the bottomsheet  bug
//                    bottomSheet.requestLayout()
//                    bottomSheet.invalidate()
//
//                }

                Log.e("height","height"+newState)

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // React to dragging events
                val padding = (10 * slideOffset).toInt()
                view.bottom_sheet.setPadding(Math.round(padding * (1 - slideOffset)),
                    0, Math.round(padding * (1 - slideOffset)), 0);
            }
        })


        return dialog
    }






    override fun getTheme(): Int = R.style.SheetDialog


}

            