package net.ukr.zubenko.g.nerdlauncher

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.content.pm.ResolveInfo
import android.support.v4.content.ContextCompat.startActivity
import android.widget.ImageView


class NerdLauncherActivityHolder(view: View, private val activity: Activity):
    RecyclerView.ViewHolder(view), View.OnClickListener
{
    private lateinit var mResolveInfo: ResolveInfo
    private val mTextView: TextView = view.findViewById(R.id.app_name)
    private val mIcon: ImageView = view.findViewById(R.id.app_icon)

    init {
        mTextView.setOnClickListener(this)
    }

    fun bindActivity(resolveInfo: ResolveInfo) {
        mResolveInfo = resolveInfo
        val appName = mResolveInfo.loadLabel(activity.packageManager).toString()
        mTextView.text = appName
        mIcon.setImageDrawable(mResolveInfo.loadIcon(activity.packageManager))
    }

    override fun onClick(v: View?) {
        val i = Intent(Intent.ACTION_MAIN).setClassName(mResolveInfo.activityInfo.applicationInfo.packageName,
            mResolveInfo.activityInfo.name).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(activity, i,null)
    }
}