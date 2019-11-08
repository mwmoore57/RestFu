package com.bignerdranch.android.restfu.controllers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.bignerdranch.android.restfu.*
import com.bignerdranch.android.restfu.models.BusinessService
import com.bignerdranch.android.restfu.models.EmployeeResponseEntity
import com.bignerdranch.android.restfu.models.Record
import com.bignerdranch.android.restfu.networking.DirectoryFacade
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_RESPONSE = "LDS response"


class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var textViewResult: TextView
    private lateinit var get1Button: Button
    private lateinit var get2Button: Button
    private lateinit var get3Button: Button
    private lateinit var postButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get1Button = findViewById(R.id.get1_button)
        get2Button = findViewById(R.id.get2_button)
        get3Button = findViewById(R.id.get3_button)
        postButton = findViewById(R.id.post_button)
        textViewResult = findViewById(R.id.text_view_result)

        get1Button.setOnClickListener(this)
        get2Button.setOnClickListener(this)
        postButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == get1Button) {
            val intent = Intent(this, RecordActivity::class.java)
            startActivity(intent)
        } else if (v == get2Button) {
            makeNetworkCall2()
        } else if (v == postButton) {
            makeNetworkPost()
        }
    }

    private fun makeNetworkCall2() {
        DirectoryFacade.getServices(object :
            Callback<List<BusinessService>> {
            override fun onResponse(
                call: Call<List<BusinessService>>,
                response: Response<List<BusinessService>>
            ) {
                displayString(Gson().toJson(response.body()))
                return
            }

            override fun onFailure(
                call: Call<List<BusinessService>>,
                t: Throwable
            ) {
                displayError(t)
            }
        })
    }

    private fun makeNetworkPost() {
        DirectoryFacade.postService(
            mutableListOf(),
            object : Callback<EmployeeResponseEntity> {
                override fun onResponse(
                    call: Call<EmployeeResponseEntity>,
                    response: Response<EmployeeResponseEntity>
                ) {
                    displayString(Gson().toJson(response.body()))
                    return
                }

                override fun onFailure(
                    call: Call<EmployeeResponseEntity>,
                    t: Throwable
                ) {
                    displayError(t)
                }
            })
    }

    private fun displayString(displayData: String?) {
        textViewResult.setText("Body: " + Gson().toJson(displayData))
        Log.e(
            "mike",
            "this is data on response in main activity: " + Gson().toJson(displayData)
        )
    }

    private fun displayError(t: Throwable) {
        textViewResult.setText(t.message)
        Log.e(
            "mike",
            "thrown error onFailure " + t.message)
    }
}
