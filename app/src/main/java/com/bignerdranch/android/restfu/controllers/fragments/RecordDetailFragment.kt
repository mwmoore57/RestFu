package com.bignerdranch.android.restfu.controllers.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bignerdranch.android.restfu.R
import com.bignerdranch.android.restfu.controllers.activities.RecordActivity
import com.bignerdranch.android.restfu.models.Record
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.record_item_detail.*


private const val RECORD_KEY = "RECORD_KEY"

class RecordDetailFragment: BaseFragment() {

    private lateinit var record: Record

    fun getFragmentLayoutResourceId(): Int {
        return R.layout.record_item_detail
    }

    fun newInstance(record: Record): RecordDetailFragment {
        val bundle = Bundle()
        bundle.putString(RECORD_KEY, Gson().toJson(record))
        val fragment = RecordDetailFragment()
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.record_item_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        Log.d("Mike", " onViewCreated FragmentProjectDetails")


        try {
            record = Gson().fromJson(arguments?.getString(RECORD_KEY), Record::class.java)
        } catch (e: Exception) {
            Toast.makeText(context,"OOPS... Unable to get record", Toast.LENGTH_LONG).show()
            activity?.onBackPressed()
        }

        Glide.with(context)
            .load(record.profilePicture)
            .centerCrop()
            .dontAnimate()
            .into(item_user_img)

        Glide.with(context)
            .load("https://images-na.ssl-images-amazon.com/images/I/31-4fNCSMLL._SY300_.jpg")
            .centerCrop()
            .dontAnimate()
            .into(item_force_sensitive_img)

        item_full_name.text = getString(R.string.full_name, record.firstName, record.lastName)
        item_affiliation.text = getString(R.string.affiliation,record.affiliation)
        item_birth_date.text = getString(R.string.birth_date,record.birthdate)
        item_force_sensitive.text = getString(R.string.force_sensitive, record.forceSensitive.toString())

        var bio_summary: String? = null
        when (item_full_name.text) {
            "Luke Skywalker" -> bio_summary = getString(R.string.Luke_Skywalker)
            "Leia Organa" -> bio_summary = getString(R.string.Leia_Organa)
            "Han Solo" -> bio_summary = getString(R.string.Han_Solo)
            "Chewbacca " -> bio_summary = getString(R.string.Chewbacca)
            "Kylo Ren" -> bio_summary = getString(R.string.Kylo_Ren)
            "Supreme Leader Snoke" -> bio_summary = getString(R.string.Supreme_Leader_Snoke)
            "General Hux" -> bio_summary = getString(R.string.General_Hux)
            "Darth Vader" -> bio_summary = getString(R.string.Darth_Vader)
        }
        bio.text = getString(R.string.bio, bio_summary)

        item_force_sensitive_img.visibility = if (this.record.forceSensitive == true) {
            View.VISIBLE
        } else {
            View.GONE
        }

    }

    override fun onResume() {
        super.onResume()
    }

    private fun getRecordListActivity(): RecordActivity {
        return activity as RecordActivity
    }


}
