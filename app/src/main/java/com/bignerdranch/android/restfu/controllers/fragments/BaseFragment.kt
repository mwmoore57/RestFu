package com.bignerdranch.android.restfu.controllers.fragments

import android.app.ProgressDialog
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {


    private var mProgressDialog: ProgressDialog? = null

    fun showLoadingDialog(@Nullable title: String?, @Nullable message: String, @NonNull cancelable: Boolean): ProgressDialog {
        dismissLoadingDialog()
        mProgressDialog = ProgressDialog(getContext(), ProgressDialog.STYLE_SPINNER)
        mProgressDialog?.setCancelable(cancelable)
        mProgressDialog?.setIndeterminate(true)
        if (title == null) {
            mProgressDialog?.setTitle("")
        } else {
            mProgressDialog?.setTitle(title)
        }
        if (message == null) {
            mProgressDialog?.setMessage("")
        } else {
            mProgressDialog?.setMessage(message)
        }
        mProgressDialog?.show()
        return mProgressDialog as ProgressDialog
    }

    /**
     *
     */
    fun dismissLoadingDialog() {
        if (mProgressDialog != null) {
            try {
                mProgressDialog?.dismiss()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        mProgressDialog = null
    }

    fun isAlive(): Boolean {
        return (!isDetached && isAdded && activity != null)
    }

}