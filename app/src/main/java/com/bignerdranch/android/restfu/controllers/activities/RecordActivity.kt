package com.bignerdranch.android.restfu.controllers.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bignerdranch.android.restfu.R
import com.bignerdranch.android.restfu.controllers.fragments.RecordDetailFragment
import com.bignerdranch.android.restfu.controllers.fragments.RecordListFragment
import com.bignerdranch.android.restfu.models.Record


class RecordActivity : AppCompatActivity() {

    private val fm: FragmentManager = supportFragmentManager
    private val TAG = "RecordActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

//        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        showRecordListFragment()
    }

     fun displayError(t: Throwable) {
        Toast.makeText(this,t.message,Toast.LENGTH_LONG).show()
        Log.e(
            "mike",
            "thrown error onFailure " + t.message)
    }

    fun showRecordDetailFragment(record: Record) {
        Log.d(TAG, "showFragmentHome")
        val fragmentDetail = RecordDetailFragment().newInstance(record)
        performFragmentTransaction(fragmentDetail)
    }

    fun showRecordListFragment() {
        Log.d(TAG, "showFragmentHome")
        val fragmentList = RecordListFragment().newInstance()
        performFragmentTransaction(fragmentList)
    }


    private fun performFragmentTransaction(fragment: Fragment) {
        fm.beginTransaction()
            .add(R.id.fragment_container, fragment)
//                .addToBackStack(fragment.tag)
            .commit()
    }
}