package net.ukr.zubenko.g.nerdlauncher

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.content.Intent
import android.content.pm.ResolveInfo
import android.util.Log


class NerdLauncherFragment : Fragment() {
    private lateinit var mRecyclerView: RecyclerView

    companion object {
        private const val TAG = "NerdLauncherFragment"

        fun newInstance(): NerdLauncherFragment {
            return NerdLauncherFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_nerd_launcher, container,false)
        mRecyclerView = v.findViewById(R.id.app_recycler_view) as RecyclerView
        mRecyclerView.layoutManager = LinearLayoutManager(activity)

        setupAdapter()
        return v
    }

    private fun setupAdapter() {
        val startupIntent = Intent(Intent.ACTION_MAIN)
        startupIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        val pm = requireActivity().packageManager
        val activities = pm.queryIntentActivities(startupIntent, 0)
        activities.sortBy { a: ResolveInfo -> a.loadLabel(requireActivity().packageManager).toString() }

        mRecyclerView.adapter = NerdLauncherActivityAdapter(activities, requireActivity())
        Log.i(TAG, "Found ${activities.size} activities.")
    }
}