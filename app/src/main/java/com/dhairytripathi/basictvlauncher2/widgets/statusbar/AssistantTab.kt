package com.dhairytripathi.basictvlauncher2.widgets.statusbar

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.KeyEvent
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import com.dhairytripathi.basictvlauncher2.R
import kotlinx.android.synthetic.main.nav_menu.view.*

class AssistantTab(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    override fun onFocusChanged(gainFocus: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect)
        if(gainFocus) {
            this.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bg_statusbar_select))
            ImageViewCompat.setImageTintList(ivAssistantIcon, ColorStateList.valueOf(Color.BLACK));
            tvSearch.setTextColor(Color.BLACK)
        } else {
            this.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.transparent))
            ImageViewCompat.setImageTintList(ivAssistantIcon, ColorStateList.valueOf(Color.WHITE));
            tvSearch.setTextColor(Color.WHITE)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (event!!.keyCode == KeyEvent.KEYCODE_DPAD_DOWN && event.action == KeyEvent.ACTION_DOWN) {
            this.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bg_statusbar_view))
            Log.d("AssistantTab", "keyCode: $keyCode Event $event")
        }
        return super.onKeyDown(keyCode, event)
    }
}