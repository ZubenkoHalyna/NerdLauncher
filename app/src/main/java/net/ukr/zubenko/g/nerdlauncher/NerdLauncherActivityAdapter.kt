package net.ukr.zubenko.g.nerdlauncher

import android.app.Activity
import android.content.pm.ResolveInfo
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class NerdLauncherActivityAdapter(private val mActivities: List<ResolveInfo>, private val activity: Activity):
    RecyclerView.Adapter<NerdLauncherActivityHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NerdLauncherActivityHolder {
        val view =
            activity.layoutInflater.inflate(R.layout.item_nerd_launcher, parent, false)
        return NerdLauncherActivityHolder(view, activity)
    }

    override fun getItemCount() = mActivities.size

    override fun onBindViewHolder(holder: NerdLauncherActivityHolder, position: Int) {
        holder.bindActivity(mActivities[position])
    }

}