package com.dhairytripathi.basictvlauncher2.ui.fragments

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dhairytripathi.basictvlauncher2.R
import com.dhairytripathi.basictvlauncher2.adapters.LeanbackAppAdapter
import kotlinx.android.synthetic.main.fragment_for_you.view.*
import java.util.ArrayList

class ForYouFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_for_you, container, false)
        val appsIntent = Intent(Intent.ACTION_MAIN, null)
        appsIntent.addCategory(Intent.CATEGORY_LEANBACK_LAUNCHER)
        val pkgAppsList: List<ResolveInfo> = context!!.packageManager.queryIntentActivities(
            appsIntent,
            PackageManager.MATCH_ALL
        )
        val arrayList = ArrayList<String>()
        for (resolveInfo in pkgAppsList) {
            arrayList.add(resolveInfo.activityInfo.applicationInfo.packageName)
        }
        Log.d("MainActivity", "package: \n$arrayList");
        v.rvApps.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        v.rvApps.adapter = LeanbackAppAdapter(arrayList, context!!)
        return v
    }
}