package com.example.newvitameanshospital.ui.education

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newvitameanshospital.R
import com.example.newvitameanshospital.data.Education
import com.example.newvitameanshospital.databinding.EducationItemLayoutBinding

class EducationAdapter : ListAdapter<Education, EducationViewHolder>(EducationDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        return EducationViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.education_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class EducationViewHolder(val binding: EducationItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Education) {
        binding.apply {
            Glide.with(itemView.context)
                .load(Uri.parse(item.img))
                .into(imgThumb)
            title.text = item.title
            root.setOnClickListener {
                itemView.context.startActivity(
                    Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse(item.link)) // edit this url
                        .setPackage("com.google.android.youtube")
                )
            }
        }
    }
}

object EducationDiff : DiffUtil.ItemCallback<Education>() {
    override fun areItemsTheSame(oldItem: Education, newItem: Education): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Education, newItem: Education): Boolean {
        return oldItem == newItem
    }
}
