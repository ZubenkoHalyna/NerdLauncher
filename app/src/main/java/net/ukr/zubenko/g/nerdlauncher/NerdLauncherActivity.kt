package net.ukr.zubenko.g.nerdlauncher

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import net.ukr.zubenko.g.criminalintent.SingleFragmentActivity

class NerdLauncherActivity: SingleFragmentActivity() {
    override fun createFragment() = NerdLauncherFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
