package com.dhairytripathi.basictvlauncher2.adapters

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dhairytripathi.basictvlauncher2.R
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.item_app.view.*

class LeanbackAppAdapter(private val pkgAppsList: ArrayList<String>, private val context: Context): RecyclerView.Adapter<LeanbackAppAdapter.LeanbackViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeanbackViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_app, parent, false)
        return LeanbackViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LeanbackViewHolder, position: Int) {
        val currentItem = pkgAppsList[position]
        val packageManager: PackageManager = context.packageManager
        val applicationInfo: ApplicationInfo = packageManager.getApplicationInfo(currentItem, 0)
        val title = packageManager.getApplicationLabel(applicationInfo) as String
        try {
            val applicationBanner: Drawable? = context.packageManager.getApplicationBanner(currentItem)
            if (applicationBanner != null) {
                holder.imageIcon.setImageDrawable(applicationBanner)
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        holder.textTitle.text = title
    }

    override fun getItemCount(): Int {
        return pkgAppsList.size
    }

    class  LeanbackViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageIcon: ShapeableImageView = itemView.ivAppIcon;
        val textTitle: TextView = itemView.tvAppName;
    }
}
