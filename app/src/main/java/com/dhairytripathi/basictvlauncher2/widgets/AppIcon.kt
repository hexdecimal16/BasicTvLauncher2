package com.dhairytripathi.basictvlauncher2.widgets

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.KeyEvent
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.item_app.view.*

class AppIcon(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {


    override fun onFocusChanged(gainFocus: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect)
        if(gainFocus) {
            tvAppName.visibility = VISIBLE
            ivAppIcon.strokeWidth = 5f
            
        } else {
            tvAppName.visibility = INVISIBLE
            ivAppIcon.strokeWidth = 0f
        }
    }


}