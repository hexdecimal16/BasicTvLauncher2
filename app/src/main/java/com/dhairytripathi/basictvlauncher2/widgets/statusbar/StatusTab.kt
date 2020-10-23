package com.dhairytripathi.basictvlauncher2.widgets.statusbar

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.LinearLayout

class StatusTab(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    override fun onFocusChanged(gainFocus: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect)
        if(gainFocus) {

        } else {

        }
    }
}