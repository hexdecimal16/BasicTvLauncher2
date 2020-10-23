package com.dhairytripathi.basictvlauncher2.adapters

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dhairytripathi.basictvlauncher2.R
import kotlinx.android.synthetic.main.item_status_tab.view.*

class StatusBar(private val context: Context, private val pager: ViewPager2): RecyclerView.Adapter<StatusBar.StatusBarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusBarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_status_tab,
            parent,
            false
        )
        return StatusBarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StatusBarViewHolder, position: Int) {
        when (position) {
            0 -> holder.textTitle.text = "For you"
            1 -> holder.textTitle.text = "Movies"
            2 -> holder.textTitle.text = "Shows"
            3 -> holder.textTitle.text = "Apps"
            4 -> holder.textTitle.text = "Libraries"
        }
        holder.icon.onFocusChangeListener = View.OnFocusChangeListener { view, b ->
            if (b) {
                holder.icon.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.bg_statusbar_select
                    )
                )
                holder.textTitle.setTextColor(Color.BLACK)
                pager.currentItem = position + 1
            } else {
                holder.icon.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.transparent
                    )
                )
                holder.textTitle.setTextColor(Color.WHITE)
            }
        }
        holder.icon.setOnKeyListener { v, keyCode, event ->
            if (event.keyCode == KeyEvent.KEYCODE_DPAD_DOWN && event.action == KeyEvent.ACTION_DOWN) {
                Log.d("StatusBar", "keyCode: $keyCode Event $event")
                holder.textTitle.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.google_blue500_30
                    )
                )
            }
            false
        }

    }

    override fun getItemCount(): Int {
        return 5;
    }

    class StatusBarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView = itemView.tvStatus
        val icon: LinearLayout = itemView.llStatusBarIcon
    }
}



