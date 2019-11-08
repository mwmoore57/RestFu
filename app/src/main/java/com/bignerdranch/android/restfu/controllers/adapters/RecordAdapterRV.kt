package com.bignerdranch.android.restfu.controllers.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bignerdranch.android.restfu.R
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.restfu.models.Record
import com.bumptech.glide.Glide

class RecordAdapterRV(
    var records: List<Record>,
    private val mOnClickListener: OnClickListener?,
    private val context: Context
) : RecyclerView.Adapter<RecordAdapterRV.RecordHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.list_item_record, parent, false)
        return RecordHolder(view)
    }

    override fun onBindViewHolder(holder: RecordHolder, position: Int) {
        val record = records[position]
        holder.bind(record)
    }

    override fun getItemCount() = records.size

    fun getItem(position: Int): Record {
        return records[position]
    }

    inner class RecordHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        lateinit var record: Record
        private var userImageView: ImageView
        private var nameTextView: TextView
        private var affiliationTextView: TextView
        private var birthDateTextView: TextView
        private var forceSensitiveImageView: ImageView
        private var constLayout: ConstraintLayout

        init {

            userImageView = itemView.findViewById(R.id.user_img) as ImageView
            nameTextView = itemView.findViewById(R.id.full_name) as TextView
            affiliationTextView = itemView.findViewById(R.id.affiliation) as TextView
            birthDateTextView = itemView.findViewById(R.id.birth_date) as TextView
            forceSensitiveImageView = itemView.findViewById(R.id.force_sensitive_img) as ImageView
            constLayout = itemView.findViewById(R.id.constraint_layout) as ConstraintLayout

            itemView.setOnClickListener(this)
        }

        fun bind(record: Record) {
            this.record = record

            Glide.with(context)
                .load(record.profilePicture)
                .centerCrop()
                .dontAnimate()
                .into(userImageView)

            Glide.with(context)
                .load("https://images-na.ssl-images-amazon.com/images/I/31-4fNCSMLL._SY300_.jpg")
                .centerCrop()
                .dontAnimate()
                .into(forceSensitiveImageView)

            nameTextView.text = this.record.firstName + " " + this.record.lastName
            affiliationTextView.text = this.record.affiliation
            birthDateTextView.text = this.record.birthdate

            forceSensitiveImageView.visibility = if (this.record.forceSensitive == true) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        override fun onClick(v: View) {
            if (mOnClickListener != null && v === constLayout) {
                val selectedRecord = getItem(position)
                mOnClickListener.onItemClick(selectedRecord)
                notifyDataSetChanged()
            }
        }
    }

    interface OnClickListener {
        fun onItemClick(entity: Record)
    }

}




