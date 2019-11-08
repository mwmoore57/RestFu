package com.bignerdranch.android.restfu.controllers.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.restfu.*
import com.bignerdranch.android.restfu.controllers.activities.RecordActivity
import com.bignerdranch.android.restfu.controllers.adapters.RecordAdapterRV
import com.bignerdranch.android.restfu.models.DirectoryResponseEntity
import com.bignerdranch.android.restfu.models.Record
import com.bignerdranch.android.restfu.networking.DirectoryFacade
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecordListFragment : BaseFragment(), RecordAdapterRV.OnClickListener {

    private lateinit var recordRecyclerView: RecyclerView
    private var adapter: RecordAdapterRV? = null
    private var individuals: List<Record> = mutableListOf()

    fun newInstance(): RecordListFragment {
        return RecordListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_record_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        Log.d("Mike", " onViewCreated FragmentProjectDetails")


        makeNetworkCall()
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    private fun makeNetworkCall() {
        showLoadingDialog("Loading", "Please be patient", true)
        DirectoryFacade.getDirectory(object :
            Callback<DirectoryResponseEntity> {
            override fun onResponse(
                call: Call<DirectoryResponseEntity>,
                response: Response<DirectoryResponseEntity>
            ) {
                individuals = response.body()?.individuals!!
                dismissLoadingDialog()
                updateUI()


                return
            }

            override fun onFailure(
                call: Call<DirectoryResponseEntity>,
                t: Throwable
            ) {
                getRecordActivity().displayError(t)
            }
        })
    }

    fun getRecordActivity(): RecordActivity {
        return activity as RecordActivity
    }

    private fun updateUI() {

        //TODO Make RecyclerView efficient by only updating the item that changed
        if (isAlive()) {

            recordRecyclerView = view?.findViewById(R.id.record_recycler_view) as RecyclerView
            recordRecyclerView.layoutManager = LinearLayoutManager(context)

            adapter?.let {
                it.records = individuals
                it.notifyDataSetChanged()
            } ?: run {
                adapter = RecordAdapterRV(individuals, this , this.context!!)
                recordRecyclerView.adapter = adapter
            }
        }
    }

    override fun onItemClick(entity: Record) {
        val position = entity.id
        Log.d("Mike", "onItemClick {$position}")

        Log.e("Mike", "clicking item " + Gson().toJson(entity))
        getRecordActivity().showRecordDetailFragment(entity)
    }


}